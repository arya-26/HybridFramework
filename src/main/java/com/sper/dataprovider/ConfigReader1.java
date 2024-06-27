package com.sper.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader1 {
	
	public static String property(String key) {
		Properties prop= new Properties();
		try {
			prop.load(new FileInputStream(new File("./Configuration/Config1.properties")));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			
		} catch (IOException e) {
			System.out.println("Couldnot read file");
		}
		String value=prop.getProperty(key);
		return value;
		
	
	}
}
