package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPanel extends BasePageObject {

    By closeLink = By.xpath("//div[@id='wex-searchPanel']//a[text()=' Close']");
    By groupFilter = By.xpath("//select[@class='wex-search-group-filter']");
    By searchInput = By.xpath("//input[@id='s']");
    By submitButton = By.xpath("//button[@type='submit']");

    public SearchPanel(WebDriver driver) {
        super(driver);
    }

    public void waitForPanelIsLoaded() {
        waitForVisibilityOf(closeLink);
        waitForVisibilityOf(searchInput);
    }

    public void selectGroup(String group) {
        waitForVisibilityOf(groupFilter);
        click(groupFilter);
        selectByVisibleText(group, groupFilter);
    }

    public void typeKeyword(String keyword) {
        waitForVisibilityOf(searchInput);
        type(keyword, searchInput);
    }

    public void submit() {
        waitForVisibilityOf(submitButton);
        click(submitButton);
    }
}
