package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

import static stepDefinitions.Hooks.driver;

public class RegistrationSteps {


     RegistrationPage registrationPage = new RegistrationPage(driver);

    @And("I enter my {string} in Email Address input field")
    public void iEnterMyInEmailAddressInputField(String newEmail) {
            registrationPage.EnterEmail();
    }

    @And("I click on Create an account button")
    public void iClickOnCreateAnAccountButton() {
        registrationPage.CreateAccount();
    }

    @And("I click on a {string} radio button to select a title")
    public void iClickOnARadioButtonToSelectATitle(String gender) throws InterruptedException {
        registrationPage.SelectGender(gender);
    }

    @And("I enter {string} in the First Name input field")
    public void iEnterInTheFirstNameInputField(String userName) {
        registrationPage.EnterFirstName(userName);
    }

    @And("I enter {string} in the Last Name input field")
    public void iEnterInTheLastNameInputField(String last) {
        registrationPage.EnterLastName(last);
    }

    @And("I enter {string} in the Password input field")
    public void iEnterInThePasswordInputField(String pass) {
        registrationPage.EnterPassword(pass);
    }


    @And("I select a {string}, {string}, {string} in the date of birth dropdown list")
    public void iSelectAInTheDateOfBirthDropdownList(String days, String months, String years) {
        registrationPage.DateOfBirth(days, months,years);
    }

    @And("I enter {string} in the Address input field")
    public void iEnterInTheAddressInputField(String address1) {
        registrationPage.EnterAddress(address1);
    }

    @And("I enter {string} in the City input field")
    public void iEnterInTheCityInputField(String cityTown) {
        registrationPage.EnterCity(cityTown);
    }

    @And("I select a {string} from the State drop down list")
    public void iSelectAFromTheStateDropDownList(String arg0) {
        registrationPage.SelectState();
    }

    @And("I enter {string} in the Zip or Postal code field")
    public void iEnterInTheZipOrPostalCodeField(String zip) {
        registrationPage.EnterZipCode(zip);
    }

    @And("I select a {string} from the Country drop down list")
    public void iSelectAFromTheCountryDropDownList(String arg0) {
        registrationPage.SelectCountry();
    }

    @And("I enter{string} in the Additional Information input area")
    public void iEnterInTheAdditionalInformationInputArea(String add) {
        registrationPage.EnterOtherMessage(add);
    }

    @And("I enter {string} in the Home Phone input field")
    public void iEnterInTheHomePhoneInputField(String home) {
        registrationPage.EnterHomePhone(home);
    }

    @And("I enter {string} in the Mobile Phone input field")
    public void iEnterInTheMobilePhoneInputField(String mobile) {
        registrationPage.EnterMobilePhone(mobile);
    }

    @And("I click on the Register button")
    public void iClickOnTheRegisterButton() {
        registrationPage.ClickOnRegister();
    }

    @Then("I must be able to register successfully")
    public void iMustBeAbleToRegisterSuccessfully() {
        registrationPage.MyAccountIsDisplayed();
    }


    @And("I do not enter any {string} in the First Name input field")
    public void iDoNotEnterAnyInTheFirstNameInputField(String first) {
        registrationPage.EnterFirstName(first);
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed(){
        Assert.assertTrue(registrationPage.RegistrationErrorMessageIsDisplayed());
    }

    @Then("a message should be displayed warning me that the email has already been registered")
    public void aMessageShouldBeDisplayedWarningMeThatTheEmailHasAlreadyBeenRegistered() throws InterruptedException {
        Assert.assertTrue(registrationPage.EmailErrorMessageIsDisplayed());

    }

    @And("I enter an existing {string} in Email Address input field")
    public void iEnterAnExistingInEmailAddressInputField(String existEmail) {
        registrationPage.EnterExistingEmailAddress(existEmail);
    }
}
