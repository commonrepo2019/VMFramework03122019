package com.test.automation.common;

import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;

public class SystemPropertyUtil {
	
		
	private final static String windowWidthKey = "window.width";
	private final static String windowHeightKey = "window.height";
	private final static String testDataDirectorykey = "test.data.directory";
	private final static String httpCredentialsKey = "http.credentials";
	private final static String browsersKey = "browsers";	
	private final static String baseUrlKey = "base.url";
	private final static String localeUrlKey = "locale.url";
	private final static String baseUrlDefault = "http://vam-qa.cloudapp.net:6363/pages/login.html";
	private final static String localeUrlDefault = "";
	
	//Default values
	private final static int windowWidthDefault = 1920;
	private final static int windowHeightDefault = 1080;
	private final static String testDataDirectoryDefault = "target/test-classes";
	private final static String httpCredentialsDefault = "true";
	private final static String browsersDefault = "Chrome";

	
	private final static int windowWidth = System.getProperties().containsKey(windowWidthKey) ? Integer.parseInt(System.getProperty(windowWidthKey)) : windowWidthDefault;		
	private final static int windowHeight =System.getProperties().containsKey(windowHeightKey) ? Integer.parseInt(System.getProperty(windowHeightKey)) : windowHeightDefault;
	private final static String browsers =			
			System.getProperties().containsKey(browsersKey) ? System.getProperty(browsersKey) : browsersDefault; //new enums
	
	private final static String testDataDirectory = System.getProperties().containsKey(testDataDirectorykey) ? System.getProperty(testDataDirectorykey) : testDataDirectoryDefault;
	private final static boolean httpCredentials = Boolean.parseBoolean(System.getProperties().containsKey(httpCredentialsKey) ? System.getProperty(httpCredentialsKey) : httpCredentialsDefault);

	
	private final static String baseUrl = System.getProperties().containsKey(baseUrlKey) ? System.getProperty(baseUrlKey) : baseUrlDefault;
	//private final static String baseUrl = "google.co.in";
	private final static String localeUrl = System.getProperties().containsKey(localeUrlKey) ? System.getProperty(localeUrlKey) : localeUrlDefault;
	
	public static String getBaseUrl() {
		return baseUrl;
	}
	
	public static String getLocale() {
		return localeUrl;
	}

	public static int getWindowWidth() {
		return windowWidth;
	}
	
	public static int getWindowHeight() {
		return windowHeight;
	}
	
	public static String getTestDataDirectory() {
		return testDataDirectory;
	}
	
	public static boolean getHttpCredentials() {
		return httpCredentials;
	}
	
	
	public static String getBrowsers() {
		//translate old style to new SeHelper enums		
		return browsers;
	}
	
	public static String getBaseStoreUrl()
	{
		return getBaseUrl();
	}
	

}
