package main;

import gui.baelle.BaelleControl;
import gui.sportartikel.SportartikelControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BaelleControl(primaryStage);
		Stage fensterSportartikel = new Stage();
 		new SportartikelControl(fensterSportartikel);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
