package org.fb.test.login;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.pages.login.FacebookLogin;
import org.utility.Base;

public class FacebookLoginTest extends Base {
	static WebDriver driver;

	@BeforeClass
	public static void launchBrowser() {
		driver = getDriver();

	}

	@Test
	public void loginFacebook() {
		FacebookLogin login = new FacebookLogin();
		setText(login.getTxtUserName(), "Ramesh@gmail.com");
		setText(login.getTxtPassword(), "87678");
		clickBtn(login.getBtnLogin());
	}

	@AfterClass
	public static void closeAppln() {
		driver.quit();
	}
}
