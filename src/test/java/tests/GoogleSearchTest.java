package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class GoogleSearchTest extends BaseTest{
	
	@Test
	public void testGoogleTitle() {
		GooglePage pg = new GooglePage(driver);
		pg.navTo();
		
		String title = pg.getTitle();
		System.out.println("Title: " +title);
		
		Assert.assertEquals(title, "Google","Title does not match");
	}
	
	@Test
	public void testsearchReturnResult() {
		GooglePage pg = new GooglePage(driver);
		pg.navTo();
		pg.searchFor("Selenium");
		
		List<WebElement> res = pg.getSearchResult();
		System.out.println("Result : " +res.size());
		
		Assert.assertTrue(res.size()>0,"return min 1 result");
	}
	
	@Test
	public void testFirstResultRelevent() {
		GooglePage pg = new GooglePage(driver);
		pg.navTo();
		pg.searchFor("TestNg");
		
		List<WebElement> res = pg.getSearchResult();
		System.out.println("Result : " +res.size());
		Assert.assertTrue(res.size()>0);
		
		String first = res.get(0).getText().toLowerCase();
		System.out.println("First result : " +first);
		
		Assert.assertTrue(first.contains("testing") || first.contains("test"),"first result should be relevent");
	}
}
