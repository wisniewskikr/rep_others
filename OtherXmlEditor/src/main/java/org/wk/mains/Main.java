package org.wk.mains;

import javax.swing.JFrame;

import org.wk.frames.HelloWorldFrame;
import org.wk.panels.ChooseXmlPanel;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new HelloWorldFrame();
		new ChooseXmlPanel(frame);
		
	}

}
