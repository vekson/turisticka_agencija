package app.tabs;

import app.tabs.components.HotelPane;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HoteliTab extends Tab {

    private final VBox hoteli;
    private final VBox drugiVBox;

    public HoteliTab() {
        setText("Hoteli");

        hoteli = new VBox();
        loadHoteli();
        hoteli.setStyle("-fx-background-color: #F4F4F4; -fx-padding: 10px;");

        drugiVBox = new VBox();
        drugiVBox.setStyle("-fx-background-color: #D6D6D6; -fx-padding: 10px; -fx-border-color: #B0B0B0; -fx-border-width: 1px; -fx-border-radius: 5px;");

        Label drugiVBoxLabel = new Label("Ovo je drugiVBox");
        drugiVBoxLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        drugiVBoxLabel.setTextFill(Color.web("#555555"));

        drugiVBox.getChildren().add(drugiVBoxLabel);
        drugiVBox.setPrefWidth(200);

        HBox mainContainer = new HBox(hoteli, drugiVBox);
        HBox.setHgrow(hoteli, Priority.ALWAYS);

        setContent(mainContainer);

        hoteli.setAlignment(Pos.CENTER_RIGHT);
    }

    private void loadHoteli() {
        List<HotelPane> hoteliList = List.of(
                new HotelPane("Ambasador", 5),
                new HotelPane("City Hotel", 4),
                new HotelPane("Neki hotel", 2),
                new HotelPane("Jos neki hotel", 3),
                new HotelPane("Ambasador", 5),
                new HotelPane("City Hotel", 4)
        );

        for (HotelPane hotel : hoteliList) {
            VBox.setMargin(hotel, new Insets(5));
            hotel.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 10px; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px;");

            // Add event handler to enlarge the hotel square on click
            hotel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                
            });

            hoteli.getChildren().add(hotel);
        }
    }
}
