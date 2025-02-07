package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReadingUtils {
	public static void main(String[] args) throws IOException {
		String base = System.getProperty("user.dir");
		System.out.println(base);
		FileInputStream fis = new FileInputStream(base + "\\src\\test\\resources\\OR.properties");
		// OR: Object repository is file which consist locators
		Properties prop = new Properties();
		prop.load(fis); // which file load
		String value = prop.getProperty("searchText");
		System.out.println(value);

	}
}
