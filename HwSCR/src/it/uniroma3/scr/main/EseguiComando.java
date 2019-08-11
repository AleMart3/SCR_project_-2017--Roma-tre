package it.uniroma3.scr.main;

import java.io.IOException;

public class EseguiComando {
	private EnergyDetection ed;	
	
	public EseguiComando() throws IOException{
		this.ed = new EnergyDetection();
	}
 
	public void calcolaUna(String s) throws IOException{
		Long tempoiniziale= System.currentTimeMillis();
		this.ed.stampaProbUnaSequenza(s);;
		Long tempofinale= System.currentTimeMillis();
		System.out.println("Tempo impiegato: " + (tempofinale-tempoiniziale)/1000 + " secondi");
	}

	public void calcolaTutte() throws IOException{
		Long tempoiniziale= System.currentTimeMillis();
		this.ed.stampaTutteProbH1();;
		Long tempofinale= System.currentTimeMillis();
		System.out.println("Tempo impiegato: " + (tempofinale-tempoiniziale)/1000 + " secondi");
	}

}
