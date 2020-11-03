package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Employee;
import sample.Main;
import sample.SaverProfile;

import java.io.IOException;
import java.util.ArrayList;

public class LoginPageController {

    @FXML
    private Button signin_button;

    @FXML
    private PasswordField pass_field;

    @FXML
    private Button showPassBtn;

    @FXML
    private TextField login_field;

    ArrayList<Employee> employees = new ArrayList<>();

    @FXML
    private String password;



    void show1()
    {
        try {
            signin_button.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/fxmles/mainMenuDW.fxml"));
            Stage main_menu = new Stage();
            main_menu.setTitle("Hazgar's Application CO");
            main_menu.setScene(new Scene(root, 1565, 756)); // размеры нового окна
            main_menu.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        employees = Main.getEmployeesMethod();


        showPassBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            password = pass_field.getText();
            pass_field.clear();
            pass_field.setPromptText(password);
        });
        showPassBtn.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
            pass_field.setText(password);
            pass_field.setPromptText("Пароль");
        });

        signin_button.setDefaultButton(true);

        signin_button.setOnAction(event ->
        {

            String pass_f = String.valueOf(pass_field.getText().trim().hashCode());
            String login_f = String.valueOf(login_field.getText());
            int check = 0;
            for (Employee employee : employees) {
                if (employee.getLogin().equals(login_f) && employee.getPass().equals(pass_f)) {
                    SaverProfile.saveProfile(employee);
                    check = 1;
                    break;
                }
            }
            if (check == 1) {
                String temp1 = String.valueOf("1234".hashCode());
                Employee employee = SaverProfile.getProfile();
                if (employee.getPass().equals(temp1))
                {
                    Parent changePass = null;
                    try {
                        show1();
                        changePass = FXMLLoader.load(this.getClass().getResource("/fxmles/changePassDW.fxml"));
                        Scene settingsScene = new Scene(changePass);
                        Stage popup = new Stage();
                        popup.setScene(settingsScene);
                        popup.setTitle("Смена пароля");
                        popup.initStyle(StageStyle.TRANSPARENT);
                        popup.initModality(Modality.WINDOW_MODAL);
                        popup.initOwner(signin_button.getScene().getWindow());
                        popup.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else
                    show1();

            }
            else {
                signin_button.getScene().getWindow().hide();

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxmles/loginPageDW.fxml"));
                    Stage main_menu = new Stage();
                    main_menu.setTitle("Hazgar's Application CO");
                    main_menu.setScene(new Scene(root, 763, 487)); // размеры нового окна
                    main_menu.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}