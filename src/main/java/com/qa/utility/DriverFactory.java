package com.qa.utility;

public class DriverFactory {

	
	private static String geckoDriverExePath;
	private static String edgeDriverExePath;
	private static String configPropertyFile;
	private static String chromeDriverExePath;
	private static String gridPath; 
	private static boolean isRemote;
	
	
	public static String getGeckoDriverExePath() {
		return geckoDriverExePath;
	}
	public static void setGeckoDriverExePath(String geckoDriverExePath) {
		DriverFactory.geckoDriverExePath = geckoDriverExePath;
	}
	public static String getEdgeDriverExePath() {
		return edgeDriverExePath;
	}
	public static void setEdgeDriverExePath(String edgeDriverExePath) {
		DriverFactory.edgeDriverExePath = edgeDriverExePath;
	}
	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}
	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	
	
}
