package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaverProfile {

    public static void saveProfile(Employee employee){
        try{
            ObjectOutputStream outputStream=
                    new ObjectOutputStream(new FileOutputStream("6er1xde.txt"));
            outputStream.writeObject(employee);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static Employee getProfile(){
        Employee employee = null;
        try{
            ObjectInputStream inputStream=
                    new ObjectInputStream(new FileInputStream("6er1xde.txt"));
            employee = (Employee) inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }
}
