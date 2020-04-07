package com.cnnnews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.ObjectMap;
import com.util.HighLighter;

import MasterPageFactory.MasterPageFactory;

public class CnnNewsBasePage {
	private WebDriver driver;
	private MasterPageFactory pf;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nefer\\Downloads\\Chrome_last\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@Test  // TC-01
	public void homePage() throws Throwable {
		driver.getTitle();
		System.out.println("Business News - Latest Headlines on CNN Business - CNN");
		ObjectMap obj = new ObjectMap();
		driver.get(obj.getconfig("URL"));

		pf = PageFactory.initElements(driver, MasterPageFactory.class);
		Thread.sleep(2000);
	}

	@Test (dependsOnMethods="homePage") // TC-02
	public void pages() throws Throwable {
		// Market
		pf.getMarket().click();
		String marketTitle = driver.getTitle();
		Assert.assertEquals(marketTitle, "Stock Market Data - Dow Jones, Nasdaq, S&P 500 - CNNMoney");
		System.out.println(marketTitle);

		Thread.sleep(2000);

		// Tech
		pf.getTech().click();
		String techTitle = driver.getTitle();
		Assert.assertEquals(techTitle, "Tech News - Latest Technology Headlines and Trends on CNN Business - CNN");
		System.out.println(techTitle);
		Thread.sleep(3000);

		// Media
		pf.getMedia().click();
		String mediaTitle = driver.getTitle();
		Assert.assertEquals(mediaTitle, "Media News - Latest Headlines on CNN Business - CNN");
		System.out.println(mediaTitle);
		Thread.sleep(2000);

		// Success
		pf.getSuccess().click();
		String successTitle = driver.getTitle();
		Assert.assertEquals(successTitle, "Careers - News for Entrepreneurs and Leaders on CNN Business - CNN");
		System.out.println(successTitle);
		Thread.sleep(3000);

		// Perspective
		pf.getPerspective().click();
		String perspectiveTitle = driver.getTitle();
		Assert.assertEquals(perspectiveTitle, "Analysis – CNN Business - CNN");
		System.out.println(perspectiveTitle);
		Thread.sleep(3000);

		// Videos
		pf.getVideos().click();
		String videosTitle = driver.getTitle();
		Assert.assertEquals(videosTitle, "Videos - CNN Business - CNN");
		System.out.println(videosTitle);
		Thread.sleep(3000);
	}

	@Test (dependsOnMethods="pages") // TC-03
	public void displayDataonMarket() throws Throwable {
		pf.getMarket().click();
		Thread.sleep(2000);
		List<String> displaydata = new ArrayList<>();
		for (int i = 0; i < pf.getDisplayData().size(); i++) {

			displaydata.add(pf.getDisplayData().get(i).getText());
		}
		System.out.println("Data display on Top Section:" + displaydata);
	}
	

	@Test (dependsOnMethods="displayDataonMarket") // TC-05
	public void mostPopularStocks() {
		
		List<String> mostPopularStocks = new ArrayList<>();
		for (int i = 0; i < pf.getMostpopularstocks().size(); i++) {

			mostPopularStocks.add(pf.getMostpopularstocks().get(i).getText());
		}
		System.out.println("Most Popular Stocks should be Apple,Citigroup, General Electric, Google, Microsoft"
				+ mostPopularStocks);

	}
	@Test(dependsOnMethods="mostPopularStocks") //TC-06
	public void validateMostPopular() {
		pf.getValidateMostPopular();
		List<String> validateMostPopularStocks = new ArrayList<>();
		for (int i = 0; i < pf.getDisplayData().size(); i++) {

			validateMostPopularStocks.add(pf.getValidateMostPopular().get(i).getText());
		}
		Assert.assertEquals("Apple	241.43	-1.43% Citigroup	37.48	-4.47% General Electric	6.72	-2.54% Google	1092.51	-2.20% Microsoft	153.83	-0.92%", validateMostPopularStocks);
		
	}
	@Test(dependsOnMethods="validateMostPopular") ///TC-07
	public void sectorPerformance() {
		pf.getSectorPerformance();
		Map<String, String> sectorP = new HashMap<>();

		sectorP.put("Retail Trade", "-8.93%");
		sectorP.put("Communications", "-9.75%");
		sectorP.put("Consumer Non-Durables", "-13.64%");
		sectorP.put("Technology Services", "-13.8%");
		sectorP.put("Utilities", "-18.39%");
		sectorP.put("Health Services", "-20.9%");
		sectorP.put("Electronic Technology", "-21.46%");
		sectorP.put("Consumer Durables"," -21.75%");
		
		sectorP.put("Commercial Services", "-24.1%");
		sectorP.put("Transportation", "-25.56%");
		sectorP.put("Finance", "-30.13%");
		sectorP.put("Energy Minerals", "-46.88%");
		System.out.println(sectorP);
		
	
	}
	@Test (dependsOnMethods="sectorPerformance") //08 
	public void biggestBarName() {
		pf.getSectorPerformance();
	}
	
	@Test (dependsOnMethods="biggestBarName")//9
	public void loserSection() {
		Map<String, String> sectorP = new HashMap<>();

		sectorP.put("Retail Trade", "-8.93%");
		sectorP.put("Communications", "-9.75%");
		sectorP.put("Consumer Non-Durables", "-13.64%");
		sectorP.put("Technology Services", "-13.8%");
		sectorP.put("Utilities", "-18.39%");
		sectorP.put("Health Services", "-20.9%");
		sectorP.put("Electronic Technology", "-21.46%");
		sectorP.put("Consumer Durables", "-21.75%");
		sectorP.put("Commercial Services", "-24.1%");
		sectorP.put("Transportation", "-25.56%");
		sectorP.put("Finance", "-30.13%");
		sectorP.put("Energy Minerals", "-46.88%");
		System.out.println(sectorP);
	}
		@Test //TC9
		public void losers() {
			Map<String,String> loser=new HashMap<>();
			loser.put("Arconic Corp (PITTSBURGH)","-9.43%");
		loser.put("Carrier Global Corp", "-8.75%");
		loser.put("Campbell Soup Co", "-3.88%");
		loser.put("Otis Worldwide Corp", "-2.92%");
		loser.put("EOG Resources Inc", "-1.15%");
		System.out.println(loser);
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}





