package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    protected WebDriver chromeDriver;
    protected WebElement searchField;

    public GoogleSearchPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.searchField = chromeDriver.findElement(By.xpath("//input"));
    }

    public void find (String word){
        searchField.click();
        searchField.sendKeys(word);
        searchField.submit();
    }



}
