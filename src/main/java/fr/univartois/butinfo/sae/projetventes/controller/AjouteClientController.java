package fr.univartois.butinfo.sae.projetventes.controller;



import java.util.ArrayList;

import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientEntreprise;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientParticulier;
import fr.univartois.butinfo.sae.projetventes.model.client.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouteClientController {

    @FXML
    private TextField prenom;

    @FXML
    private TextField adresse;

    @FXML
    private RadioButton entreprise;

    @FXML
    private TextField nom;

    @FXML
    private RadioButton particulier;
    
    private Scene scene;
    
    private Stage stage;
    
    @FXML
    private ComboBox<Genre> genre;
    
    CarnetClients clients;
    
    public void setClients(CarnetClients clients) {
    	this.clients=clients;
    }
    
    public void setScene(Scene scene) {
    	this.scene=scene;
    	ObservableList<Genre> list = FXCollections.observableList(new ArrayList<Genre>());
    	list.add(Genre.Homme);
    	list.add(Genre.Femme);
    	genre.setItems(list);
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void changeScene() {
		stage.setScene(scene);
	}
    
    public void valider() {
    	if (particulier.isSelected()) {
    		clients.ajouterClient(new ClientParticulier(nom.getText(),adresse.getText(),0,prenom.getText(),genre.getValue()));
    	}
    	else if (entreprise.isSelected()) {
    		clients.ajouterClient(new ClientEntreprise(nom.getText(),adresse.getText(),0,prenom.getText()));
    	}
    	changeScene();
    }
    
    public void onEntreprise() {
    	genre.setDisable(true);
    	prenom.setText("Contact");
    	particulier.setSelected(false);
    }
    
    public void onParticulier() {
    	genre.setDisable(false);
    	prenom.setText("Prénom");
    	entreprise.setSelected(false);
    }
}