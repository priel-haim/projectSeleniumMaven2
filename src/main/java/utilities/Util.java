package utilities;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.Properties;

public class Util {
	public static String ReadProperty(String key) {
	String Value="";
    try (InputStream input = new FileInputStream("./src/test/resources/data/configuration.properties")) {
        Properties prop = new Properties();
        // load a properties file
        prop.load(input);
          Value=prop.getProperty(key);
    } catch (Exception e) {
       
    }
	return Value;
}
}