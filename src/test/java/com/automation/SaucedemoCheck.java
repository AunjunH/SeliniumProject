package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaucedemoCheck {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement getProduct = driver.findElement(By.className("inventory_item_name"));
        getProduct.click();

        List<WebElement> productInfo = driver.findElements(By.id("inventory_item_container"));
        for (WebElement element : productInfo) {
            System.out.println(element.getText());


            Thread.sleep(2000);

            WebElement addcart = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            addcart.click();

            Thread.sleep(2000);


            WebElement cartList = driver.findElement(By.className("shopping_cart_link"));
            cartList.click();
            Thread.sleep(1000);

            WebElement checkout = driver.findElement(By.id("checkout"));
            checkout.click();

            Thread.sleep(1000);

            // Checkout information
            WebElement Firstname = driver.findElement(By.id("first-name"));

            Firstname.sendKeys("Hosna");

            Thread.sleep(1000);

            WebElement Lastname = driver.findElement(By.id("last-name"));
            Lastname.sendKeys("Aunjun");

            Thread.sleep(1000);

            WebElement zipcode = driver.findElement(By.id("postal-code"));
            zipcode.sendKeys("12345");

            Thread.sleep(1000);

            WebElement Continue = driver.findElement(By.id("continue"));
            Continue.click();

            // System.out.println("*** Payment and price information ***");
            //WebElement elements=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));


            Thread.sleep(2000);



        }

        driver.close();

    }
}

