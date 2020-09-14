package sample;

import java.io.File;

public class TableClass {
    private int number;
    private String type;
    private String name;
    private File file;

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public TableClass(int number, String type, File file, String name) {
        this.number = number;
        this.type = type;
        this.name = name;
        this.file = file;
    }


}
