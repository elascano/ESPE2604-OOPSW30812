/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author sbart
 */
public class GestationController {
    public Map<String, String> calculateGestation(int day, int monthIndex, int year) throws Exception {
        Map<String, String> results = new HashMap<>();

        Calendar fum = Calendar.getInstance();
        fum.set(year, monthIndex, day, 0, 0, 0);
        fum.set(Calendar.MILLISECOND, 0);

        Calendar hoy = Calendar.getInstance();
        hoy.set(Calendar.HOUR_OF_DAY, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);

        if (fum.after(hoy)) {
            throw new IllegalArgumentException("La fecha de la última menstruación no puede ser una fecha futura.");
        }

        long diferenciaMilisegundos = hoy.getTimeInMillis() - fum.getTimeInMillis();
        long diasTranscurridos = diferenciaMilisegundos / (24 * 60 * 60 * 1000);

        long semanas = diasTranscurridos / 7;
        long diasRestantes = diasTranscurridos % 7;

        Calendar fpp = (Calendar) fum.clone();
        fpp.add(Calendar.DAY_OF_YEAR, 280);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaPartoFormateada = sdf.format(fpp.getTime());

        results.put("weeksResult", "Semanas de Gestación: " + semanas + " semanas y " + diasRestantes + " días.");
        results.put("dueDateResult", "Fecha Probable de Parto (FPP): " + fechaPartoFormateada);
        
        if (semanas > 42) {
            results.put("warning", "El cálculo excede las 42 semanas de gestación. Por favor verifique la fecha.");
        } else {
            results.put("warning", "");
        }

        return results;
    }
}

