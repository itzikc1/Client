package properties;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//get Properties and begin the Properties of server
public class GetProperties {
private static final String FILE_NAME = "resources/Properties.xml";
	public static MyProperties readProperties() {
		XMLDecoder decoder = null;	//Create new XML file and start with NULL
		//try to get XML file
		try {
			decoder = new XMLDecoder(new FileInputStream(FILE_NAME));
			MyProperties properties = (MyProperties)decoder.readObject();//begin the Properties of server 
			return properties;			
		} catch (FileNotFoundException e) {
		//	creatXMLfile();
			e.printStackTrace();
		} finally {
		  decoder.close();
		}
		return null;
	    }
}
