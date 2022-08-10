package com.google;

import core.BaseTest;
import Pages.GoogleResultPage;
import Pages.GoogleSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"Гладиолус"})
    public void gladiolusTest (String word){
        chromeDriver.get("https://www.google.com/");
        GoogleSearchPage searchPage = new GoogleSearchPage(chromeDriver);
        GoogleResultPage resultPage = new GoogleResultPage(chromeDriver);
        searchPage.find(word);
        List <WebElement> searchResult =  resultPage.getResult();
        Assertions.assertTrue(searchResult.stream().anyMatch( x->x.getText().contains("wikipedia.org")),
                "В выводе нет ссылки на wikipedia.org");
    }

    }







