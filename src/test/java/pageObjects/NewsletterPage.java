package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class NewsletterPage {

    public NewsletterPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//*[@id=\"newsletter-input\"]"))
    private WebElement newsletterEmail;

    @FindBy(xpath = ("//*[@id=\"newsletter_block_left\"]/div/form/div/button"))
    private WebElement submissionButton;

    @FindBy(xpath = ("//*[@id=\"columns\"]/p"))
    private WebElement newsletterMessage;



    public void EnterNewsletterEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String newsEmail = "username" + randomInt + "@mailinator.com";
        newsletterEmail.sendKeys(newsEmail);
    }

    public void ClickNewsletterSubmission(){
        submissionButton.click();
    }

    public boolean SuccessfullySubmittedIsDisplayed(){
        String expectedResult = "Newsletter : You have successfully subscribed to this newsletter.";
        String actualResult = newsletterMessage.getText();
        return actualResult.contains(expectedResult);

    }

}
