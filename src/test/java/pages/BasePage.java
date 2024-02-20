package pages;

import engine.config.reader.ConfigReader;
import enums.CategoryMenuButton;
import enums.FooterHyperLink;
import enums.NavbarButton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    protected final String navbarXpath = "//div[@role='navigation']";
    protected final String categoryMenuXpath = "//section[@id='categorymenu']";
    protected final String footersocialXpath = "//section[@class='footersocial']";
    protected final String footerlinksXpath = "//section[@class='footerlinks']";
    public By searchInputLocator = By.xpath("//input[@id='filter_keyword']");
    public By searchButtonLocator = By.xpath("//i[@class='fa fa-search']");
    public By loginAndRegisterButtonLocator = By.xpath("//div[@class='navbar']//a");
    public By homeLinkByLogoLocator = By.xpath("//a[@class='logo']");
    public By currencyDropdownLocator = By.xpath("//ul[contains(@class, 'currency')]/parent::*");
    public By itemsInCartDropDownLocator = By.xpath("//ul[contains(@class, 'topcartopen')]/parent::*");
    public By newsletterInputLocator = By.xpath(footersocialXpath + "//input[@id='appendedInputButton']");
    public By newsletterButtonLocator = By.xpath(footersocialXpath + "//button[@class='btn btn-orange']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int baseWaitInSeconds = Integer.parseInt(ConfigReader.getProperty(ConfigReader.PropertyKeys.BASE_WAIT_IN_SECONDS));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(baseWaitInSeconds));
        this.baseUrl = ConfigReader.getProperty(ConfigReader.PropertyKeys.BASE_URL);
    }

    public By buttonNavbarLocatorByDataId(NavbarButton button) {
        return By.xpath(navbarXpath + "//li[@data-id='"+ button.getDataId() +"']//span[@class='menu_text']");
    }

    public By buttonCategoryMenuLocatorByText(CategoryMenuButton button) {
        return By.xpath(categoryMenuXpath + "//a[contains(text(), '" + button.getText() + "')]");
    }

    public By hyperLinkFooterLocatorByText(FooterHyperLink link) {
        return By.xpath(footerlinksXpath + "//a[text()='" + link.getText() + "']");
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void clickOnElement(By locator) {
        locateElement(locator).click();
    }

    public void scrollToElement(By locator) {
        WebElement element = locateElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void hoverOverElement(By locator) {
        WebElement element = locateElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void selectCheckbox(By locator) {
        WebElement element = locateElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void deselectCheckbox(By locator) {
        WebElement element = locateElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void selectRadioButton(By locator) {
        WebElement element = locateElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void setCheckboxState(By locator, boolean state) {
        WebElement element = locateElement(locator);
        if (element.isSelected() != state) {
            element.click();
        }
    }

    public void sendKeysToElement(By locator, String text) {
        locateElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator) {
        return locateElement(locator).getText();
    }

    public String getAttributeFromElement(By locator, String attribute) {
        return locateElement(locator).getAttribute(attribute);
    }

    public String getTagNameFromElement(By locator) {
        return locateElement(locator).getTagName();
    }

    public void clearTextFromElement(By locator) {
        locateElement(locator).clear();
    }
    public void clearAndType(By locator, String text) {
        clearTextFromElement(locator);
        sendKeysToElement(locator, text);
    }

    public boolean isElementDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
    }

    public boolean isElementDisplayedAfterWait(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected WebElement locateElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}