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


public class ChooseXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;

	
	public ChooseXmlPanel(JFrame frame){
		super(frame);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Choose XML"));
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton jButtonNext = new JButton("Next");
		jButtonNext.addActionListener(new ActionListenerButtonNext());
		panel.add(jButtonNext);
		return panel;
		
	}
	
	private class ActionListenerButtonNext implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new EditXmlPanel(frame, null);
		}
		
	}
		
}
