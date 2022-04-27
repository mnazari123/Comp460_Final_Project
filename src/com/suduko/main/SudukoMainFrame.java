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

public class SudukoMainFrame extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu file, edit, help;
	JPanel playPanel, settingPanel, mainPanel;
	JButton adjustButton, hintButton, solutionButton, startGame;
	JCheckBox checkbox;
	JProgressBar bar;
	
	JComboBox combobox;
	String[] animals = {"3 x 3", "6 x 6", "9 x 9", "12 x 12"};
	JTextField index_01, index_02, index_03, index_04, index_05, index_06, index_07, index_08, index_09;
	JTextField [][] textFields = new JTextField[9][9];
	
	JMenuItem loadItem, saveItem, exitItem, timmer_window;
	
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
		
		loadItem.setMnemonic(KeyEvent.VK_L); // l for load
		saveItem.setMnemonic(KeyEvent.VK_S); // s for save
		exitItem.setMnemonic(KeyEvent.VK_E); // e for exit
		
		file.add(loadItem);
		file.add(saveItem);
		file.add(exitItem);
		
		timmer_window = new JMenuItem("Timer Window");
		
		edit.add(timmer_window);
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		
		
		
		this.setJMenuBar(menuBar);
		
		playPanel = new JPanel();
		playPanel.setOpaque(true);
		playPanel.setBackground(Color.LIGHT_GRAY);
		playPanel.setPreferredSize(new Dimension(600, 100));
		playPanel.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		playPanel.add(mainPanel, BorderLayout.CENTER);
		
		settingPanel = new JPanel();
		settingPanel.setOpaque(true);
		settingPanel.setBackground(Color.BLUE);
		settingPanel.setPreferredSize(new Dimension(250, 100));
		settingPanel.setLayout(new FlowLayout());
		
		combobox = new JComboBox(animals);
		settingPanel.add(combobox);
		
		adjustButton = new JButton("New Adjustment");
		adjustButton.addActionListener(this);
		
		hintButton = new JButton("Hint");
		solutionButton = new JButton("Solve for me");
		
		settingPanel.add(adjustButton);
		settingPanel.add(hintButton);
		settingPanel.add(solutionButton);
		
		bar = new JProgressBar();
		bar.setValue(0);
		//bar.setBounds(25, 25, 450, 50);
		bar.setStringPainted(true); // adding percentage to progress bar.
		bar.setFont(new Font("MV Boli", Font.BOLD, 20));
		bar.setForeground(Color.RED);
		bar.setBackground(Color.GRAY);
		settingPanel.add(bar);
		
		checkbox = new JCheckBox();
		checkbox.setText("Stop");
		checkbox.setFocusable(false);
		settingPanel.add(checkbox);
		
		startGame = new JButton("Start Game with Timer");
		settingPanel.add(startGame);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(10, 10));
		this.setVisible(true);
		
		this.add(playPanel, BorderLayout.WEST);
		this.add(settingPanel, BorderLayout.EAST);
		
		life_status();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == adjustButton) {
			switch(combobox.getSelectedIndex()) {
			case 0: 
				game3x3();	
				break;
			case 1: 
				BoxData(6);
				break;
			case 2: 
				addTextfields();
				break;
			case 3: 
				BoxData(12);
				break;
			}
		}
		
	}
	public void life_status() {
		  
		int counter = 100;
		while (counter >= 0) {
			bar.setValue(counter);  
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			counter --;
		}
		bar.setString("Failed");
	}
	
	public void game3x3() {
		List<Integer> numbers = myRandList(3);
		
//		for(Integer r : numbers) {
//			System.out.println(r);
//		}
		
		mainPanel.setBounds(100, 100, 400, 400);
		String val_1 = numbers.get(0) + "";
		index_01 = new JTextField(val_1);
		index_01.setFont(new Font("Serif", Font.BOLD, 40));
		String val_2 = numbers.get(1) + "";
		index_02 = new JTextField(val_2);
		index_02.setFont(new Font("Serif", Font.BOLD, 40));
		String val_3 = numbers.get(2) + "";
		index_03 = new JTextField(val_3);
		index_03.setFont(new Font("Serif", Font.BOLD, 40));
		String val_4 = numbers.get(3) + "";
		index_04 = new JTextField(val_4);
		index_04.setFont(new Font("Serif", Font.BOLD, 40));
		String val_5 = numbers.get(4) + "";
		index_05 = new JTextField(val_5);
		index_05.setFont(new Font("Serif", Font.BOLD, 40));
		String val_6 = numbers.get(5) + "";
		index_06 = new JTextField(val_6);
		index_06.setFont(new Font("Serif", Font.BOLD, 40));
		String val_7 = numbers.get(6) + "";
		index_07 = new JTextField(val_7);
		index_07.setFont(new Font("Serif", Font.BOLD, 40));
		String val_8 = numbers.get(7) + "";
		index_08 = new JTextField(val_8);
		index_08.setFont(new Font("Serif", Font.BOLD, 40));
		String val_9 = numbers.get(8) + "";
		index_09 = new JTextField(val_9);
		index_09.setFont(new Font("Serif", Font.BOLD, 40));
		
		
		mainPanel.add(index_01);
		mainPanel.add(index_02);
		mainPanel.add(index_03);
		mainPanel.add(index_04);
		mainPanel.add(index_05);
		mainPanel.add(index_06);
		mainPanel.add(index_07);
		mainPanel.add(index_08);
		mainPanel.add(index_09);
		
		mainPanel.setLayout(new GridLayout(3, 3, 10, 10));
	}
	
	public void BoxData(int s) {
		List<Integer> numbers = myRandList(s*s);
		//mainPanel.setBounds(100, 100, 400, 400);
		for(int i = 0; i <= numbers.size() -1 ; i++) {
			
			String val = numbers.get(i) + "";
			mainPanel.add(new JTextField(val));
			
		}
		mainPanel.setLayout(new GridLayout(s, s, 10, 10));
	}
	
	
	public List myRandList(int last){
		List<Integer> primary_numbers = new ArrayList<Integer>();
		List<Integer> numbers_list = new ArrayList<Integer>();
		
		for(int entry = 1; entry <= last; entry++) {
			numbers_list.add(entry);
		}
		
		Random rand = new Random();
		for (int i = last; i >= 1; i --) {
			int r = rand.nextInt(i);
			primary_numbers.add(numbers_list.get(r));
			numbers_list.remove(r);
		}
		return primary_numbers;
		
		
	}
	public void addTextfields(){
        //addClues();
        for (int i = 0; i < textFields.length; i++){
            for (int j = 0; j < textFields.length; j++){
                JTextField temp = new JTextField("");
                textFields[i][j] = temp;
            }
        }
    }

}
