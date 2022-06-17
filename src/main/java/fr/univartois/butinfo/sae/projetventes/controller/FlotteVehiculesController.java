package fr.univartois.butinfo.sae.projetventes.controller;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientEntreprise;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientParticulier;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.FlotteVehicules;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Fourgon;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.IFlotteVehicules;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.PasPresentException;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Vehicule;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class FlotteVehiculesController implements IFlotteVehicules {

    @FXML
    private Label anneeM;

    @FXML
    private Button boutonAdd;

    @FXML
    private Button boutonEdit;

    @FXML
    private Label immatriculation;

    @FXML
    private ListView<Vehicule> listview;

    @FXML
    private Label marque;

    @FXML
    private Label modele;

    @FXML
    private Label nbKm;

    @FXML
    private Label nom;

    @FXML
    private Label nomflotteVehicules;

    @FXML
    private Label poidsMax;

    @FXML
    private Label prenom;

    @FXML
    private Label volMax;

	private FlotteVehicules flotteVehicules;

	private Scene scene;

	private Stage stage;

	private Scene scene2;

	@Override
	public void ajouterVehicule() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteVehiculeView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		AjouteVehiculeController controller = fxmlLoader.getController();
		controller.setScene(this.scene2);
		controller.setStage(stage);
		controller.setFlotteVehicules(flotteVehicules); 
		controller.init();
		}
	
	@Override
	public void supprimerVehicule() throws PasPresentException {
		Vehicule v = listview.getSelectionModel().getSelectedItem();
		flotteVehicules.supprimeVehicule(v);
		
	}

	@Override
	public void editerVehicule() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteVehiculeView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		AjouteVehiculeController controller = fxmlLoader.getController();
		controller.setScene(this.scene2);
		controller.setStage(stage);
		controller.setFlotteVehicules(flotteVehicules);
		controller.edit(listview.getSelectionModel().getSelectedItem());
		
	}
	
	public void changeScene() {
		stage.setScene(scene);
	}
	
	public void setScene2(Scene scene2) {
		this.scene2=scene2;
	}

	@FXML
	public void retour(ActionEvent event) {
		changeScene();
	}

	@Override
	public void setFlotteVehicules(FlotteVehicules flotteVehicules) {
		this.flotteVehicules=flotteVehicules;
		nomflotteVehicules.setText(flotteVehicules.getNom());
		listview.setItems(flotteVehicules.getVehicules());
		listview.getSelectionModel().selectedItemProperty().addListener((p,o,n) -> {
			prenom.setVisible(true);
			modele.setText(n.getModele());
			marque.setText(n.getMarque());
			immatriculation.setText(n.getImmatriculation());
			nbKm.setText(Double.toString(n.getNbKm()));
			anneeM.setText(Integer.toString(n.getAnneeMiseEnCirculation()));
			if (n instanceof Voiture) {
				poidsMax.setVisible(false);
				volMax.setVisible(false);
				Voiture m = (Voiture)n;
				if (m.getCommercial()!=null) {
					nom.setText(m.getCommercial().getNom());
					prenom.setText(m.getCommercial().getPrenom());
				}
				else {
					nom.setText("Pas de commercial assigné");
					prenom.setVisible(false);
				}
			}
			else if (n instanceof Fourgon) {
				Fourgon m = (Fourgon)n;
				poidsMax.setVisible(true);
				volMax.setVisible(true);
				poidsMax.setText(Double.toString(m.getPoidsMax()));
				volMax.setText(Double.toString(m.getVolumeMax()));
				if (m.getLivreur()!=null) {
					nom.setText(m.getLivreur().getNom());
					prenom.setText(m.getLivreur().getPrenom());
				}
				else {
					nom.setText("Pas de livreur assigné");
					prenom.setVisible(false);
				}
			}
				
		});
		listview.setCellFactory(list -> {
    		return new ListCell<>() {
    			@Override
    			public void updateItem(Vehicule vehicule, boolean empty) {
    				super.updateItem(vehicule, empty);
    				if (empty || (vehicule == null)) {
    					setText(null);
    				} else {
    					setText(vehicule.getModele());
    				}
    			}
    		};
    	});
		
	}

	@Override
	public void setStage(Stage stage) {
		this.stage=stage;
		
	}
	
	@Override
	public void setScene(Scene scene) {
		this.scene=scene;
		
	}

}

