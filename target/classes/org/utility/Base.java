package org.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	static java.io.File jsonPath = new java.io.File("./JSON/Configuration.json");
	static File driverPath = new File("./Driver");

	public static WebDriver getDriver() {
		JSONObject jsonObject = readJSONObject();
		String browserName = (String) jsonObject.get("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					driverPath.getAbsoluteFile() + "/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					driverPath.getAbsoluteFile() + "/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					driverPath.getAbsoluteFile() + "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Pls give valid browser name");
		}
		driver.manage().window().maximize();
		driver.get((String) jsonObject.get("url"));
		return driver;
	}

	public static void setText(WebElement element, String name) {
		element.sendKeys(name);
	}

	public static void clickBtn(WebElement element) {
		element.click();
	}

	public static JSONObject readJSONObject() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser
					.parse(new FileReader(jsonPath.getAbsoluteFile()));
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
