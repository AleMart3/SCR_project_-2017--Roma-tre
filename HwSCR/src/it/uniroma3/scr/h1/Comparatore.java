package it.uniroma3.scr.h1;

import java.util.ArrayList;
import java.util.List;

public class Comparatore {
	private List<Boolean> confronti;//lista contenente l'esito del confronto di ogni potenza con la soglia
	private Double probUtentePrimario;

	public Comparatore(List<Double> potenze, Double soglia){
		this.confronti = new ArrayList<>();
		this.confronta(potenze, soglia);
		this.calcolaPercentuale();
	}
	
	//confronta ogni potenza con la soglia e aggiunge il risultato del confronto nella lista
	public void confronta(List<Double> potenze, Double soglia){
		for(int i=0; i<potenze.size(); i++)
			this.confronti.add(potenze.get(i) > soglia);
	}

	//calcola la probabilita' di trasmissione dell'utente primario
	public void calcolaPercentuale(){
		Double cont = 0.0;
		for(int i = 0; i<confronti.size(); i++)
			if(this.confronti.get(i))
				cont++;
		this.probUtentePrimario = cont/10.0;
	}

	public Double getProbabilita(){
		return this.probUtentePrimario;
	}
}
