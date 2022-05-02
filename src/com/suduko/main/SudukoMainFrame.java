package com.suduko.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

// Using JFrame to cast the the main frame
public class SudukoMainFrame extends JFrame implements ActionListener{
	
	
	JMenuBar menuBar; // Menu Bar
	JMenu file, edit, help; // Menu
	JMenuItem loadItem, saveItem, exitItem, timmer_window; // Menu Item
	
	public SudukoMainFrame() {

		menuBar = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");
		
		file.setMnemonic(KeyEvent.VK_F); 
		edit.setMnemonic(KeyEvent.VK_E); 
		help.setMnemonic(KeyEvent.VK_H); 
		
		loadItem = new JMenuItem("Load");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");
		
		loadItem.setMnemonic(KeyEvent.VK_L); // l for load - short cut
		saveItem.setMnemonic(KeyEvent.VK_S); // s for save - short cut
		exitItem.setMnemonic(KeyEvent.VK_E); // e for exit - short cut
		
		file.add(loadItem);
		file.add(saveItem);
		file.add(exitItem);
		
		timmer_window = new JMenuItem("Timer Window");
		
		edit.add(timmer_window);
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		this.setJMenuBar(menuBar);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850, 600); // the window size of 850, 600
		this.setLocationRelativeTo(null); // Adjusting the window in the middle when it pops up.
		this.setLayout(new BorderLayout()); // Adjusting the items in the window based on the border of the frame

		this.add(new SettingPanel(), BorderLayout.EAST); // the setting panel on the right. 
		this.add(new PlayPanel(), BorderLayout.WEST); // the play panel on the left.
		
		this.setVisible(true);
		
		
	}
	
	// Action performed is due to the menu items. 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

	

}
