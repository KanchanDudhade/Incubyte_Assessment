package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeEmailSteps {
    WebDriver driver;

    @Given("User am on the Gmail homepage")
    public void navigateToGmailHomePage() {
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/mail/u/6/?ogbl#inbox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("User click on the Compose button")
    public void clickComposeButton() throws InterruptedException {
    	WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
    	emailField.sendKeys("test@gmail.com");      //Use valid email id
  
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));       
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='Passwd']"));
        passwordField.sendKeys("pass@123");   //Use valid password
        Thread.sleep(1000);
        WebElement nextButtonpasswordField = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButtonpasswordField.click();
         
        WebElement composeButton = driver.findElement(By.xpath("//div[@jscontroller='eIu7Db']"));
        composeButton.click();
    }

    @When("User fill in recipient's email, subject, and body")
    public void fillEmailDetails() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebElement toField = driver.findElement(By.xpath("//div[@class='aH9']//input[@type='text']"));
        toField.sendKeys("test@example.com");         //Use valid email id

        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys("Incubyte");

        WebElement bodyField = driver.findElement(By.xpath("//div[@role='textbox']"));
        bodyField.sendKeys("Automation QA test for Incubyte");
    }

    @When("User click on the Send button")
    public void clickSendButton() {
        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();
    }

    @Then("the email should be sent successfully")
    public void verifyEmailSent() throws InterruptedException {    	
    	Thread.sleep(1000);
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='bAq']")));
    	String successMessage = driver.findElement(By.xpath("//span[@class='bAq']")).getText();
    	System.out.println(successMessage);
    	
    	String expectedOutputTxt = "Message sent";
    	
    	if(expectedOutputTxt.equals(successMessage))
    	{
    		System.out.println("Email successfully sent test case passed...!!! ");
    	}
    	else
    	{
    		System.out.println("Email not sent test case failed...!!! ");   		
    	}       
    }

	@After
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}

