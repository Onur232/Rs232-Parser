package com.sur.parser.program;

import com.sur.parser.controller.Application;

public class Driver {
/*
 * Text dosyalar�n� masa�st�nde Sur Parser klas�r�ne atar.
 * E�er c�mlelerin ba��nda 1484832755,$DASUR,0010,2000,0793,00*5F oldu�u gibi bir numara varsa
 * �ncelikle Ins Number Remover projesi �al��t�r�l�p, o projenin ��kt� dosyas� bu programa sokulmal�d�r.
 * ��nk� bu program�n giri� dosyas�ndaki c�mleler $DASUR,0010,2000,0793,00*5F �eklinde olmal�d�r.
 */

	public static void main(String[] args) {
		Application application=new Application();
		application.start();
	}

}
