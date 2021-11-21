package bootcamp.pages;

import bootcamp.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInGooglePage {
    public SignInGooglePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement eMailBox;

    @FindBy(xpath = "//div[@class='qhFLie']//button")
    public WebElement forwardBtn;


    public void fillEmailBox(String eMail)
    {
        eMailBox.sendKeys(eMail);
        clickForwardButton();
    }

    public void clickForwardButton()
    {
        forwardBtn.click();
    }

}
