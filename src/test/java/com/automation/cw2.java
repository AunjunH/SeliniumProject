package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cw2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);

        WebElement element=driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        element.click();

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hosna Aunjun");
        System.out.println(alert.getText());



    }
}
