package bootcamp.step_def;

import bootcamp.pages.*;
import bootcamp.utils.Driver;
import bootcamp.utils.Helper;
import io.cucumber.java.bs.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class MyStepDefs {
    Homepage homepage = new Homepage();
    SearchResultPage searchResultPage = new SearchResultPage();
    SigInPage sigInPage = new SigInPage();
    SignInGooglePage signInGooglePage = new SignInGooglePage();
    SignInGooglePasswordPage signInGooglePasswordPage = new SignInGooglePasswordPage();
    ItemsPage itemsPage = new ItemsPage();
    SelectedItemPage selectedItemPage = new SelectedItemPage();

    @Given("homepage is open")
    public void homepageIsOpen() {
        homepage.chooseUS();
    }

    @When("I close the pop up")
    public void iCloseThePopUp() {

        homepage.closePopup();
    }

    @Then("title should verify")
    public void titleVerifyControl() {
        homepage.verifyTitle();
    }

    @Then("verify loading page")
    public void verifyLoadingControl(){homepage.verifyLoadingPage();}

    @When("I search for {string}")
    public void iSearchFor(String searchKey) {
        homepage.searchFor(searchKey);
    }

    @Then("search result {string} should be seen")
    public void searchResultShouldBeSeen(String searchText) {
        searchResultPage.verifySearchResult(searchText);
    }

    @And("I open {string} dropdown menu")
    public void iOpenDropdownMenu(String dropdown) {
        homepage.openDropdown(dropdown);
    }

    @Given("sign in page click")
    public void signInPage() {
        homepage.clickSignInButton();
    }

    @When("I write email address {string} and password {string}")
    public void IWriteEmailAddressAndPassword(String email, String pass) {
        sigInPage.fillLoginEmailPassword(email,pass);
    }

    @And("click login button")
    public void clickLoginButton() {
        sigInPage.clickLogInButton();
    }

    @Then("verify successful login")
    public void verifySuccessfulLogin() {
        homepage.verifySuccessfulLogIn();
    }


    @When("I open sign in with google")
    public void IOpenSignInWithGoogle() {
        sigInPage.clickSignInWithGoogle();
    }

    @And("I switch to google page")
    public void ISwitchToGooglePage() {
        Helper.switchLastTab();
    }


    @And("I write email address {string} then click forward button")
    public void IWriteEmailAddressThenClickForwardButton(String eMail) {
        signInGooglePage.fillEmailBox(eMail);
    }

    @And("I write password {string} then click forward button")
    public void IWritePasswordThenClickForwardButton(String password) {
        signInGooglePasswordPage.fillPasswordBox(password);
    }

    @When("Open new tab and go to bestbuy")
    public void openNewTabAndGoToBestbuy() {
        signInGooglePasswordPage.openNewTabGoToUrl();
    }

    @Given("I open menu")
    public void IOpenMenu() {
        homepage.openMenu();
    }

    @Given("I open {string} item")
    public void IOpenItem(String itemName) {
        homepage.selectItemInMenu(itemName);
    }

    @And("I open {string} item page")
    public void IOpenItemPage(String itemName) {
        homepage.openItemPage(itemName);
    }

    @And("I filter by {string} in item page")
    public void IFilterByInItemPage(String selectedFilters) {
        itemsPage.FilterBy(selectedFilters);
    }

    @And("filter brands show more")
    public void filterBrandsShowMore() {
        itemsPage.openAllBrands();
    }

    @And("I select {string} from Brand filtered results")
    public void ISelectFromBrandFilteredResults(String brand) {
        itemsPage.FilterOfBrands(brand);
    }

    @And("show filters results")
    public void showFiltersResults() {
        itemsPage.ShowFiltersResult();
    }

    @And("Click {string}nd product on the search result page")
    public void clickNdProductOnTheSearchResultPage(String index) {
        itemsPage.SelectItemsOfIndex(index);
    }

    @And("Click save button")
    public void clickSaveButton() {
        selectedItemPage.SaveItem();
    }

    @Then("Verify that the title of saved product is on the list")
    public void verifyThatTheTitleOfSavedProductIsOnTheList() {
    }
}
