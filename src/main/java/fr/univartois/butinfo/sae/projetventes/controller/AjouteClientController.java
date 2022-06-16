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
import javafx.scene.control.Button;
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
    
    @FXML
    private Button validerAjout;

    @FXML
    private Button validerEdit;
    
    @FXML
    private ComboBox<Genre> genre;
    
    private Scene scene;
    
    private Stage stage;
    
    private CarnetClients clients;
    
    private CarnetClientController control;
    
    public void setClients(CarnetClients clients) {
    	this.clients=clients;
    	validerAjout.setVisible(true);
    	validerEdit.setVisible(false);
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
    	genre.setVisible(false);
    	prenom.setText("Contact");
    	particulier.setSelected(false);
    }
    
    public void onParticulier() {
    	genre.setVisible(true);
    	prenom.setText("Prénom");
    	entreprise.setSelected(false);
    }
    
    public void edit(Client client) {
    	validerAjout.setVisible(false);
    	validerEdit.setVisible(true);
    	entreprise.setVisible(false);
    	particulier.setVisible(false);
    	nom.setText(client.getNom());
    	adresse.setText(client.getAdresse());
    	if (client instanceof ClientParticulier) {
    		prenom.setPromptText("Prénom");
    		ClientParticulier c = (ClientParticulier)client;
    		genre.setVisible(true);
    		prenom.setText(c.getPrenom());
    		genre.setValue(c.getGenre());
    	}
    	else if (client instanceof ClientEntreprise) {
    		prenom.setPromptText("Contact");
    		ClientEntreprise c = (ClientEntreprise)client;
    		prenom.setText(c.getContact());
    		genre.setVisible(false);
    	}
    }
    
    public void retour() {
    	changeScene();
    }
    
    public void validerEdit() {
    	control.modifierClient();
    }
    
    public void updateClient(Client c) {
    	clients.supprimerClient(c);
    	c.setNom(nom.getText());
    	c.setAdresse(adresse.getText());
    	if (c instanceof ClientParticulier) {
    		ClientParticulier d = (ClientParticulier)c;
    		d.setPrenom(prenom.getText());
    		d.setGenre(genre.getValue());
    	}
    	else if (c instanceof ClientEntreprise) {
    		ClientEntreprise d = (ClientEntreprise)c;
    		d.setContact(prenom.getText());
    	}
    	clients.ajouterClient(c);
    	changeScene();
    }
    
    public void setControl(CarnetClientController control) {
    	this.control=control;
    }
}