package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
	
	static Properties properties = new Properties();//selenium provide properties class to us read or right files
    
	//to give my properties file path /static>> because only one copy I want | final : no one can change my path
	private static final String filepath = System.getProperty("user.dir") + "//src/test/resources/ORconfig.properties";

	public static String getBrowserName() throws IOException {
		FileInputStream fis = new FileInputStream(filepath);//to read file
		properties.load(fis); //to load file 
		String browserName = properties.getProperty("browser_name");//my browsername get
		System.out.println("Launched Browser: " + browserName);
		return browserName;
	}

	public static String getURL() throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		properties.load(fis);
		String url = properties.getProperty("QA_url");
		System.out.println("Launched Url: " + url);
		return url;
	}
}
