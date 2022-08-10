package ru.yandex;

import core.BaseTest;
import Pages.WikipediaPage;
import Pages.YandexSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

public class YandexTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"'таблица', 'Таблица — Википедия'"})
    public void tableTest (String word, String title){
        chromeDriver.get("https://yandex.ru");

        WikipediaPage wikipediaPage = new WikipediaPage(chromeDriver);
        YandexSearchPage yandexSearchPage = new YandexSearchPage(chromeDriver);

        yandexSearchPage.find(word);
        String href = yandexSearchPage.findTitlesHref(title);
        chromeDriver.get(href);
        int tablesLastElementNumber = wikipediaPage.findTable().size();
        boolean firstLine =  chromeDriver.findElement(By.xpath(".//caption[contains(text(), 'Преподаватели кафедры программирования')]/following-sibling::tbody/child::tr[2]")).getText().contains("Сергей Владимирович");
        boolean lastLine =  chromeDriver.findElement(By.xpath(".//caption[contains(text(), 'Преподаватели кафедры программирования')]/following-sibling::tbody/child::tr[" + tablesLastElementNumber +"]")).getText().contains("Сергей Адамович");

        Assertions.assertTrue(firstLine && lastLine, "Порядок имен в таблице не соответствует заданному");




    }
}
