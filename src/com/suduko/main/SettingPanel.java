package com.suduko.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SettingPanel extends JPanel implements ActionListener{
	
	JButton hintButton, solutionButton, startGame;
	JCheckBox checkbox;
	JProgressBar bar;
	
	public SettingPanel() {
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(250, 100));
		this.setLayout(new FlowLayout());
		
		hintButton = new JButton("Hint");
		solutionButton = new JButton("Solve for me");
		
		this.add(hintButton);
		this.add(solutionButton);
		
		bar = new JProgressBar();
		bar.setValue(0);
		//bar.setBounds(25, 25, 450, 50);
		bar.setStringPainted(true); // adding percentage to progress bar.
		bar.setFont(new Font("MV Boli", Font.BOLD, 20));
		bar.setForeground(Color.RED);
		bar.setBackground(Color.GRAY);
		this.add(bar);
		
		checkbox = new JCheckBox();
		checkbox.setText("Stop");
		checkbox.setFocusable(false);
		this.add(checkbox);
		
		startGame = new JButton("Start Game with Timer");
		this.add(startGame);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
