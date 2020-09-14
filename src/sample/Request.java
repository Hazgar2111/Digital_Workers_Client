package sample;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private static final long serialVersionUID=1L;
    private String operationType;
    private ArrayList<Employee> employees;
    private String name;
    private ArrayList<File> files;
    private  ArrayList<FileSaver> fileSaver;
    private FileSaver fileSaver1;
    private ArrayList<Prikazy> prikazy;
    private AllUserData allUserData;
    private int id;


    public AllUserData getAllUserData() {
        return allUserData;
    }


    public Request(String operationType, AllUserData allUserData, String name, int id) {
        this.operationType = operationType;
        this.allUserData = allUserData;
        this.name = name;
        this.id = id;
    }


    public Request() {

    }


    public Request(String operationType, ArrayList<Employee> employees) {
        this.operationType = operationType;
        this.employees = employees;
    }


    public Request(String operationType, FileSaver fileSavers, String name, int check) {
        this.operationType = operationType;
        this.fileSaver1 = fileSavers;
        this.name = name;
    }


    public ArrayList<FileSaver> getFileSaver() {
        return fileSaver;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }
}
