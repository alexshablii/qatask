package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTopNav extends BasePageObject {

    By menuSearch = By.xpath("//ul[@id='mega-menu-wex-top-nav']//a[text()=' Search']");

    public MenuTopNav(WebDriver driver) {
        super(driver);
    }

    public void openSearchPanel() {
        waitForClickableOf(menuSearch);
        click(menuSearch);
    }
}
