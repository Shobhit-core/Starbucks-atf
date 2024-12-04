//package com.starbucks.utils;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class ConfigReader {
//
//    private static Properties properties;
//
//    public ConfigReader() {
//        properties = new Properties();
//        try {
//            // Load the config.properties file from resources folder
//            InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Get the URL value from the properties file
//    public static String getBaseUrl() {
//        return properties.getProperty("https://starbucks.in");
//    }
//}
