package sample;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Main extends Application {

    private static Socket socket;
    private static ObjectOutputStream outStream;
    private static ObjectInputStream inStream;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //System.out.println("1234".hashCode());
        Parent root = FXMLLoader.load(getClass().getResource("/fxmles/loginPageDW.fxml"));
        primaryStage.setTitle("Авторизация пользователя");
        primaryStage.setScene(new Scene(root, 763, 487));
        primaryStage.show();
    }


    public static void main(String[] args) {
        connect();
        launch(args);
    }


    private static void connect()
    {
        try {
            socket = new Socket("127.0.0.1", 4444);
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Employee> getEmployeesMethod()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Request r = new Request("LIST_EMPLOYEES", null);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                employees = request.getEmployees();
            }
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return employees;
    }


    public static Employee getOneEmployeeMethod(int id)
    {
        Employee employee = new Employee();
        try {
            Request r = new Request("ONE_EMPLOYEE", id);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                employee = request.getEmployee();

            }
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return employee;
    }


    public static FileSaver getOneFileMethod(int id)
    {
        FileSaver fileSaver = new FileSaver();
        try {
            Request r = new Request("ONE_FILE", id);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                fileSaver = request.getFileSaver1();

            }
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return fileSaver;
    }


    public static AllUserData getUserData(String path, int id)
    {
        AllUserData allUserData = null;
        String filePath = new File("").getAbsolutePath();
        try {
            Request r = new Request("LIST_FILES", (AllUserData) null, path, id);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                allUserData = request.getAllUserData();
            }

            assert allUserData != null;
            File folder = new File(filePath + "\\tempFile\\" +
                    File.separator + allUserData.getSurnameName() );
            String str = "";
            if (!folder.exists()) {
                folder.mkdir();
            }
            str = folder.getAbsolutePath();
            for (int i = 0; i < Objects.requireNonNull(allUserData).getFileSavers().size() ; i++) {
                File folder1 = new File(str +
                        File.separator +  allUserData.getFileSavers().get(i).getType());
                if (!folder1.exists()) {
                    folder1.mkdir();
                }
                Files.write(Path.of(folder1.getAbsolutePath()  +
                        "\\" +
                        allUserData.getFileSavers().get(i).getName()),
                        allUserData.getFileSavers().get(i).getFileBytes());

            }

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return allUserData;
    }


    public static void saveFile(FileSaver fileSavers, ArrayList<Employee> employees)
    {
        try {
            Request r = new Request("SAVE_FILE", fileSavers, employees);
            outStream.writeObject(r);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void editFile(FileSaver fileSavers, Employee employee)
    {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        try {
            Request r = new Request("EDIT_FILE", fileSavers, employees);
            outStream.writeObject(r);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void deleteFile(int id, int employee_id)
    {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getTime());
        try
        {
            Request r = new Request("DELETE_FILE", id, employee_id,2147483647, date);
            outStream.writeObject(r);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void deleteHumanToFile(int id, int employee_id_kto, int employee_id_komu)
    {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getTime());
        try
        {
            Request r = new Request("DELETE_HUMAN_TO_FILE", id, employee_id_kto, employee_id_komu, date);
            outStream.writeObject(r);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void updateEmployee(Employee employee)
    {
        try {
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(employee);
            Request r = new Request("UPDATE_EMPLOYEE", employees);
            outStream.writeObject(r);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static ArrayList<BackUpFile> getBackUpMethod()
    {
        ArrayList<BackUpFile> backUpFiles = new ArrayList<>();
        try {
            Request r = new Request("LIST_BACKUP", null, 1);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                backUpFiles = request.getBackUpFiles();
            }
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return backUpFiles;
    }


    public static ArrayList<File_to_human> getFilesToHumanBackup(int file_id)
    {
        ArrayList<File_to_human> file_to_humen = new ArrayList<>();
        try {
            Request r = new Request("LIST_HUMAN_BACKUP", file_id);
            outStream.writeObject(r);
            Request request = (Request) inStream.readObject();
            if (request != null)
            {
                file_to_humen = request.getFile_to_humen();
            }
        }catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return file_to_humen;
    }


    public static void deleteBackUp (int backUp_id, int file_id, int komu_id)
    {
        try {
            Request r = new Request("DELETE_BACKUP", backUp_id, file_id, komu_id);
            outStream.writeObject(r);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void deleteBackUpMany (int backUp_id, int file_id)
    {
        try {
            Request r = new Request("DELETE_BACKUP_MANY", backUp_id, file_id, 0);
            outStream.writeObject(r);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
