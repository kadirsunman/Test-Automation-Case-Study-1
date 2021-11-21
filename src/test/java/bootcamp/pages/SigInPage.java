package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SigInPage {
    public SigInPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    private final int TIMEOUT = 10;

    @FindBy(tagName = "h1")
    public WebElement title;

    @FindBy(id = "fld-e")
    public WebElement eMailBox;

    @FindBy(id = "fld-p1")
    public WebElement passwordBox;

    @FindBy(className = "cia-form__controls__submit")
    public WebElement logInBtn;

    @FindBy(xpath = "/html/body/div[1]/div/section/main/div[2]/div[1]/div/div/div/div/div/div[4]/button")
    public WebElement signInWithGoogle;

    public void fillLoginEmailPassword(String eMail, String password)
    {
        eMailBox.click();
        eMailBox.sendKeys(eMail);
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    public void clickLogInButton()
    {
        logInBtn.click();
    }

    public void clickSignInWithGoogle()
    {
        WebDriverWait wait = new WebDriverWait(Driver.get(), TIMEOUT);
        ExpectedCondition<Boolean> elementIsEnabled = arg0 -> {
            try {
                signInWithGoogle.isDisplayed();
                return true;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        wait.until(elementIsEnabled);
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        signInWithGoogle.click();
    }
}
