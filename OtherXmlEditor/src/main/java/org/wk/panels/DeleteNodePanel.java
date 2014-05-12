package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.wk.services.TreeService;
import org.wk.swing.abstrs.AbstrPanel;


public class DeleteNodePanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode selectedNode;
	private TreeService treeService;
	private JTree tree;

	
	public DeleteNodePanel(JFrame frame, DefaultMutableTreeNode selectedNode, JTree tree){
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
		panel.add(new JLabel("Delete Node"));
		return panel;
		
	}
	
	private JPanel getRequestPanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Do you really want to delete node with name: " + selectedNode.getUserObject().toString() + "?"));
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
		
		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				treeService.deleteXmlNode(selectedNode);
				((DefaultTreeModel)tree.getModel()).reload();
				new EditXmlPanel(frame, tree);
			}
		});
		panel.add(button);		
		
		return panel;
		
	}

	
}
