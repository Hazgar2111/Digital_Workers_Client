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


    public static AllUserData getUserData(String path, int id)
    {
        System.out.println(path);
        ArrayList<File> files = new ArrayList<>();
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


    public static void saveFile(FileSaver fileSavers, String nameSurname)
    {
        try {
            Request r = new Request("SAVE_FILE", fileSavers, nameSurname,1);
            outStream.writeObject(r);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void deleteFile()
    {

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
}
