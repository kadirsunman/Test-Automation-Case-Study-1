package bootcamp.pages;

import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.get(),this);
    }

    private final int TIMEOUT = 10;

    @FindBy(css = "[alt='United States']")
    public WebElement country;

    @FindBy(css = ".c-close-icon.c-modal-close-icon")
    public WebElement closeButton;

    @FindBy(id = "gh-search-input")
    public WebElement searchBox;

    @FindBy(css = "[aria-label='submit search']")
    public WebElement searchIcon;

    @FindBy(className = "sign-in-btn")
    public WebElement signInBtn;

    @FindBy(css = ".c-button-unstyled.hamburger-menu-button")
    public WebElement menuBtn;

    @FindBy(css = ".plButton-label.v-ellipsis")
    public WebElement hiName;


    public void chooseUS(){
        country.click();
    }

    public void closePopup(){
        closeButton.click();
    }

    public void verifyTitle(){
        Assert.assertEquals("Best Buy | Official Online Store | Shop Now & Save",Driver.get().getTitle());
    }

    public void verifyLoadingPage()
    {
        WebDriverWait wait = new WebDriverWait(Driver.get(), TIMEOUT);
        ExpectedCondition<Boolean> elementIsEnabled = arg0 -> {
            try
            {
                if(Driver.get().getTitle().equals("Best Buy | Official Online Store | Shop Now & Save"))
                {
                    return true;
                }
                return false;
            }
            catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        wait.until(elementIsEnabled);
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void verifySuccessfulLogIn()
    {
        Assert.assertTrue(hiName.getText().contains("Hi,"));
    }

    public void searchFor(String searchKey) {
        searchBox.click();
        searchBox.sendKeys(searchKey);
        searchIcon.click();
    }

    public void openDropdown(String dropdown) {
        Driver.get().findElement(By.xpath("//span[text()='" + dropdown + "']")).click();
    }

    public void clickSignInButton()
    {
        signInBtn.click();
    }

    public void selectItemInMenu(String itemName) {
        String locator = "//button[text()='" + itemName + "']";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void openMenu()
    {
        menuBtn.click();
    }

    public void openItemPage(String itemName) {
        String locator = "//a[text()='" + itemName + "']";
        Driver.get().findElement(By.xpath(locator)).click();
    }
}
