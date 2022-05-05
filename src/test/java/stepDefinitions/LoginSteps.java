package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;

import static stepDefinitions.Hooks.driver;




public class LoginSteps {

     LoginPage loginPage = new LoginPage(driver);




    @Given("I navigate to {string} automation practice website")
    public void iNavigateToAutomationPracticeWebsite(String WebPage) {

    }

    @When("I click on Sign in hyperlink on the top of the page")
    public void iClickOnSignInHyperlinkOnTheTopOfThePage() {
        loginPage.ClickSignInHyperlink();
    }


    @And("I enter my registered {string} in Email Address input field")
    public void iEnterMyRegisteredInEmailAddressInputField(String existEmail) {
        loginPage.EnterExistingEmailAddress(existEmail);
    }


    @And("I enter password {string}")
    public void iEnterPassword(String pass) {
        loginPage.EnterPassword(pass);
    }

    @And("I click on Sign in button in Already registered section")
    public void iClickOnSignInButtonInAlreadyRegisteredSection() {
        loginPage.ClickOnSignInButton();
    }

    @Then("I am directed to my account")
    public void iAmDirectedToMyAccount() throws InterruptedException {
        loginPage.MyAccountIsDisplayed();

    }

    @And("I do not enter password {string}")
    public void iDoNotEnterPassword(String pass) {
        loginPage.EnterPassword(pass);
    }

    @Then("I an error message is displayed")
    public void iAnErrorMessageIsDisplayed() throws InterruptedException {
          Assert.assertTrue(loginPage.ErrorMessageIsDisplayed());

    }


}
