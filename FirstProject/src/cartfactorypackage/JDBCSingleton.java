package cartfactorypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JDBCSingleton {
	
	private static JDBCSingleton XYZ = new JDBCSingleton();
	
	Properties x = new Properties();
	
	private JDBCSingleton() {
		
		try{
			
			FileInputStream f = new FileInputStream("C:\\Users\\nooka\\eclipse-workspace\\FirstProject\\src\\cartfactorypackage\\test.txt");
			x.load(f);
		}
		catch(IOException e) {
			
		}
	}
	
	public static JDBCSingleton getInstance() {
			
				return XYZ;
	}
	
	public String getProperty(String name) {
		
		return x.getProperty(name);	
		
	}

}
