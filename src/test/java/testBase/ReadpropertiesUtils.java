package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertiesUtils {

	private Properties prop = new Properties();
	public ReadpropertiesUtils(){
		try {
			prop.load(new FileInputStream(new File("Config/config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public Properties readPropertiesFile() throws FileNotFoundException, IOException{
		
		prop.load(new FileInputStream(new File("configs/config.properties")));
		return prop;
	}*/
	public String getProp(String propertyName ){
		return prop.getProperty(propertyName);
		
		
	}
}
