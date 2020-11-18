package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfiguraionProperties {

	private Properties prop;
	private final String PROPERTIES_FILE_PATH = "/src/test/resources/properties/env.properties";

	public TestConfiguraionProperties() {

		File file = new File(System.getProperty("user.dir")+PROPERTIES_FILE_PATH);
		FileInputStream fis = null;
		try {
			prop = new Properties();
			fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getbaseURI()
	{
		String set_url = prop.getProperty("baseURI");
		return set_url;
	}
	public String getbasePath()
	{
		String set_url = prop.getProperty("basePATH");
		return set_url;
	}
	
	public String getUserName()
	{
		String set_url = prop.getProperty("user_name");
		return set_url;
	}
	public String getUserJob()
	{
		String set_url = prop.getProperty("user_job");
		return set_url;
	}
	
	public String getemailID()
	{
		String set_url = prop.getProperty("emailID");
		return set_url;
	}	
	public String getpassword()
	{
		String set_url = prop.getProperty("password");
		return set_url;
	}
	
}
