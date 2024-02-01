package cs202.turagencija.tabs.components;

import cs202.turagencija.db.AranzmanCRUD;
import cs202.turagencija.tabs.AranzmaniTab;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AranzmanPane extends BorderPane {
    private final int aranzmanId;
    private final AranzmaniTab parentTab;

    public AranzmanPane(int aranzmanId, String odrediste, String mestoPolaska, AranzmaniTab parentTab) {
        this.aranzmanId = aranzmanId;
        this.parentTab = parentTab;

        Label imeLabel = new Label(odrediste);
        imeLabel.setStyle("-fx-font-size: 18px; -fx-font-family: 'Arial'; -fx-font-weight: bold;");

        Label odredisteLabel = new Label("Odrediste: " + odrediste);
        odredisteLabel.setStyle("-fx-font-size: 14px;");

        Label mestoPolaskaLabel = new Label("Mesto Polaska: " + mestoPolaska);
        mestoPolaskaLabel.setStyle("-fx-font-size: 14px;");

        VBox labelsContainer = new VBox(5, odredisteLabel, mestoPolaskaLabel);
        labelsContainer.setAlignment(Pos.CENTER_LEFT);

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteAranzman());

        HBox content = new HBox(10, imeLabel, labelsContainer, deleteButton);
        content.setAlignment(Pos.CENTER_LEFT);

        setCenter(content);

        setStyle(
                "-fx-background-color: #F0F0F0; "
                + "-fx-border-color: #C0C0C0; "
                + "-fx-border-width: 1px; "
                + "-fx-border-radius: 5px; "
                + "-fx-padding: 10px;"
        );
    }

    private void deleteAranzman() {
        AranzmanCRUD.deleteAranzman(aranzmanId);
        parentTab.loadAranzmani();
    }
}
