package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.wk.swing.abstrs.AbstrPanel;
import org.wk.xml.elements.XmlNode;
import org.wk.xml.elements.XmlNodeAttribute;
import org.wk.xml.elements.XmlNodeValue;

public class EditXmlPanel extends AbstrPanel{
	

	private static final long serialVersionUID = 1L;
	private JPanel buttonTreePanel;
	private DefaultMutableTreeNode selectedNode;
	private JTree tree;
	
	
	public EditXmlPanel(JFrame frame, JTree tree){
		super(frame);
		this.tree = tree;
		buttonTreePanel = new JPanel();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getTreeScrollPane(), BorderLayout.CENTER);
		this.add(getButtonTreePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Edit XML"));
		return panel;
		
	}
	
	private JScrollPane getTreeScrollPane(){
		
		JTree tree = getEtidXmlTree();
		JScrollPane scrollPane = new JScrollPane(tree);
		return scrollPane;
		
	}
	
	private JPanel getButtonTreePanel(){		
		return buttonTreePanel;
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChooseXmlPanel(frame);
			}
		});
		panel.add(button);
		
		button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ValidateXmlPanel(frame);
			}
		});
		panel.add(button);
		
		return panel;
		
	}
	
	private JButton getButtonEdit() {
		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedNode.getUserObject() instanceof XmlNode) {
					new EditNodePanel(frame, selectedNode, tree);
				} else if(selectedNode.getUserObject() instanceof XmlNodeAttribute) {
					new EditNodeAttributePanel(frame, selectedNode, tree);
				} else if(selectedNode.getUserObject() instanceof XmlNodeValue) {
					new EditNodeValuePanel(frame, selectedNode, tree);
				}					
			}
		});
		return button;
	}
	
	private JButton getButtonDelete() {
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedNode.getUserObject() instanceof XmlNode) {
					new DeleteNodePanel(frame, selectedNode, tree);
				} else if(selectedNode.getUserObject() instanceof XmlNodeAttribute) {
					new DeleteNodeAttributePanel(frame, selectedNode, tree);
				} else if(selectedNode.getUserObject() instanceof XmlNodeValue) {
					new DeleteNodeValuePanel(frame, selectedNode, tree);
				}
			}
		});
		return button;
	}
	
	private JButton getButtonNewNode() {
		JButton button = new JButton("New Node");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewNodePanel(frame, selectedNode, tree);
			}
		});
		return button;
	}
	
	private JButton getButtonNewAttribute() {
		JButton button = new JButton("New Attribute");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewNodeAttributePanel(frame, selectedNode, tree);
			}
		});
		return button;
	}
	
	private JButton getButtonNewValue() {
		JButton button = new JButton("New Value");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewNodeValuePanel(frame, selectedNode, tree);
			}
		});
		return button;
	}
	
	private JTree getEtidXmlTree() {
		
		if(tree == null) {
			DefaultMutableTreeNode root =
			        new DefaultMutableTreeNode(new XmlNode("root"));
			DefaultTreeModel model = new DefaultTreeModel(root);
			tree = new JTree(model);
		}
		
		tree.setShowsRootHandles(true);
		tree.setCellRenderer(new MyTreeCellRenderer());
		tree.getSelectionModel().addTreeSelectionListener(new EditXmlTreeSelectionListener());
		tree.setSelectionPath(new TreePath(tree.getModel().getRoot()));
		
		return tree;
		
	}
	
	private class EditXmlTreeSelectionListener implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			selectedNode = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			
			if(selectedNode.getUserObject() instanceof XmlNode) {
				buttonTreePanel.removeAll();
				buttonTreePanel.add(getButtonEdit());
				buttonTreePanel.add(getButtonDelete());
				if(!hasValue(selectedNode)) {
					buttonTreePanel.add(getButtonNewNode());
				}
				buttonTreePanel.add(getButtonNewAttribute());
				if(!hasValue(selectedNode) && !hasSubNode(selectedNode)) {
					buttonTreePanel.add(getButtonNewValue());
				}				
				buttonTreePanel.validate();
				buttonTreePanel.repaint();
			}
			
			if(selectedNode.getUserObject() instanceof XmlNodeAttribute) {
				buttonTreePanel.removeAll();
				buttonTreePanel.add(getButtonEdit());
				buttonTreePanel.add(getButtonDelete());
				buttonTreePanel.validate();
				buttonTreePanel.repaint();
			}
			
			if(selectedNode.getUserObject() instanceof XmlNodeValue) {
				buttonTreePanel.removeAll();
				buttonTreePanel.add(getButtonEdit());
				buttonTreePanel.add(getButtonDelete());
				buttonTreePanel.validate();
				buttonTreePanel.repaint();
			}
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean hasSubNode(DefaultMutableTreeNode node) {
		
		boolean result = false;
		
		Enumeration<DefaultMutableTreeNode> children = node.children();
		while (children.hasMoreElements()) {
			DefaultMutableTreeNode nod = children.nextElement();
			if(nod.getUserObject() instanceof XmlNode) {
				result = true;
				break;
			}
		}
		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean hasValue(DefaultMutableTreeNode node) {
		
		boolean result = false;
		
		Enumeration<DefaultMutableTreeNode> children = node.children();
		while (children.hasMoreElements()) {
			DefaultMutableTreeNode nod = children.nextElement();
			if(nod.getUserObject() instanceof XmlNodeValue) {
				result = true;
				break;
			}
		}
		
		return result;
		
	}
	
	private static class MyTreeCellRenderer extends DefaultTreeCellRenderer {
		
		private static final long serialVersionUID = 1L;

		@Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            
			Component comp = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			
			if (!(value instanceof DefaultMutableTreeNode)) {
				return comp;
			}
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			
			if(node.getUserObject() instanceof XmlNode) {
				setIcon(openIcon);
			}
			
			if(node.getUserObject() instanceof XmlNodeAttribute) {
				setIcon(leafIcon);
			}
			
			if(node.getUserObject() instanceof XmlNodeValue) {
				setIcon(leafIcon);
			}
		
            return comp;
		} 
		
	}

	
}
