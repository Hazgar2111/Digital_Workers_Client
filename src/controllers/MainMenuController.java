package controllers;


import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.ls.LSOutput;
import sample.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {


    @FXML
    private Button changePassBtn;

    @FXML
    private Label lblUserProfile;

    @FXML
    private AnchorPane personalDelaAp;

    @FXML
    private Button buttonInputPoiskPersonal;

    @FXML
    private TextField inputPoiskPersonal;

    @FXML
    private AnchorPane prikazyAp;

    @FXML
    private Button btnPoiskPrikazy;

    @FXML
    private TextField inputPrikazy;

    @FXML
    private AnchorPane prikazyAp1;

    @FXML
    private AnchorPane personalDelaAp1;

    @FXML
    private Button btnPersonal;

    @FXML
    private Button btnZhurnal;

    @FXML
    private Button btnSpravka;

    @FXML
    private Button btnVyhod;

    @FXML
    private Label PersonalSurname;

    @FXML
    private Label PersonalName;

    @FXML
    private Label PersonalMiddleName;

    @FXML
    private Label PersonalDate;

    @FXML
    private Label PersonalDolzhnost;

    @FXML
    private Label PersonalTrudDog;

    @FXML
    private Label PersonalNumberPhone;

    @FXML
    private Label PersonalEmail;

    @FXML
    private Label errorLblPoisk;

    @FXML
    private Label personalPapkaLabel;

    @FXML
    private TableView<TableClass> tablePersonal;

    @FXML
    private TableColumn<?, ?> numberCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private ImageView imageProfile;

    @FXML
    private Button personalBtnEdit;

    @FXML
    private Button personalBtnAdd;

    @FXML
    private Button personalBtnDelete;

    @FXML
    private AnchorPane PersonalAPpustyshka;

    @FXML
    private AnchorPane PersonalAPedit;

    @FXML
    private TextField inputEditFileType;

    @FXML
    private TextField inputEditFileName;

    @FXML
    private Button buttonEditSave;

    @FXML
    private Button buttonEditFile;

    @FXML
    private Button editBtnHide;

    @FXML
    private ComboBox<String> editComboBox;

    @FXML
    private ComboBox<String> addComboBx;

    @FXML
    private Button addBtnHide;

    @FXML
    private Button fileChoserBtn;

    @FXML
    private Button btnAddFile;

    @FXML
    private AnchorPane PersonalAPAdd;


    private static Employee temp;
    private final Desktop desktop = Desktop.getDesktop();
    private AllUserData allUserData;
    private File file;
    private TableClass tempEdit;
    private FileSaver fileSaverAdd;


    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ignored) {

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Employee employee = SaverProfile.getProfile();
        lblUserProfile.setText(employee.getSurname() + " " + employee.getName());

    }


    public static byte[] decodeImage(String imageDataString) {
        return Base64.getDecoder().decode(imageDataString);
    }


    public void eraiseLabel() {
        errorLblPoisk.setText("");
    }


    public ArrayList<FileSaver> getFileMethod(String filePath, String path) throws IOException {

        ArrayList<FileSaver> fileSavers = new ArrayList<>();

        String path1 = filePath + "\\tempFile\\" + path + "\\Внутренние Документы";
        String path2 = filePath + "\\tempFile\\" + path + "\\Командировки";
        String path3 = filePath + "\\tempFile\\" + path + "\\Корреспонденция Вход";
        String path4 = filePath + "\\tempFile\\" + path + "\\Корреспонденция Исход";
        String path5 = filePath + "\\tempFile\\" + path + "\\Личный Состав";
        String path6 = filePath + "\\tempFile\\" + path + "\\Производство";


        File dir1 = new File(path1);
        File dir2 = new File(path2);
        File dir3 = new File(path3);
        File dir4 = new File(path4);
        File dir5 = new File(path5);
        File dir6 = new File(path6);

        File[] arrFiles1 = dir1.listFiles();
        File[] arrFiles2 = dir2.listFiles();
        File[] arrFiles3 = dir3.listFiles();
        File[] arrFiles4 = dir4.listFiles();
        File[] arrFiles5 = dir5.listFiles();
        File[] arrFiles6 = dir6.listFiles();

        if (dir1.exists())
        {
            arrFiles1 = dir1.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles1).length; i++) {
                fileSavers.add(new FileSaver("Внутренние Документы", arrFiles1[i].getName(), arrFiles1[i]));
            }
        }
        if (dir2.exists())
        {
            arrFiles2 = dir2.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles2).length; i++) {
                fileSavers.add(new FileSaver("Командировки", arrFiles2[i].getName(), arrFiles2[i]));
            }
        }
        if (dir3.exists())
        {
            arrFiles3 = dir3.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles3).length; i++) {
                fileSavers.add(new FileSaver("Корреспонденция Вход", arrFiles3[i].getName(), arrFiles3[i]));
            }
        }
        if (dir4.exists())
        {
            arrFiles4 = dir4.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles4).length; i++) {
                fileSavers.add(new FileSaver("Корреспонденция Исход", arrFiles4[i].getName(), arrFiles4[i]));
            }
        }
        if (dir5.exists())
        {
            arrFiles5 = dir5.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles5).length; i++) {
                fileSavers.add(new FileSaver("Личный Состав", arrFiles5[i].getName(), arrFiles5[i]));
            }
        }
        if (dir6.exists())
        {
            arrFiles6 = dir6.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles6).length; i++) {
                fileSavers.add(new FileSaver("Производство", arrFiles6[i].getName(), arrFiles6[i]));
            }
        }


        return fileSavers;
    }


    @FXML
    public void handleClicks(javafx.event.ActionEvent event) throws IOException {
        if (event.getSource() == btnPersonal) {
            personalDelaAp.toFront();
            personalDelaAp1.toFront();
            eraiseLabel();
        }
        else if (event.getSource() == btnZhurnal)
        {
            prikazyAp.toFront();
            prikazyAp1.toFront();
            eraiseLabel();
        }
        else if (event.getSource() == btnVyhod)
        {
            eraiseLabel();
            btnVyhod.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxmles/loginPageDW.fxml"));
                Stage main_menu = new Stage();
                main_menu.setTitle("Авторизация пользователя");
                main_menu.setScene(new Scene(root, 763, 487)); // размеры нового окна
                main_menu.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonInputPoiskPersonal)
        {
            ArrayList<Employee> employees = Main.getEmployeesMethod();
            int check = 0;
            for (Employee employee : employees) {
                if (employee.getSurname().contains(inputPoiskPersonal.getText())) {
                    temp = employee;
                    check = 1;
                }
            }
            if (check == 1) {
                allUserData = Main.getUserData(temp.getSurname() + temp.getName(), temp.getId());

                byte[] imageByteArray = allUserData.getImage();
                String filePath = new File("").getAbsolutePath();
                String pathToImage = filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + "temp.png";
                FileOutputStream imageOutFile = new FileOutputStream(pathToImage);
                imageOutFile.write(imageByteArray);

                BufferedImage bufferedImage = ImageIO.read(new File(pathToImage));
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                imageProfile.setImage(image);


                personalPapkaLabel.setText(temp.getSurname() + " " + temp.getName());
                PersonalSurname.setText(temp.getSurname());
                PersonalName.setText(temp.getName());
                PersonalMiddleName.setText(temp.getMiddle_name());
                PersonalDate.setText(temp.getDatePriema());
                PersonalDolzhnost.setText(temp.getDolzhnost());
                PersonalTrudDog.setText(temp.getTrud_dogovor());
                PersonalNumberPhone.setText(temp.getPhone_number());
                PersonalEmail.setText(temp.getEmail());
                eraiseLabel();

                ArrayList<TableClass> tableClasses = new ArrayList<>();
                String path = temp.getSurname() + temp.getName();
                ArrayList<FileSaver> fileSavers = getFileMethod(filePath, path);
                for (int i = 0; i < fileSavers.size(); i++) {
                    tableClasses.add(new TableClass(i + 1,
                            fileSavers.get(i).getType(),
                            fileSavers.get(i).getFile(),
                            fileSavers.get(i).getFile().getName()));
                }

                ObservableList<TableClass> observableList = FXCollections.observableList(
                        tableClasses
                );
                numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
                typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
                nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

                tablePersonal.setItems(observableList);
            } else {
                errorLblPoisk.setText("Данный сотрудник не найден!");
            }
        }
        else if (event.getSource() == personalBtnEdit)
        {


            tempEdit = tablePersonal.getSelectionModel().getSelectedItem();
            file = tempEdit.getFile();
            inputEditFileName.setText(tempEdit.getName());

            ObservableList<String> spisok2 = FXCollections.observableArrayList("Внутренние Документы", "Командировки",
                    "Корреспонденция Вход", "Корреспонденция Исход",
                    "Личный Состав", "Производство");
            editComboBox.setValue(tempEdit.getType());
            editComboBox.setItems(spisok2);
            PersonalAPedit.toFront();

        }
        else if (event.getSource() == buttonEditFile)
        {
            openFile(file);
        }
        else if (event.getSource() == buttonEditSave)
        {
            FileSaver fileSaver = new FileSaver(editComboBox.getValue(),
                    tempEdit.getType(),
                    inputEditFileName.getText(),
                    tempEdit.getName(),
                    Files.readAllBytes(Path.of(tempEdit.getFile().getAbsolutePath())),
                    1);

            if (editComboBox.getValue().equals(tempEdit.getType()) && inputEditFileName.getText().equals(tempEdit.getName())) {
                Main.saveFile(fileSaver, temp.getSurname() + temp.getName());

            } else {
                String filePath = new File("").getAbsolutePath();
                String delete = filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + tempEdit.getType() + "\\" + tempEdit.getName();
                String path1 = filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + editComboBox.getValue() + "\\" + inputEditFileName.getText();
                Files.delete(Path.of(delete));
                Files.write(Path.of(path1), fileSaver.getFileBytes());
                Main.saveFile(fileSaver, temp.getSurname() + temp.getName());
            }
        }
        else if (event.getSource() == personalBtnAdd)
        {
            ObservableList<String> spisok2 = FXCollections.observableArrayList("Внутренние Документы", "Командировки",
                    "Корреспонденция Вход", "Корреспонденция Исход",
                    "Личный Состав", "Производство");
            addComboBx.setValue("Выберите тип документа");
            addComboBx.setItems(spisok2);
            PersonalAPAdd.toFront();

        }
        else if (event.getSource() == fileChoserBtn)
        {
            final FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                byte[] fileByte = Files.readAllBytes(Path.of(file.getAbsolutePath()));
                fileSaverAdd = new FileSaver(addComboBx.getValue(), file.getName(), fileByte);
                //openFile(file);
            }

        }
        else if (event.getSource() == addBtnHide)
        {
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == editBtnHide)
        {
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == btnAddFile)
        {
            if (!fileSaverAdd.getName().isEmpty())
            {
                Main.saveFile(fileSaverAdd,temp.getSurname()+temp.getName());
            }
            PersonalAPpustyshka.toFront();
        }

        else if (event.getSource() == personalBtnDelete)
        {
            TableClass temp = tablePersonal.getSelectionModel().getSelectedItem();
            System.out.println(temp.getName());
        }
        else if (event.getSource() == changePassBtn) {
            if (event.getSource() == changePassBtn) {
                Employee employee = SaverProfile.getProfile();
                Parent settingsParent = FXMLLoader.load(this.getClass().getResource("/fxmles/changePassDW.fxml"));
                Scene settingsScene = new Scene(settingsParent);
                Stage popup = new Stage();
                popup.setScene(settingsScene);
                popup.setTitle("Смена пароля");
                popup.initModality(Modality.WINDOW_MODAL);
                popup.initOwner(changePassBtn.getScene().getWindow());
                popup.show();
            }

        }
    }


}
