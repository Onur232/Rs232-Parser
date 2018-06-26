package com.sur.parser.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import com.sur.parser.controller.Application;


public class CheckBoxListener implements ActionListener{
	private ArrayList<String> checkBoxes;
	private Application application;
	
	public CheckBoxListener(Application application) {
		checkBoxes=new ArrayList<>();
		this.application=application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox source = (JCheckBox) e.getSource();
		if (source.isSelected()) {
			checkBoxes.add(source.getText());
			System.out.println(source.getText());
		}
		else {
			checkBoxes.remove(source.getText());
		}
		application.setSelectedCheckboxes(checkBoxes);
	}

}
