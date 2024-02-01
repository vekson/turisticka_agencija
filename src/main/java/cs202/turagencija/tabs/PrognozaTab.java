package cs202.turagencija.tabs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PrognozaTab extends Tab {

    private static final Map<String, String> CITY_COORDINATES_MAP = new HashMap<>();

    static {
        CITY_COORDINATES_MAP.put("San Francisco", "37.7749,-122.4194");
        CITY_COORDINATES_MAP.put("New York", "40.7128,-74.0060");
        CITY_COORDINATES_MAP.put("London", "51.5074,-0.1278");
        CITY_COORDINATES_MAP.put("Paris", "48.8566,2.3522");
        CITY_COORDINATES_MAP.put("Tokyo", "35.6895,139.6917");
        CITY_COORDINATES_MAP.put("Moscow", "55.7558,37.6176");
        CITY_COORDINATES_MAP.put("Beijing", "39.9042,116.4074");
        CITY_COORDINATES_MAP.put("Hong Kong", "22.3193,114.1694");
        CITY_COORDINATES_MAP.put("Sydney", "33.8688,151.2093");
        CITY_COORDINATES_MAP.put("Seoul", "37.5665,126.9780");
        CITY_COORDINATES_MAP.put("Rome", "41.9028,12.4964");
        CITY_COORDINATES_MAP.put("Berlin", "52.5200,13.4050");
        CITY_COORDINATES_MAP.put("Toronto", "43.6532,-79.3832");
        CITY_COORDINATES_MAP.put("Copenhagen", "55.7558,12.5370");
        CITY_COORDINATES_MAP.put("Madrid", "40.4168,-3.7038");
        CITY_COORDINATES_MAP.put("Saint Petersburg", "59.9343,30.3351");
        CITY_COORDINATES_MAP.put("Delhi", "28.6139,77.2090");
        CITY_COORDINATES_MAP.put("Boston", "42.3601,-71.0589");
        CITY_COORDINATES_MAP.put("Dubai", "25.2769,55.2962");
        CITY_COORDINATES_MAP.put("Barcelona", "41.3851,2.1734");
    }

    private final ObservableList<String> cityNames = FXCollections.observableArrayList(CITY_COORDINATES_MAP.keySet());
    private final ComboBox<String> cityComboBox = new ComboBox<>(cityNames);
    private final Label coordinateLabel = new Label("Coordinates: ");
    private final Label weatherLabel = new Label();

    public PrognozaTab() {
        setText("Prognoza");
        initializeUI();
        setupEventHandlers();
    }

    private void initializeUI() {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER); // Aligns content to the top center
        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(weatherLabel, coordinateLabel);
        root.getChildren().addAll(cityComboBox, centerPane); // Adding components to the VBox
        setContent(root);

        // Apply styles
        root.setStyle("-fx-padding: 10px;");
        cityComboBox.setStyle("-fx-pref-width: 200px;");
        coordinateLabel.setStyle("-fx-font-weight: bold;");
        weatherLabel.setStyle("-fx-font-size: 14px;");
    }

    private void setupEventHandlers() {
        cityComboBox.setPromptText("Select City");
        cityComboBox.setOnAction(event -> {
            String selectedCity = cityComboBox.getValue();
            if (selectedCity != null) {
                String coordinates = CITY_COORDINATES_MAP.get(selectedCity);
                if (coordinates != null) {
                    coordinateLabel.setText("City: " + selectedCity + ", Coordinates: " + coordinates);
                    fetchWeatherInformation(coordinates);
                }
            }
        });
    }

    private void fetchWeatherInformation(String coordinates) {
        try {
            String weatherUrl = "https://weather.com/en-IN/weather/today/l/" + coordinates;
            Document doc = Jsoup.connect(weatherUrl).get();
            Elements weatherElements = doc.select(".Card--content--1GQMr");
            StringBuilder weatherInfoBuilder = new StringBuilder();

            for (Element element : weatherElements) {
                String weatherInfo = element.text();
                weatherInfoBuilder.append(formatWeatherInfo(weatherInfo)).append("\n\n");
            }

            weatherLabel.setText(weatherInfoBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            weatherLabel.setText("Error fetching weather information.");
        }
    }

    private String formatWeatherInfo(String weatherInfo) {
        String[] lines = weatherInfo.split("\n");
        StringBuilder formattedWeatherInfo = new StringBuilder();

        for (String line : lines) {
            line = line.replaceAll("Video.*", "");
            line = line.trim();
            if (!line.isEmpty()) {
                formattedWeatherInfo.append(line).append("\n");
            }
        }

        return formattedWeatherInfo.toString();
    }
}
