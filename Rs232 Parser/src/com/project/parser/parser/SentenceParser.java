package com.sur.parser.parser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.sur.parser.objects.Sentence;


public class SentenceParser {
	
	private List<String> surSentences=new ArrayList<>();
	private List<String> otherSentences = new ArrayList<>();
	private ArrayList<Sentence> surs=new ArrayList<>();
	
	private ArrayList<Integer> surats=new ArrayList<>();
	private ArrayList<Integer> umks=new ArrayList<>();
	private ArrayList<Integer> rotas=new ArrayList<>();
	private int currentIndex=0;
	
	public SentenceParser() {
		
	}

	public void parseFile(File file) {
		try {
			for (String line : Files.readAllLines(file.toPath(), Charset.forName("Cp1252"))) {
				String[] split = line.split(",");
				switch (split[0]) {
				case "$DASUR":
					surSentences.add(line);
					break;
				default:
					otherSentences.add(line);
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseSentences() {
		for (String string : surSentences) {
			Sentence sentence=new Sentence();
			String[] split = string.split(",");
			Integer surat = Integer.valueOf(split[1]);
			sentence.setSurat(surat);
			surats.add(surat);
			Integer umk = Integer.valueOf(split[2]);
			sentence.setUmk(umk);
			umks.add(umk);
			Integer rota = Integer.valueOf(split[3]);
			sentence.setRota(rota);
			rotas.add(rota);
			surs.add(sentence);
			
		}
	}

	public ArrayList<Sentence> getSurs() {
		return surs;
	}

	public void setSurs(ArrayList<Sentence> surs) {
		this.surs = surs;
	}


	

}
