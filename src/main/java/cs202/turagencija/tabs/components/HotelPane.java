package app.tabs.components;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HotelPane extends BorderPane {

    public HotelPane(String ime, int brojZvezdica) {
        
        Label imeLabel = new Label(ime);
        imeLabel.setStyle("-fx-font-size: 18px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");

        Label zvezdiceLabel = new Label("★ ".repeat(brojZvezdica));
        zvezdiceLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");

        setCenter(imeLabel);
        setRight(zvezdiceLabel);

        setStyle(
            "-fx-background-color: #F0F0F0; " +
            "-fx-border-color: #C0C0C0; " +
            "-fx-border-width: 1px; " +
            "-fx-border-radius: 5px; " +
            "-fx-padding: 10px;"
        );
    }
}
