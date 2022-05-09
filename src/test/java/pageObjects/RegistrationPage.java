package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class RegistrationPage {

    public RegistrationPage (WebDriver driver){
        PageFactory.initElements(driver, this);
}

        @FindBy(xpath = ("//*[@id=\"email_create\"]"))
        private WebElement emailAddress;

        /*@FindBy(xpath= ("//*[@id=\"email_create\"]"))
        private WebElement email;*/

        @FindBy(xpath= ("//*[@id=\"SubmitCreate\"]/span"))
        private WebElement createAccountButton;

        @FindBy(xpath = ("//*[@id=\"id_gender1\"]"))
        private WebElement genderMr;

        @FindBy(xpath = ("//*[@id=\"id_gender2\"]"))
        private WebElement genderMrs;

        @FindBy(xpath = ("//*[@id=\"customer_firstname\"]"))
        private WebElement firstName;

        @FindBy(xpath = ("//*[@id=\"customer_lastname\"]"))
        private WebElement lastName;

        @FindBy(xpath = ("//input[@id=\"passwd\"]"))
        private WebElement password;

        @FindBy(xpath = ("//select[@id=\"days\"]"))
        private WebElement day;

        @FindBy(xpath = ("//select[@id=\"months\"]"))
        private WebElement month;

        @FindBy(xpath = ("//select[@id=\"years\"]"))
        private WebElement year;

        @FindBy(xpath = ("//input[@id=\"address1\"]"))
        private WebElement address;

        @FindBy(xpath = ("//input[@id=\"city\"]"))
        private WebElement city;

        @FindBy(xpath = ("//select[@id=\"id_state\"]"))
        private WebElement state;

        @FindBy(xpath = ("//input[@id=\"postcode\"]"))
        private WebElement zipPostalCode;

        @FindBy(xpath = ("//*[@id=\"id_country\"]"))
        private WebElement country;

        @FindBy(xpath = ("//textarea[@id=\"other\"]"))
        private WebElement otherMessage;

        @FindBy(xpath = ("//input[@id=\"phone\"]"))
        private WebElement landline;

        @FindBy(xpath = ("//input[@id=\"phone_mobile\"]"))
        private WebElement mobilePhone;

        @FindBy(xpath = ("//button[@id=\"submitAccount\"]"))
        private WebElement registerButton;

        @FindBy(xpath = ("//*[@id=\"center_column\"]/h1"))
        private WebElement myAccount;

        @FindBy(xpath = ("//*[@id=\"center_column\"]/div/ol/li"))
        private WebElement registError;

        @FindBy(id = ("create_account_error"))
        private WebElement emailError;


        public void EnterEmail(){
                        Random randomGenerator = new Random();
                        int randomInt = randomGenerator.nextInt(1000);
                        String newEmail = "username" + randomInt + "@mailinator.com";
                        emailAddress.sendKeys(newEmail);

        }

        public void CreateAccount(){
                createAccountButton.click();
        }


        public void TitleMrs(){
                genderMrs.click();
        }

        public void TitleMr(){
                genderMr.click();
        }
        public void SelectGender(String gender) throws InterruptedException {
                Thread.sleep(5000);

                if (gender.equals("Mrs")){
                        TitleMrs();
                }
                else if (gender.equals(("Mr"))){
                       TitleMr();
                }
        }

        public void EnterFirstName(String userName){
                firstName.sendKeys(userName);
        }

        public void EnterLastName(String last){
                lastName.sendKeys(last);
        }

        public void EnterPassword(String pass){
                password.sendKeys(pass);
        }

        public void DateOfBirth(String days, String months, String years){
                new Select(day).selectByValue(days);
                new Select(month).selectByValue(months);
                new Select(year).selectByValue(years);
        }

        public void EnterAddress(String address1){
                address.sendKeys(address1);
        }

        public void EnterCity(String cityTown){
                city.sendKeys(cityTown);
        }

        public void SelectState(){
                new Select(state).selectByVisibleText("Washington");
        }

        public void EnterZipCode(String zip){
                zipPostalCode.sendKeys(zip);
        }

        public void SelectCountry(){
                new Select(country).selectByVisibleText("United States");
        }

        public void EnterOtherMessage(String message){
                otherMessage.sendKeys(message);
        }

        public void EnterHomePhone(String homePhone){
                landline.sendKeys(homePhone);
        }

        public void EnterMobilePhone(String mobile){
                mobilePhone.sendKeys(mobile);
        }

        public void ClickOnRegister(){
                registerButton.click();
        }

        public void MyAccountIsDisplayed(){
                String expectedResult = "MY ACCOUNT";
                String actualResult = myAccount.getText();
                Assert.assertEquals(expectedResult, actualResult, "Testing Failed, because Expected and Actual do not match");
        }

        public void ErrorMessageIsDisplayed(){
                String expectedResult = "MY ACCOUNT";
                String actualResult = myAccount.getText();
                Assert.assertEquals(expectedResult, actualResult, "Testing Failed, because Expected and Actual do not match");
        }

        public boolean RegistrationErrorMessageIsDisplayed(){
                String expectedResult = "firstname is required";
                String actualResult = registError.getText();
                return actualResult.contains(expectedResult);
        }

        public boolean EmailErrorMessageIsDisplayed() throws InterruptedException {
                //JavascriptExecutor jse = (JavascriptExecutor) driver;
                //jse.executeScript("window.scrollBy(0,250)");
                Thread.sleep(10000);
                String expectedResult = "An account using this email address has already been registered";
                String actualResult = emailError.getText();
                System.out.println("actual error message is" + actualResult);
                return actualResult.contains(expectedResult);
        }

        public void EnterExistingEmailAddress(String existEmail){
                emailAddress.sendKeys(existEmail);
        }

}
