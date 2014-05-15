package org.wk.swing.abstrs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class AbstrPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	protected JFrame frame;
	protected JPanel panel;
	protected JTextField textField;
	protected JPanel messagePanel;
	
	public AbstrPanel(JFrame frame){
		this.frame = frame;
	}
	
	protected JPanel getMessagePanel(){
		
		messagePanel = new JPanel();
		messagePanel.setVisible(false);
		return messagePanel;
		
	}
	
	protected void displayMessage(String message) {
		cleanMessage();
		messagePanel.add(new JLabel(message));
		messagePanel.setVisible(true);
		messagePanel.validate();
		messagePanel.repaint();
	}
	
	protected void cleanMessage() {
		messagePanel.removeAll();
		messagePanel.setVisible(false);
	}

}
