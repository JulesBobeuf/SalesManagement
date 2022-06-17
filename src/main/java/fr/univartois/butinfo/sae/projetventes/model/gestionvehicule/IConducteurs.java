package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IConducteurs {
	
public void ajouterConducteur() throws IOException;
	
	public void supprimerConducteur() throws PasPresentException;
	
	public void editerConducteur() throws IOException;
	
	public void setScene(Scene scene);
	
	public void setConducteurs(Conducteurs conducteurs);
	
	public void setStage(Stage stage);
	
	public void changeScene();

	public void setScene2(Scene scene);

}
