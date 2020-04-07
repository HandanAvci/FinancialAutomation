package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectMap {
public String getconfig (String object) throws IOException {
		
	
		
		String file = "./config.properties"; // location

		FileInputStream fis = new FileInputStream(file);  //serilization
		
		Properties properties = new Properties(); //to read notepad
		
		properties.load(fis); // properties & serilization connect together
		
	
		properties.getProperty(object) ;
		
		return properties.getProperty(object);
		
		
		

	}


}
