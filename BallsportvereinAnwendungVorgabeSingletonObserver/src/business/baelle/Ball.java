package business.baelle;

public class Ball {
	
	private int einkaufsdatum;
	private String material;
	private String sportart;
	private String status;
	private String nutzung;
	private double preis;
	
	public Ball(int einkaufsdatum, String material, String sportart,
		String status, String nutzung, double preis) 
	 	throws Exception {
		this.einkaufsdatum = einkaufsdatum;
		this.material = material;
		this.sportart = sportart;
		this.status = status;
		this.nutzung = nutzung;
		this.preis = preis;
	}
	 
	public boolean ueberpruefeSportart(){
	    if(this.sportart == null){
	    	return false;
	    }
	    else
	    	return true;
	}	
	
	public int getEinkaufsdatum() {
		return einkaufsdatum;
	}
	
	public void setEinkaufsdatum(int einkaufsdatum) {
		this.einkaufsdatum = einkaufsdatum;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getSportart() {
		return sportart;
	}
	
	public void setSportart(String sportart) {
		this.sportart = sportart;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNutzung() {
		return nutzung;
	}
	
	public void setNutzung(String nutzung) {
		this.nutzung = nutzung;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public String gibZurueck(char trenner) {
		return (this.getEinkaufsdatum() + "") + trenner + this.getMaterial() + trenner
		+ this.getSportart() + trenner + this.getStatus() + trenner
		+ this.getNutzung() + trenner + this.getPreis();
	}
	
}
