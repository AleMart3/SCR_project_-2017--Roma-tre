package it.uniroma3.scr.h1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaPotenze {
	private List<Double> potenze; //lista delle potenze da calcolare per ogni blocco di lunghezza LUNBLOCCO 
	private static int NUMCAMPIONI = 1000000; //numero dei campioni ascoltati 
    private static int LUNBLOCCO = 1000; //numero dei campioni in ogni blocco
	
    public ListaPotenze(String path) throws IOException{
		this.potenze = new ArrayList<>();
		this.calcolaPotenze(path);
	}
    
    //calcolo 1000 potenze relative ai 1000 blocchi composti da 1000 campioni 
	public void calcolaPotenze(String path) throws IOException{
		CaricatoreSequenza sequenza= new CaricatoreSequenza(path);
		List<Double> listaValori = sequenza.getSequenza();
		int j = 1;    //variabile j usata per dividere la sequenza in blocchi
		Double potenza = 0.0;
		for(int i=0; i < 2*NUMCAMPIONI; i++)  //itero su tutta la sequenza, 2 milioni di valori (Re e Im)
			if(i == (2*LUNBLOCCO*j)-1){  // ogni 1000 campioni (2 mila valori) aggiungo la potenza calcolata alla lista
				this.potenze.add(potenza/LUNBLOCCO); //linearizzo la potenza alla lunghezza del blocco
				j++;
				potenza = 0.0;
			}
			else 
				potenza += Math.pow(listaValori.get(i), 2.0);
	}

	public List<Double> getListaPotenze(){
		return this.potenze;
	}
}
