package stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.loginPage;

public class LoginSteps {
	
	WebDriver driver = null;
	loginPage login;
	
	
	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {
		
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
	    
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web/");
	   
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
		login = new loginPage(driver);
		
		login.getUsername(username);
		login.getPassword(password);
		
		Thread.sleep(2000);
		login.clickLoginBtn();
	    
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		login.verifyLogoutnBtn();
		driver.close();
		driver.quit();
	    
	}

}
