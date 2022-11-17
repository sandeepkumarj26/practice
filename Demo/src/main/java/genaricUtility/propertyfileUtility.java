package genaricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyfileUtility {
public static String PropertyReader(String keyValue) throws IOException {
	FileInputStream	fis = new FileInputStream("./src/main/resources/property.property");
	Properties property=new Properties();
	property.load(fis);
	String value=property.getProperty(keyValue);
	return value;
	
	
}


}


