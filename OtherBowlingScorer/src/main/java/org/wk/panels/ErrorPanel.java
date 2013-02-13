package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.wk.swing.abstrs.AbstrPanel;

public class ErrorPanel extends AbstrPanel{
	

	private static final long serialVersionUID = 1L;
	private Exception e;
	
	
	public ErrorPanel(JFrame frame, Exception e){
		super(frame);
		this.e = e;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getDescriptionPanel(), BorderLayout.NORTH);
		this.add(getResponsePanel(), BorderLayout.CENTER);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Page: Error"));
		return panel;
		
	}
	
	private JPanel getDescriptionPanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("An error found during processing of scores"));
		return panel;
		
	}
	
	private JPanel getResponsePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Error message: " + e.getMessage()));
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton jButtonOK = new JButton("Back");
		jButtonOK.addActionListener(new ActionListenerButtonOK());
		panel.add(jButtonOK);
		return panel;
		
	}
	
	private class ActionListenerButtonOK implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new InputPanel(frame);
		}
		
	}
	

	
}
