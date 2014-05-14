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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.wk.services.TreeService;
import org.wk.swing.abstrs.AbstrPanel;


public class SaveXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTree tree;
	private TreeService treeService;

	
	public SaveXmlPanel(JFrame frame, JTree tree){
		super(frame);
		this.frame = frame;
		this.tree = tree;
		this.treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getButtonSavePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Save XML"));
		return panel;
		
	}
	
	private JPanel getButtonSavePanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Document doc = treeService.convertTree2Document(tree);
					DOMSource source = new DOMSource(doc);
					
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
		            Transformer transformer = transformerFactory.newTransformer();
		            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		            
		            transformer.transform(source, new StreamResult(System.out));
										
				} catch (Exception exc) {
					exc.getStackTrace();
				}
								
			}
		});
		panel.add(button);
		return panel;
		
	}
	
	private JPanel getButtonPanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ValidateXmlPanel(frame, tree);
			}
		});
		panel.add(button);
		button = new JButton("Finish");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(button);
		return panel;
		
	}
		
}
