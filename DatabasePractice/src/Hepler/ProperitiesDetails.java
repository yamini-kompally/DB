package Hepler;

import java.io.FileReader;
import java.util.Properties;

public class ProperitiesDetails {
	public static void main(String[] args)throws Exception {
		
	
	FileReader reader = new FileReader("C:\\Users\\ADMIN\\eclipse-workspace\\DatabasePractice\\Properities\\DBDetails.Properities");

	Properties p = new Properties();
	p.load(reader);
	System.out.println(p.getProperty("username"));
	System.out.println(p.getProperty("password"));
	System.out.println(p.getProperty("port"));
	System.out.println(p.getProperty("hostname"));
	System.out.println(p.getProperty("user"));

}
}