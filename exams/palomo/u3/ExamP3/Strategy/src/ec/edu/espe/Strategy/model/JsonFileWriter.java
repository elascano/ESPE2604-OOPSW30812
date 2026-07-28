/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Strategy.model;

import ec.edu.espe.Strategy.model.SortingRecord;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class JsonFileWriter {
    public static final String DEFAULT_FILE_PATH = "sorting_results.json";
 
    private static final JsonWriterSettings PRETTY =
            JsonWriterSettings.builder().indent(true).build();
 
    private JsonFileWriter() {
    }

    public static synchronized void appendRecord(SortingRecord record) throws IOException {
        appendRecord(record, DEFAULT_FILE_PATH);
    }
 
    public static synchronized void appendRecord(SortingRecord record, String filePath) throws IOException {
        String newObjectJson = record.toDocument().toJson(PRETTY);
 
        Path path = Paths.get(filePath);
        String existingBody = "";
 
        if (Files.exists(path) && Files.size(path) > 0) {
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8).trim();
            int start = content.indexOf('[');
            int end = content.lastIndexOf(']');
            if (start != -1 && end != -1 && end > start) {
                existingBody = content.substring(start + 1, end).trim();
            }
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        if (!existingBody.isEmpty()) {
            sb.append(existingBody);
            sb.append(",\n");
        }
        sb.append(newObjectJson);
        sb.append("\n]");
 
        Files.write(path, sb.toString().getBytes(StandardCharsets.UTF_8));
    }
}
