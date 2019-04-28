package com.rj.bd.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @desc 解析properties配置文件的工具类
 *
 **/
public class PropertyUtils {

	public static Map<String, Object> getPropertyInfo(String propertyPath) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Properties prop = new Properties();
		InputStream inputFile = PropertyUtils.class.getClassLoader().getResourceAsStream(propertyPath);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFile, "utf-8"));
		prop.load(bufferedReader);
		Iterator<String> it = prop.stringPropertyNames().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + ":" + prop.getProperty(key));
			map.put(key, prop.getProperty(key));

		}
		inputFile.close();

		return map;

	}

	public static void main(String[] args) throws IOException {
		PropertyUtils.getPropertyInfo("mail.properties");

	}
}
