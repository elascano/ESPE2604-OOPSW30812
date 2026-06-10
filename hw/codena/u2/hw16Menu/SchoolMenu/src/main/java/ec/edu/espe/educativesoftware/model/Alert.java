/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.model;

import java.time.LocalDate;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class Alert {

    private String alertId;

    private String message;

    private LocalDate date;

    private boolean active;

    public Alert() {
    }

    public Alert(String alertId,
            String message,
            LocalDate date,
            boolean active) {

        this.alertId = alertId;
        this.message = message;
        this.date = date;
        this.active = active;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}