package org.wk.services;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wk.xml.elements.XmlNode;
import org.wk.xml.elements.XmlNodeAttribute;
import org.wk.xml.elements.XmlNodeValue;

public class TreeService {
	
	
	private DomService domService;
	
	
	public TreeService() {
		domService = new DomService();
	}
	
	
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
	
	
	public Document convertTree2Document(JTree tree) {
		
		Document doc = null;
		
		try {
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	        doc = docBuilder.newDocument();
			
			DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
			addElement(doc, null, root);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return doc;
		
	}
	
	public JTree convertDocument2Tree(Document doc) {
		
		JTree tree = null;
		
		try {
			
			DefaultMutableTreeNode root = addElement(doc.getChildNodes(), null);
			DefaultTreeModel model = new DefaultTreeModel(root);
			tree = new JTree(model);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tree;
		
	}
	
	@SuppressWarnings("rawtypes")
	private void addElement(Document doc, Element parent, DefaultMutableTreeNode node) {
		
		Element element = domService.addElement(doc, parent, node.getUserObject().toString());
		
		Enumeration children = node.children();
		while (children.hasMoreElements()) {
			Object object = (DefaultMutableTreeNode) children.nextElement();
			Object userObject = ((DefaultMutableTreeNode)object).getUserObject();
			if(userObject instanceof XmlNode) {
				addElement(doc, element, (DefaultMutableTreeNode)object);
			} if (userObject instanceof XmlNodeAttribute) {
				XmlNodeAttribute xmlNodeAttribute = (XmlNodeAttribute)userObject;
				domService.addAttribute(element, xmlNodeAttribute.getKey(), xmlNodeAttribute.getValue());
			} if (userObject instanceof XmlNodeValue) {
				XmlNodeValue xmlNodeValue = (XmlNodeValue) userObject;
				domService.addValue(element, xmlNodeValue.toString());
			}
			
		}
		
	}
	
	private DefaultMutableTreeNode addElement(NodeList nodeList,
			DefaultMutableTreeNode parent) {
	
		DefaultMutableTreeNode current = null;

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);
			
			if (tempNode.getNodeType() == Node.TEXT_NODE && tempNode.getNodeValue() != null 
					&& !"".equals(tempNode.getNodeValue().trim())) {
				
				parent.add(new DefaultMutableTreeNode(new XmlNodeValue(
					tempNode.getNodeValue().trim())));
			}
			
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				
				current = new DefaultMutableTreeNode(new XmlNode(
						tempNode.getNodeName()));

				if (parent != null) {
					parent.add(current);
				}

				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);			
						current.add(new DefaultMutableTreeNode(
								new XmlNodeAttribute(node.getNodeName(), node
										.getNodeValue())));

					}

				}

				if (tempNode.hasChildNodes()) {
					addElement(tempNode.getChildNodes(), current);
				}

			}

		}

		return current;

	}
	

}
