package it.uniroma3.scr.h0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatoreSequenzaRumorosa {
	private List<Double> campioni;
	private Double Pn; //potenza della curva gaussiana generata
	private static int NUMCAMPIONI = 1000; //numero di campioni con cui si vuole approssimare la curva gaussiana

	public CreatoreSequenzaRumorosa(Double snr){
		this.Pn = CalcolaPn(snr);
		this.campioni = new ArrayList<>();
		this.CreaSequenza();
	}

	public Double CalcolaPn(Double snr){
		 return Math.pow(10.0, ((-snr)/10));
	}
	
	public Double CreaCampione(){
		Random random = new Random();
		return random.nextGaussian()*Math.sqrt(this.Pn/2); //ho 2000 valori, devo dividere per 2
	}

	public void CreaSequenza(){
		for(int i=0; i<(2*NUMCAMPIONI); i++)    //1000 campioni, quindi 2000 valori da generare parte Re e Im
			this.campioni.add(this.CreaCampione());

	}

	public Double CalcolaPotenza(){
		Double somma = 0.0;
		for(Double Pi : this.campioni)
			somma += Pi * Pi;
		return somma/1000;
	}

	public List<Double> getSequenza(){
		return this.campioni;
	}
}
