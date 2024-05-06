package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

import static enums.Currency.convertCurrencyFromCookie;

public class TotalsTable {
    public final String totalsTable = "//table[@id='totals_table']";
    public By subTotalLocator = By.xpath(totalsTable + "/tbody/tr[1]/td[2]");
    public By flatShippingRateLocator = By.xpath(totalsTable + "/tbody/tr[2]/td[2]");
    public By totalLocator = By.xpath(totalsTable + "/tbody/tr[3]/td[2]");
    protected BasePage basePage;

    public BigDecimal getSubTotalPrize() {
        return convertCurrencyFromCookie(getSubTotalText());
    }

    public BigDecimal getFlatShippingRatePrize() {
        return convertCurrencyFromCookie(getFlatShippingRateText());
    }

    public BigDecimal getTotalPrize() {
        return convertCurrencyFromCookie(getTotalText());
    }

    private String getSubTotalText() {
        return basePage.getTextFromElement(subTotalLocator);
    }

    private String getFlatShippingRateText() {
        return basePage.getTextFromElement(flatShippingRateLocator);
    }

    private String getTotalText() {
        return basePage.getTextFromElement(totalLocator);
    }
}