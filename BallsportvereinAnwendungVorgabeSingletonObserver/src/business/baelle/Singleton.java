// Ansatz mit Wrapper Klasse

/*package business.baelle;

public class Singleton {
	
	private static Singleton theInstance = null; // Instanz von Singleton
	private BaelleModel baelleModel; // Instanz von BaelleModel
	
	private Singleton() {
		baelleModel = new BaelleModel();
	}
	
	public static Singleton getInstance() {
		if(theInstance == null) {
			theInstance = new Singleton();
		}
		return theInstance;
		
	}
	
	public BaelleModel getBaelleModel() {
		return baelleModel;
	}

}
*/