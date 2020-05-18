package JKU_MMS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {

    public static Connection conn;

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("mainUI.fxml"));
        final Parent root = loader.load();
        Controller controller = loader.getController();

        primaryStage.setTitle("Video Encoder");
        primaryStage.setScene(new Scene(root, 500, 250));
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            controller.close();
        });
    }



    public static void main(String[] args) throws UnexpectedException, SQLException {
        Connection conn = SQLite.getConnection();
        SQLite.addSampleProfile();
        launch(args);
        conn.close();
    }
}
