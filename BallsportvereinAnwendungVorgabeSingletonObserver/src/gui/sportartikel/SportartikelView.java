package gui.sportartikel;

import business.baelle.*;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;
//---------------------------------------------------------------------------------------
//import java.util.Observable;
//import java.util.Observer;
//---------------------------------------------------------------------------------------
// java.util Ansatz!
// SportartikelView ist hier der ConcreteObserver
public class SportartikelView implements Observer { // implements Observer {
	
	private SportartikelControl sportartikelControl;
  	private BaelleModel baelleModel;	
	
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane = new  Pane();
    private Label lblAnzeigeTrikots    		= new Label("Anzeige Trikots");
    private Label lblAnzeigeBaelle          = new Label("Anzeige B�lle");
    private TextArea txtAnzeigeTrikots      = new TextArea();
    private TextArea txtAnzeigeBaelle       = new TextArea();  
    // Wegen Observer Pattern nicht mehr gebraucht!
    //private Button btnAnzeigeBaelle         = new Button("Anzeige");
    //-------Ende Attribute der grafischen Oberflaeche-------
     
    public SportartikelView(SportartikelControl sportartikelControl, 
    	Stage stage, BaelleModel baelleModel){
    	Scene scene = new Scene(this.pane, 640, 340);
    	stage.setScene(scene);
    	stage.setTitle("Anzeige von Sportartikeln");
    	stage.show();
    	this.sportartikelControl = sportartikelControl;
    	this.baelleModel = baelleModel;
		this.initKomponenten();
		//this.initListener();
//---------------------------------------------------------------------------------------		
		// java.util Ansatz
		//this.baelleModel.addObserver(this); // Diese instanz der SportartikelView Klasse wird zum Observer der BaelleModel Klasse hinzugefügt
		
//---------------------------------------------------------------------------------------
//#######################################################################################
		// EIGNENER ANSATZ
		// Der BaelleModel Klasse wird der Observer SportartikelView hinzugefügt (hier das (this))
		this.baelleModel.addObserver(this);
		// Wird aufgerufen, wenn das Fenster geschlossen wird und entfernt die View von der Observer Liste
		stage.setOnCloseRequest(event -> close());
//#######################################################################################
   	}
//---------------------------------------------------------------------------------------

    // java.util Ansatz
    //@Override
	//public void update(Observable obs, Object o) {
	//	if (obs instanceof BaelleModel) {
	//		System.out.println("Die update-Methode der SportartikelView wurde aufgerufen!");
	//		zeigeBaelleAn();
	//	}
	//}
//---------------------------------------------------------------------------------------  
    private void initKomponenten(){
    	// Label
 	    Font font = new Font("Arial", 20);
 	    lblAnzeigeTrikots.setLayoutX(20);
        lblAnzeigeTrikots.setLayoutY(40);
        lblAnzeigeTrikots.setFont(font);
        lblAnzeigeTrikots.setStyle("-fx-font-weight: bold;"); 
        lblAnzeigeBaelle.setLayoutX(310);
        lblAnzeigeBaelle.setLayoutY(40);
        lblAnzeigeBaelle.setFont(font);
        lblAnzeigeBaelle.setStyle("-fx-font-weight: bold;"); 
        pane.getChildren().addAll(lblAnzeigeTrikots, lblAnzeigeBaelle);    
      	// Textbereiche	
    	txtAnzeigeTrikots.setEditable(false);
       	txtAnzeigeTrikots.setLayoutX(20);
       	txtAnzeigeTrikots.setLayoutY(90);
       	txtAnzeigeTrikots.setPrefWidth(220);
       	txtAnzeigeTrikots.setPrefHeight(185);
       	txtAnzeigeBaelle.setEditable(false);
       	txtAnzeigeBaelle.setLayoutX(310);
       	txtAnzeigeBaelle.setLayoutY(90);
       	txtAnzeigeBaelle.setPrefWidth(300);
       	txtAnzeigeBaelle.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeBaelle);        	
       	// Buttons <- werden nicht mehr gebraucht
        /*
       	btnAnzeigeBaelle.setLayoutX(310);
       	btnAnzeigeBaelle.setLayoutY(290);
       	pane.getChildren().add(btnAnzeigeBaelle); 
       	*/
    }
   
    //private void initListener() {
    	// Aufgrund von Observer Pattern nicht mehr benötigt!
    	/*
  	    btnAnzeigeBaelle.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBaelleAn();
	        	} 
   	    });
  	    */
    //}
   
    public void zeigeBaelleAn(){
   		String text = "";
   		for(int i = 0; i < baelleModel.holeBaelle().length; i++) {
   		    text = text + baelleModel.holeBaelle()[i].gibZurueck('|') + "\n";
   		}
   		txtAnzeigeBaelle.setText(text);
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
 		new MeldungsfensterAnzeiger(AlertType.INFORMATION,
 			"Information", meldung).zeigeMeldungsfensterAn();
    }
//#################################################################################################
	@Override
	public void update() {
		if (baelleModel != null) {
			System.out.println("Eigener Ansatz update methode aufruf sportartikelview");
			zeigeBaelleAn();
			zeigeInformationsfensterAn("Bälle wurden aktualisiert (Informationsfenster, wenn SportartikelView noch offen ist!).");
		} else {
			System.out.println("SportartikelView ist nicht mehr registriert.");
		}
		
		
	}
	// Abmelden des Observers wenn das Fenster geschlossen wird
	public void close() {
		this.baelleModel.removeObserver(this);
		System.out.println("SportartikelView wurde geschlossen");
	}
	
//#################################################################################################
}
