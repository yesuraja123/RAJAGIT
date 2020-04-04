package Pagefiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testpage1 {
	
	@FindBy(xpath="(//input[contains(@type,'password')])[1]")
	public WebElement txtPassword;
	
	 WebDriver driver;
	
	
	
	public void loginpage () throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");			
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	public  void EnterFromandToLocation() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[contains(@id,'src')]")).sendKeys("Sholinganallur");
		WebDriverWait wait = new WebDriverWait (driver,30); 
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class,'autoFill')]/li")));
		List <WebElement> List = driver.findElements(By.xpath("//ul[contains(@class,'autoFill')]/li"));
		System.out.println("Auto Sugget List "+ List.size());
		
		for(int i=0 ; i<List.size();i++) {
			System.out.println(List.get(i).getText());
			if(List.get(i).getText().equals("Sholinganallur, Chennai")) {
				List.get(i).click();
				break;
			}
			
		}
		
		
		driver.findElement(By.xpath("//input[contains(@id,'dest')]")).sendKeys("Trichy");
		Thread.sleep(500);
		List <WebElement> Destn = driver.findElements(By.xpath("//ul[contains(@class,'autoFill')]/li"));
		System.out.println("Auto Suggest List" + Destn.size());
		
		for(int i =0;i<Destn.size();i++) {
			System.out.println(Destn.get(i).getText());
			if(Destn.get(i).getText().equals("Trichy")) {
				Destn.get(i).click();
				break;
			}
		}
		
	}
	
	public void SelectDateandSearchBUS() throws InterruptedException
	{
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		
	}
	
	public void QuitDriver() {
		driver.quit();
	}

}
