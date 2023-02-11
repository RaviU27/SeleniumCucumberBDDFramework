package stepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class googleSearch {
	
	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Given("browser is open for Search")
	public void browser_is_open() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.navigate().to("https://google.com");
		
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Maths");
	}

	@And("hits enter")
	public void hits_enter() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		driver.getPageSource().contentEquals("Maths");
		driver.close();
		driver.quit();
	}
}
