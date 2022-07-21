package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");

        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.com");
        //Create web element where we have select tag.
        WebElement catagoryDropdown= driver.findElement(By.id("gh-cat"));

        //Wrap web element wit select class methods.

        Select catDropdownSelect=new Select(catagoryDropdown);
        catDropdownSelect.selectByValue("11116");
        Thread.sleep(3000);

        catDropdownSelect.selectByVisibleText("Baby");
        Thread.sleep(3000);

        catDropdownSelect.selectByIndex(5);
        Thread.sleep(3000);

        List<WebElement> option=catDropdownSelect.getOptions();

        for(WebElement ele: option) {
            System.out.println(ele.getText());

        }
        driver.close();
    }
}
