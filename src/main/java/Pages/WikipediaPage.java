package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WikipediaPage {

    protected WebDriver chromeDriver;
    private List<WebElement> table;

    public WikipediaPage (WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public List <WebElement>  findTable (){
        table = chromeDriver.findElements(By.xpath("//caption[contains(text(), 'Преподаватели кафедры программирования')]/following-sibling::tbody/child::tr"));
        return table;
    }
}
