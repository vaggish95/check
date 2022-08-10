package ru.open;

import Pages.*;
import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenBankTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"'Открытие', 'Банк Открытие: Частным клиентам'"})
    public void bankTest (String word, String expectedResult){
        chromeDriver.get("https://www.google.com/");

        GoogleSearchPage searchPage = new GoogleSearchPage(chromeDriver);
        GoogleResultPage resultPage = new GoogleResultPage(chromeDriver);
        OpenBankPage openBankPage = new OpenBankPage(chromeDriver);

        searchPage.find(word);
        resultPage.findTitleByTextAndClick(expectedResult);

         //Ищем элемент "Соглашение о кукис" и если он есть нажимаем его.
        List<WebElement> cookies= chromeDriver.findElements(By.xpath("//*[@class = 'ant-btn ant-btn-round ant-btn-sm cookies-agreement__agree-button']"));
        if (!cookies.isEmpty()) {
            cookies.get(0).click();
        }

        // Методы, которые работают с WebElement на статнице сайта Открытие (поиск данных о курсах валют)
        boolean conditionForDollar = openBankPage.compareSellAndBuyPrices(Currencies.USD.toString());
        boolean conditionForEuro = openBankPage.compareSellAndBuyPrices(Currencies.EUR.toString());

        Assertions.assertTrue(conditionForDollar && conditionForEuro, "Курс продажи меньше курса покупки");

    }
}
