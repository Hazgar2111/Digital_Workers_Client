package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import sample.Employee;
import sample.Main;
import sample.SaverProfile;

public class ChangePassController {

    @FXML
    private Button saveBtn;

    @FXML
    private Label errorLbl;

    @FXML
    private PasswordField oldPass;

    @FXML
    private PasswordField newPass;

    @FXML
    private PasswordField newPass1;

    @FXML
    void handleClicks(ActionEvent event) {
        if (event.getSource() == saveBtn)
        {
            String temp = String.valueOf(oldPass.getText().hashCode());
            Employee employee = SaverProfile.getProfile();
            if (temp.equals(employee.getPass()) && newPass.getText().equals(newPass1.getText()))
            {
                String s = String.valueOf(newPass.getText().hashCode());
                employee.setPass(s);
                try {
                    saveBtn.getScene().getWindow().hide();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                Main.updateEmployee(employee);
            }
            else
            {
                errorLbl.setText("Некоректные данные!!!");
            }
        }
    }

}
