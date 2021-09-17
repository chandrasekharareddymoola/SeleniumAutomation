package com.eagle.ConfigUtils;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadObject {
	
	Properties p = new Properties();
	
	public Properties getObjectRepositoty() throws IOException
	{
		InputStream stream = new FileInputStream(new File(System.getProperty("user.dir") + "\\Resources\\config.properties"));
		p.load(stream);
		return p;
	}

}
