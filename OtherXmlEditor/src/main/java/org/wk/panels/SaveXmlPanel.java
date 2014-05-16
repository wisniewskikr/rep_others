package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	private JPanel fileChoosePanel;
	private File file;

	
	public SaveXmlPanel(JFrame frame, JTree tree){
		super(frame);
		this.frame = frame;
		this.tree = tree;
		this.treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getMessagePanel(), BorderLayout.NORTH);
		this.add(getChooseFilePanel(), BorderLayout.SOUTH);
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
	
	private JPanel getChooseFilePanel(){
		
		fileChoosePanel = new JPanel();
		
		textField = new JTextField(30);
		textField.setEnabled(false);
		fileChoosePanel.add(textField);
		
		JButton button = new JButton("Choose File ...");
		button.addActionListener(new ChooseFileListener());
		fileChoosePanel.add(button);
		
		return fileChoosePanel;
		
	}
	
	private JPanel getButtonSavePanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Save");
		button.addActionListener(new SaveFileListener());
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
	
	 class ChooseFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      int rVal = c.showSaveDialog(SaveXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        file = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        textField.setText(file.getAbsolutePath());
		        fileChoosePanel.validate();
		        fileChoosePanel.repaint();
		        cleanMessage();
		      }		     
		    }
		  }
	 
	 class SaveFileListener implements ActionListener {
		 @Override
			public void actionPerformed(ActionEvent e) {
				
				if(file == null) {
					displayMessage("File can not be empty");
					return;
				} 
				
				try {
					
					Document doc = treeService.convertTree2Document(tree);
					DOMSource source = new DOMSource(doc);
					
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
		            Transformer transformer = transformerFactory.newTransformer();
		            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		            
		            transformer.transform(source, new StreamResult(file));
										
				} catch (Exception exc) {
					displayMessage("Following error occurs: " + exc.getMessage());
					return;
				}
				
				displayMessage("File saved succuessfully");
		 }
	 }	 
		
}
