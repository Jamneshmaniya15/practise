package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By sBox = By.name("q");
	private By res = By.cssSelector("h3");
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void navTo() {
		driver.get("https://www.google.com/");
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void searchFor(String query) {
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(sBox));
		input.clear();
		input.sendKeys(query);
		input.sendKeys(Keys.ENTER);
	}
	
	public List<WebElement> getSearchResult(){
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(res));
		return driver.findElements(res);
	}
}
