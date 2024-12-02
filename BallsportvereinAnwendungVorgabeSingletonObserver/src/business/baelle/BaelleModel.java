package business.baelle;

import java.io.*;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
//---------------------------------------------------------------------------------------
// Ansatz mit java.util
//import java.util.Observable;
//---------------------------------------------------------------------------------------
// Ansatz mit java.util
// BaelleModel ist hier der ConcreteObservable
public class BaelleModel implements Observable { // extends Observable {
//#######################################################################################
	// EIGENER ANSATZ!!!
	// Kann man sich in der Observable Klasse von java.util anschauen!
	private Vector<Observer> observers = new Vector<>();
	
//#######################################################################################
	private Ball[] baelle = new Ball[100];
	private int anzahlBaelle;
//-----------------------------------------------------------------------------------------
	// Ansatz Singleton Pattern
	
	// Statische Instanz von BaelleModel
	private static BaelleModel instance;
	
	// privater Konstruktor, verhindert new BaelleModel() aufruf in anderen Klassen
	private BaelleModel() { }
	
	// public Statische Methode, mit der die erste Instanz erzeugt werden kann, sonst aber nur die erste Instanz returnt!
	public static BaelleModel getInstance() {
		if(instance == null) {
			instance = new BaelleModel();
		}
		return instance;
	}
//-----------------------------------------------------------------------------------------
	
	public int getAnzahlBaelle() {
		return anzahlBaelle;
	}

	public void setAnzahlBaelle(int anzahlBaelle) {
		this.anzahlBaelle = anzahlBaelle;
	}
	
	public Ball[] holeBaelle() {
		Ball[] result = new Ball[this.getAnzahlBaelle()];
		for(int i = 0; i < result.length; i++) {
			result[i] = this.baelle[i];
		}
		return result;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		Ball ball = null;
		int i = 0;
		while (ball == null && i < this.getAnzahlBaelle()) {
			if(Integer.parseInt(einkaufsdatum) == this.holeBaelle()[i].getEinkaufsdatum()){
				ball = this.holeBaelle()[i];
			}
			i++;
		}
		return ball;
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	   	for(int i = 0; i < this.anzahlBaelle; i++) {
	   	 	this.baelle[i] = null;
	   	}
	   	this.anzahlBaelle = Integer.parseInt(ein.readLine());
	   	String[] zeile;
	   	for(int i = 0; i < this.getAnzahlBaelle(); i++) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle[i] = new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5]));
	   	}
	    ein.close();
//#######################################################################################
	    // EIGENER ANSATZ -> Aufruf der Methode, die die Observer benachrichtig, wenn diese Methode
	    // Ausgeführt worden ist -> View Observer führen ihre update Methoden aus!
	    notifyObserver();
//#######################################################################################
//---------------------------------------------------------------------------------------	    
	    // java.util ansatz
	    //setChanged(); // Markiert das Objekt als geändert
	    //notifyObservers(); // Benachrichtig alle Observer
//---------------------------------------------------------------------------------------
 	}
//#######################################################################################
	// EIGENE IMPLEMENTATION!
	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer obs : observers) {
			obs.update();
		}
	}
//#######################################################################################
}