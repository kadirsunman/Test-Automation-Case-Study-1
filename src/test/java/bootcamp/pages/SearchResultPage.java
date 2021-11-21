package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public SearchResultPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "search-title")
    public WebElement resultTitle;


    public void verifySearchResult(String searchText) {
        Assert.assertTrue(resultTitle.getText().contains(searchText));
    }
}
