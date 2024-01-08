package cs202.turagencija;

import cs202.turagencija.db.DBUtil;
import cs202.turagencija.scenes.StartScene;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author djoki_4zczxr0
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {
        DBUtil.initDB();

        //Starting primary stage 
        new StartScene().start(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
