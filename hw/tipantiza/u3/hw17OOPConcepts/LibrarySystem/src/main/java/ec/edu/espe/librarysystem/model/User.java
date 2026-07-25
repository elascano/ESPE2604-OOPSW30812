
package ec.edu.espe.librarysystem.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class User extends Person {
    private String userType;
    private int activeLoans;
    private List<String> loanHistory;

    public User() {
        this.loanHistory = new ArrayList<>();
        this.activeLoans = 0;
    }

    public User(String id, String firstName, String lastName, String email, String userType) {
        super(id, firstName, lastName, email);
        this.userType = userType;
        this.activeLoans = 0;
        this.loanHistory = new ArrayList<>();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(int activeLoans) {
        this.activeLoans = activeLoans;
    }

    public List<String> getLoanHistory() {
        return loanHistory;
    }

    public void setLoanHistory(List<String> loanHistory) {
        this.loanHistory = loanHistory;
    }

    @Override
    public String getPersonType() {
        return "User";
    }

    public void addLoan(String bookId) {
        loanHistory.add(bookId);
        activeLoans++;
    }

    public void returnLoan(String bookId) {
        loanHistory.remove(bookId);
        activeLoans--;
    }

    public boolean canBorrow() {
        return activeLoans < 5;
    }

    @Override
    public String toString() {
        return "User: " + super.toString() + ", Type: " + userType;
    }
}
