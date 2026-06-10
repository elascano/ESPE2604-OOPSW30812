
/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
package ec.edu.espe.safestore.model;

import java.time.LocalDate;

public class Backup {
    private int backupId;
    private String fileName;
    private String status;
    private LocalDate date;
    
    public Backup() {}
    
    public Backup(int backupId, String fileName, String status, LocalDate date) {
        this.backupId = backupId;
        this.fileName = fileName;
        this.status = status;
        this.date = date;
    }
    
    public int getBackupId() { return backupId; }
    public void setBackupId(int backupId) { this.backupId = backupId; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    @Override
    public String toString() {
        return "Backup{backupId=" + backupId + ", fileName=" + fileName + ", date=" + date + "}";
    }
}
