package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.wk.swing.abstrs.AbstrPanel;


public class ChooseXmlPanel extends AbstrPanel{
		

	private static final String IMPORT_ACTION_COMMAND = "import";
	private static final String NEW_ACTION_COMMAND = "new";
	private static final long serialVersionUID = 1L;
	private ButtonGroup group;

	
	public ChooseXmlPanel(JFrame frame){
		super(frame);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getContentPanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Choose XML"));
		return panel;
		
	}
	
	private JPanel getContentPanel() {
		
		panel = new JPanel();
		
		group = new ButtonGroup();
		JRadioButton button = new JRadioButton("New Xml");
		button.setActionCommand(NEW_ACTION_COMMAND);
		button.setSelected(true);
		group.add(button);
		panel.add(button);
		button = new JRadioButton("Import Xml");
		button.setActionCommand(IMPORT_ACTION_COMMAND);
		group.add(button);
		panel.add(button);
				
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton jButtonNext = new JButton("Next");
		jButtonNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = group.getSelection().getActionCommand();
				if(NEW_ACTION_COMMAND.equals(actionCommand)) {
					new EditXmlPanel(frame, null);
				}else if(IMPORT_ACTION_COMMAND.equals(actionCommand)) {
					new ImportXmlPanel(frame);
				}				
				
			}
		});
		panel.add(jButtonNext);
		return panel;
		
	}
		
}
