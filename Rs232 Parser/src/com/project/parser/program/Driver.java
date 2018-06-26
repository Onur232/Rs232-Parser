package com.sur.parser.program;

import com.sur.parser.controller.Application;

public class Driver {
/*
 * Text dosyalarýný masaüstünde Sur Parser klasörüne atar.
 * Eðer cümlelerin baþýnda 1484832755,$DASUR,0010,2000,0793,00*5F olduðu gibi bir numara varsa
 * öncelikle Ins Number Remover projesi çalýþtýrýlýp, o projenin çýktý dosyasý bu programa sokulmalýdýr.
 * Çünkü bu programýn giriþ dosyasýndaki cümleler $DASUR,0010,2000,0793,00*5F þeklinde olmalýdýr.
 */

	public static void main(String[] args) {
		Application application=new Application();
		application.start();
	}

}
