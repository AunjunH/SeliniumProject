package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SaucedemoCheck {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");

        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("problem_user");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

        WebElement getProduct=driver.findElement(By.className("inventory_item_name"));
        getProduct.click();

        List<WebElement>productInfo=driver.findElements(By.id("inventory_item_container"));
        for(WebElement element:productInfo){
            System.out.println(element.getText());

            WebElement addcart=driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            addcart.click();

            WebElement cartList=driver.findElement(By.className("shopping_cart_link"));
            cartList.click();

           // WebElement checkcart=driver.findElement(By.xpath("shopping_cart_badge"));
           // checkcart.click();

        }








    }

}
