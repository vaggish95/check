package core;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class BaseTest {

        protected WebDriver chromeDriver;

        @BeforeEach
        public void before(){
            System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/chromedriver");
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().window();
            chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }





    }


