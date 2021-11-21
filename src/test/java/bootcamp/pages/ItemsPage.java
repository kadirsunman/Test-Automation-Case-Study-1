package bootcamp.pages;

import bootcamp.utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ItemsPage {

    public ItemsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    long timeOutInSeconds = 10;

    JavascriptExecutor executor = (JavascriptExecutor)Driver.get();

    @FindBy(xpath = "//button[@data-track='Brand - Show More']")
    public WebElement showMoreBrands;

    @FindBy(className = "large-facet-group-show-results")
    public WebElement showResultsBtn;

    public void FilterBy(String selectFilters)
    {
        String locator = "//option[text()='" + selectFilters + "']";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void openAllBrands()
    {
        executor.executeScript("arguments[0].click();", showMoreBrands);
    }


    public void FilterOfBrands(String selectBrand)
    {
        String locator = "//span[@class='sr-only'][text()='" + selectBrand + "']";

        WebElement brandFilter = Driver.get().findElement(By.xpath(locator));
        executor.executeScript("arguments[0].click();", brandFilter);
    }

    public void ShowFiltersResult()
    {
        executor.executeScript("arguments[0].click();", showResultsBtn);
    }

    public void SelectItemsOfIndex(String index)
    {

        WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
        String locator = "//div[@data-track='[context:listRank=" + index + "]']//h4//a";
        WebElement selectedItem = Driver.get().findElement(By.xpath(locator));
        ExpectedCondition<Boolean> elementIsEnabled = arg0 -> {
            try {
                selectedItem.isDisplayed();
                return true;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        wait.until(elementIsEnabled);
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        selectedItem.click();

    }
    /*
    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

    wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
    */
}
