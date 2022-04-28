package com.suduko.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayPanel extends JPanel{
	
	int N = 9;
	int K = 50;
	SudokuValueGenerator myList = new SudokuValueGenerator(N, K);
	
	List<Integer> cell_value;
	
		
	public PlayPanel() {
		
		//playPanel = new JPanel();
		
		this.setPreferredSize(new Dimension(600, 100));
		this.setLayout(new GridLayout(9, 9, 5, 5));
		
		//backgroundPanels();
		drawTextFields();
	}
	
	public void BoxData(int s) {
		List<Integer> numbers = myRandList();
		//mainPanel.setBounds(100, 100, 400, 400);
		for(int i = 0; i <= numbers.size() -1 ; i++) {
			String val = numbers.get(i) + "";
			JTextField temp = new JTextField(val);
			temp.setFont(new Font("Sanserif", Font.BOLD, 30));
			//mainPanel.add(temp);
			
		}
		//mainPanel.setLayout(new GridLayout(s, s, 10, 10));
	}
	public List myRandList(){
		List<Integer> primary_numbers = new ArrayList<Integer>();
		List<Integer> numbers_list = new ArrayList<Integer>();
		
		for(int entry = 1; entry <= 9; entry++) {
			numbers_list.add(entry);
		}
		
		Random rand = new Random();
		for (int i = 9; i >= 1; i --) {
			int r = rand.nextInt(i);
			primary_numbers.add(numbers_list.get(r));
			numbers_list.remove(r);
		}
		return primary_numbers;
		
		
	}
	
	public void backgroundPanels() {
		boolean status = true;
		for (int i = 0; i < 9; i++) {
			JPanel panel_background = new JPanel();
			panel_background.setLayout(new GridLayout(3, 3, 5 ,5));
			//drawTextFields(panel_background);
			//panel_background.setPreferredSize(new Dimension(this.getX()/3, this.getY()/3));
			if (status == true) {
				panel_background.setBackground(Color.yellow);
				status = false;
			}else {
				panel_background.setBackground(Color.orange);
				status = true;
			}
			this.add(panel_background);
		}
		//drawTextFields(this);
	}
	
	public void drawTextFields() {
		myList.fillValues();
		cell_value = myList.getCellValue();
		
		for(int t = 0; t < 81; t++) {
			JTextField temp;
			String ID_KEY = t+"";
			if(cell_value.get(t) == 0) {
				temp = new JTextField("");
			}else {
				temp = new JTextField("" + cell_value.get(t));
				temp.setEditable(false);
			}
			temp.putClientProperty(ID_KEY, t);
			//temp.setPreferredSize(new Dimension(panel_background.getX()/3, panel_background.getY()/3));
			temp.setBackground(null);
			temp.setFont(new Font("Sanserif", Font.BOLD, 34));
			//temp.setAlignmentX(0);
			temp.setHorizontalAlignment(0);
			temp.setForeground(Color.black);
			temp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int r = (int) temp.getClientProperty(ID_KEY);
					int v = Integer.parseInt(temp.getText());
					
				}
				
			});
			this.add(temp);
			
		}
	}

}
