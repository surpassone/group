package com.ssm.util;

import java.util.*;
import java.io.*;

import javax.xml.registry.infomodel.User;

public class PropertyUtil {
	public static String getValue(String fileName, String keyName) {
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
