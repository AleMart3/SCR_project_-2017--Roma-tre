package it.uniroma3.scr.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		esegui();
	}

	public static void esegui() throws IOException{
		Boolean continua = true;
		InterfacciaUtente hud = new InterfacciaUtente();
		Scanner in = new Scanner(System.in);
		EseguiComando ec = new EseguiComando();
		hud.stampaComandi();
		while(continua && in.hasNext()){
			String input = in.next();
			if(input.equals("1") || input.equals("2") || input.equals("3"))
				ec.calcolaUna(input);
			else if(input.equals("tutte"))
				ec.calcolaTutte();	
			else if(input.equals("fine"))
				continua=false;
			else
				hud.stampaErroreDigitazione();
		}
		in.close();
	}
}


