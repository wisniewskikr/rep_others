package org.wk.services;

import javax.swing.tree.DefaultMutableTreeNode;

import org.wk.xml.elements.XmlNode;

public class TreeService {
	
	
	public void addXmlNode(DefaultMutableTreeNode parent, String name) {
		parent.add(new DefaultMutableTreeNode(new XmlNode(name)));
	}
	
	public void updateXmlNode(DefaultMutableTreeNode node, String name) {
		node.setUserObject(new XmlNode(name));
	}
	
	public void deleteXmlNode(DefaultMutableTreeNode node) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
		parent.remove(node);
	}
	

}
