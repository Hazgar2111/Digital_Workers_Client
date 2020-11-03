package sample;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Request implements Serializable {
    private static final long serialVersionUID=1L;
    private String operationType;
    private ArrayList<Employee> employees;
    private Employee employee;
    private String name;
    private ArrayList<FileSaver> fileSavers;
    private FileSaver fileSaver1;
    private ArrayList<Prikazy> prikazy;
    private AllUserData allUserData;
    private int id;
    private int employee_id_kto;
    private int employee_id_komu;
    private int file_id;
    private ArrayList<BackUpFile> backUpFiles;
    private ArrayList<File_to_human> file_to_humen;
    private java.sql.Timestamp date;
    private String type;


    public Request() {

    }

    public Request(String operationType, AllUserData allUserData, String name, int id) {
        this.operationType = operationType;
        this.allUserData = allUserData;
        this.name = name;
        this.id = id;
    }

    public Request(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public Request(String operationType, int id, int file_id, int komu_id) {
        this.operationType = operationType;
        this.id = id;
        this.file_id = file_id;
        this.employee_id_komu = komu_id;
    }

    public Request(String operationType, ArrayList<Employee> employees) {
        this.operationType = operationType;
        this.employees = employees;
    }

    public Request(String operationType, ArrayList<File_to_human> file_to_humen, boolean check) {
        this.operationType = operationType;
        this.file_to_humen = file_to_humen;
    }

    public Request(String operationType, int id, int employee_id_kto,  java.sql.Timestamp date) {
        this.operationType = operationType;
        this.id = id;
        this.employee_id_kto = employee_id_kto;
        this.date = date;

    }

    public Request(String operationType, int id, int employee_id_kto, int employee_id_komu,  java.sql.Timestamp date) {
        this.operationType = operationType;
        this.id = id;
        this.employee_id_kto = employee_id_kto;
        this.employee_id_komu = employee_id_komu;
        this.date = date;
    }

    public Request(String operationType, FileSaver fileSavers, ArrayList<Employee> employees) {
        this.operationType = operationType;
        this.fileSaver1 = fileSavers;
        this.employees = employees;
    }

    public Request(String operationType, ArrayList<BackUpFile> backUpFiles, int check) {
        this.operationType = operationType;
        this.backUpFiles = backUpFiles;
    }

    public Request(String operationType, ArrayList<FileSaver> fileSavers, String type) {
        this.operationType = operationType;
        this.fileSavers = fileSavers;
        this.type = type;
    }




    public AllUserData getAllUserData() {
        return allUserData;
    }

    public  java.sql.Timestamp getDate() {
        return date;
    }

    public void setDate(java.sql.Timestamp date) {
        this.date = date;
    }

    public ArrayList<BackUpFile> getBackUpFiles() {
        return backUpFiles;
    }

    public void setBackUpFiles(ArrayList<BackUpFile> backUpFiles) {
        this.backUpFiles = backUpFiles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id_kto() {
        return employee_id_kto;
    }

    public ArrayList<FileSaver> getFileSaver() {
        return fileSavers;
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

    public FileSaver getFileSaver1() {
        return fileSaver1;
    }

    public void setFileSaver1(FileSaver fileSaver1) {
        this.fileSaver1 = fileSaver1;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<File_to_human> getFile_to_humen() {
        return file_to_humen;
    }

    public void setFile_to_humen(ArrayList<File_to_human> file_to_humen) {
        this.file_to_humen = file_to_humen;
    }
}
