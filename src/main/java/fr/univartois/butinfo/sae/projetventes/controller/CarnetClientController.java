package fr.univartois.butinfo.sae.projetventes.controller;

import java.io.IOException;
import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientEntreprise;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientParticulier;
import fr.univartois.butinfo.sae.projetventes.model.client.Genre;
import fr.univartois.butinfo.sae.projetventes.model.client.ICarnetClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CarnetClientController implements ICarnetClient {

    @FXML
    private Label adresse;

    @FXML
    private Button boutonAdd;

    @FXML
    private Button boutonEdit;

    @FXML
    private Button boutonSup;

    @FXML
    private ListView<Client> listview;

    @FXML
    private Label nom;

    @FXML
    private Label nomCarnet;

    @FXML
    private Label points;

    @FXML
    private Label ref;

    @FXML
    private Label prenom;
    
    @FXML
    private Label ristourne;

    @FXML
    private Label genre;
    
	private CarnetClients carnet;

	private Scene scene;

	private Stage stage;
	
	private AjouteClientController controller;
	
	private Client tmp;
	
	
	@Override
	public void setCarnetClients(CarnetClients carnet) {
		this.carnet=carnet;
		nomCarnet.setText(carnet.getNom());
		carnet.ajouterClient(new ClientParticulier("Jakobowowowwoski","10 rue de la fosse",13,"Aime le ricar",Genre.Femme));
		carnet.ajouterClient(new ClientEntreprise("Entreprise","14 rue de lail",14,"Aime la zqdk^dspj ricar"));
		listview.setItems(carnet.getClients());
		listview.getSelectionModel().selectedItemProperty().addListener((p,o,n) -> {
			nom.setText(n.getNom());
			ref.setText(Integer.toString(n.getReference()));
			adresse.setText(n.getAdresse());
			points.setText(Integer.toString(n.getPointsFidelite()));
			ristourne.setText(Integer.toString(n.getRistourne()));
			if (n instanceof ClientParticulier) {
				genre.setVisible(true);
				ClientParticulier m = (ClientParticulier)n;
				prenom.setText(m.getPrenom());
				genre.setText(m.getGenre().toString());
			}
			else if (n instanceof ClientEntreprise) {
				ClientEntreprise m = (ClientEntreprise)n;
				prenom.setText(m.getContact());
				genre.setVisible(false);
			}
				
		});
		listview.setCellFactory(list -> {
    		return new ListCell<>() {
    			@Override
    			public void updateItem(Client client, boolean empty) {
    				super.updateItem(client, empty);
    				if (empty || (client == null)) {
    					setText(null);
    				} else {
    					setText(client.getNom());
    				}
    			}
    		};
    	});
	}


	@Override
	public void ajouterClient() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteClientView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		AjouteClientController controller = fxmlLoader.getController();
		controller.setScene(this.scene);
		controller.setStage(stage);
		controller.setClients(carnet); 
		
	}
	
	public void modifierClient() {
		controller.updateClient(tmp);
	}

	@Override
	public void supprimerClient() {
		Client client = listview.getSelectionModel().getSelectedItem();
		carnet.supprimerClient(client);
	}

	@Override
	public void editerClient() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteClientView.fxml"));
		Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent);
		stage.setScene(scene);
		this.controller = fxmlLoader.getController();
		controller.setControl(this);
		controller.setScene(this.scene);
		controller.setStage(stage);
		controller.setClients(carnet);
		this.tmp = listview.getSelectionModel().getSelectedItem();
		controller.edit(tmp);
	}

	@Override
	public void setScene(Scene scene) {
		this.scene=scene;
	}


	@Override
	public void setStage(Stage stage) {
		this.stage=stage;
	}

}
