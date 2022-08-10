package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenBankPage {

    protected WebDriver chromeDriver;

    public OpenBankPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public boolean compareSellAndBuyPrices (String currency) {
        boolean sellPriceIsHigher = false;
        List <WebElement> elements = chromeDriver.findElements(By.xpath(".//*[@class = 'CurrencyExchangeRow_currency-exchange-item__r26Uu']"));
        for (WebElement element : elements) {
            if (element.getText().contains(currency)) {
                List <WebElement> currencyDetails = element.findElements(By.xpath("./div[@class = 'CurrencyExchangeItem_currency-exchange-item-wrapper__b_tuv']"));
                float SellPrice = Float.parseFloat(currencyDetails.get(findSellPositionInTable()).getText());
                float BuyPrice = Float.parseFloat(currencyDetails.get(findBuyPositionInTable()).getText());
                if (SellPrice > BuyPrice) {
                    sellPriceIsHigher = true;
                }
            }
        }
        return sellPriceIsHigher;
    }

    private int findSellPositionInTable () {
        int position = -1;
        WebElement tableHeader = chromeDriver.findElement(By.xpath("//div[@class = 'CurrencyExchangeFilterContentHeader_currency-exchange-filter-content-title-wrapper__G8_l_']"));
        List<WebElement> headerFields = tableHeader.findElements(By.xpath("./span[@class ='open-ui-text open-ui-text-theme-light s-size CurrencyExchangeFilterContentHeader_currency-exchange-filter-content-title__JIyde']"));
        for (WebElement field : headerFields) {
            if (field.getText().contains("Банк продает")) {
                position = headerFields.indexOf(field);
            }
        }
        return position;
    }

    private int findBuyPositionInTable () {
        int position = -1;
        WebElement tableHeader = chromeDriver.findElement(By.xpath("//div[@class = 'CurrencyExchangeFilterContentHeader_currency-exchange-filter-content-title-wrapper__G8_l_']"));
        List<WebElement> headerFields = tableHeader.findElements(By.xpath("./span[@class ='open-ui-text open-ui-text-theme-light s-size CurrencyExchangeFilterContentHeader_currency-exchange-filter-content-title__JIyde']"));
        for (WebElement field : headerFields) {
            if (field.getText().contains("Банк покупает")) {
                position = headerFields.indexOf(field);
            }
        }
        return position;
    }




}
