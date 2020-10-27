package sample;

public class TableClassBackUp {
    private int id;
    private int LogNumberCol;
    private String LogNameCol;
    private String logActonCol;
    private String logKtoCol;
    private String logKomuCol;
    private String logDate;
    private int file_id;
    private int komu_id;


    public TableClassBackUp() {
    }


    public TableClassBackUp(int id, int logNumberCol, String logNameCol, String logActonCol, String logKtoCol, String logKomuCol, String date, int file_id, int komu_id) {
        this.id = id;
        this.LogNumberCol = logNumberCol;
        this.LogNameCol = logNameCol;
        this.logActonCol = logActonCol;
        this.logKtoCol = logKtoCol;
        this.logKomuCol = logKomuCol;
        this.logDate = date;
        this.file_id = file_id;
        this.komu_id = komu_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public int getLogNumberCol() {
        return LogNumberCol;
    }

    public void setLogNumberCol(int logNumberCol) {
        LogNumberCol = logNumberCol;
    }

    public String getLogNameCol() {
        return LogNameCol;
    }

    public void setLogNameCol(String logNameCol) {
        LogNameCol = logNameCol;
    }

    public String getLogActonCol() {
        return logActonCol;
    }

    public void setLogActonCol(String logActonCol) {
        this.logActonCol = logActonCol;
    }

    public String getLogKtoCol() {
        return logKtoCol;
    }

    public void setLogKtoCol(String logKtoCol) {
        this.logKtoCol = logKtoCol;
    }

    public String getLogKomuCol() {
        return logKomuCol;
    }

    public void setLogKomuCol(String logKomuCol) {
        this.logKomuCol = logKomuCol;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getKomu_id() {
        return komu_id;
    }

    public void setKomu_id(int komu_id) {
        this.komu_id = komu_id;
    }
}
