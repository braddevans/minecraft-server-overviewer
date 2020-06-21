package uk.co.piratescode.overview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import uk.co.piratescode.overview.entitys.Server;
import uk.co.piratescode.overview.util.LoggingUtil;
import uk.co.piratescode.overview.util.Utils;

import java.util.HashMap;

public class Main extends Application {
    // on load
    // list all JVM's and set there names using their jvm -Dservername="tkx"
    // also add the option to add servers over the network using the visualVm methods
    // possibly multi-thread this program

    public static HashMap<Integer, Server> servers = new HashMap<>();

    public static void main(String[] args) {
        PropertyConfigurator.configure(Main.class.getResourceAsStream("/log4j.properties"));
        LoggingUtil.log(Level.INFO, "Loaded");
        Utils.InitialStartup();

        LoggingUtil.log(Level.INFO, "Starting Tasks");
        Utils.loadJsonServersFile();

        // nothing else runs beyond this function `launch()` until the program exits
        launch(args);
        LoggingUtil.log(Level.INFO, "Closed App");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("Minecraft Server Overview");
        primaryStage.setScene(new Scene(root, 1500, 900));
        primaryStage.show();
    }

}
