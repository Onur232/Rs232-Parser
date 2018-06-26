package com.sur.parser.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.sur.parser.listeners.ButtonCreateTextFileListener;
import com.sur.parser.listeners.ButtonSelectAllListener;
import com.sur.parser.listeners.CheckBoxListener;
import com.sur.parser.objects.Sentence;
import com.sur.parser.parser.SentenceParser;
import com.sur.parser.view.MainFrame;


public class Application implements Runnable{
	/*
	 * Object i�indeki t�m field'lar�n parse i�lemi parser s�n�flar�nda da yap�labilir. Bu uygulamada
	 * textwriter class'� i�inde se�ili checkbox'a g�re field ilgili object �zerinde t�m object instance'lar�
	 * �zerinde get+fieldName metodu �a�r�larak field'lar al�narak text'e yaz�l�r.
	 */
	File selectedFile;
	private MainFrame mainFrame;
	private ArrayList<String> selectedCheckboxes=new ArrayList<>();
	private SentenceParser parser;

	public void start() {
		SwingUtilities.invokeLater(this);
	}
	
	@Override
	public void run() {
		mainFrame = new MainFrame();
		CheckBoxListener checkBoxListener=new CheckBoxListener(this);
		ButtonCreateTextFileListener createTextFileListener=new ButtonCreateTextFileListener(this);
		ButtonSelectAllListener selectAllListener=new ButtonSelectAllListener(this);
		getFile();
		parser = new SentenceParser();
		parser.parseFile(selectedFile);
		parser.parseSentences();
		mainFrame.setVisible(true);
		mainFrame.addBtnCreateTextFileListener(createTextFileListener);
		mainFrame.addCheckBoxListener(checkBoxListener);
		mainFrame.addBtnSelectAllListener(selectAllListener);
	}
	

	private void getFile() {
		UIManager.put("FileChooser.openDialogTitleText", "Select Sur File");
//		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"+"\\Desktop")));
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home")+"\\Desktop"
				+"\\ASS-Ed kay�tlar ve ethernet logger"+"\\Kayitlar");
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile=fileChooser.getSelectedFile();
		}
	}

	public ArrayList<String> getSelectedCheckboxes() {
		return this.selectedCheckboxes;
	}


	public void setSelectedCheckboxes(ArrayList<String> selectedCheckboxes) {
		this.selectedCheckboxes = selectedCheckboxes;
	}
	
	
	public void disposeMainFrame(){
		mainFrame.dispose();
	}
	
	public void selectAllCheckBox(boolean selected){
		mainFrame.selectAllCheckBox(selected);
	}

	public ArrayList<Sentence> getSentences() {
		return parser.getSurs();
	}





}
