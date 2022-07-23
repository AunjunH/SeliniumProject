package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Hw3 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://ebay.com");
        Thread.sleep(3000);
        WebElement search=driver.findElement(By.xpath("//input[@id='gh-ac']"));
        search.sendKeys("Tv"+ Keys.ENTER);
        //search.click();

        List<WebElement>link=driver.findElements(By.xpath("//span[@class='s-item__watchheart-icon']/ancestor::li//h3[2]"));
        search.click();


    }
}
