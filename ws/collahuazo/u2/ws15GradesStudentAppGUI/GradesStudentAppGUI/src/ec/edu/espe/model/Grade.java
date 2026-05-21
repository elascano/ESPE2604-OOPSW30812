package ec.edu.espe.model;

public class Grade {

    private String studentId;
    private double value;

    public Grade(String studentId, double value) {
        if (value < 0 || value > 20) {
            throw new IllegalArgumentException("Grade must be between 0 and 20.");
        }
        this.studentId = studentId;
        this.value = value;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value < 0 || value > 20) {
            throw new IllegalArgumentException("Grade must be between 0 and 20.");
        }
        this.value = value;
    }
}
