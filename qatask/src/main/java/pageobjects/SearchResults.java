package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults extends BasePageObject {

    By header = By.xpath("//div[@class='hero-content']/h1");
    By bottomMenu = By.id("buttonMenu");
    By noResultMessage = By.xpath("//p[@class='lead']");
    By searchItem = By.xpath("//div[contains(@class, 'wex-search-item')]");
    By searchItemTitle = By.xpath("//h4/a");
    By highlightedTab = By.xpath("//li[contains(@class, 'is-active')]/a");

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public void waitForPageIsLoaded() {
        waitForVisibilityOf(header);
        waitForVisibilityOf(bottomMenu);
    }

    public String getNoResultMessage() {
        waitForVisibilityOf(noResultMessage);
        return getText(noResultMessage);
    }

    public String getSearchItemTitle() {
        return getText(searchItemTitle);
    }

    public String getSearchItemPreview() {
        return getText(searchItem);
    }

    public String getHighlightedTab() {
        waitForVisibilityOf(bottomMenu);
        return getText(highlightedTab);
    }

    public String getHeader() {
        return getText(header);
    }

    public List<WebElement> getSearchItems() {
        return findElements(searchItem);
    }
}
