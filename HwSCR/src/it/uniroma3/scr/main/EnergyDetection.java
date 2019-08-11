package it.uniroma3.scr.main;


import it.uniroma3.scr.h1.Comparatore;
import it.uniroma3.scr.h1.ListaPotenze;
import it.uniroma3.scr.h0.Soglia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EnergyDetection {
	private Map<Double, ListaPotenze> mappaPotenze; //mappa contenente le potenze dei blocchi con cui si e' suddivisa la sequenza ascoltata
	private Map<Double, Soglia> tabellaSoglie; //tabella contenente le soglie
	private List<Double> rapportiSNR; //lista contenente gli SNR 


	public EnergyDetection() throws IOException{
		this.creaListaSNR();
		this.creaSoglie();
	}

	public void creaListaSNR(){
		this.rapportiSNR = new ArrayList<>();
		this.rapportiSNR.add(-13.0);
		this.rapportiSNR.add(-8.0);
		this.rapportiSNR.add(-3.0);
		this.rapportiSNR.add(2.0);
	}

	/*crea una mappa associando ad ogni SNR il rispettivo valore di soglia calcolato*/
	public void creaSoglie(){
		this.tabellaSoglie = new HashMap<>();
		for(int i=0; i<this.rapportiSNR.size(); i++)
			this.tabellaSoglie.put(this.rapportiSNR.get(i), new Soglia(this.rapportiSNR.get(i)));
	}

	/*crea una mappa associando ad ogni SNR la rispettiva lista di potenze relativa
	 * alla sequenza passata come parametro*/
	public void creaListePotenze(String s) throws IOException{
		this.mappaPotenze = new HashMap<>();
		this.mappaPotenze.put(-13.0 , new ListaPotenze("Sequenze_SDR_2015/Sequenza_"+ s +"/output_4.dat"));
		this.mappaPotenze.put(-8.0, new ListaPotenze("Sequenze_SDR_2015/Sequenza_"+ s +"/output_3.dat"));
		this.mappaPotenze.put(-3.0, new ListaPotenze("Sequenze_SDR_2015/Sequenza_"+ s +"/output_1.dat"));
		this.mappaPotenze.put(2.0, new ListaPotenze("Sequenze_SDR_2015/Sequenza_"+ s +"/output_2.dat"));

	}

	/*Stampa le probabilita'  di H1 per ogni SNR di ogni sequenza*/
	public void stampaTutteProbH1() throws IOException{
		for(int i=1; i<4; i++){
			System.out.println("Calcolo in corso per la sequenza: "+i);
			this.creaListePotenze(String.valueOf(i));
			for(int j=0; j<this.rapportiSNR.size(); j++){
				Comparatore c = new Comparatore(this.mappaPotenze.get(this.rapportiSNR.get(j)).getListaPotenze(), this.tabellaSoglie.get(this.rapportiSNR.get(j)).getSoglia());      
				System.out.println("La probabilita  di H1 a "+ this.rapportiSNR.get(j) +" dB e': "+ c.getProbabilita()+ "%");
			}
			System.out.println("----------------------");
		}
		this.mappaPotenze.clear();

	}

	/*Stampa la probabilita' di H1 per ogni SNR con cui
	 * E' stata ascoltata una sequenza passata per parametro*/
	public void stampaProbUnaSequenza(String s) throws IOException{
		System.out.println("Calcolo in corso per la sequenza: "+s);
		this.creaListePotenze(s);
		for(int j=0; j<this.rapportiSNR.size(); j++){
			Comparatore c = new Comparatore(this.mappaPotenze.get(this.rapportiSNR.get(j)).getListaPotenze(), this.tabellaSoglie.get(this.rapportiSNR.get(j)).getSoglia());      
			System.out.println("La probabilita di H1 a "+ this.rapportiSNR.get(j) +" dB e': "+ c.getProbabilita()+ "%");
		}
		this.mappaPotenze.clear();
	}
}

