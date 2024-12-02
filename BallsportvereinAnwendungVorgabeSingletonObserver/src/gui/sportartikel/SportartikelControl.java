package gui.sportartikel;

import business.baelle.BaelleModel;
//import business.baelle.Singleton; <- Ansatz Wrapper Klasse Singleton!
import javafx.stage.Stage;

public class SportartikelControl {
	
	private SportartikelView sportartikelView;
	
	private BaelleModel baelleModel;

	public SportartikelControl(Stage stage){
		//this.baelleModel = Singleton.getInstance().getBaelleModel(); <- Ansatz Wrapper Klasse Singleton!
		this.baelleModel = BaelleModel.getInstance();
		this.sportartikelView = new SportartikelView(this, stage, 
			baelleModel);
	}

}
