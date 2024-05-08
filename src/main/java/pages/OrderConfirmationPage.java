package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage {
    // Locators:
    public By orderConfirmationMessageLocator = By.xpath("//h1[contains(text(), 'YOUR ORDER HAS BEEN PROCESSED')]");
    public By invoicePageHyperlinkLocator = By.xpath("//div[@id='maincontainer']//a[contains(@href,'rt=account/invoice')]");
    public By contactPageHyperlinkLocator = By.xpath("//div[@id='maincontainer']//a[contains(@href,'rt=content/contact')]");
    public By continueButtonLocator = By.xpath("//div[@id='maincontainer']//a[@title='Continue']");
    protected BasePage basePage;

    public OrderConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void navigateToInvoicePage() {
        basePage.clickOnElement(invoicePageHyperlinkLocator);
    }

    public void navigateToContactPage() {
        basePage.clickOnElement(contactPageHyperlinkLocator);
    }

    public void navigateToContinueShopping() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public boolean isOrderConfirmationMessageVisible() {
        return basePage.isElementDisplayed(orderConfirmationMessageLocator);
    }

    public boolean doesOrderConfirmationMessageContainExpectedText() {
        return basePage.getTextFromElement(orderConfirmationMessageLocator).matches(".*YOUR ORDER HAS BEEN PROCESSED.*");
    }
}