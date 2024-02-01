/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class Styling extends Application {

    /**
     * Buttons used in starting scene, crypto(add, withdraw and conversion)
     * scenes
     *
     * @param buttons
     */
    public static void buttonStyling(Button... buttons) {

        for (Button btn : buttons) {

            btn.setStyle("-fx-background-color: \n"
                    + "        linear-gradient(#f2f2f2, #d6d6d6),\n"
                    + "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n"
                    + "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n"
                    + "    -fx-background-radius: 8,7,6;\n"
                    + "    -fx-background-insets: 0,1,2;\n"
                    + "    -fx-text-fill: black;\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )"
            );
            btn.setPrefSize(185, 50);
            btn.setFont(Font.font("Sans Serif", 20));
            btn.setOnMouseMoved(e -> {
                btn.setStyle("-fx-background-color: \n"
                        + "        #c3c4c4,\n"
                        + "        linear-gradient(#d6d6d6 50%, white 100%),\n"
                        + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                        + "    -fx-background-radius: 8,7,6;\n"
                        + "    -fx-background-insets: 0,1,2;\n"
                        + "    -fx-text-fill: black;\n"
                        + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
            });
            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color: \n"
                        + "        linear-gradient(#f2f2f2, #d6d6d6),\n"
                        + "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n"
                        + "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n"
                        + "    -fx-background-radius: 8,7,6;\n"
                        + "    -fx-background-insets: 0,1,2;\n"
                        + "    -fx-text-fill: black;\n"
                        + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
            });
        }

    }

    /**
     * Making smaller buttons
     *
     * @param buttons
     */
    public static void buttonStylingSmall(Button... buttons) {
        for (Button btn : buttons) {
            btn.setPrefSize(120, 35);
        }
    }

    /**
     * TextField styling
     *
     * @param textfields
     */
    public static void textFieldStyling(TextField... textfields) {
        for (TextField tf : textfields) {
            tf.setStyle("-fx-background-color: #a9a9a9 , white , white;\n"
                    + "  -fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;");
            tf.setMinSize(200, 30);
        }
    }

    /**
     * Label styling
     *
     * @param labels
     */
    public static void labelStyling(Label... labels) {
        for (Label l : labels) {
            l.setFont(Font.font("Sans Serif", 25));
            l.setTextFill(Color.WHITE);
        }
    }

    /**
     * Used in register and login
     *
     * @param labels
     */
    public static void labelLogoStyling(Label... labels) {
        for (Label l : labels) {
            l.setFont(Font.font("Sans Serif", FontWeight.BOLD, 65));
            l.setTextFill(Color.WHITE);
        }
    }

    /**
     * Menu buttons
     *
     * @param buttons
     */
    public static void menuButtons(Button... buttons) {
        for (Button btn : buttons) {
            btn.setStyle("-fx-background-color:#0B052C;"
            );

            btn.setOnMouseMoved(e -> {
                btn.setStyle("-fx-background-color:#0C1464;"
                );

            });
            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color:#0B052C;"
                );

            });
            btn.setPrefSize(310, 35);
            btn.setTextFill(Color.WHITE);
            btn.setFont(Font.font("Sans Serif", FontWeight.NORMAL, 25));
        }
    }

    /**
     * For validation label
     *
     * @param labels
     */
    public static void badCredentialLabels(Label... labels) {
        for (Label l : labels) {
            l.setTextFill(Color.RED);
            l.setVisible(false);

        }
    }

    /**
     * Buttons for wallet menu
     *
     * @param buttons
     */
    public static void menuButtonsWallet(Button... buttons) {
        for (Button btn : buttons) {
            btn.setStyle("-fx-background-color:#0B052C;"
                    + "-fx-background-radius: 0;"
            );
            btn.setFont(Font.font("Sans Serif", FontWeight.NORMAL, 25));

            btn.setOnMouseMoved(e -> {
                btn.setStyle("-fx-background-color:#0C1464;"
                        + "-fx-background-radius: 0;"
                );
                btn.setFont(Font.font("Sans Serif", FontWeight.NORMAL, 35));
            });
            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color:#0B052C;"
                        + "-fx-background-radius: 0;"
                );
                btn.setFont(Font.font("Sans Serif", FontWeight.NORMAL, 25));
            });
            btn.setPrefSize(800, 300);
            btn.setTextFill(Color.WHITE);

        }
    }

    /**
     * ComboBox styling
     *
     * @param combos
     */
    public static void comboBoxStyling(ComboBox... combos) {
        for (ComboBox b : combos) {
            b.setStyle("-fx-background-color: #a9a9a9 , white , white;\n"
                    + "  -fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;");
            b.setMinSize(300, 30);
        }
    }

    /**
     * Buttons for scene CurrencyScene
     *
     * @param buttons
     */
    public static void currencySceneButtons(Button... buttons) {
        for (Button btn : buttons) {
            btn.setStyle("-fx-background-color:#0B052C;"
                    + "-fx-background-radius: 0;"
            );

            btn.setOnMouseMoved(e -> {
                btn.setStyle("-fx-background-color:#0C1464;"
                        + "-fx-background-radius: 0;"
                );

            });
            btn.setOnMouseExited(e -> {
                btn.setStyle("-fx-background-color:#0B052C;"
                        + "-fx-background-radius: 0;"
                );

            });
            btn.setPrefSize(500, 40);
            btn.setTextFill(Color.WHITE);
            btn.setFont(Font.font("Sans Serif", FontWeight.NORMAL, 25));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}
