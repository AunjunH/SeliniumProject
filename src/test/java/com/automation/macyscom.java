package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class macyscom {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.macys.com/");
        Thread.sleep(1000);
        WebElement menu=driver.findElement(By.xpath("//span[normalize-space()='Women']"));
        menu.click();
        WebElement item= driver.findElement(By.xpath("//div[@class='accordion active']//h5[@role='button']"));
        item.click();
        WebElement plustSign=driver.findElement(By.xpath("//div[@class='accordion-header-icon icon-ui-plus-gr-small']"));

        //List<WebElement>items=driver.findElements()


    }
}
