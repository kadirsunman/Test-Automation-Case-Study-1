package bootcamp.pages;

import bootcamp.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SelectedItemPage {
    public SelectedItemPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='row v-m-top-xs']//button")
    public WebElement saveBtn;

    @FindBy(xpath = "//h1")
    public WebElement itemsOnPage;

    public void SaveItem() {
        saveBtn.click();
    }

    public void verifyTitles()
    {
        boolean result =false;
        ArrayList<String> getTitles = new ArrayList<String>();
        int count= 1;
        while(true)
        {
            try {
                String locator = "(//a[@data-track='navhistory_masi_timeline_product'][@style])["+ count + "]";
                getTitles.add(Driver.get().findElement(By.xpath(locator)).getText());
            }
            catch (Exception e)
            {
                break;
            }
        }
        for(String item:getTitles)
        {
            if(itemsOnPage.getText().equals(item)){ result = true;break;}
        }
        Assert.assertTrue(result);
    }
}
