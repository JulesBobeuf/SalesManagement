package fr.univartois.butinfo.sae.projetventes.controller;

import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientEntreprise;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientParticulier;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.DejaPresentException;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.FlotteVehicules;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Fourgon;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.PasPresentException;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Vehicule;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouteVehiculeController {

	@FXML
	private TextField anneeM;

	@FXML
	private TextField conducteur;

	@FXML
	private RadioButton fourgon;

	@FXML
	private TextField immatriculation;

	@FXML
	private TextField marque;

	@FXML
	private Label erreur;

	@FXML
	private TextField modele;

	@FXML
	private TextField nbKm;

	@FXML
	private Button validerAjout;

	@FXML
	private Button validerEdit;

	@FXML
	private RadioButton voiture;

	@FXML
	private TextField poidsMax;

	@FXML
	private TextField volumeMax;

	private Scene scene;

	private Stage stage;

	private FlotteVehicules flotteVehicules;

	private Vehicule tmp;

	public void init() {
		validerAjout.setVisible(true);
		validerEdit.setVisible(false);
		erreur.setVisible(false);
	}

	@FXML
	public void onFourgon(ActionEvent event) {
		validerAjout.setVisible(true);
		validerEdit.setVisible(false);
		voiture.setSelected(false);
		volumeMax.setVisible(true);
		poidsMax.setVisible(true);
		conducteur.setPromptText("Livreur");
	}

	@FXML
	public void onVoiture(ActionEvent event) {
		volumeMax.setVisible(false);
		poidsMax.setVisible(false);
		conducteur.setPromptText("Commercial");
		fourgon.setSelected(false);
	}

	@FXML
	public void retour(ActionEvent event) {
		changeScene();
	}

	@FXML
	public void valider(ActionEvent event) {
		if (fourgon.isSelected()) {
			try {
				flotteVehicules.ajouteVehicule(new Fourgon(marque.getText(),immatriculation.getText(),modele.getText(),Double.parseDouble(nbKm.getText()),Integer.parseInt(anneeM.getText()),Double.parseDouble(poidsMax.getText()),Double.parseDouble(volumeMax.getText()),null));
			} catch (Exception e) {
				erreur.setVisible(true);
				erreur.setText("Une mauvaise valeur à été rentré.");
				return;
			}
		}
		else if (voiture.isSelected()) {
			try {
				flotteVehicules.ajouteVehicule(new Voiture(marque.getText(),immatriculation.getText(),modele.getText(),Double.parseDouble(nbKm.getText()),Integer.parseInt(anneeM.getText()),null));
			} catch (Exception e) {
				erreur.setVisible(true);
				erreur.setText("Une mauvaise valeur à été rentré.");
				return;
			}
		}
		changeScene();
	}

	public void edit(Vehicule v) {
		this.tmp=v;
		erreur.setVisible(false);
		validerAjout.setVisible(false);
		validerEdit.setVisible(true);
		fourgon.setVisible(false);
		voiture.setVisible(false);
		marque.setText(v.getMarque());
		modele.setText(v.getModele());
		immatriculation.setText(v.getImmatriculation());
		nbKm.setText(Double.toString(v.getNbKm()));
		anneeM.setText(Integer.toString(v.getAnneeMiseEnCirculation()));
		if (v instanceof Voiture) {
			Voiture c = (Voiture)v;
			poidsMax.setVisible(false);
			volumeMax.setVisible(false);
			conducteur.setText(c.getCommercial().getNom());
		}
		else if (v instanceof Fourgon) {
			Fourgon c = (Fourgon)v;
			poidsMax.setVisible(true);
			volumeMax.setVisible(true);
			poidsMax.setText(Double.toString(c.getPoidsMax()));
			volumeMax.setText(Double.toString(c.getVolumeMax()));
			conducteur.setText(c.getLivreur().getNom());
		}
	}
	@FXML
	public void validerEdit() {
		try {
			flotteVehicules.supprimeVehicule(tmp);
		} catch (PasPresentException e1) {
			erreur.setVisible(true);
			erreur.setText("Le vehicule n'est pas présent dans la liste");
			return;
		}
		tmp.setMarque(marque.getText());
		tmp.setModele(modele.getText());
		tmp.setImmatriculation(immatriculation.getText());
		tmp.setNbKm(Double.parseDouble(nbKm.getText()));
		tmp.setAnneeMiseEnCirculation(Integer.parseInt(anneeM.getText()));
		if (tmp instanceof Voiture) {
			Voiture d = (Voiture)tmp;
			d.setCommercial(null);
		}
		else if (tmp instanceof Fourgon) {
			Fourgon d = (Fourgon)tmp;
			d.setLivreur(null);
			d.setPoidsMax(Double.parseDouble(poidsMax.getText()));
			d.setVolumeMax(Double.parseDouble(volumeMax.getText()));
		}
		try {
			flotteVehicules.ajouteVehicule(tmp);
		} catch (DejaPresentException e) {
			erreur.setVisible(true);
			erreur.setText("Le véhicule est déjà présent dans la liste.");
			return;
		}
		changeScene();
	}

	public void changeScene() {
		stage.setScene(scene);
	}

	public void setStage(Stage stage) {
		this.stage=stage;
	}

	public void setScene(Scene scene) {
		this.scene=scene;
	}

	public void setFlotteVehicules(FlotteVehicules v) {
		this.flotteVehicules=v;
	}

}

