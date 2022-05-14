package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readPropertyFile {
	
	 public static Properties prop;
	//method to read data from properties file
	 public readPropertyFile() {
		 
		 File src = new File("./Configuration/config.properties");
		 try {
			 FileInputStream Input = new FileInputStream(src);
			 prop= new Properties();
				prop.load(Input);
		 }catch (Exception e) {
			 System.out.println("Exception in read property file is "+ e.getMessage());
		 }
	 }
	 //method to read data from properties file
	 public String getDataFromPropertyFile(String val) {
		 
		 String data = null;
		 try {
		 data = prop.getProperty(val);
		 }catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
		 return data;
	 }
}
