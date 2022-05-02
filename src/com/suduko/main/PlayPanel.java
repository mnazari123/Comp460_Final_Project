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

// Using JPanel to add items to it and them adding the JPanel to the JFrame
public class PlayPanel extends JPanel{
	
	int N = 9; // number of columns and rows 
	int K = 20; // level difficulty.  
	SudokuValueGenerator myList = new SudokuValueGenerator(N, K);
	
	List<Integer> cell_value; // storing the values returned by the Sudoku Generator
	List<Integer> answer_value; // Storing the answers of the blank spaces for checking the types values by the user.
	
		
	public PlayPanel() {
		
		//playPanel = new JPanel();
		
		this.setPreferredSize(new Dimension(600, 100));
		this.setLayout(new GridLayout(9, 9, 5, 5)); // 9 x 9 table
		
		
		//backgroundPanels();
		drawTextFields(false);
	}
	
//	public void BoxData(int s) { // reading the 2d array. 
//		List<Integer> numbers = myRandList();
//		//mainPanel.setBounds(100, 100, 400, 400);
//		for(int i = 0; i <= numbers.size() -1 ; i++) {
//			String val = numbers.get(i) + "";
//			JTextField temp = new JTextField(val);
//			temp.setFont(new Font("Sanserif", Font.BOLD, 30));
//			//mainPanel.add(temp);
//			
//		}
//		//mainPanel.setLayout(new GridLayout(s, s, 10, 10));
//	}
//	public List myRandList(){
//		List<Integer> primary_numbers = new ArrayList<Integer>();
//		List<Integer> numbers_list = new ArrayList<Integer>();
//		
//		for(int entry = 1; entry <= 9; entry++) {
//			numbers_list.add(entry);
//		}
//		
//		Random rand = new Random();
//		for (int i = 9; i >= 1; i --) {
//			int r = rand.nextInt(i);
//			primary_numbers.add(numbers_list.get(r));
//			numbers_list.remove(r);
//		}
//		return primary_numbers;
//		
//		
//	}
//	
//	public void backgroundPanels() {
//		boolean status = true;
//		for (int i = 0; i < 9; i++) {
//			JPanel panel_background = new JPanel();
//			panel_background.setLayout(new GridLayout(3, 3, 5 ,5));
//			//drawTextFields(panel_background);
//			//panel_background.setPreferredSize(new Dimension(this.getX()/3, this.getY()/3));
//			if (status == true) {
//				panel_background.setBackground(Color.yellow);
//				status = false;
//			}else {
//				panel_background.setBackground(Color.orange);
//				status = true;
//			}
//			this.add(panel_background);
//		}
//		//drawTextFields(this);
//	}
	
	// Drawing the textfield and beside the adding value and action handler to it.
	public void drawTextFields( boolean solve) {
		myList.fillValues();
		answer_value = myList.getSolution(); 
		cell_value = myList.getCellValue();
		for(int t = 0; t < 81; t++) { // creating 81 text fields 
			JTextField temp; // creating a temporary textfield. 
			String ID_KEY = t+"";
			if(cell_value.get(t) == 0) { // checking if the values are blank = 0 
				temp = new JTextField(""); // not to show 0 but instead show blank text field
			}else {
				temp = new JTextField("" + cell_value.get(t)); // showing the values
				temp.setEditable(false); // make them uneditable 
			}
			temp.putClientProperty(ID_KEY, t);  // adding specific id for the text fields for later accessing. 
			
			temp.setBackground(null);
			temp.setFont(new Font("Sanserif", Font.BOLD, 34));
			//temp.setAlignmentX(0);
			temp.setHorizontalAlignment(0);
			temp.setForeground(Color.black);
			temp.addActionListener(new ActionListener() { // adding action listener to each of the text fields 
			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int r = (int) temp.getClientProperty(ID_KEY); // minuplating based on the id we get from the each component.
					int v = Integer.parseInt(temp.getText());  // parsing the values based on the part we receive from the user. 
					int checker = answer_value.get(r); // comparing the value we receive and the value we have in our list
					if(v == checker) {
						temp.setBackground(Color.green); // if it is true. the background becomes green for confirmation
						temp.setEditable(false); // and we make uneditable for completion 
					}else {
						temp.setBackground(Color.RED); // if the typed value is incorrect so we turn the background to red to help the user understand the key is wrong
					}	
				}
				
			});
			this.add(temp);	
		}
	}

}
