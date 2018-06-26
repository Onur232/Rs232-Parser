package com.sur.parser.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.sur.parser.controller.Application;
import com.sur.parser.writer.TextWriter;



public class ButtonCreateTextFileListener implements ActionListener{
	private Application application;
	private TextWriter textWriter;
	private ArrayList<String> checkBoxes;

	public ButtonCreateTextFileListener(Application application) {
		this.application=application;
		checkBoxes=new ArrayList<>();
		textWriter = new TextWriter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkBoxes = application.getSelectedCheckboxes();
		for (String string : checkBoxes) {
			System.out.println(string);
		}
		textWriter.setSentencesList(application.getSentences());
		textWriter.createTextFiles(checkBoxes);
	}

}
