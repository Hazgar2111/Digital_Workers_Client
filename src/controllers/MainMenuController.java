package controllers;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
import java.nio.file.StandardCopyOption;
import java.util.*;


public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane spravkaAP;

    @FXML
    private AnchorPane spravkaAP1;

    @FXML
    private AnchorPane pustyshkaAP1;


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
    private Label errorLblAccess;

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


    @FXML
    private AnchorPane PersonalAPDelete;

    @FXML
    private CheckBox deleteCheckBx;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button deleteBtnHide;

    @FXML
    private Label deleteFileType;

    @FXML
    private Label deleteFileName;


    @FXML
    private Button btnSite;

    @FXML
    private TableView<TableClassBackUp> logTable;

    @FXML
    private TableColumn<?, ?> LogNumberCol;

    @FXML
    private TableColumn<?, ?> logDateCol;

    @FXML
    private TableColumn<?, ?> LogNameCol;

    @FXML
    private TableColumn<?, ?> logActonCol;

    @FXML
    private TableColumn<?, ?> logKtoCol;

    @FXML
    private TableColumn<?, ?> logKomuCol;

    @FXML
    private TextField logInputPoisk;

    @FXML
    private Button logInputPoiskBtn;

    @FXML
    private ComboBox<String> logComboPoisk;

    @FXML
    private Button logRepairBtn;

    @FXML
    private Label logFileNameLbl;

    @FXML
    private AnchorPane logAPPustyshDown;

    @FXML
    private AnchorPane logAPDown;



    @FXML
    private ComboBox<String> createTemplateCmbBox;

    @FXML
    private Button createTemplateBtn;

    @FXML
    private AnchorPane createPustyshkaAP;

    @FXML
    private AnchorPane createEditFileAP;

    @FXML
    private Button createEditFileBtn;

    @FXML
    private Label createNameLbl;

    @FXML
    private AnchorPane createAddEmployeeAP;

    @FXML
    private Button createEmployeeBtn;

    @FXML
    private TextField createInputEmployee1;

    @FXML
    private ListView<String> createListView;

    @FXML
    private AnchorPane createNamePrikazaAP;

    @FXML
    private AnchorPane createApEmplTable;

    @FXML
    private Button createInputNameBtn;

    @FXML
    private TextField createInputName;

    @FXML
    private TableView<TableClassNewFile> createTableEmpl;

    @FXML
    private ProgressBar createProgressBar;


    @FXML
    private Button createNameBackBtn;

    @FXML
    private Button createAddEmplBackBtn;

    @FXML
    private Button createEditFileBackBtn;

    @FXML
    private TableColumn<?, ?> createTableColNumber;

    @FXML
    private TableColumn<?, ?> createTableColSurname;

    @FXML
    private TableColumn<?, ?> createTableColName;

    @FXML
    private TableColumn<?, ?> createTableColMName;


    @FXML
    private AnchorPane createApPustyskaEmplTable;

    @FXML
    private AnchorPane createSaveFile;

    @FXML
    private Button createAddEmplForwardBtn;

    @FXML
    private Button createDeleteEmplBtn;

    @FXML
    private Button createSaveFileBackBtn;

    @FXML
    private Button createSaveFileBtn;

    @FXML
    private AnchorPane createApNext;


    @FXML
    private TableView<TableClass> komandirovkiTable;

    @FXML
    private TableColumn<?, ?> komandirovkiTableDate;

    @FXML
    private TableColumn<?, ?> komandirovkiTableName;

    @FXML
    private TableColumn<?, ?> komandirovkiTableDesc;

    @FXML
    private TextField komandirovkiInputPoisk;

    @FXML
    private Button komandirovkiPoiskBtn;

    @FXML
    private TableView<TableClass> lichSostavTable;

    @FXML
    private TableColumn<?, ?> lichSostavTableDate;

    @FXML
    private TableColumn<?, ?> lichSostavTableName;

    @FXML
    private TableColumn<?, ?> lichSostavTableDesc;

    @FXML
    private TextField lichSostavInputPoisk;

    @FXML
    private Button lichSostavPoiskBtn;

    @FXML
    private TableView<TableClass> proizvodTable;

    @FXML
    private TableColumn<?, ?> proizvodTableDate;

    @FXML
    private TableColumn<?, ?> proizvodTableName;

    @FXML
    private TableColumn<?, ?> proizvodTableDesc;

    @FXML
    private TextField proizvodInputPosik;

    @FXML
    private Button proizvodPoiskBtn;

    @FXML
    private Button komandirovkiEditFileBtn;

    @FXML
    private Button komandirovkiSaveChangesBtn;

    @FXML
    private ComboBox<String> komandirovkiCmbBox;

    @FXML
    private TextField komandirovkiInputEditName;

    @FXML
    private Button btnZhurnalPrikazy;

    @FXML
    private AnchorPane zhurnalPrikazyAP;

    @FXML
    private AnchorPane zhurnalPrikazyAP1;

    @FXML
    private TabPane zhurnalTabpane;

    @FXML
    private Label logEmplLblEmployees;

    @FXML
    private AnchorPane zhurnalPrikPustyshkaAp;

    @FXML
    private AnchorPane zhurnalPrikEditAp;

    @FXML
    private TextArea description;

    @FXML
    private Label amountSymbolLbl;


    private static File tempFile;
    private static Employee temp;
    private final Desktop desktop = Desktop.getDesktop();
    private AllUserData allUserData;
    private File file;
    private TableClass tempEdit;
    private FileSaver fileSaverAdd;
    private ArrayList<TableClass> tableClasses;
    private final String filePath = new File("").getAbsolutePath();
    private static TableClass tempDelete;
    private ArrayList<TableClassBackUp> tableClassBackUps;
    private ObservableList<String> entries;
    private int count = 0;
    private HashSet<TableClassNewFile> tableClassNewFileArrayList = new HashSet<>();
    private FileSaver fileSaverEditPrikazy = new FileSaver();
    private TableClassBackUp tempBackUp;


    public void search(String oldVal, String newVal) {
        if (oldVal != null && (newVal.length() < oldVal.length())) {
            createListView.setItems(entries);
        }
        String value = newVal.toUpperCase();
        ObservableList<String> subentries = FXCollections.observableArrayList();
        ObservableList<String> items = createListView.getItems();
        for (String str : items) {
            if (str.toUpperCase().contains(value)) {
                subentries.add(str);
            }
        }
        createListView.setItems(subentries);
    }


    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ignored) {

        }
    }


    public void eraiseLabel() {
        errorLblPoisk.setText("");
        errorLblAccess.setText("");
        createNameLbl.setText("");
        description.setText("");
        komandirovkiInputEditName.setText("");
        createInputName.setText("");
        zhurnalPrikPustyshkaAp.toFront();
    }


    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        File[] arrFiles1;
        File[] arrFiles2;
        File[] arrFiles3;
        File[] arrFiles4;
        File[] arrFiles5;
        File[] arrFiles6;

        if (dir1.exists()) {
            arrFiles1 = dir1.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles1).length; i++) {
                fileSavers.add(new FileSaver("Внутренние Документы", arrFiles1[i].getName(), arrFiles1[i]));
            }
        }
        if (dir2.exists()) {
            arrFiles2 = dir2.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles2).length; i++) {
                fileSavers.add(new FileSaver("Командировки", arrFiles2[i].getName(), arrFiles2[i]));
            }
        }
        if (dir3.exists()) {
            arrFiles3 = dir3.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles3).length; i++) {
                fileSavers.add(new FileSaver("Корреспонденция Вход", arrFiles3[i].getName(), arrFiles3[i]));
            }
        }
        if (dir4.exists()) {
            arrFiles4 = dir4.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles4).length; i++) {
                fileSavers.add(new FileSaver("Корреспонденция Исход", arrFiles4[i].getName(), arrFiles4[i]));
            }
        }
        if (dir5.exists()) {
            arrFiles5 = dir5.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles5).length; i++) {
                fileSavers.add(new FileSaver("Личный Состав", arrFiles5[i].getName(), arrFiles5[i]));
            }
        }
        if (dir6.exists()) {
            arrFiles6 = dir6.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles6).length; i++) {
                fileSavers.add(new FileSaver("Производство", arrFiles6[i].getName(), arrFiles6[i]));
            }
        }


        return fileSavers;
    }


    public ArrayList<FileSaver> getFileMethodType(String type) {

        ArrayList<FileSaver> fileSavers = new ArrayList<>();
        String path1 = filePath + "\\tempFileType" + type;
        File dir1 = new File(path1);
        File[] arrFiles1;

        if (dir1.exists()) {
            arrFiles1 = dir1.listFiles();
            for (int i = 0; i < Objects.requireNonNull(arrFiles1).length; i++) {
                fileSavers.add(new FileSaver("Внутренние Документы", arrFiles1[i].getName(), arrFiles1[i]));
            }
        }
        return fileSavers;
    }


    public void eraseTempFile(String name) {
        String path1 = filePath + "\\tempFile";
        File dir1 = new File(path1);
        File[] arrFiles1 = dir1.listFiles();
        assert arrFiles1 != null;
        for (File file : arrFiles1) {
            deleteFolder(file);
        }
    }


    static void deleteFolder(File file) {
        for (File subFile : Objects.requireNonNull(file.listFiles())) {
            if (subFile.isDirectory()) {
                deleteFolder(subFile);
            } else {
                subFile.delete();
            }
        }
        file.delete();
    }


    public void refreshTable() throws IOException {
        tablePersonal.getItems().clear();
        tableClasses = new ArrayList<>();
        allUserData = Main.getUserData(temp.getSurname() + temp.getName(), temp.getId());
        String path = temp.getSurname() + temp.getName();

        ArrayList<FileSaver> fileSavers = getFileMethod(filePath, path);
        ArrayList<FileSaver> fileSavers1 = allUserData.getFileSavers();
        for (int i = 0; i < fileSavers.size(); i++) {
            for (FileSaver files : fileSavers1) {
                if (files.getName().equals(fileSavers.get(i).getFile().getName())) {
                    tableClasses.add(new TableClass(i + 1,
                            fileSavers.get(i).getType(),
                            fileSavers.get(i).getFile(),
                            fileSavers.get(i).getFile().getName(),
                            files.getId()));
                }
            }
        }

        ObservableList<TableClass> observableList1 = FXCollections.observableList(
                tableClasses
        );

        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        tablePersonal.setItems(observableList1);
    }


    public void refreshTableBackUp() {
        logTable.getItems().clear();

        ArrayList<BackUpFile> backUpFiles = Main.getBackUpMethod();
        tableClassBackUps = new ArrayList<>();
        int count = 1;
        String s = ", ";

        for (BackUpFile backUp : backUpFiles) {
            StringBuilder all = new StringBuilder();
            FileSaver fileSaver = Main.getOneFileMethod(backUp.getFiles_id());
            Employee kto_sdelal = Main.getOneEmployeeMethod(backUp.getKto_sdelal_employeeId());
            ArrayList<File_to_human> file_to_humen = Main.getFilesToHumanBackup(backUp.getFiles_id());
            String logKomucol = " ";
            for (File_to_human temp : file_to_humen) {
                Employee employee = Main.getOneEmployeeMethod(temp.getId_employee());
                String temp1 = employee.getSurname();
                if (backUp.getKomu_sdelali_employeeId() == temp.getId_employee()) {
                    logKomucol = employee.getSurname();
                } else {
                    all.append(temp1).append(s);
                }
            }

            switch (logComboPoisk.getValue()) {
                case "Наименование файла":
                    if (!logInputPoisk.getText().isEmpty()) {
                        if (fileSaver.getName().toLowerCase().contains(logInputPoisk.getText().toLowerCase())) {
                            ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol);
                        }
                    }
                    else {
                        ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol); }
                    break;
                case "Кто сделал изменения":
                    if (!logInputPoisk.getText().isEmpty()) {
                        String s1 = kto_sdelal.getSurname()+kto_sdelal.getName();
                        if (s1.toLowerCase().contains(logInputPoisk.getText().toLowerCase())) {
                            ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol);
                        }
                    } else {
                        ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol); }
                    break;
                case "Кому сделали изменения":
                    if (!logInputPoisk.getText().isEmpty()) {
                        String s1 = (logKomucol +all).replace(" ", "");
                        if (s1.toLowerCase().contains(logInputPoisk.getText().toLowerCase())) {
                            ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol);
                        }
                    } else {
                        ifForLogInputSearch(count, backUp, all, fileSaver, kto_sdelal, logKomucol); }
                    break;
            }

            count++;
        }

        ObservableList<TableClassBackUp> observableList1 = FXCollections.observableList(
                tableClassBackUps);

        LogNumberCol.setCellValueFactory(new PropertyValueFactory<>("LogNumberCol"));
        LogNameCol.setCellValueFactory(new PropertyValueFactory<>("LogNameCol"));
        logActonCol.setCellValueFactory(new PropertyValueFactory<>("logActonCol"));
        logKtoCol.setCellValueFactory(new PropertyValueFactory<>("logKtoCol"));
        logKomuCol.setCellValueFactory(new PropertyValueFactory<>("logKomuCol"));
        logDateCol.setCellValueFactory(new PropertyValueFactory<>("logDate"));

        logTable.setItems(observableList1);
    }


    private void ifForLogInputSearch(int count, BackUpFile backUp, StringBuilder all, FileSaver fileSaver, Employee kto_sdelal, String logKomucol) {
        if (logKomucol.equals(" ")) {
            int size = all.lastIndexOf(",");
            all.deleteCharAt(size);
            tableClassBackUps.add(new TableClassBackUp(backUp.getId(), count, fileSaver.getName(), backUp.getAction1(),
                    kto_sdelal.getSurname() + " " + kto_sdelal.getName(), all.toString(), backUp.getDate().toString(),
                    backUp.getFiles_id(), backUp.getKomu_sdelali_employeeId()));
        } else {
            tableClassBackUps.add(new TableClassBackUp(backUp.getId(), count, fileSaver.getName(), backUp.getAction1(),
                    kto_sdelal.getSurname() + " " + kto_sdelal.getName(), logKomucol, backUp.getDate().toString(),
                    backUp.getFiles_id(), backUp.getKomu_sdelali_employeeId()));
        }
    }


    public void refreshTableNewFile() {
        createTableEmpl.getItems().clear();
        //Collections.copy(tempArray, tableClassNewFileArrayList);
        ArrayList<TableClassNewFile> tempArray = new ArrayList<>(tableClassNewFileArrayList);

        ObservableList<TableClassNewFile> observableListNewfile = FXCollections.observableList(
                tempArray
        );

        createTableColNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        createTableColSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        createTableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        createTableColMName.setCellValueFactory(new PropertyValueFactory<>("middle_name"));
        createTableEmpl.setItems(observableListNewfile);
    }


    public void refreshkomandirovkiTable(){
        komandirovkiTable.getItems().clear();
        ArrayList<TableClass> tableClassKomandirovki = new ArrayList<>();
        ArrayList<FileSaver> fileSavers1 = Main.getFilesKomand("Командировки");
        //ArrayList<FileSaver> fileSavers = getFileMethodType("Командировки");

        if (!komandirovkiInputPoisk.getText().isEmpty()){
            for (FileSaver saver : fileSavers1) {
                if (saver.getName().contains(komandirovkiInputPoisk.getText())) {
                    tableClassKomandirovki.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
                }

            }
        }
        else {
            for (FileSaver saver : fileSavers1) {
                    tableClassKomandirovki.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
            }
        }


        ObservableList<TableClass> observableList1 = FXCollections.observableList(
                tableClassKomandirovki
        );

        komandirovkiTableDate.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        komandirovkiTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        komandirovkiTableDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));


        komandirovkiTable.setItems(observableList1);
    }


    public void refreshLsTable(){
        lichSostavTable.getItems().clear();
        ArrayList<TableClass> tableClassLS = new ArrayList<>();
        ArrayList<FileSaver> fileSavers1 = Main.getFilesKomand("Личный состав");
        //ArrayList<FileSaver> fileSavers = getFileMethodType("Командировки");

        if (!lichSostavInputPoisk.getText().isEmpty()){
            for (FileSaver saver : fileSavers1) {
                if (saver.getName().contains(lichSostavInputPoisk.getText())) {
                    tableClassLS.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
                }

            }
        }
        else {
            for (FileSaver saver : fileSavers1) {
                tableClassLS.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
            }
        }


        ObservableList<TableClass> observableList1 = FXCollections.observableList(
                tableClassLS
        );

        lichSostavTableDate.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        lichSostavTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        lichSostavTableDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        lichSostavTable.setItems(observableList1);
    }


    public void refreshtableProizvodstvo(){
        proizvodTable.getItems().clear();
        ArrayList<TableClass> tableClassProizvodstvo = new ArrayList<>();
        ArrayList<FileSaver> fileSavers1 = Main.getFilesKomand("Производство");

        if (!proizvodInputPosik.getText().isEmpty()){
            for (FileSaver saver : fileSavers1) {
                if (saver.getName().contains(proizvodInputPosik.getText())) {
                    tableClassProizvodstvo.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
                }
            }
        }
        else {
            for (FileSaver saver : fileSavers1) {
                tableClassProizvodstvo.add(new TableClass(saver.getName(), saver.getDesc(), saver.getDateTime(), saver.getId()));
            }
        }

        ObservableList<TableClass> observableList1 = FXCollections.observableList(
                tableClassProizvodstvo
        );

        proizvodTableDate.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        proizvodTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        proizvodTableDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        proizvodTable.setItems(observableList1);
    }


    public void doubleClicksListener(TableView<TableClass> tableView) {
        tableView.setRowFactory(tv -> {
            TableRow<TableClass> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    TableClass rowData = row.getItem();
                    komandirovkiInputEditName.setText(rowData.getName());
                    fileSaverEditPrikazy = Main.getOneFileMethod(rowData.getId());
                    zhurnalPrikEditAp.toFront();
                    try {
                        Files.write(Path.of(filePath + "\\tempFileType\\" +

                                        fileSaverEditPrikazy.getName()),
                                fileSaverEditPrikazy.getFileBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    komandirovkiCmbBox.setValue(fileSaverEditPrikazy.getType());

                }
            });
            return row;
        });

    }


    public void showNoteSuccess(String path) throws IOException {
        Parent settingsParent = FXMLLoader.load(this.getClass().getResource(path));
        Scene settingsScene = new Scene(settingsParent);
        Stage popup = new Stage();
        popup.setScene(settingsScene);
        popup.setTitle("Уведомление");
        popup.initModality(Modality.WINDOW_MODAL);
        popup.initStyle(StageStyle.TRANSPARENT);
        popup.initOwner(createSaveFileBtn.getScene().getWindow());
        popup.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> spisok2 = FXCollections.observableArrayList("Внутренние Документы", "Командировки",
                "Корреспонденция Вход", "Корреспонденция Исход",
                "Личный Состав", "Производство");
        editComboBox.setItems(spisok2);

        final int MAX_CHARS = 200;
        description.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= MAX_CHARS ? change : null));
        description.textProperty().addListener((ObservableValue<? extends String> obs, String oVal, String nVal) -> {

            String prevText = description.getText();
            int inputLength = prevText.length();
            String s = inputLength + " / 200";
            amountSymbolLbl.setText(s);
        });

        Employee employee = SaverProfile.getProfile();
        lblUserProfile.setText(employee.getSurname() + " " + employee.getName());
        PersonalSurname.setText("");

        ObservableList<String> tempComboBx = FXCollections.observableArrayList("Командировки", "Личный состав",
                "Корреспонденция Вход", "Корреспонденция Исход", "Внутренние документы", "Производство");
        createTemplateCmbBox.setItems(tempComboBx);
        createTemplateCmbBox.setValue("Командировки");


        ArrayList<Employee> employees = Main.getEmployeesMethod();
        ArrayList<String> tempStr = new ArrayList<>();
        for (Employee value : employees) {
            tempStr.add(value.getId() + "/ " + value.getSurname() + " " + value.getName() + " " + value.getMiddle_name());

        }
        entries = FXCollections.observableArrayList(tempStr);
        createListView.setItems(entries);
        createInputEmployee1.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldVal,
                                Object newVal) {
                search((String) oldVal, (String) newVal);
            }
        });

        zhurnalTabpane.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
            if (zhurnalTabpane.getSelectionModel().getSelectedIndex() == 0) {
                refreshkomandirovkiTable();
            } else if (zhurnalTabpane.getSelectionModel().getSelectedIndex() == 1) {
                refreshLsTable();
            } else if (zhurnalTabpane.getSelectionModel().getSelectedIndex() == 2) {
                refreshtableProizvodstvo();
            }

        });


        logTable.setRowFactory(tv -> {
            TableRow<TableClassBackUp> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    tempBackUp = row.getItem();
                    logFileNameLbl.setText(tempBackUp.getLogNameCol());
                    logEmplLblEmployees.setText(tempBackUp.getLogKomuCol());
                    logAPDown.toFront();
                    komandirovkiCmbBox.setValue(fileSaverEditPrikazy.getType());
                }
            });
            return row;
        });
        ObservableList<String> tempComboBx1 = FXCollections.observableArrayList("Командировки", "Личный состав", "Производство");
        komandirovkiCmbBox.setItems(tempComboBx1);


        doubleClicksListener(komandirovkiTable);
        doubleClicksListener(lichSostavTable);
        doubleClicksListener(proizvodTable);
    }


    @FXML
    public void handleClicks(javafx.event.ActionEvent event) throws IOException {

        if (event.getSource() == btnPersonal) {
            personalDelaAp.toFront();
            pustyshkaAP1.toFront();
            eraiseLabel();
        }
        else if (event.getSource() == btnZhurnal) {
            eraiseLabel();
            Employee employee = SaverProfile.getProfile();
            if (employee.getDolzhnost().equals("Администратор")) {
                ObservableList<String> spisok3 = FXCollections.observableArrayList("Наименование файла", "Кто сделал изменения",
                        "Кому сделали изменения");
                logComboPoisk.setValue("Наименование файла");
                logComboPoisk.setItems(spisok3);
                refreshTableBackUp();

                prikazyAp.toFront();
                prikazyAp1.toFront();

            } else {
                showNoteSuccess("/fxmles/nedostatochnoPravDW.fxml");
            }
        }
        else if (event.getSource() == btnSpravka) {
            eraiseLabel();
            spravkaAP.toFront();
            spravkaAP1.toFront();
        }
        else if (event.getSource() == btnVyhod) {
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
        else if (event.getSource() == buttonInputPoiskPersonal) {

            eraiseLabel();
            ArrayList<Employee> employees = Main.getEmployeesMethod();
            int check = 0;
            for (Employee employee : employees) {
                if (employee.getSurname().toLowerCase().contains(inputPoiskPersonal.getText().toLowerCase())) {
                    temp = employee;
                    check = 1;
                    eraseTempFile(temp.getSurname()+temp.getName());
                    break;
                }
            }
            if (check == 1) {
                personalDelaAp1.toFront();
                allUserData = Main.getUserData(temp.getSurname() + temp.getName(), temp.getId());

                byte[] imageByteArray = allUserData.getImage();
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

                refreshTable();
            } else {
                errorLblPoisk.setText("Данный сотрудник не найден!");
            }
        }
        else if (event.getSource() == personalBtnEdit) {
            eraiseLabel();
            TableClass tableClass = tablePersonal.getSelectionModel().getSelectedItem();
            if(tableClass != null) {
                tempEdit= tableClass;
                file = tempEdit.getFile();
                inputEditFileName.setText(tempEdit.getName());
                editComboBox.setValue(tempEdit.getType());
                PersonalAPedit.toFront();
            }
        }
        else if (event.getSource() == buttonEditFile) {
            openFile(file);
        }
        else if (event.getSource() == buttonEditSave) {
            eraiseLabel();
            int id = 0;
            for (TableClass table : tableClasses)
                if (table.getName().equals(tempEdit.getName())) {
                    id = table.getId();
                }

            FileSaver fileSaver = new FileSaver(editComboBox.getValue(),
                    tempEdit.getType(),
                    inputEditFileName.getText(),
                    tempEdit.getName(),
                    Files.readAllBytes(Path.of(tempEdit.getFile().getAbsolutePath())),
                    id);

            if (editComboBox.getValue().equals(tempEdit.getType()) && inputEditFileName.getText().equals(tempEdit.getName())) {
                Main.editFile(fileSaver, temp);
            } else {
                String filePath = new File("").getAbsolutePath();
                String delete = filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + tempEdit.getType() + "\\" + tempEdit.getName();
                String path1 = filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + editComboBox.getValue() + "\\" + inputEditFileName.getText();
                Files.delete(Path.of(delete));
                Files.write(Path.of(path1), fileSaver.getFileBytes());
                Main.editFile(fileSaver, temp);
            }


            refreshTable();

            PersonalAPpustyshka.toFront();

        }
        else if (event.getSource() == personalBtnAdd) {
            ObservableList<String> spisok2 = FXCollections.observableArrayList("Внутренние Документы", "Командировки",
                    "Корреспонденция Вход", "Корреспонденция Исход",
                    "Личный Состав", "Производство");
            addComboBx.setValue("Выберите тип документа");
            addComboBx.setItems(spisok2);
            PersonalAPAdd.toFront();

        }
        else if (event.getSource() == fileChoserBtn) {
            final FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                byte[] fileByte = Files.readAllBytes(Path.of(file.getAbsolutePath()));
                fileSaverAdd = new FileSaver(addComboBx.getValue(), file.getName(), fileByte);
                //openFile(file);
            }

        }
        else if (event.getSource() == addBtnHide) {
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == editBtnHide) {
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == btnAddFile) {
            if (!fileSaverAdd.getName().isEmpty()) {
                ArrayList<Employee> tempAdd = new ArrayList<>();
                tempAdd.add(temp);
                Main.saveFile(fileSaverAdd, tempAdd);
                refreshTable();
            }
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == personalBtnDelete) {
            TableClass tableClass = tablePersonal.getSelectionModel().getSelectedItem();
            if(tableClass != null) {
                tempDelete = tableClass;
                deleteFileName.setText(tempDelete.getName());
                deleteFileType.setText(tempDelete.getType());
                PersonalAPDelete.toFront();
            }
        }
        else if (event.getSource() == deleteBtn) {
            File del = new File(filePath + "\\tempFile\\" + temp.getSurname() + temp.getName() + "\\" + tempDelete.getType() + "\\" + tempDelete.getName());

            if (del.exists()) {
                Employee employee = SaverProfile.getProfile();
                if (del.delete()) {
                    if (deleteCheckBx.isSelected()) {
                        Main.deleteFile(tempDelete.getId(), employee.getId());
                        refreshTable();
                    } else {
                        //System.out.println(temp.getId());
                        Main.deleteHumanToFile(tempDelete.getId(), employee.getId(), temp.getId());
                        refreshTable();

                    }
                    PersonalAPpustyshka.toFront();

                } else
                    System.out.println("Delete Error");
            }


        }
        else if (event.getSource() == deleteBtnHide) {
            PersonalAPpustyshka.toFront();
        }
        else if (event.getSource() == changePassBtn) {
            if (event.getSource() == changePassBtn) {
                Employee employee = SaverProfile.getProfile();
                Parent settingsParent = FXMLLoader.load(this.getClass().getResource("/fxmles/changePassDW.fxml"));
                Scene settingsScene = new Scene(settingsParent);
                Stage popup = new Stage();
                popup.setScene(settingsScene);
                popup.setTitle("Смена пароля");
                popup.initOwner(changePassBtn.getScene().getWindow());
                popup.show();
            }

        }
        else if (event.getSource() == logRepairBtn) {

            if (tempBackUp.getKomu_id() != 0) {
                Main.deleteBackUp(tempBackUp.getId(), tempBackUp.getFile_id(), tempBackUp.getKomu_id());
            } else {
                Main.deleteBackUpMany(tempBackUp.getId(), tempBackUp.getFile_id());
            }
            refreshTableBackUp();
            logAPPustyshDown.toFront();


        }
        else if (event.getSource() == btnSite) {
            openWebpage("http://www.jupiterjet.aero/");
        }
        else if (event.getSource() == createTemplateBtn) {
            createNamePrikazaAP.toFront();
            createProgressBar.setProgress(0.25);
        }
        else if (event.getSource() == createInputNameBtn) {
            String filePath = new File("").getAbsolutePath();
            if (!createInputName.getText().isEmpty()) {
                String s = filePath + "\\newFiles\\" + createInputName.getText() + ".docx";
                tempFile = new File(s);

                switch (createTemplateCmbBox.getValue()) {
                    case "Командировки":
                        String pathKm = filePath + "\\templates\\" + "Командировки.docx";
                        Files.copy(Path.of(pathKm), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    case "Личный состав":
                        String pathLs = filePath + "\\templates\\" + "ЛичныйСостав.docx";
                        Files.copy(Path.of(pathLs), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    case "Корреспонденция Вход":
                        String pathKv = filePath + "\\templates\\" + "КорреспонденцияВход.docx";
                        Files.copy(Path.of(pathKv), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    case "Корреспонденция Исход":
                        String pathKi = filePath + "\\templates\\" + "КорреспонденцияИсход.docx";
                        Files.copy(Path.of(pathKi), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    case "Внутренние документы":
                        String pathVd = filePath + "\\templates\\" + "ВнутренниеДокументы.docx";
                        Files.copy(Path.of(pathVd), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        createNameLbl.setText(tempFile.getName());
                }

                createEditFileAP.toFront();
                createProgressBar.setProgress(0.5);
            }

        }
        else if (event.getSource() == createEditFileBtn) {
            openFile(tempFile);
            createAddEmployeeAP.toFront();
            createProgressBar.setProgress(0.75);
        }
        else if (event.getSource() == createEmployeeBtn) {
            if (createListView.getSelectionModel().getSelectedItem() != null) {
                createProgressBar.setProgress(0.9);
                createApNext.toFront();
                createApEmplTable.toFront();

                count++;

                int index = createListView.getSelectionModel().getSelectedItem().indexOf("/");
                String idStr = createListView.getSelectionModel().getSelectedItem().substring(0, index);
                int id = Integer.parseInt(idStr);
                Employee employee = Main.getOneEmployeeMethod(id);

                int check = 0;

                for (TableClassNewFile i : tableClassNewFileArrayList) {
                    if (i.getId() == employee.getId()) {
                        count--;
                        check = 1;
                        break;
                    }
                }
                if (check == 0) {
                    tableClassNewFileArrayList.add(new TableClassNewFile(count, employee.getId(), employee.getName(), employee.getMiddle_name(), employee.getSurname()));
                    refreshTableNewFile();
                }
            }
        }
        else if (event.getSource() == createSaveFileBtn) {
            createApNext.toBack();


            byte[] fileByte = Files.readAllBytes(Path.of(tempFile.getAbsolutePath()));
            FileSaver fileSaver = new FileSaver(createTemplateCmbBox.getValue(), tempFile.getName(), fileByte, description.getText());
            ArrayList<Employee> employees = Main.getEmployeesMethod();
            ArrayList<Employee> employeesSave = new ArrayList<>();
            for (Employee employee : employees) {
                for (TableClassNewFile ter : tableClassNewFileArrayList) {
                    if (ter.getId() == employee.getId()) {
                        employeesSave.add(employee);
                    }
                }
            }
            Main.saveFile(fileSaver, employeesSave);

            showNoteSuccess("/fxmles/newFileSuccessful.fxml");
            Files.delete(tempFile.toPath());
            createPustyshkaAP.toFront();
            createProgressBar.setProgress(0.0);
            tableClassNewFileArrayList.clear();
            eraiseLabel();
        }
        else if (event.getSource() == createDeleteEmplBtn) {
            TableClassNewFile tempDelCreate = createTableEmpl.getSelectionModel().getSelectedItem();
            tableClassNewFileArrayList.removeIf(ter -> tempDelCreate.getId() == ter.getId());
            refreshTableNewFile();
        }
        else if (event.getSource() == createAddEmplForwardBtn) {
            createProgressBar.setProgress(1);
            createSaveFile.toFront();
            createApEmplTable.toBack();
        }
        else if (event.getSource() == createSaveFileBackBtn) {
            createAddEmployeeAP.toFront();
            createProgressBar.setProgress(0.9);
        }
        else if (event.getSource() == createNameBackBtn) {
            createPustyshkaAP.toFront();
            createProgressBar.setProgress(0);
        }
        else if (event.getSource() == createEditFileBackBtn) {
            createNamePrikazaAP.toFront();
            createProgressBar.setProgress(0.25);
        }
        else if (event.getSource() == createAddEmplBackBtn) {
            createEditFileAP.toFront();
            createApPustyskaEmplTable.toFront();
            createProgressBar.setProgress(0.5);

        }
        else if (event.getSource() == btnZhurnalPrikazy) {
            eraiseLabel();
            refreshkomandirovkiTable();
            zhurnalPrikazyAP1.toFront();
            zhurnalPrikazyAP.toFront();
        }
        else if (event.getSource() == komandirovkiEditFileBtn) {
            openFile(new File(filePath + "\\tempFileType\\" + fileSaverEditPrikazy.getName()));
        }
        else if (event.getSource() == komandirovkiSaveChangesBtn) {
            if (!komandirovkiInputEditName.getText().equals("")) {
                FileSaver fileSaverNew = new FileSaver(komandirovkiCmbBox.getValue(),
                        fileSaverEditPrikazy.getType(),
                        komandirovkiInputEditName.getText(),
                        fileSaverEditPrikazy.getName(),
                        Files.readAllBytes(Path.of(filePath + "\\tempFileType\\" + fileSaverEditPrikazy.getName())),
                        fileSaverEditPrikazy.getId());

                Main.editFile(fileSaverNew, temp);
                String delete = filePath + "\\tempFileType\\" + fileSaverEditPrikazy.getName();
                Files.delete(Path.of(delete));


                eraiseLabel();
                zhurnalPrikPustyshkaAp.toFront();
                refreshkomandirovkiTable();
                refreshtableProizvodstvo();
                refreshLsTable();
                showNoteSuccess("/fxmles/newFileSuccessful.fxml");
            }
        }

        else if (event.getSource() == komandirovkiPoiskBtn) {
            refreshkomandirovkiTable();
        }
        else if (event.getSource() == lichSostavPoiskBtn) {
            refreshLsTable();
        }
        else if (event.getSource() == proizvodPoiskBtn) {
            refreshtableProizvodstvo();
        }
        else if (event.getSource() == logInputPoiskBtn)
        {
            refreshTableBackUp();
        }

    }
}
