package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Youtube {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.youtube.com/");

        WebElement searchbutton=driver.findElement(By.xpath("//input[@id='search']"));
        searchbutton.sendKeys("Chirag khimani");
        searchbutton.click();
        Thread.sleep(4000);

        WebElement search=driver.findElement(By.xpath("//ytd-masthead/div[@id='container']/div[@id='center']/ytd-searchbox[@id='search']/button[@id='search-icon-legacy']/yt-icon[1]"));
        search.click();

      // WebElement item=driver.findElement(By.xpath("//Iframe[@name='passive_signin']"));
      // item.click();
        //item.click();

       // driver.close();



    }
}
