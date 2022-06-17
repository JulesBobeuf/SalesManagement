package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IFlotteVehicules {
	
public void ajouterVehicule() throws IOException;
	
	public void supprimerVehicule() throws PasPresentException;
	
	public void editerVehicule() throws IOException;
	
	public void setScene(Scene scene);
	
	public void setFlotteVehicules(FlotteVehicules flotteVehicules);
	
	public void setStage(Stage stage);

	public void changeScene();

	public void setScene2(Scene scene);
}
