
package ec.edu.espe.librarysystem.model;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class Loan {
    private String id;
    private String userId;
    private String bookId;
    private Date loanDate;
    private Date returnDate;
    private String status;
    private double fine;

    private static final int MAX_LOAN_DAYS = 7;
    private static final double FINE_PER_DAY = 0.50;

    public Loan() {
    }

    public Loan(String id, String userId, String bookId, Date loanDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.status = "ACTIVE";
        this.fine = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        calculateFine();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void calculateFine() {
        if (returnDate != null && loanDate != null) {
            long diffInMillies = returnDate.getTime() - loanDate.getTime();
            long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            
            if (days > MAX_LOAN_DAYS) {
                this.fine = (days - MAX_LOAN_DAYS) * FINE_PER_DAY;
            } else {
                this.fine = 0.0;
            }
        }
    }

    public boolean isOverdue() {
        if (returnDate == null) {
            Date now = new Date();
            long diffInMillies = now.getTime() - loanDate.getTime();
            long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            return days > MAX_LOAN_DAYS;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Loan: " + id + " - Status: " + status;
    }
}
