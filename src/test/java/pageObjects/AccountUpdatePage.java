package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountUpdatePage {

    public AccountUpdatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = ("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"))
    private WebElement myInformation;

    @FindBy(xpath = ("//*[@id=\"firstname\"]"))
    private WebElement newFirstName;


    @FindBy(xpath = ("//*[@id=\"old_passwd\"]"))
    private WebElement currentPassword;

    @FindBy(xpath = ("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button"))
    private WebElement saveButton;

    @FindBy(xpath = ("//*[@id=\"center_column\"]/div/p"))
    private WebElement successfulMessage;


    public void ClickOnMyInformation(){
        myInformation.click();
    }

    public void EnterNewFirstName(String newName){
        newFirstName.sendKeys(newName);
    }

    public void EnterCurrentPassword(String pass){
        currentPassword.sendKeys(pass);
    }

    public void ClickOnSaveButton(){
        saveButton.click();
    }

    public boolean UpdateSuccessfull() {
        String expectedResult = "Your personal information has been successfully updated";
        String actualResult = successfulMessage.getText();
        return actualResult.contains(expectedResult);
    }

}