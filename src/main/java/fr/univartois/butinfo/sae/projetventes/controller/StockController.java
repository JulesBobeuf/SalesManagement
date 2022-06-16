package fr.univartois.butinfo.sae.projetventes.controller;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.article.Article;
import fr.univartois.butinfo.sae.projetventes.model.article.ArticleCat1;
import fr.univartois.butinfo.sae.projetventes.model.article.ArticleCat2;
import fr.univartois.butinfo.sae.projetventes.model.article.IStock;
import fr.univartois.butinfo.sae.projetventes.model.article.Stock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StockController implements IStock {

    @FXML
    private Button boutonAdd;

    @FXML
    private Button boutonEdit;

    @FXML
    private Label categorie;

    @FXML
    private Label designation;

    @FXML
    private ListView<Article> listview;

    @FXML
    private Label nomStock;

    @FXML
    private Label prix;

    @FXML
    private Label quantite;
    
    @FXML 
    private Label particularite;
    
    private Stock stock;
    
    private Scene scene;
    
    private Stage stage;

    @Override
    public void setStock(Stock stock) {
    	this.stock = stock;
    	nomStock.setText(stock.getNom());
    	listview.setItems(stock.getArticles());
    	listview.getSelectionModel().selectedItemProperty().addListener((p,o,n) -> {
    		if (stock.getNbArticles() > 0) {
        		designation.setText(n.getDesignation());
        		categorie.setText(n.getCategorie());
        		quantite.setText(Integer.toString(n.getQuantiteStock()));
        		prix.setText(Double.toString(n.getPrix()));
        		
        		if (n instanceof ArticleCat1) {
        			ArticleCat1 m = (ArticleCat1)n;
        			particularite.setText(Integer.toString(m.getCapacite()));
        		}
        		else if (n instanceof ArticleCat2) {
        			ArticleCat2 m = (ArticleCat2)n;
        			particularite.setText(Double.toString(m.getPoids()));
        		}
			} else {
				return;
			}
    	});
    	listview.setCellFactory(list -> {
    		return new ListCell<>() {
    			@Override
    			public void updateItem(Article article, boolean empty) {
    				super.updateItem(article, empty);
    				if (empty || (article == null)) {
    					setText(null);
    				} else {
    					setText(article.getDesignation());
    				}
    			}
    		};
    	});
    }
    
    @Override
    public void setScene(Scene scene) {
    	this.scene = scene;
    }
    
    @Override
    public void setStage(Stage stage) {
    	this.stage = stage;
    }

	@Override
	public void ajouterArticle() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteArticleView.fxml"));
    	Parent viewContent = fxmlLoader.load();
    	Scene scene = new Scene(viewContent);
    	stage.setScene(scene);
    	AjouteArticleController controller = fxmlLoader.getController();
    	controller.setScene(this.scene);
    	controller.setStage(stage);
    	controller.setArticle(stock);
	}

	@Override
	public void supprimerArticle() {
    	Article article = listview.getSelectionModel().getSelectedItem();
    	stock.supprimerArticle(article);
	}

	@Override
	public void editerArticle() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AjouteArticleView.fxml"));
    	Parent viewContent = fxmlLoader.load();
    	Scene scene = new Scene(viewContent);
    	stage.setScene(scene);
    	AjouteArticleController controller = fxmlLoader.getController();;
    	controller.setScene(this.scene);
    	controller.setStage(stage);
    	controller.setArticle(stock);
    	controller.edit(listview.getSelectionModel().getSelectedItem());		
	}

}
