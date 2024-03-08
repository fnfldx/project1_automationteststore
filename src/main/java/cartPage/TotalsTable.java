package cartPage;

import org.openqa.selenium.By;

public class TotalsTable {

    public final String totalsTable = "//table[@id='totals_table']";

    public By subTotalLocator = By.xpath(totalsTable + "//tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(totalsTable + "//tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(totalsTable + "//tbody/tr[3]/td[2]/span");


}
