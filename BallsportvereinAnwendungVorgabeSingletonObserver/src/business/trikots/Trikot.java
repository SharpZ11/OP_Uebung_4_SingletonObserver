package business.trikots;

public class Trikot {
	
	private int trikotnummer;
	private int groesse;
	private double preis;
	private int einkaufsdatum;
	
	public Trikot(int trikotnummer, int groesse, double preis, int einkaufsdatum) {
		super();
		this.trikotnummer = trikotnummer;
		this.groesse = groesse;
		this.preis = preis;
		this.einkaufsdatum = einkaufsdatum;
	}
	
	public boolean ueberpruefePreis(){
	    if(this.preis < 0){
	    	return false;
	    }
	    else{
	    	return true;
	    }	
	}	

	public int getTrikotnummer() {
		return trikotnummer;
	}

	public void setTrikotnummer(int trikotnummer) {
		this.trikotnummer = trikotnummer;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getEinkaufsdatum() {
		return einkaufsdatum;
	}

	public void setEinkaufsdatum(int einkaufsdatum) {
		this.einkaufsdatum = einkaufsdatum;
	}
	
	public String gibZurueck(char trenner) {
		return (this.getEinkaufsdatum() + "") + trenner 
			+ this.getTrikotnummer() + trenner
			+ this.getGroesse() + trenner + this.getPreis();
	}

}
