package fr.univartois.butinfo.sae.projetventes.controller;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Commercial;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Conducteur;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Conducteurs;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Livreur;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.IConducteurs;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Vehicule;
import fr.univartois.butinfo.sae.projetventes.model.gestionvehicule.Voiture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ConducteursController implements IConducteurs {

    @FXML
    private ListView<Conducteur> listview;

    @FXML
    private Label nbHeures;

    @FXML
    private Label nom;

    @FXML
    private Label nomConducteurs;

    @FXML
    private Label numPermis;

    @FXML
    private Label prenom;

    @FXML
    private Label typeCond;

    @FXML
    private Label typePermis;

	private Scene scene;

	private Stage stage;

	private Conducteurs conducteurs;

    @FXML
    public void ajouterConducteur() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteConducteurView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		AjouteConducteurController controller = fxmlLoader.getController();
		controller.setScene(this.scene);
		controller.setStage(stage);
		controller.setConducteurs(conducteurs); 
		controller.init();

    }
    
    @FXML
    public void editerConducteur() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteConducteurView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		AjouteConducteurController controller = fxmlLoader.getController();
		controller.setScene(this.scene);
		controller.setStage(stage);
		controller.setConducteurs(conducteurs);
		controller.edit(listview.getSelectionModel().getSelectedItem());

    }

    @FXML
    public void supprimerConducteur() {
		Conducteur c = listview.getSelectionModel().getSelectedItem();
		conducteurs.supprimeConducteur(c);

    }
    
    public void changeScene() {
		stage.setScene(scene);
	}
    
    @FXML
    public void retour(ActionEvent event) {
    	changeScene();
    }

    @Override
    public void setScene(Scene scene) {
    	this.scene=scene;

    }

    @Override
    public void setConducteurs(Conducteurs conducteurs) {
    	this.conducteurs=conducteurs;
    	//nomConducteurs.setText("Ma liste de conducteurs");
    	listview.setItems(conducteurs.getConducteurs());
    	listview.getSelectionModel().selectedItemProperty().addListener((p,o,n) -> {
    		nom.setText(n.getNom());
    		prenom.setText(n.getPrenom());
    		numPermis.setText(n.getNumPermis());
    		typePermis.setText(n.getTypePermis().toString());
    		if (n instanceof Commercial) {
    			typeCond.setText("Commercial");
    			Commercial m = (Commercial)n;
    			nbHeures.setText(Integer.toString(m.getNbVisites()));
    		}
    		else if (n instanceof Livreur) {
    			typeCond.setText("Livreur");
    			Livreur m = (Livreur)n;
    			nbHeures.setText(Integer.toString(m.getNbHeures()));
    		}

    	});
    	listview.setCellFactory(list -> {
    		return new ListCell<Conducteur>() {
    			@Override
    			public void updateItem(Conducteur conducteur, boolean empty) {
    				super.updateItem(conducteur, empty);
    				if (empty || (conducteur == null)) {
    					setText(null);
    				} else {
    					setText(conducteur.getNom());
    				}
    			}
    		};
    	});
    }

    	@Override
    	public void setStage(Stage stage) {
    		this.stage=stage;

    	}

}
