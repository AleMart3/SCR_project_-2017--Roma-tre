package it.uniroma3.scr.h0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Soglia {
	private List<Double> potenze;
	private Double soglia;
	private static int NUMPOTENZE = 1000; //numero di sequenze da generare e quindi di potenze con cui calcolare la soglia
	private static int posizioneSoglia = 989; //probabilita'  di falso allarme 10/1000

	public Soglia(Double snr){
		this.potenze = new ArrayList<>();
		this.generaPotenze(snr);
		this.soglia = this.calcolaSoglia();
	}

	public void generaPotenze(Double snr){
		for(int i=0; i<NUMPOTENZE; i++)
			this.potenze.add(new CreatoreSequenzaRumorosa(snr).CalcolaPotenza());		  
	}

	public Double calcolaSoglia(){
		Collections.sort(this.potenze);
		return this.potenze.get(posizioneSoglia);

	}


	public Double getSoglia(){
		return this.soglia;
	}

}
