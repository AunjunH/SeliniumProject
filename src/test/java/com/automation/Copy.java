package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Copy {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.co.uk/");
        Thread.sleep(2000);

        //type Tv in search box
        WebElement search = driver.findElement(By.id("gh-ac"));
        search.sendKeys("Tv" + Keys.ENTER);
        Thread.sleep(10000);

        //---------------------------------------------------------------------------------
        //looping TVs
        List<WebElement> listOfTvs = driver.findElements(By.xpath("//span[@class='s-item__watchheart at-corner s-item__watchheart--watch']/ancestor::li//h3"));
        int counter=1;
        for (WebElement Tv : listOfTvs) {
            try {
                System.out.println("item =" + Tv.getText());
                Tv.click();
            } catch (Exception e) {
                System.out.println("Item not available");
                continue;
            }
            //handling list of windows
            String originalWindow = driver.getWindowHandle();
            Set<String> listOfWindows = driver.getWindowHandles();
            for (String window : listOfWindows) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                }
            }
            //passing contact information
            List<WebElement> sellerInfo = new ArrayList<>();
            try {
                WebElement contactInfo = driver.findElement(By.xpath("//span[text()='Show contact information']"));
                contactInfo.click();
                sellerInfo = driver.findElements(By.xpath("//div[@class='ux-expandable-textual-display-block-details__items']"));
            } catch (Exception e) {
                System.out.println("sorry!! seller information not available");
            }
            if (!sellerInfo.isEmpty()) {
                for (WebElement information : sellerInfo) {
                    System.out.println(information.getText());
                }
            }
            System.out.println("== THIS IS RECORD# " + counter++ + " =========================================================");
            driver.close();
            driver.switchTo().window(originalWindow);


        } // end loop for items
        driver.quit();
    }

}



