package org.wk.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.wk.services.CsvService;
import org.wk.services.TreeService;
import org.wk.services.VelocityService;
import org.wk.swing.abstrs.AbstrPanel;


public class TemplateXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private JTree tree;	
	private JTextField vmFileTextField;
	private JPanel vmFileChoosePanel;
	private File vmFile;
	private JTextField csvFileTextField;
	private JPanel csvFileChoosePanel;
	private File csvFile;
	private TreeService treeService;
	private CsvService csvService;
	private VelocityService velocityService;
	
	public final static String XML_FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator;
	public final static String XML_FILE_NAME = "tmp.xml";
	
	
	public TemplateXmlPanel(JFrame frame){
		super(frame);
		this.treeService = new TreeService();
		this.csvService = new CsvService();
		this.velocityService = new VelocityService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getMessagePanel(), BorderLayout.NORTH);
		this.add(getChooseVmFilePanel(), BorderLayout.SOUTH);
		this.add(getChooseCsvFilePanel(), BorderLayout.SOUTH);
		this.add(getButtonFillTemplatePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Template XML"));
		return panel;
		
	}
	
	private JPanel getChooseVmFilePanel(){
		
		vmFileChoosePanel = new JPanel();
		
		vmFileTextField = new JTextField(30);
		vmFileTextField.setEnabled(false);
		vmFileChoosePanel.add(vmFileTextField);
		
		JButton button = new JButton("Choose Vm File ...");
		button.addActionListener(new ChooseVmFileListener());
		vmFileChoosePanel.add(button);
		
		return vmFileChoosePanel;
		
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
	
	private JPanel getButtonFillTemplatePanel(){
		
		panel = new JPanel();
		JButton button = new JButton("Fill Template");
		button.addActionListener(new FillTemplateListener());
		panel.add(button);
		return panel;
		
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
	
	 class ChooseVmFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("vm files (*.vm)", "vm");
		      c.setFileFilter(xmlfilter);
		      int rVal = c.showOpenDialog(TemplateXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        vmFile = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        vmFileTextField.setText(vmFile.getAbsolutePath());
		        vmFileChoosePanel.validate();
		        vmFileChoosePanel.repaint();
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
	 
	 class FillTemplateListener implements ActionListener {
		 @Override
			public void actionPerformed(ActionEvent e) {
				
			 if(vmFile == null) {
					displayMessage("Xml file can not be empty");
					return;
				}
			 	
			 	if(csvFile == null) {
					displayMessage("Vm file can not be empty");
					return;
				}  
				
				try {
					
					File xmlFile = new File(XML_FILE_PATH + XML_FILE_NAME);
					handleTemplate(xmlFile);
					
					DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			        Document doc = docBuilder.parse(xmlFile);
			        
			        tree = treeService.convertDocument2Tree(doc);
										
				} catch (Exception exc) {
					displayMessage("Following error occurs: " + exc.getMessage());
					return;
				}
				
				displayMessage("Template filled succuessfully");
		 }
		 
		 private void handleTemplate(File xmlFile) {
			 
			 List<Map<String, String>> valuesList = new ArrayList<Map<String, String>>();
				
				String[] headers = csvService.readHeaderFromFile(csvFile);
				List<String[]> lines = csvService.readLinesFromFile(csvFile);
									
				for (String[] values : lines) {
					Map<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < values.length; i++) {
						map.put(headers[i], values[i]);
					}
					valuesList.add(map);
				}				
				
				velocityService.transformTemplate(vmFile, xmlFile, valuesList);
			 
		 }
	 }	 
	 
	 class NextListener implements ActionListener {
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
			 
			 	if(tree == null) {
			 		displayMessage("Please fill template");
					return;
			 	}
		 
				new EditXmlPanel(frame, tree);
			}
		 
	 }
		
}
