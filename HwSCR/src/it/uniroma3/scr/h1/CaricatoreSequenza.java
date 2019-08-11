package it.uniroma3.scr.h1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaricatoreSequenza{
	private List<Double> sequenzaAscoltata;
	private Path filePath;

	public CaricatoreSequenza(String filePath) throws IOException{
		this.sequenzaAscoltata= new ArrayList<>();
		this.filePath= Paths.get(filePath);
		this.caricaFile();

	}

	/*Per ogni campione leggo prima parte reale e l'aggiungo alla lista poi parte immaginaria e l'aggiungo
	alla lista, avro' quindi una lista di 1 milione di campioni, cioe' 2 milioni di valori */
	public void caricaFile() throws IOException{
		Scanner scanner= new Scanner(filePath);
		while(scanner.hasNext())
			sequenzaAscoltata.add(Double.parseDouble(scanner.next())); 
		scanner.close();											
	}												

	public List<Double> getSequenza(){
		return this.sequenzaAscoltata;
	}

}