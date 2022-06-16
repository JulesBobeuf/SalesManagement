package fr.univartois.butinfo.sae.projetventes.controller;

import java.util.ArrayList;

import fr.univartois.butinfo.sae.projetventes.model.client.Genre;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Commercial;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Conducteur;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Conducteurs;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.DejaPresentException;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Livreur;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Livreur;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.PasPresentException;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.TypeDePermis;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Voiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouteConducteurController {

    @FXML
    private RadioButton commercial;

    @FXML
    private Label erreur;

    @FXML
    private RadioButton livreur;

    @FXML
    private TextField nbHeures;

    @FXML
    private TextField nom;

    @FXML
    private TextField numPermis;

    @FXML
    private TextField prenom;

    @FXML
    private ComboBox<TypeDePermis> typePermis;

    @FXML
    private Button validerAjout;

    @FXML
    private Button validerEdit;

	private Stage stage;

	private Scene scene;

	private Conducteurs conducteurs;
    
	private Conducteur tmp;
    public void init() {
    	erreur.setVisible(false);
    	validerAjout.setVisible(true);
    	validerEdit.setVisible(false);
    	ObservableList<TypeDePermis> list = FXCollections.observableList(new ArrayList<TypeDePermis>());
    	list.add(TypeDePermis.PERMIS_A);
    	list.add(TypeDePermis.PERMIS_B);
    	list.add(TypeDePermis.PERMIS_C);
    	list.add(TypeDePermis.PERMIS_D);
    	list.add(TypeDePermis.PERMIS_E);
    	typePermis.setItems(list);
    	
    }

    @FXML
    public void onCommercial(ActionEvent event) {
    	livreur.setSelected(false);
    	nbHeures.setPromptText("Nombre de visites");
    }

    @FXML
    public void onLivreur(ActionEvent event) {
    	commercial.setSelected(false);
    	nbHeures.setPromptText("Nombre d'heures");
    }
    
    public void changeScene() {
		stage.setScene(scene);
	}

    @FXML
    public void retour(ActionEvent event) {
    	changeScene();
    }

    @FXML
    public void valider(ActionEvent event) {
    	if (commercial.isSelected()) {
    		try {
				conducteurs.ajouteConducteur(new Commercial(nom.getText(),prenom.getText(),numPermis.getText(),typePermis.getValue(),Integer.parseInt(nbHeures.getText())));
			} catch (Exception e) {
				erreur.setVisible(true);
				erreur.setText("Une mauvaise valeur à été rentré.");
				return;
			}
    	}
    	else if (livreur.isSelected()) {
    		try {
    			conducteurs.ajouteConducteur(new Livreur(nom.getText(),prenom.getText(),numPermis.getText(),typePermis.getValue(),Integer.parseInt(nbHeures.getText())));
    		} catch (Exception e) {
    			erreur.setVisible(true);
    			erreur.setText("Une mauvaise valeur à été rentré.");
    			return;
			}
    	}
    	changeScene();

    }

    @FXML
    
    public void edit(Conducteur c) {
    	this.tmp=c;
    	erreur.setVisible(false);
    	validerAjout.setVisible(false);
    	validerEdit.setVisible(true);
    	commercial.setVisible(false);
    	livreur.setVisible(false);    	
    	nom.setText(c.getNom());
    	prenom.setText(c.getPrenom());
    	numPermis.setText(c.getNumPermis());
    	typePermis.setValue(c.getTypePermis());
    	if (c instanceof Commercial) {
    		nbHeures.setPromptText("Nombre de visites");
    		Commercial d = (Commercial)c;
    		nbHeures.setText(Integer.toString(d.getNbVisites()));
    	}
    	else if (c instanceof Livreur) {
    		nbHeures.setPromptText("Nombre d'heures");
    		Livreur d = (Livreur)c;
    		nbHeures.setText(Integer.toString(d.getNbHeures()));
    		
    	}
    }
    public void validerEdit(ActionEvent event) {
    	try {
			conducteurs.supprimeConducteur(tmp);
		} catch (Exception e) {
			erreur.setVisible(true);
			erreur.setText("Le vehicule n'est pas présent dans la liste");
			return;
		}
    	tmp.setNom(nom.getText());
    	tmp.setPrenom(prenom.getText());
    	tmp.setNumPermis(numPermis.getText());
    	tmp.setTypePermis(typePermis.getValue());
    	if (tmp instanceof Commercial) {
    		Commercial d = (Commercial)tmp;
    		d.setNbVisites(Integer.parseInt(nbHeures.getText()));
    	}
    	else if (tmp instanceof Livreur) {
    		Livreur d = (Livreur)tmp;
    		d.setNbHeures(Integer.parseInt(nbHeures.getText()));
    	}
    	try {
			conducteurs.ajouteConducteur(tmp);
		} catch (Exception e) {
			erreur.setVisible(true);
			erreur.setText("Le véhicule est déjà présent dans la liste.");
			return;
		}
    	changeScene();

    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void setScene(Scene scene) {
    	this.scene=scene;
    }
    
    public void setConducteurs(Conducteurs conducteurs) {
    	this.conducteurs=conducteurs;
    }
}