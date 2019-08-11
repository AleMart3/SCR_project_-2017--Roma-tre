package it.uniroma3.scr.main;


public class InterfacciaUtente {


	public InterfacciaUtente(){
	}

	public void stampaComandi(){
		System.out.println("Inserisci:");
		System.out.println("-'1' per analizzare la sequenza numero 1");
		System.out.println("-'2' per analizzare la sequenza numero 2");
		System.out.println("-'3' per analizzare la sequenza numero 3");
		System.out.println("-'tutte' per analizzare tutte le sequenze");
		System.out.println("-'fine' per terminare");

	}
	public void stampaErroreDigitazione(){
		System.out.println("Il valore immesso non e'valido");
	}


}
