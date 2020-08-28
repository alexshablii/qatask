package search;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.MenuTopNav;
import pageobjects.SearchPanel;
import pageobjects.SearchResults;

public class WebsiteSearchStepdefs {

    private WebDriver driver;

    private HomePage homePage;
    private MenuTopNav menuTopNav;
    private SearchPanel searchPanel;
    private SearchResults searchResults;

    private String expectedSearchResult;
    private String expectedHighlightedGroup;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        menuTopNav = new MenuTopNav(driver);
        searchPanel = new SearchPanel(driver);
        searchResults = new SearchResults(driver);
    }


    @Given("the Search panel is open")
    public void theSearchPanelIsOpen() {
        driver.get("https://www.wexinc.com/");
        homePage.waitForPageIsLoaded();
        menuTopNav.openSearchPanel();
        searchPanel.waitForPanelIsLoaded();
    }

    @And("user types search keywords {string}")
    public void userTypesSearchKeywords(String keywords) {
        searchPanel.typeKeyword(keywords);
        expectedSearchResult = keywords;
    }

    @When("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {
        searchPanel.submit();
    }

    @Then("the Search WEX page is open")
    public void theSearchWEXPageIsOpen() {
        searchResults.waitForPageIsLoaded();
        Assert.assertEquals(searchResults.getHeader(), "Search WEX");
    }

    @And("the search result is relevant")
    public void theSearchResultIsRelevant() {
        for (WebElement item : searchResults.getSearchItems()) {
            Assert.assertTrue(item.getText().toLowerCase().contains(expectedSearchResult), "The search item is not relevant");
        }
    }

    @Then("the {string} message is displayed")
    public void theMessageIsDisplayed(String message) {
        searchResults.waitForPageIsLoaded();
        Assert.assertEquals(searchResults.getNoResultMessage(), message);
    }

    @When("user selects {string} group from the dropdown menu")
    public void userSelectsGroupFromTheDropdownMenu(String group) {
        searchPanel.selectGroup(group);
        expectedHighlightedGroup = group;
    }

    @And("the selected group is highlighted on the menu")
    public void theSelectedGroupIsHighlightedOnTheMenu() {
        Assert.assertEquals(searchResults.getHighlightedTab(), expectedHighlightedGroup);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
