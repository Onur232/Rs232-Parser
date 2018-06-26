package com.sur.parser.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sur.parser.objects.Sentence;


public class TextWriter {

	private static final String NEW_FILE_FOLDER = System.getProperty("user.home") + "\\Desktop" + "\\Sur Parser";
	private File newFolder=new File(NEW_FILE_FOLDER);
	private FileOutputStream fileOutputStream;
	private List<Sentence> sentences = new ArrayList<>();

	/*
	 * Öncelikle dizinin oluþturulmasý gerekir. Dizin oluþturma iþlemi
	 * Application içinde yapýlmaktadýr.
	 */
	public TextWriter() {
		createFolder(newFolder);
	}

	public void createTextFiles(ArrayList<String> checkBoxes) {
		for (String string : checkBoxes) {
			switch (string) {
			case "Sürat":
				writeText("getSurat", "Sürat", "int");
				break;
			case "Umk":
				writeText("getUmk", "Umk", "int");
				break;
			case "Rota":
				writeText("getRota", "Rota", "int");
				break;
			default:
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Files has been created on Desktop\\Sur Parser!", "Files Created", JOptionPane.INFORMATION_MESSAGE);
	}

	private void writeText(String methodName, String fieldName,String type) {
		
		File file=new File(NEW_FILE_FOLDER+"\\"+fieldName+".txt");
		FileWriter fileWriter;
		BufferedWriter bWriter;
		try {
			fileWriter = new FileWriter(file,true);
			bWriter=new BufferedWriter(fileWriter);
			for (Sentence sentence : sentences) {
				String string = sentence.getClass().toString();
				string=string.replaceFirst("class ", "");
				Class<?> class1=Class.forName(string);
				Method method=class1.getDeclaredMethod(methodName);
				switch (type) {
				case "int":
					Integer intValue=(Integer) method.invoke(sentence);
					bWriter.write(String.valueOf(intValue));
					break;	
				default:
					break;
				}
				bWriter.newLine();
			}
			bWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void setSentencesList(ArrayList<Sentence> sentences) {
		this.sentences = sentences;
	}

	private void createFolder(File folder) {
		if (!folder.exists()) {
			folder.mkdir();
		} else {
			deleteFolder(folder);
//			try {
//				// deletefolder bitmeden aþaðýdaki klasörü oluþturuyor. bu
//				// yüzden wait verildi.
//				Thread.sleep(30);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			folder.mkdir();
		}
		
	}
	
	private void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
		
	}
	
	
}
