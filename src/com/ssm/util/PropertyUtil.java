package com.ssm.util;

import java.util.*;
import java.io.*;

import javax.xml.registry.infomodel.User;

public class PropertyUtil {

	public static String getKey(String fileName, String keyName) {
		// Properties prop = new Properties();
		// try {
		// fis = new FileInputStream(name);
		// } catch (FileNotFoundException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// try {
		// prop.load(fis);
		// prop.list(System.out);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// if ("".equals(prop.getProperty(keyName))
		// || prop.getProperty(keyName) == null) {
		// return null;
		// } else {
		// return prop.getProperty(keyName);
		// }
		// }
	
		String value = "";
		InputStream fis = null;
		try {
			fis = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
			Properties pro = new Properties();
			pro.load(fis);
			value = pro.getProperty(keyName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
}
