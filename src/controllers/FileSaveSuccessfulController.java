package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FileSaveSuccessfulController {

    @FXML
    private Button okBtn;

    @FXML
    private Label errorLbl;

    @FXML
    void handleClicks(ActionEvent event) {
        if (event.getSource() == okBtn)
        {
            okBtn.getScene().getWindow().hide();
        }
    }

}
