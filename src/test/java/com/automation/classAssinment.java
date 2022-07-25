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

public class classAssinment {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.ebay.co.uk/");

        Thread.sleep(1000);
        WebElement search=driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        search.sendKeys("Tv"+ Keys.ENTER);
        Thread.sleep(1000);


        // Looping tv

        List<WebElement> listOfTvs = driver.findElements(By.xpath("//span[@class='s-item__watchheart at-corner s-item__watchheart--watch']/ancestor::li//h3"));
        int count=1;

        for(WebElement tv: listOfTvs){
            try{
                System.out.println("item ="+tv.getText());
                tv.click();
            }catch (Exception e){
                System.out.println("item is not available");
                continue;
            }
            //Handling list of windows

            String originalWindow = driver.getWindowHandle();
            Set<String>numberOfWindow=driver.getWindowHandles();
            for(String window : numberOfWindow){
                if(!window.equals(originalWindow)){
                    driver.switchTo().window(window);
                }
            }
            //Passing contact information
            List<WebElement> sellerInfo= new ArrayList<>();
            try {
                WebElement contactInfo=driver.findElement(By.xpath("//span[text()='Show contact information']"));
                contactInfo.click();
                sellerInfo=driver.findElements(By.xpath("//div[@class='ux-expandable-textual-display-block-details__items']"));

            }catch (Exception e){
                System.out.println("Sorry, seller information not available");
            }if (!sellerInfo.isEmpty()){
                for(WebElement information:sellerInfo){
                    System.out.println(information.getText());
                }
            }
            System.out.println("  The Information of seller number is "+count++);
            driver.close();
            driver.switchTo().window(originalWindow);


        }
        driver.quit();



    }
}
