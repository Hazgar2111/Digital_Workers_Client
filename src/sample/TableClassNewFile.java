package sample;

public class TableClassNewFile {
    private int number;
    private int id;
    private String name;
    private String middle_name;
    private String surname;

    public TableClassNewFile(int number, int id, String name, String middle_name, String surname) {
        this.number = number;
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
