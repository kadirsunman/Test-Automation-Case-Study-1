package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignInGooglePasswordPage {
    public SignInGooglePasswordPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    private final int TIMEOUT = 10;

    @FindBy(css = "input[class='whsOnd zHQkBf'][type='password']")
    public WebElement passwordBox;

    @FindBy(id="passwordNext")
    public WebElement forwardBtn;

    public void fillPasswordBox(String password)
    {
        passwordBox.sendKeys(password);
        clickForwardButton();
    }
    public void clickForwardButton()
    {
        forwardBtn.click();
        Helper.switchFirstTab();
    }

    public void openNewTabGoToUrl()
    {
        Driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        Driver.get().switchTo().newWindow(WindowType.TAB);
        Driver.get().get("https://www.bestbuy.com/");
    }

}
