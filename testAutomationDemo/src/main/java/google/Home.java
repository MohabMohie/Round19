package google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class Home {
	
	//variables
	private WebDriver driver;
	private String url = "https://www.google.com/";
	
	//locators
	private static By googleLogo_image = By.xpath("//img[@alt='Google']"); // img
	public static By getGoogleLogo_image() {
		return googleLogo_image;
	}
	private static By search_textBox = By.name("q"); // *[@name='q']

	//constructor
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	//keywords / actions
	public Home navigate() {
		BrowserActions.navigateToURL(driver, url+"ncr", url);
		return this;
	}
	
	public SearchResults search(String query) {
		ElementActions.type(driver, search_textBox, query);
		ElementActions.keyPress(driver, search_textBox, Keys.ENTER);
		return new SearchResults(driver);
	}
}
