package fr.univartois.butinfo.sae.projetventes.model.article;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;

public interface IStock {

	public void ajouterArticle() throws IOException;
	
	public void supprimerArticle();
	
	public void editerArticle() throws IOException;
	
	public void setScene(Scene scene);
	
	public void setStock(Stock stock);
	
	public void setStage(Stage stage);
}
