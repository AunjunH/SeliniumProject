package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class MultipleWindowHandling {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");

        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com");


        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("TV" + Keys.ENTER);
        Thread.sleep(3000);
        // Click on first link
        WebElement link = driver.findElement(By.xpath("(//span[@class='s-item__watchheart-icon']/ancestor::li//h3)[1]"));
        link.click();
        Thread.sleep(3000);
        // Return current window id
        String originalWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        // Retrieve list of window
        Set<String> listOfWindow = driver.getWindowHandles();
        Thread.sleep(2000);
        // Switch to new Window
        for(String window : listOfWindow){
            if(!window.equals(originalWindow)){
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(3000);
        // Retrieve price from new window
        WebElement price = driver.findElement(By.id("prcIsum"));
        Thread.sleep(2000);
        System.out.println(price.getText());
        Thread.sleep(3000);
        // Close new window
        driver.close();
        Thread.sleep(2000);
        // Switch to original window
        driver.switchTo().window(originalWindow);
        Thread.sleep(3000);
    }
}

















