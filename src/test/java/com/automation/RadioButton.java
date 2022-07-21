package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {
    public static void main(String[] args) {

        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        WebElement locatedRadioBtn = driver.findElement(By.id("LH_Located"));
        System.out.println(locatedRadioBtn.isSelected());

        locatedRadioBtn.click();

        System.out.println(locatedRadioBtn.isSelected());

        driver.quit();



    }
}
