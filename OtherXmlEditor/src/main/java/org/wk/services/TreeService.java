package org.wk.services;

import javax.swing.tree.DefaultMutableTreeNode;

import org.wk.xml.elements.XmlNode;
import org.wk.xml.elements.XmlNodeAttribute;
import org.wk.xml.elements.XmlNodeValue;

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
	
	public void addXmlNodeAttribut(DefaultMutableTreeNode parent, String key, String value) {
		parent.add(new DefaultMutableTreeNode(new XmlNodeAttribute(key, value)));
	}
	
	public void updateXmlNodeAttribute(DefaultMutableTreeNode node, String key, String value) {
		node.setUserObject(new XmlNodeAttribute(key, value));
	}
	
	public void deleteXmlNodeAttribute(DefaultMutableTreeNode node) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
		parent.remove(node);
	}
	
	public void addXmlNodeValue(DefaultMutableTreeNode parent, String value) {
		parent.add(new DefaultMutableTreeNode(new XmlNodeValue(value)));
	}
	
	public void updateXmlNodeValue(DefaultMutableTreeNode node, String value) {
		node.setUserObject(new XmlNodeValue(value));
	}
	
	public void deleteXmlNodeValue(DefaultMutableTreeNode node) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
		parent.remove(node);
	}
	

}
