package fr.univartois.butinfo.sae.projetventes.controller;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.article.Stock;
import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import fr.univartois.butinfo.sae.projetventes.model.client.ICarnetClient;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Conducteurs;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.FlotteVehicules;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.IConducteurs;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.IFlotteVehicules;
import fr.univartois.butinfo.sae.projetventes.principal.IGestionVentes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestionVentesController implements IGestionVentes {
	
	private Conducteurs conducteurs = new Conducteurs("Conducteurs");
	
	private FlotteVehicules flotteVehicules = new FlotteVehicules("Véhicules");
	
	private CarnetClients carnet = new CarnetClients("Carnet de cliens");
	
	private Stock stock = new Stock("Stock d'articles");
	
	private Stage stage;

	private Scene scene;

    @FXML
    public void onClients(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CarnetClientView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
    	ICarnetClient controller = fxmlLoader.getController();
    	stage.setScene(scene);
        stage.setTitle("Carnet de clients");
        controller.setCarnetClients(carnet);
        controller.setScene(scene);
        controller.setStage(stage);
    }

    @FXML
    public void onConducteurs(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ConducteursView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
    	IConducteurs controller = fxmlLoader.getController();
    	stage.setScene(scene);
        stage.setTitle("Liste des conducteurs");
        controller.setConducteurs(conducteurs);
        controller.setScene(scene);
        controller.setStage(stage);

    }

    @FXML
    public void onStock(ActionEvent event) {
    	
    }

    @FXML
    public void onVehicules(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/flotteVehiculesView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
    	IFlotteVehicules controller = fxmlLoader.getController();
    	stage.setScene(scene);
        stage.setTitle("Liste des véhicules");
        controller.setFlotteVehicules(flotteVehicules);
        controller.setScene(scene);
        controller.setStage(stage);
    }
    
    public void setScene(Scene scene) {
    	this.scene=scene;
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }

}