package com.suduko.main;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayPanel3x3{
	
	JPanel playPanel;
	JTextField index_01, index_02, index_03, index_04, index_05, index_06, index_07, index_08, index_09;
	
	public PlayPanel3x3() {
		
		playPanel = new JPanel();
		playPanel.setLayout(new GridLayout());
		
		index_01 = new JTextField();
		index_02 = new JTextField();
		index_03 = new JTextField();
		index_04 = new JTextField();
		index_05 = new JTextField();
		index_06 = new JTextField();
		index_07 = new JTextField();
		index_08 = new JTextField();
		index_09 = new JTextField();
		
		playPanel.add(index_01);
		playPanel.add(index_02);
		playPanel.add(index_03);
		playPanel.add(index_04);
		playPanel.add(index_05);
		playPanel.add(index_06);
		playPanel.add(index_07);
		playPanel.add(index_08);
		playPanel.add(index_09);
		
		
	}

}
