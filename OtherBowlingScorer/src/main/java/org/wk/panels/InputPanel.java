package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.wk.services.ScoreService;
import org.wk.swing.abstrs.AbstrPanel;


public class InputPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private ScoreService scoreService;

	
	public InputPanel(JFrame frame){
		super(frame);
		scoreService = new ScoreService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getDescriptionPanel(), BorderLayout.NORTH);
		this.add(getRequestPanel(), BorderLayout.CENTER);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Page: Input"));
		return panel;
		
	}
	
	private JPanel getDescriptionPanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("You can use digits from 0-9 and words 'spare' and 'strike'."));
		panel.add(new JLabel("Elements of the input should be separated by whitespace."));
		return panel;
		
	}
	
	private JPanel getRequestPanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Type your score: "));
		textField = new JTextField(20);
		panel.add(textField);
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton jButtonOK = new JButton("OK");
		jButtonOK.addActionListener(new ActionListenerButtonOK());
		panel.add(jButtonOK);
		return panel;
		
	}
	
	private class ActionListenerButtonOK implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String input = textField.getText();
			String output;
			try {
				output = scoreService.transformInputToOutput(input);
			} catch (Exception e2) {
				new ErrorPanel(frame, e2);
				return;
			}		
						
			new OutputPanel(frame, output);
			
		}
		
	}

		
}
