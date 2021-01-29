package com.computechis.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
	Properties pro;
	public ConfigProvider() {
		pro = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\Config\\ProjectConfig.properties"));
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			pro.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getValue(String key) {
		return pro.getProperty(key);
		/*String value=pro.getProperty(key);
		return value;*/
	}
	public String getStagingURL() {
		return pro.getProperty("stagingURL");
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public void loadConfigFile() {
		
	}
}
