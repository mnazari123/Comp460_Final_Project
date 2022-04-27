package com.suduko.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SudukoPanel implements ActionListener{
	
	JPanel mainPanel, playPanel, settingPanel;
	
	public SudukoPanel() {
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		playPanel = new JPanel();
		playPanel.setOpaque(true);
		playPanel.setBackground(Color.BLUE);
		playPanel.setPreferredSize(new Dimension(100, 100));
		
		settingPanel = new JPanel();
		settingPanel.setOpaque(true);
		settingPanel.setBackground(Color.GRAY);
		playPanel.setPreferredSize(new Dimension(100, 100));
		
		mainPanel.add(playPanel, BorderLayout.EAST);
		mainPanel.add(settingPanel, BorderLayout.WEST);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
