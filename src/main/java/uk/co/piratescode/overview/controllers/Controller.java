package uk.co.piratescode.overview.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uk.co.piratescode.overview.Main;

public class Controller {

    public static int i = 0;
    public static ListView<String> serverlist;

    public Color Center_Pane_TextColor;
    public Color Bottom_Status_Pane_TextColor;
    public Font Center_Pane_Font;
    public Font Bottom_Status_Pane_Font;
    public String Left_Status = "Loaded File: servers.json";
    public String Right_Status = "Connected";
    public Label RightStatus;
    public Label LeftStatus;

    public Controller(){
    }

    @FXML
    private void initialize() {
        RightStatus.setText(Right_Status);
        LeftStatus.setText(Left_Status);
        for (int j = 0; j < Main.servers.size(); j++) {
            serverlist.edit(j);
            serverlist.getItems().add(Main.servers.get(j).getServerName());
        }
    }

    @FXML public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + serverlist.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void ItemList() {
        serverlist.getItems().add(i, "test" + i);
        serverlist.edit(i);
        i++;
    }

    @FXML
    private void closeApplication() {
        System.exit(1);
    }
}
