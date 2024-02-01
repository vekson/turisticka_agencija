package app.tabs;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class PonudeTab extends Tab {

    private final FlowPane lastMinute;
    private final FlowPane ponude;

    public PonudeTab() {
        setText("Ponude");

        lastMinute = new FlowPane();
        ponude = new FlowPane();

        VBox sidePane = new VBox();
        VBox centerPane = new VBox(
                new Label("Last Minute"),
                lastMinute,
                new Label("Ponude"),
                ponude
        );

        BorderPane root = new BorderPane();
        root.setLeft(sidePane);
        root.setCenter(centerPane);
        setContent(root);
    }

    private void loadPonude() {
        
    }
}
