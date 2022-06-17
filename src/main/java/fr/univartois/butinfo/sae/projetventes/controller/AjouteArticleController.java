package fr.univartois.butinfo.sae.projetventes.controller;

import fr.univartois.butinfo.sae.projetventes.model.article.Article;
import fr.univartois.butinfo.sae.projetventes.model.article.ArticleCat1;
import fr.univartois.butinfo.sae.projetventes.model.article.ArticleCat2;
import fr.univartois.butinfo.sae.projetventes.model.article.Stock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AjouteArticleController {

    @FXML
    private RadioButton cat1;

    @FXML
    private RadioButton cat2;

    @FXML
    private TextField designation;

    @FXML
    private TextField prix;

    @FXML
    private TextField particularite;
    
    @FXML
    private TextField quantiteStock;

    @FXML
    private Button validerAjout;

    @FXML
    private Button validerEdit;
    
    @FXML
    private Label erreur;

    private Scene scene;
    
    private Stage stage;
    
    private Stock stock;
    
    private StockController control;
    
    private Article a;
    
    public void setArticle(Stock stock) {
		this.stock = stock;
		validerAjout.setVisible(true);
		validerEdit.setVisible(false);
		particularite.setVisible(false);
		erreur.setVisible(false);
	}
    
    public void setScene(Scene scene) {
		this.scene=scene;
	}
    
    public void setStage(Stage stage) {
		this.stage = stage;
	}
    
    public void changeScene() {
		stage.setScene(scene);
	}
    
    @FXML
    void onCat2(ActionEvent event) {
    	cat1.setSelected(false);
    	particularite.setVisible(true);
    	particularite.setPromptText("Poids");
    }

    @FXML
    void onCat1(ActionEvent event) {
    	cat2.setSelected(false);
    	particularite.setVisible(true);
    	particularite.setPromptText("Capacité");
    }

    @FXML
    void retour(ActionEvent event) {
    	changeScene();
    }

    @FXML
    void valider(ActionEvent event) {
    	if (cat1.isSelected()) {
    		try {
        		stock.ajouterArticle(new ArticleCat1(designation.getText(),Double.parseDouble(prix.getText()),Integer.parseInt(quantiteStock.getText()),Integer.parseInt(particularite.getText())));
        		changeScene();
			} catch (Exception e) {
				erreur.setVisible(true);
				erreur.setText("Mauvaise valeur !");
			}
    	}
    	else if (cat2.isSelected()) {
    		try {
        		stock.ajouterArticle(new ArticleCat2(designation.getText(),Double.parseDouble(prix.getText()),Integer.parseInt(quantiteStock.getText()),Integer.parseInt(particularite.getText())));
        		changeScene();
			} catch (Exception e) {
				erreur.setVisible(true);
				erreur.setText("Mauvaise valeur !");
			}
    	}
    }

    public void edit(Article article) {
    	this.a=article;
    	cat1.setVisible(false);
    	cat2.setVisible(false);
		validerAjout.setVisible(false);
		validerEdit.setVisible(true);
		particularite.setVisible(false);
		designation.setText(article.getDesignation());
		quantiteStock.setText(Integer.toString(article.getQuantiteStock()));
		prix.setText(Double.toString(article.getPrix()));
    	if (article instanceof ArticleCat1) {
    		ArticleCat1 art = (ArticleCat1)article;
    		particularite.setText(Integer.toString(art.getCapacite()));
    	}
    	else if (article instanceof ArticleCat2) {
    		ArticleCat2 art = (ArticleCat2)article;
    		particularite.setText(Double.toString(art.getPoids()));
    	}
	}
    
    @FXML
    public void validerEdit() {
    	stock.supprimerArticle(a);
    	a.setPrix(Integer.parseInt(prix.getText()));
    	a.setQuantiteStock(Integer.parseInt(quantiteStock.getText()));
    	if (a instanceof ArticleCat1) {
    		ArticleCat1 art = (ArticleCat1)a;
    		art.setCapacite(Integer.parseInt(particularite.getText()));
    	}
    	else if (a instanceof ArticleCat2) {
    		ArticleCat2 art = (ArticleCat2)a;
    		art.setPoids(Double.parseDouble(particularite.getText()));
    	}
    	stock.ajouterArticle(a);
    	changeScene();
    }

}
