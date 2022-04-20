package StepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;


public class LoginSteps {
	WebDriver driver=null;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver","S:/Eclipse/workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.ssc-live.com/viewer/ThirdPartyLogin.jsp");
	}
	
	@When("user enters username and selects currency")
	public void user_enters_username_and_selects_currency() {
		driver.findElement(By.id("uname")).sendKeys("test1@test.com");
		Select currency= new Select(driver.findElement(By.id("currencyList")));
		currency.selectByVisibleText("INR");
		System.out.println("hello");
	}

	@And("clicks submit button")
	public void clicks_submit_button() {
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

		System.out.println("welcome");
	}

	@SuppressWarnings("deprecation")
	@Then("user clicks game lobby link")
	public void user_is_navigated_to_game_lobby() {

		WebElement lobby=driver.findElement(By.xpath("//a[contains(text(),'Game Lobby')]"));
		lobby.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		System.out.println("cucumber");
	}

	@Given("user navigates to another tab")
	public void user_navigates_to_another_tab() {

		System.out.println("PpppppP");
		ArrayList <String> ssgtab=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(ssgtab.get(1));
		String title=driver.getTitle();
		System.out.println(title);
	}

	@SuppressWarnings("deprecation")
	@And("closes alert popup")
	public void closes_alert_popup() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		WebElement popup=driver.findElement(By.xpath("(//div[@class='promotion-popup'])[2]/descendant::img[3]"));
		popup.click();


	}

	@SuppressWarnings("deprecation")
	@Then("selects the tp2020 game")
	public void selects_the_tp2020_game() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebElement play=driver.findElement(By.xpath("//div[@class='ng-tns-c47-20 menubetlimitShower-Arrow ng-star-inserted']"));
		play.click();

	}

	@SuppressWarnings("deprecation")
	@And("navigates to game table")
	public void navigates_to_game_table() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebElement limit=driver.findElement(By.xpath("(//span[@class='ng-tns-c62-33'])[1]"));
		limit.click();

		

	}

	@Then("shows the bet limit")
	public void shows_the_bet_limit() {
		String min= driver.findElement(By.xpath("//div[contains(text(),'Table Min.')]/following::div[4]")).getText();
		System.out.println("Table min = "+min);
		String max=driver.findElement(By.xpath("//div[contains(text(),'Table Min.')]/following::div[5]")).getText();
		System.out.println("Table max = "+max);
		System.out.println("3");

	}
	@And("checks the balance")
	public void checks_the_balance() {


		String balance=driver.findElement(By.xpath("//div[contains(text(),'BALANCE')]/following::span")).getText();
		System.out.println("before game-balance = "+balance);

	}
	@And("wait for timer")
	public void wait_for_timer() {
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,100000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ng-tns-c64-34'])[3]")));

	}


	@Then("selects the chip")
	public void selects_the_chip() throws InterruptedException {

		if(driver.findElement(By.xpath("(//div[@class='ng-tns-c64-34'])[3]")).isDisplayed())
		{
			WebElement chiptray=driver.findElement(By.xpath("(//div[@class='ng-tns-c81-37'])[2]"));
			chiptray.click();
			Thread.sleep(3000);
			WebElement chip=driver.findElement(By.id("circle-4"));
			chip.click();
		}

	}
	@SuppressWarnings("deprecation")
	@And("place the bet")
	public void place_the_bet() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		//WebElement area=driver.findElement(By.id("main"));
		Actions actions=new Actions(driver);
		//actions. moveToElement(driver. findElement(By.id("main")),0,576);
		actions.moveByOffset(782,506).click().build().perform();
		
		
	}
	@Then("checking total bet")
	public void checking_total_bet() throws InterruptedException {
		Thread.sleep(12000);
		String bet = driver.findElement(By.xpath("(//div[contains(text(),'TOTAL')]/following::div)[1]")).getText();
	   System.out.println("total bet = "+bet);
		
	}
	@And("checks the total balance")
	public void checks_the_total_balance() throws InterruptedException {
		Thread.sleep(5000);
		String totalbal=driver.findElement(By.xpath("//div[contains(text(),'BALANCE')]/following::span")).getText();
		System.out.println("after game-balance = "+totalbal);
		
	   
	}
	
	@And("checking the win amount")
	public void checking_the_win_amount() throws InterruptedException  {
		Thread.sleep(45000);
		String win=driver.findElement(By.xpath("(//div[contains(text(),'TOTAL')]/following::div)[2]")).getText();
	    System.out.println("win amount = "+win);
	    
		
	}
	
	@Then("gets the Total balance")
	public void gets_the_total_balance() throws InterruptedException  {
		Thread.sleep(2000);
		String finalbal=driver.findElement(By.xpath("//div[contains(text(),'BALANCE')]/following::span")).getText();
		System.out.println("final game-balance = "+finalbal);
		
	    
	}




}
