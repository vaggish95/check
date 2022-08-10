package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YandexSearchPage {

    protected WebDriver chromeDriver;
    protected WebElement searchField;
    protected WebElement searchButton;

    public YandexSearchPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.searchField = chromeDriver.findElement(By.xpath("//*[@class = 'input__control input__input mini-suggest__input']"));
        this.searchButton = chromeDriver.findElement(By.xpath("//button[@class ='button mini-suggest__button button_theme_search button_size_search i-bem button_js_inited']"));
    }

    public void find (String word){
        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }

    public String findTitlesHref(String text) {
        String href = null;
        List<WebElement> elements = chromeDriver.findElements(By.xpath("//span[@class = 'OrganicTitleContentSpan organic__title']"));
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                 href = element.findElement(By.xpath("./parent::h2/parent::a")).getDomProperty("href");
            }
        }
        return href;
    }
}
