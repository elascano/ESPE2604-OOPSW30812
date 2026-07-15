/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.widgets.controller;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import ec.edu.espe.widgets.model.Config;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class ConfigReader {

    public static int readFromConfigFile(String key) {

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.json")) {

            if (input == null) {
                throw new RuntimeException("config.json not found");
            }

            Gson gson = new Gson();
            Config config = gson.fromJson(new InputStreamReader(input), Config.class);

            switch (key) {
                case "OS_TYPE":
                    return config.getOS_TYPE();

                default:
                    throw new IllegalArgumentException("Unknown configuration key: " + key);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
