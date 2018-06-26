package com.sur.parser.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import com.sur.parser.controller.Application;



public class ButtonSelectAllListener implements ActionListener{
	private Application application;

	public ButtonSelectAllListener(Application application) {
		this.application=application;
	}

	@Override
	public void actionPerformed(ActionEvent source) {
		JToggleButton button = (JToggleButton) source.getSource();
		application.selectAllCheckBox(button.isSelected());
	}
	
}
