package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    By header = By.xpath("//div[@class='hero-content']/h1");
    By bigTopicMenuHeader = By.id("BlogTopicMenu");
    By categoryMenu = By.xpath("//nav[@class='wex-category-menu']/ul");
    By categoryMenuItem = By.xpath("//nav[@class='wex-category-menu']/ul/li/a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageIsLoaded() {
        waitForVisibilityOf(header);
        waitForVisibilityOf(bigTopicMenuHeader);
        waitForVisibilityOf(categoryMenu);
        waitForClickableOf(categoryMenuItem);
    }
}
