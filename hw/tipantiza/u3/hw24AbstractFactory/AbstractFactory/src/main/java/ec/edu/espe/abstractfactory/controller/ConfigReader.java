
package ec.edu.espe.abstractfactory.controller;
import com.google.gson.Gson;
import ec.edu.espe.abstractfactory.model.Config;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class ConfigReader {
    
    public static int getOSType() {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.json")) {
            
            if (input == null) {
                return detectOSFromSystem();
            }
            
            Gson gson = new Gson();
            Config config = gson.fromJson(new InputStreamReader(input), Config.class);
            return config.getOS_TYPE();
            
        } catch (Exception e) {
            return detectOSFromSystem();
        }
    }
    
    private static int detectOSFromSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return 0;
        } else if (os.contains("mac")) {
            return 2;
        } else {
            return 1;
        }
    }
    
    public static String getOperatingSystemName() {
        int osType = getOSType();
        switch (osType) {
            case 0:
                return "Windows";
            case 2:
                return "Mac";
            default:
                return "Linux";
        }
    }
}
