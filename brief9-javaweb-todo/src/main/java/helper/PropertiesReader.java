package helper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public static Properties getProperties(final String filePath) {
		
		Properties properties = new Properties();
		try(FileInputStream inputStream = new FileInputStream(filePath)){
		    properties.load(inputStream);
		}catch(FileNotFoundException e) {
			  e.printStackTrace();
		} catch (IOException e) {
			  e.printStackTrace();
		}
		
		return properties;
		
	}
	
	


}
