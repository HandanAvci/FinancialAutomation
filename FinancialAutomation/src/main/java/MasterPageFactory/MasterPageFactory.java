package MasterPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

////*a[href='https://money.cnn.com/data/markets/dow']

	public class MasterPageFactory {
		WebDriver driver;
	public void  MasterPageFactory( WebDriver driver) {
		
		this.driver=driver;
	}
		//Market
		@FindBy
		(xpath="(//*[contains(@class,'sc-dnqmqq dMglaH')])[1]")
		private WebElement market;
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getMarket() {
			return market;
		}
		
		
		
	//Tech
		@FindBy
		(xpath=("(//*[contains(text(),'Tech')])[1]"))
		private WebElement Tech;
		public WebElement getTech() {
			return Tech;
		}
		
	//Media
	@FindBy
	(xpath=("(//*[contains(text(),'Media')])[3]"))
	private WebElement media;
	public WebElement getMedia() {
		return media;
	}

	
	//Success
	@FindBy
	(xpath=("(//*[text()='Success'])[1]"))
	private WebElement success;
	public WebElement getSuccess() {
		return success;
	}
	//Perspective
	@FindBy 
	(xpath=("(//*[text()='Perspectives'])[1]"))
	private WebElement perspective;
	public WebElement getPerspective() {
		return perspective;
	}
	
	//Videos
	@FindBy 
	(xpath=("(//*[text()='Videos'])[1]"))
	private WebElement videos;
	public WebElement getVideos() {
		return videos;
	}
	
	//TestCase-3
	@FindBy(xpath=("(//*[contains(@class,'markets-overview')])[1]"))
	private List<WebElement>displayData;
	public List<WebElement> getDisplayData() {
		return displayData;
	}
	
	//TestCase-4
	@FindBy(xpath=("//*[contains(text(),'Most Popular Stocks ')]"))
	private List<WebElement>mostpopularstocks;
	public List<WebElement> getMostpopularstocks() {
		return mostpopularstocks;
	}

	public void setMostpopularstocks(List<WebElement> mostpopularstocks) {
		this.mostpopularstocks = mostpopularstocks;
	}
	@FindBy
	(xpath=("//*[contains(@class,'module-body wsod most-popular-stocks')]"))
	private List<WebElement> validateMostPopular;
	public List<WebElement> getValidateMostPopular() {
		return validateMostPopular;
	}
		@FindBy
		(xpath=("//*[contains(text(),'Sector Performance')]"))
		private WebElement sectorPerformance;
		public WebElement getSectorPerformance() {
			return sectorPerformance;
		}

		
		@FindBy
		(xpath=("(//*[contains(@class,'module-body')])[6]"))
		private List<WebElement> sectorPerformancesmaller;
		public List<WebElement> getSectorPerformancesmaller() {
			return sectorPerformancesmaller;
		}

		
		@FindBy //TC-9
		(xpath=("(//*[contains(@class,'module-header')])[7]"))
		private List<WebElement>Losers;
		public List<WebElement> getLosers() {
			return Losers;
		}
		
	
	
	
	}
	


