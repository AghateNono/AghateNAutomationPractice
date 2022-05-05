package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.AccountUpdatePage;

import static stepDefinitions.Hooks.driver;

public class AccountUpdateSteps {

    AccountUpdatePage accountUpdatePage = new AccountUpdatePage(driver);

    @And("I click on My personal information button")
    public void iClickOnMyPersonalInformationButton() {
        accountUpdatePage.ClickOnMyInformation();
    }

    @And("I enter a different {string} in the first name input field")
    public void iEnterADifferentInTheFirstNameInputField(String newName) {
        accountUpdatePage.EnterNewFirstName(newName);
    }

    @And("I enter {string} in the current password input field")
    public void iEnterInTheCurrentPasswordInputField(String pass) {
        accountUpdatePage.EnterCurrentPassword(pass);
    }

    @And("I click on Save button")
    public void iClickOnSaveButton() {
        accountUpdatePage.ClickOnSaveButton();
    }

    @Then("my personal information is successfully updated")
    public void myPersonalInformationIsSuccessfullyUpdated() {
        Assert.assertTrue(accountUpdatePage.UpdateSuccessfull());
    }


}
