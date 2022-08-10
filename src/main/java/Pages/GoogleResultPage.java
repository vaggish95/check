package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleResultPage extends GoogleSearchPage{

    private List<WebElement> result;
    WebDriverWait wait;

    public GoogleResultPage(WebDriver chromeDriver) {
        super(chromeDriver);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(120));
    }

    public List <WebElement> getResult() {
        result = chromeDriver.findElements(By.xpath("//*[@id=\"rso\"]/div[*]"));
        return result;
    }

    public void findTitleByTextAndClick (String text) {
        WebElement element = chromeDriver.findElement(By.xpath("//h3[text()='" +text + "']"));
        element.click();
    }

}
