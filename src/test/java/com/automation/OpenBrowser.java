package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static java.lang.System.*;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
// type tv on search button
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("Tv"+ Keys.ENTER);

        List<WebElement>listofWebeliment =driver.findElements(By.xpath("//span[@class='s-item__price']"));
        for(WebElement ele : listofWebeliment){
            System.out.println(ele.getText());
        }
       // WebElement searchButton=driver.findElement(By.id("gh-btn"));
        //searchButton.click();
        driver.close();
    }
}

