package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = ("//a[@class=\"login\"]"))
    private WebElement signInHyperlink;

   @FindBy(xpath = ("//*[@id=\"email\"]"))
    private WebElement emailExist;

    @FindBy(xpath = ("//input[@id=\"passwd\"]"))
    private WebElement password;

    @FindBy(xpath = ("//button[@name=\"SubmitLogin\"]/span"))
    private WebElement signInButton;

    @FindBy(xpath = ("//*[@id=\"center_column\"]/h1"))
    private WebElement myAccount;

    @FindBy(xpath = ("//*[@id=\"center_column\"]/div[1]/ol/li"))
    private WebElement errorMessage;



    public void ClickSignInHyperlink(){
        signInHyperlink.click();
    }

    public void EnterExistingEmailAddress(String email){
           emailExist.sendKeys(email);
    }

    public void EnterPassword(String pass){
        password.sendKeys(pass);
    }

    public void ClickOnSignInButton(){
        signInButton.click();
    }


    public void MyAccountIsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        String expectedResult = "MY ACCOUNT";
        String actualResult = myAccount.getText();
        Assert.assertEquals(expectedResult, actualResult, "Testing Failed, because Expected and Actual do not match");
    }

    public boolean ErrorMessageIsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        String expectedResult = "Password is required";
        String actualResult = errorMessage.getText();
        return actualResult.contains(expectedResult);
    }


}
