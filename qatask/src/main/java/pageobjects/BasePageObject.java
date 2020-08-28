package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject {

    protected WebDriver driver;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickableOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected void selectByVisibleText(String text, By locator) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);
    }

    protected void type(String text, By locator) {
        findElement(locator).sendKeys(text);
    }
}
