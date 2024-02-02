package cs202.turagencija.tabs;

import cs202.turagencija.db.KorisnikCRUD;
import cs202.turagencija.db.TerminCRUD;
import cs202.turagencija.entities.Korisnik;
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

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.StringConverter;

public class KorisnikTab extends Tab {

    private final VBox korisnici;
    private final TextField imeField;
    private final TextField prezimeField;
    private final TextField adresaField;
    private final TextField brojPasosaField;
    private final ComboBox<Termin> terminComboBox;
    private Korisnik selectedKorisnik;

    public KorisnikTab() {
        setText("Korisnici");

        korisnici = new VBox();
        ScrollPane scrollPane = new ScrollPane(korisnici);
        scrollPane.setFitToWidth(true);

        imeField = new TextField();
        imeField.setPromptText("Ime");

        prezimeField = new TextField();
        prezimeField.setPromptText("Prezime");

        adresaField = new TextField();
        adresaField.setPromptText("Adresa");

        brojPasosaField = new TextField();
        brojPasosaField.setPromptText("Broj pasoša");

        terminComboBox = new ComboBox<>();
        terminComboBox.setPromptText("Termin");
        terminComboBox.setConverter(new StringConverter<Termin>() {
            @Override
            public String toString(Termin object) {
                return object.getAranzman().getMestoPolaska() + "-"
                        + object.getAranzman().getOdrediste() + "-"
                        + object.getDatumPolaska() + "-"
                        + object.getDatumOdlaska();
            }

            @Override
            public Termin fromString(String string) {
                return null;
            }
        });
        try {
            loadTermini();
        } catch (SQLException ex) {
            Logger.getLogger(KorisnikTab.class.getName()).log(Level.SEVERE, null, ex);
        }

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            if (selectedKorisnik == null) {
                addKorisnik();
            } else {
                updateKorisnik();
            }

        });

        addButton.disableProperty().bind(
                imeField.textProperty().isEmpty()
                        .or(prezimeField.textProperty().isEmpty())
                        .or(adresaField.textProperty().isEmpty())
                        .or(brojPasosaField.textProperty().isEmpty())
                        .or(terminComboBox.valueProperty().isNull())
        );

        VBox inputContainer = new VBox(
                new Label("Add Korisnik"),
                imeField,
                prezimeField,
                adresaField,
                brojPasosaField,
                terminComboBox,
                addButton
        );
        inputContainer.setSpacing(10);
        inputContainer.setPadding(new Insets(10, 0, 0, 0));

        VBox mainContainer = new VBox(inputContainer, scrollPane);

        setContent(mainContainer);

        loadKorisnici();
    }

    private void loadKorisnici() {
        try {
            korisnici.getChildren().clear();
            List<Korisnik> korisniciList = KorisnikCRUD.readAllKorisnici();

            for (Korisnik korisnik : korisniciList) {
                VBox korisnikPane = new VBox(
                        new Label("Ime: " + korisnik.getIme()),
                        new Label("Prezime: " + korisnik.getPrezime()),
                        new Label("Adresa: " + korisnik.getAdresa()),
                        new Label("Broj pasoša: " + korisnik.getBrojPasosa()),
                        new Label("Termin: "
                                + korisnik.getTermin().getAranzman().getMestoPolaska() + "-"
                                + korisnik.getTermin().getAranzman().getOdrediste()+ "-"
                                + korisnik.getTermin().getDatumPolaska() + "-"
                                + korisnik.getTermin().getDatumOdlaska())
                );
                korisnikPane.setStyle("-fx-background-color: #E8E8E8; -fx-padding: 10px; -fx-border-color: #CCCCCC; -fx-border-width: 1px; -fx-border-radius: 5px;");

                korisnikPane.setOnMouseClicked(event -> {
                    selectedKorisnik = korisnik;
                    fillFields(selectedKorisnik);
                });
                korisnici.getChildren().add(korisnikPane);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KorisnikTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addKorisnik() {
        String ime = imeField.getText();
        String prezime = prezimeField.getText();
        String adresa = adresaField.getText();
        String brojPasosa = brojPasosaField.getText();
        Termin termin = terminComboBox.getValue();

        Korisnik korisnik = new Korisnik(ime, prezime, adresa, Integer.parseInt(brojPasosa), termin);
        KorisnikCRUD.insertKorisnik(korisnik);
        loadKorisnici();
        clearFields();
    }

    private void clearFields() {
        imeField.clear();
        prezimeField.clear();
        adresaField.clear();
        brojPasosaField.clear();
        terminComboBox.setValue(null);
    }

    private void loadTermini() throws SQLException {
        ObservableList<Termin> terminList = FXCollections.observableArrayList(TerminCRUD.readAllTermini());
        terminComboBox.setItems(terminList);
    }

    private void updateKorisnik() {
        if (selectedKorisnik != null) {
            selectedKorisnik.setIme(imeField.getText());
            selectedKorisnik.setPrezime(prezimeField.getText());
            selectedKorisnik.setAdresa(adresaField.getText());
            selectedKorisnik.setBrojPasosa(Integer.valueOf(brojPasosaField.getText()));
            selectedKorisnik.setTermin(terminComboBox.getValue());

            KorisnikCRUD.updateKorisnik(selectedKorisnik);
            loadKorisnici();
            clearFields();
            selectedKorisnik = null;
        }
    }

    private void fillFields(Korisnik korisnik) {
        imeField.setText(korisnik.getIme());
        prezimeField.setText(korisnik.getPrezime());
        adresaField.setText(korisnik.getAdresa());
        brojPasosaField.setText(String.valueOf(korisnik.getBrojPasosa()));
        terminComboBox.setValue(korisnik.getTermin());
    }
}
