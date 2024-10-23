package ch11_컬렉션프레임워크;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesEx3 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "한글");
		prop.setProperty("site", "10");
		prop.setProperty("capacity", "10");
		
		try {
			prop.store(new FileOutputStream("output.txt"), "Properties Example");
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
