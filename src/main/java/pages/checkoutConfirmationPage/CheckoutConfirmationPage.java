package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static enums.Currency.convertCurrencyFromCookie;

public class CheckoutConfirmationPage {
    public final String totalsTableXpath = "//div[contains(@class, 'confirm_total')]//table";
    public By subTotalLocator = By.xpath(totalsTableXpath + "/tbody/tr[1]/td[2]");
    public By flatShippingRateLocator = By.xpath(totalsTableXpath + "/tbody/tr[2]/td[2]");
    public By totalLocator = By.xpath(totalsTableXpath + "/tbody/tr[3]/td[2]");
    public By returnPolicyLocator = By.xpath("//div[contains(@class,'contentpanel')]/p/a");
    public By returnPolicyModalLocator = By.id("returnPolicyModal");
    public By closeReturnPolicyModalCrossLocator = By.xpath("//button[@class='close']");
    public By closeReturnPolicyModalButtonLocator = By.xpath("//button[@class='btn']");
    public By backButtonLocator = By.id("back");
    public By confirmOrderButtonLocator = By.id("checkout_btn");
    protected BasePage basePage;

    public CheckoutConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void clickOnReturnPolicy() {
        basePage.clickOnElement(returnPolicyLocator);
    }

    public void clickOnCloseReturnPolicyByCross() {
        basePage.clickOnElement(closeReturnPolicyModalCrossLocator);
    }

    public void clickOnCloseReturnPolicy() {
        basePage.clickOnElement(closeReturnPolicyModalButtonLocator);
    }

    public BigDecimal getSubTotalPrice() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(subTotalLocator));
    }

    public BigDecimal getFlatShippingRatePrice() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(flatShippingRateLocator));
    }

    public BigDecimal getTotalPrice() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(totalLocator));
    }

    public void clickOnBackButton() {
        basePage.clickOnElement(backButtonLocator);
    }

    public void clickOnConfirmOrderButton() {
        basePage.clickOnElement(confirmOrderButtonLocator);
    }

    public boolean isReturnPolicyModalVisible() {
        var style = getWebDriverInstance().findElement(returnPolicyModalLocator).getAttribute("style");
        return !style.contains("display: none");
    }
}