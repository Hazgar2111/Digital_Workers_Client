package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class nedPravController {

    @FXML
    private Button okBtn;

    @FXML
    void handleClicks(ActionEvent event) {
        if (event.getSource() == okBtn)
        {
            okBtn.getScene().getWindow().hide();
        }
    }
}
