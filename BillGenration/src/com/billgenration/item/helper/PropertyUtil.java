package com.billgenration.item.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	Properties prop = new Properties();
	InputStream input = null;

	/** unable to use static as getclass is not working */
	public Properties getProperties(String filename) {

		try {
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
			}
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public String getPropertyValue(String key) {
		String value = "";
		if (key != null && !key.isEmpty()) {
			value = prop.getProperty(key);
		}

		return value;
	}

}
