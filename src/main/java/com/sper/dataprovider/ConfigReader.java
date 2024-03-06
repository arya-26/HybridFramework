package com.sper.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String getProperty(String key) {
		
		Properties prop= new Properties();
		try {
			prop.load(new FileInputStream(new File("./Configuration/Config properties")));
		} catch (FileNotFoundException e) {
			System.out.println("File Location not found" +e.getMessage());
		} catch (IOException e) {
			System.out.println("Couldn't read the file" +e.getMessage());
		}
		String value=prop.getProperty(key);
		
		return value;
		
	}

}
