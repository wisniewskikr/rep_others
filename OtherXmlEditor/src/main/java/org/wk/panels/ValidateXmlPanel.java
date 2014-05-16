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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.wk.services.TreeService;
import org.wk.swing.abstrs.AbstrPanel;


public class ValidateXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private JTree tree;
	private TreeService treeService;
	private JPanel fileChoosePanel;
	private File file;

	
	public ValidateXmlPanel(JFrame frame, JTree tree){
		super(frame);
		this.tree = tree;
		this.treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getMessagePanel(), BorderLayout.NORTH);
		this.add(getChooseFilePanel(), BorderLayout.SOUTH);
		this.add(getButtonValidatePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Validate XML"));
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
	
	private JPanel getButtonValidatePanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Validate");
		button.addActionListener(new ValidateFileListener());
		panel.add(button);
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
		
		button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveXmlPanel(frame, tree);
			}
		});
		panel.add(button);
		return panel;
		
	}
	
	 class ChooseFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xsd files (*.xsd)", "xsd");
		      c.setFileFilter(xmlfilter);
		      int rVal = c.showSaveDialog(ValidateXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        file = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        textField.setText(file.getAbsolutePath());
		        fileChoosePanel.validate();
		        fileChoosePanel.repaint();
		        cleanMessage();
		      }		     
		    }
		  }
	 
	 class ValidateFileListener implements ActionListener {
		 @Override
			public void actionPerformed(ActionEvent e) {
				
				if(file == null) {
					displayMessage("File can not be empty");
					return;
				} 
				
				try {
					
					Document doc = treeService.convertTree2Document(tree);
					DOMSource source = new DOMSource(doc);
					
					String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
				    SchemaFactory factory = SchemaFactory.newInstance(language);
				    Schema schema = factory.newSchema(file);
				    
				    Validator validator = schema.newValidator();
				    validator.validate(source);
										
				} catch (Exception exc) {
					displayMessage("Following error occurs: " + exc.getMessage());
					return;
				}
				
				displayMessage("Validation ok");
		 }
	 }	 
		
}
