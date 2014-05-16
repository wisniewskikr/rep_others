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


public class ImportXmlPanel extends AbstrPanel{
		

	private static final long serialVersionUID = 1L;
	private JTree tree;
	private TreeService treeService;
	private JPanel fileChoosePanel;
	private File file;

	
	public ImportXmlPanel(JFrame frame){
		super(frame);
		this.treeService = new TreeService();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(getTitlePanel(), BorderLayout.NORTH);
		this.add(getMessagePanel(), BorderLayout.NORTH);
		this.add(getChooseFilePanel(), BorderLayout.SOUTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
		frame.setContentPane(this);	
		frame.setVisible(true);
		
	}
	
	private JPanel getTitlePanel(){
		
		panel = new JPanel();
		panel.add(new JLabel("Import XML"));
		return panel;
		
	}
	
	private JPanel getChooseFilePanel(){
		
		fileChoosePanel = new JPanel();
		
		textField = new JTextField(30);
		textField.setEnabled(false);
		fileChoosePanel.add(textField);
		
		JButton button = new JButton("Choose Xml File ...");
		button.addActionListener(new ChooseFileListener());
		fileChoosePanel.add(button);
		
		return fileChoosePanel;
		
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
	
	 class ChooseFileListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      JFileChooser c = new JFileChooser();
		      FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		      c.setFileFilter(xmlfilter);
		      int rVal = c.showOpenDialog(ImportXmlPanel.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		        file = new File(c.getCurrentDirectory().toString() + System.getProperty("file.separator") + c.getSelectedFile().getName());
		        textField.setText(file.getAbsolutePath());
		        fileChoosePanel.validate();
		        fileChoosePanel.repaint();
		        cleanMessage();
		      }		     
		    }
		  }
	 
	 class NextListener implements ActionListener {
		 
		 @Override
			public void actionPerformed(ActionEvent e) {
			 
			 if(file == null) {
					displayMessage("File can not be empty");
					return;
				} 
			 
			 	try {
					
			 		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			        Document doc = docBuilder.parse(file);
			        
			        tree = treeService.convertDocument2Tree(doc);
			 		
				} catch (Exception exc) {
					displayMessage("Following error occurs: " + exc.getMessage());
					return;
				}			 
			 
				new EditXmlPanel(frame, tree);
			}
		 
	 }
		
}
