package fr.univartois.butinfo.sae.projetventes.application;

import java.io.IOException;

import fr.univartois.butinfo.sae.projetventes.model.client.CarnetClients;
import fr.univartois.butinfo.sae.projetventes.model.client.ICarnetClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarnetClientApplication extends Application {
    /**
     * Cette méthode permet d'initialiser l'affichage de la fenêtre de l'application.
     *
     * @param stage La fenêtre (initialement vide) de l'application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Il faut d'abord récupérer la description de la vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/CarnetClientView.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une Scene...
        Scene scene = new Scene(viewContent);
        // que l'on place elle-même dans la fenêtre.
        stage.setScene(scene);
        
        ICarnetClient controller = fxmlLoader.getController();
        CarnetClients carnet = new CarnetClients("Nékléo");
        controller.setCarnetClients(carnet);
        controller.setScene(scene);
        controller.setStage(stage);

        // On peut ensuite donner un titre à la fenêtre.
        stage.setTitle("Carnet de clients");

        // Enfin, on affiche la fenêtre.
        stage.show();
    }
    
    /**
     * Cette méthode exécute l'application JavaFX.
     *
     * @param args Les arguments de la ligne de commande (dont on ne tient pas compte).
     *
     * @see #launch(String...)
     */
    public static void main(String[] args) {
        launch();
    }

}
