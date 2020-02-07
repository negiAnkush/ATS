package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Constants {

	Properties prop;
	FileInputStream inStream;
	public String browser;
	public String chromeAgent;
	public String ffAgent;
	public String ieAgent;
	public Constants() throws IOException
	{
		inStream=new FileInputStream(new File(""+ "./src/main/resources/config/config.properties"));
		prop=new Properties();
		prop.load(inStream);
		browser=prop.getProperty("browser").trim();
		chromeAgent=prop.getProperty("chromeagent").trim();
		ffAgent=prop.getProperty("ffagent").trim();
		ieAgent=prop.getProperty("ieagent").trim();

	} 
	
	
}
