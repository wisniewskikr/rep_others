package org.wk.mains;

import javax.swing.JFrame;

import org.wk.frames.Frame;
import org.wk.panels.ChooseXmlPanel;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new Frame();
		new ChooseXmlPanel(frame);
		
	}

}
