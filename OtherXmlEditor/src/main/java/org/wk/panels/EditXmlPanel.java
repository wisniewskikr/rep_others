package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import org.wk.swing.abstrs.AbstrPanel;
import org.wk.xml.elements.XmlNode;
import org.wk.xml.elements.XmlNodeAttribute;
import org.wk.xml.elements.XmlNodeValue;

public class EditXmlPanel extends AbstrPanel{
	

	private static final long serialVersionUID = 1L;
	
	
	public EditXmlPanel(JFrame frame){
		super(frame);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getTreeScrollPane(), BorderLayout.CENTER);
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
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton jButtonBack = new JButton("Back");
		jButtonBack.addActionListener(new ActionListenerButtonBack());
		panel.add(jButtonBack);
		return panel;
		
	}
	
	private class ActionListenerButtonBack implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			new ChooseXmlPanel(frame);
		}
		
	}
	
	private JTree getEtidXmlTree() {
				
		
		DefaultMutableTreeNode root =
		        new DefaultMutableTreeNode(new XmlNode("root"));
		root.add(new DefaultMutableTreeNode(new XmlNodeAttribute("key", "value")));
		root.add(new DefaultMutableTreeNode(new XmlNodeValue("value")));
		root.add(new DefaultMutableTreeNode(new XmlNode("node")));
		
		
		DefaultTreeModel model = new DefaultTreeModel(root);
		JTree tree = new JTree(model);
		tree.setShowsRootHandles(true);
		tree.setCellRenderer(new MyTreeCellRenderer());
		
		return tree;
		
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
