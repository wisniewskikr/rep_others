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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.wk.services.TreeService;
import org.wk.swing.abstrs.AbstrPanel;


public class TemplateXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private JTree tree;
	private TreeService treeService;
	private JTextField xmlFileTextField;
	private JPanel xmlFileChoosePanel;
	private File xmlFile;
	private JTextField csvFileTextField;
	private JPanel csvFileChoosePanel;
	private File csvFile;
	
	
	public TemplateXmlPanel(JFrame frame){
		super(frame);
		this.treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getMessagePanel(), BorderLayout.NORTH);
		this.add(getChooseXmlFilePanel(), BorderLayout.SOUTH);
		this.add(getChooseCsvFilePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Template XML"));
		return panel;
		
	}
	
	private JPanel getChooseXmlFilePanel(){
		
		xmlFileChoosePanel = new JPanel();
		
		xmlFileTextField = new JTextField(30);
		xmlFileTextField.setEnabled(false);
		xmlFileChoosePanel.add(xmlFileTextField);
		
		JButton button = new JButton("Choose Xml File ...");
		button.addActionListener(new ChooseXmlFileListener());
		xmlFileChoosePanel.add(button);
		
		return xmlFileChoosePanel;
		
	}
	
	private JPanel getChooseCsvFilePanel(){
		
		csvFileChoosePanel = new JPanel();
		
		csvFileTextField = new JTextField(30);
		csvFileTextField.setEnabled(false);
		csvFileChoosePanel.add(csvFileTextField);
		
		JButton button = new JButton("Choose Csv File ...");
		button.addActionListener(new ChooseCsvFileListener());
		csvFileChoosePanel.add(button);
		
		return csvFileChoosePanel;
		
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
		button.addActionListener(new NextListener());
		panel.add(button);
		panel.add(button);
		return panel;
		
	}
	
	 class ChooseXmlFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		      c.setFileFilter(xmlfilter);
		      int rVal = c.showOpenDialog(TemplateXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        xmlFile = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        xmlFileTextField.setText(xmlFile.getAbsolutePath());
		        xmlFileChoosePanel.validate();
		        xmlFileChoosePanel.repaint();
		        cleanMessage();
		      }		     
		    }
		  }
	 
	 class ChooseCsvFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      FileNameExtensionFilter csvfilter = new FileNameExtensionFilter("csv files (*.csv)", "csv");
		      c.setFileFilter(csvfilter);
		      int rVal = c.showOpenDialog(TemplateXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        csvFile = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        csvFileTextField.setText(csvFile.getAbsolutePath());
		        csvFileChoosePanel.validate();
		        csvFileChoosePanel.repaint();
		        cleanMessage();
		      }		     
		    }
		  }
	 
	 class NextListener implements ActionListener {
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
			 
			 	if(xmlFile == null) {
					displayMessage("Xml file can not be empty");
					return;
				}
			 	
			 	if(csvFile == null) {
					displayMessage("Csv file can not be empty");
					return;
				} 
			 
			 	try {
					
//			 		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//			        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//			        Document doc = docBuilder.parse(file);
			        
//			        tree = treeService.convertDocument2Tree(doc);
			        tree = null;
			 		
				} catch (Exception exc) {
					displayMessage("Following error occurs: " + exc.getMessage());
					return;
				}			 
			 
				new EditXmlPanel(frame, tree);
			}
		 
	 }
		
}
