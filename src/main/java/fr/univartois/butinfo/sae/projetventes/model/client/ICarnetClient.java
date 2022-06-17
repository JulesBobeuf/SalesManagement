package fr.univartois.butinfo.sae.projetventes.model.client;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface ICarnetClient {
	
	public void ajouterClient() throws IOException;
	
	public void supprimerClient();
	
	public void editerClient() throws IOException;
	
	public void modifierClient();
	
	public void setScene(Scene scene);
	
	public void setCarnetClients(CarnetClients carnet);
	
	public void setStage(Stage stage);
	
	public void changeScene();

	public void setScene2(Scene scene);

}
