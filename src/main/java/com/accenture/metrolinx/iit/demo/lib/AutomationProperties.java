package com.accenture.metrolinx.iit.demo.lib;

import java.io.IOException;
import java.util.Properties;

import com.accenture.metrolinx.iit.demo.lib.exception.InitializationException;

/**
 * An utility class to access the global properties
 * 
 * @author lucy.yang
 *
 */
public class AutomationProperties {

	private static Properties p = null;
	
	private synchronized static void init()
	{
		try {
			p = new Properties();
			p.load(AutomationProperties.class.getClassLoader()
                    .getResourceAsStream("init.properties"));
		} catch (IOException e) {
			throw new InitializationException(e);
		}
	}

	public static String getProperty(String key) {
		if (p == null)
		{
			init();
		}
		
		return p.getProperty(key);
		
	}

}
