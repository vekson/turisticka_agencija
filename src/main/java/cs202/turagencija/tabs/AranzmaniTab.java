package cs202.turagencija.tabs;

import cs202.turagencija.db.AgencijaCRUD;
import cs202.turagencija.db.AranzmanCRUD;
import cs202.turagencija.db.PrevoznoSredstvoCRUD;
import cs202.turagencija.entities.Agencija;
import cs202.turagencija.entities.Aranzman;
import cs202.turagencija.entities.PrevoznoSredstvo;
import cs202.turagencija.tabs.components.AranzmanPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AranzmaniTab extends Tab {

    private final VBox aranzmani;
    private final TextField odredisteField;
    private final TextField mestoPolaskaField;
    private final ComboBox<Agencija> agencijaComboBox;
    private final ComboBox<PrevoznoSredstvo> prevoznoSredstvoComboBox;
    private Aranzman selectedAranzman;

    public AranzmaniTab() {
        setText("Aranzmani");

        aranzmani = new VBox();
        ScrollPane scrollPane = new ScrollPane(aranzmani); // Wrap your VBox inside a ScrollPane
        scrollPane.setFitToWidth(true);
        odredisteField = new TextField();
        odredisteField.setPromptText("Odrediste");

        mestoPolaskaField = new TextField();
        mestoPolaskaField.setPromptText("Mesto polaska");

        agencijaComboBox = new ComboBox<>();
        agencijaComboBox.setPromptText("Agencija");
        agencijaComboBox.setConverter(new StringConverter<Agencija>() {
            @Override
            public String toString(Agencija object) {
                return object.getNaziv();
            }

            @Override
            public Agencija fromString(String string) {
                return null;
            }
        });
        loadAgencije();

        prevoznoSredstvoComboBox = new ComboBox<>();
        prevoznoSredstvoComboBox.setPromptText("Prevozno sredstvo");
        prevoznoSredstvoComboBox.setConverter(new StringConverter<PrevoznoSredstvo>() {
            @Override
            public String toString(PrevoznoSredstvo object) {
                return object.getTip().toString();
            }

            @Override
            public PrevoznoSredstvo fromString(String string) {
                return null;
            }
        });

        try {
            loadPrevoznoSredstvo();
        } catch (SQLException ex) {
            Logger.getLogger(AranzmaniTab.class.getName()).log(Level.SEVERE, null, ex);
        }

        Button addButton = new Button("Add");

        // Bind the disabled property of the button to the conditions where fields are empty
        addButton.disableProperty().bind(
                odredisteField.textProperty().isEmpty()
                        .or(mestoPolaskaField.textProperty().isEmpty())
                        .or(agencijaComboBox.valueProperty().isNull())
                        .or(prevoznoSredstvoComboBox.valueProperty().isNull())
        );

        addButton.setOnAction(event -> {
            if (selectedAranzman == null) {
                addAranzman(new Aranzman(
                        odredisteField.getText(),
                        mestoPolaskaField.getText(),
                        prevoznoSredstvoComboBox.getValue(),
                        agencijaComboBox.getValue()
                ));
            } else {
                updateAranzman();
            }
        });

        VBox inputContainer = new VBox(
                new Label("Add Aranzman"),
                agencijaComboBox,
                prevoznoSredstvoComboBox,
                odredisteField,
                mestoPolaskaField,
                addButton
        );
        inputContainer.setSpacing(10);
        inputContainer.setPadding(new Insets(10, 0, 0, 0));

        VBox mainContainer = new VBox(inputContainer, scrollPane); // Add the ScrollPane to the main container

        setContent(mainContainer);

        loadAranzmani();
    }

    public void loadAranzmani() {
        try {
            aranzmani.getChildren().clear();
            List<Aranzman> aranzmaniList = AranzmanCRUD.readAllAranzmani();

            for (Aranzman aranzman : aranzmaniList) {
                AranzmanPane aranzmanPane = new AranzmanPane(aranzman.getId(), aranzman.getOdrediste(), aranzman.getMestoPolaska(), this);
                aranzmanPane.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 10px; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px;");

                // Add event handler to handle clicks on AranzmanPane
                aranzmanPane.setOnMouseClicked(event -> {
                    selectedAranzman = aranzman;
                    fillFields(selectedAranzman);
                });

                aranzmani.getChildren().add(aranzmanPane);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addAranzman(Aranzman aranzman) {
        AranzmanCRUD.insertAranzman(aranzman);
        loadAranzmani();
        clearFields();
    }

    private void updateAranzman() {
        if (selectedAranzman != null) {
            selectedAranzman.setOdrediste(odredisteField.getText());
            selectedAranzman.setMestoPolaska(mestoPolaskaField.getText());
            selectedAranzman.setAgencija(agencijaComboBox.getValue());
            selectedAranzman.setPrevoznoSredstvo(prevoznoSredstvoComboBox.getValue());

            AranzmanCRUD.updateAranzman(selectedAranzman);
            loadAranzmani();
            clearFields();
            selectedAranzman = null;
        }
    }

    private void clearFields() {
        odredisteField.clear();
        mestoPolaskaField.clear();
        agencijaComboBox.setValue(null);
        prevoznoSredstvoComboBox.setValue(null);
    }

    private void fillFields(Aranzman aranzman) {
        odredisteField.setText(aranzman.getOdrediste());
        mestoPolaskaField.setText(aranzman.getMestoPolaska());
        agencijaComboBox.setValue(aranzman.getAgencija());
        prevoznoSredstvoComboBox.setValue(aranzman.getPrevoznoSredstvo());
    }

    private void loadAgencije() {
        try {
            ObservableList<Agencija> agencijaList = FXCollections.observableArrayList(AgencijaCRUD.readAllAgencije());
            agencijaComboBox.setItems(agencijaList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadPrevoznoSredstvo() throws SQLException {
        ObservableList<PrevoznoSredstvo> prevoznoSredstvoList = FXCollections.observableArrayList(PrevoznoSredstvoCRUD.readAllPrevoznaSredstva());
        prevoznoSredstvoComboBox.setItems(prevoznoSredstvoList);
    }
}
