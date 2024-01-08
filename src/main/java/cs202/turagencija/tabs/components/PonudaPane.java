package app.tabs.components;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PonudaPane extends BorderPane {

    public PonudaPane(String imeOglasa, double cena) {
        VBox vBox = new VBox(
                new Label(imeOglasa),
                new Label(String.valueOf(cena))
        );
        setCenter(vBox);
    }
}
