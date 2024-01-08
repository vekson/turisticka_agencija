/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs202.turagencija.scenes;

import app.tabs.HoteliTab;
import app.tabs.PonudeTab;
import app.tabs.ProfilTab;
import app.tabs.PrognozaTab;
import app.tabs.RezervacijeTab;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class StartScene extends Application {

    VBox vb = new VBox();
    TabPane tabPane = new TabPane(new PonudeTab(),
            new HoteliTab(),
            new RezervacijeTab(),
            new PrognozaTab(),
            new ProfilTab());
    BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        //Node positioning and styling

        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(tabPane);
        vb.setSpacing(30);
        root.setTop(vb);
        BorderPane.setAlignment(vb, Pos.TOP_CENTER);

        root.setStyle("-fx-background-color: lightgray;");

        //Icon, scene and size
        Scene scene = new Scene(root, 750, 500);
        primaryStage.setTitle("Cryptocurrency");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
