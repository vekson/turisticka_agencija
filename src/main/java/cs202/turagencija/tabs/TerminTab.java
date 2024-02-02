package cs202.turagencija.tabs;

import cs202.turagencija.db.AranzmanCRUD;
import cs202.turagencija.db.TerminCRUD;
import cs202.turagencija.entities.Aranzman;
import cs202.turagencija.entities.Termin;
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
import javafx.scene.control.DatePicker;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.StringConverter;

public class TerminTab extends Tab {

    private final VBox termini;
    private final TextField slobodnaMestaField;
    private final ComboBox<Aranzman> aranzmanComboBox;
    private final DatePicker datumPolaskaPicker;
    private final DatePicker datumOdlaskaPicker;
    private Termin selectedTermin;

    public TerminTab() {
        setText("Termini");

        termini = new VBox();
        ScrollPane scrollPane = new ScrollPane(termini);
        scrollPane.setFitToWidth(true);

        datumPolaskaPicker = new DatePicker();
        datumPolaskaPicker.setPromptText("Datum polaska");

        datumOdlaskaPicker = new DatePicker();
        datumOdlaskaPicker.setPromptText("Datum odlaska");

        slobodnaMestaField = new TextField();
        slobodnaMestaField.setPromptText("Slobodna mesta");

        aranzmanComboBox = new ComboBox<>();
        aranzmanComboBox.setPromptText("Aranzman");
        aranzmanComboBox.setConverter(new StringConverter<Aranzman>() {
            @Override
            public String toString(Aranzman object) {
                return object.getMestoPolaska() + " - " + object.getOdrediste();
            }

            @Override
            public Aranzman fromString(String string) {
                return null;
            }
        });

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addOrUpdateTermin());

        addButton.disableProperty().bind(
                datumPolaskaPicker.valueProperty().isNull()
                        .or(datumOdlaskaPicker.valueProperty().isNull())
                        .or(slobodnaMestaField.textProperty().isEmpty())
                        .or(aranzmanComboBox.valueProperty().isNull())
        );

        VBox inputContainer = new VBox(
                new Label("Add/Update Termin"),
                datumPolaskaPicker,
                datumOdlaskaPicker,
                slobodnaMestaField,
                aranzmanComboBox,
                addButton
        );
        inputContainer.setSpacing(10);
        inputContainer.setPadding(new Insets(10, 0, 0, 0));

        VBox mainContainer = new VBox(inputContainer, scrollPane);

        setContent(mainContainer);

        loadTermini();
        try {
            loadAranzman();
        } catch (SQLException ex) {
            Logger.getLogger(TerminTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTermini() {
        try {
            termini.getChildren().clear();
            List<Termin> terminList = TerminCRUD.readAllTermini();

            for (Termin termin : terminList) {
                VBox terminPane = createTerminPane(termin);
                terminPane.setOnMouseClicked(event -> {
                    selectedTermin = termin;
                    fillFields(selectedTermin);
                });
                termini.getChildren().add(terminPane);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TerminTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private VBox createTerminPane(Termin termin) {
        VBox terminPane = new VBox(
                new Label("Datum polaska: " + termin.getDatumPolaska()),
                new Label("Datum odlaska: " + termin.getDatumOdlaska()),
                new Label("Slobodna mesta: " + termin.getBrojSlobodnihMesta())
        );

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteTermin(termin.getId()));

        terminPane.getChildren().add(deleteButton);

        terminPane.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 10px; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px;");

        return terminPane;
    }


    private void addOrUpdateTermin() {
        LocalDate datumPolaska = datumPolaskaPicker.getValue();
        LocalDate datumOdlaska = datumOdlaskaPicker.getValue();
        int slobodnaMesta = Integer.parseInt(slobodnaMestaField.getText());
        Aranzman selectedAranzman = aranzmanComboBox.getValue();

        if (selectedTermin == null) {
            if (selectedAranzman != null && datumPolaska != null && datumOdlaska != null) {
                Termin termin = new Termin(selectedAranzman, datumPolaska, datumOdlaska, slobodnaMesta);
                TerminCRUD.insertTermin(termin);
                loadTermini();
                clearFields();
            }
        } else {
            selectedTermin.setDatumPolaska(datumPolaska);
            selectedTermin.setDatumOdlaska(datumOdlaska);
            selectedTermin.setBrojSlobodnihMesta(slobodnaMesta);
            selectedTermin.setAranzman(selectedAranzman);

            TerminCRUD.updateTermin(selectedTermin);
            loadTermini();
            clearFields();
            selectedTermin = null;
        }
    }

    private void clearFields() {
        datumPolaskaPicker.setValue(null);
        datumOdlaskaPicker.setValue(null);
        slobodnaMestaField.clear();
        aranzmanComboBox.setValue(null);
    }

    private void loadAranzman() throws SQLException {
        ObservableList<Aranzman> aranzmanList = FXCollections.observableArrayList(AranzmanCRUD.readAllAranzmani());
        aranzmanComboBox.setItems(aranzmanList);
    }

    private void fillFields(Termin termin) {
        datumPolaskaPicker.setValue(termin.getDatumPolaska());
        datumOdlaskaPicker.setValue(termin.getDatumOdlaska());
        slobodnaMestaField.setText(String.valueOf(termin.getBrojSlobodnihMesta()));
        aranzmanComboBox.setValue(termin.getAranzman());
    }

    private void deleteTermin(Integer terminId) {
        TerminCRUD.deleteTermin(terminId);
        loadTermini(); // Refresh the UI after deletion
    }
}
