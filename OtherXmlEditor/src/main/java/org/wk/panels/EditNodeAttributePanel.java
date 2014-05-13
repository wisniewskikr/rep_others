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
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.wk.services.TreeService;
import org.wk.swing.abstrs.AbstrPanel;
import org.wk.xml.elements.XmlNodeAttribute;


public class EditNodeAttributePanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode selectedNode;
	private TreeService treeService;
	private JTree tree;
	private JTextField key;
	private JTextField value;

	
	public EditNodeAttributePanel(JFrame frame, DefaultMutableTreeNode selectedNode, JTree tree){
		super(frame);
		this.selectedNode = selectedNode;
		this.tree = tree;
		treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getRequestPanel(), BorderLayout.CENTER);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Edit Node Attribute"));
		return panel;
		
	}
	
	private JPanel getRequestPanel(){
		XmlNodeAttribute node = (XmlNodeAttribute) selectedNode.getUserObject();
		
		panel = new JPanel();
		panel.add(new JLabel("Key: "));
		key = new JTextField(10);
		key.setText(node.getKey());
		panel.add(key);
		panel.add(new JLabel("Value: "));
		value = new JTextField(10);
		value.setText(node.getValue());
		panel.add(value);
		
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditXmlPanel(frame, tree);
			}
		});
		panel.add(button);
		
		button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				treeService.updateXmlNodeAttribute(selectedNode, key.getText(), value.getText());
				((DefaultTreeModel)tree.getModel()).reload();
				new EditXmlPanel(frame, tree);
			}
		});
		panel.add(button);		
		
		return panel;
		
	}

	
}
