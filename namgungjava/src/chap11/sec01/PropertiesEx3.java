package chap11.sec01;

import java.util.*;
import java.io.*;

public class PropertiesEx3 {
	
	public static void main(String [] args) {
		Properties prop = new Properties();
		
		
		prop.setProperty("timeout",  "30");
		prop.setProperty("language", "ÇÑ±Û");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		try {
			prop.store(new FileOutputStream("output.txt"), "Properties example");
			
			prop.storeToXML(new FileOutputStream("output.xml"), "propreties example");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
