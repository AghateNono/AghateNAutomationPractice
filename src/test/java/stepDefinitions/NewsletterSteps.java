package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.NewsletterPage;

import static stepDefinitions.Hooks.driver;

public class NewsletterSteps {


    NewsletterPage newsletterPage = new NewsletterPage(driver);


    @And("I enter my {string} in the Newsletter Email Address input field")
    public void iEnterMyInTheNewsletterEmailAddressInputField(String newsEmail) {
        newsletterPage.EnterNewsletterEmail();
    }

    @And("I click on the forward button next to the Input field")
    public void iClickOnTheForwardButtonNextToTheInputField() {
        newsletterPage.ClickNewsletterSubmission();
    }

    @Then("I am able to successfully subscribe to Newsletter")
    public void iAmAbleToSuccessfullySubscribeToNewsletter() {
        Assert.assertTrue(newsletterPage.SuccessfullySubmittedIsDisplayed());

    }
}
