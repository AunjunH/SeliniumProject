package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClassWork {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(3000);


        //WebElement box=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Thread.sleep(1000);

        WebElement write=driver.findElement(By.xpath("//body/p[1]"));

        write.sendKeys("Hosna Aunjun");
        Thread.sleep(3000);

        driver.close();


    }
}
