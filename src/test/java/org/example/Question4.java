package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question4 {
    @Test
    public void verifyCartBtn(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=search");
        String findText=driver.findElement(By.xpath("//span[text()='(empty)']")).getText();
        String expected="(empty)";
        Assert.assertEquals(findText,expected);
    }

    @Test
    public void verifyCartPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=search");
        String expectedHead="SHOPPING-CART SUMMARY";
        String expected="Your shopping cart is empty.";
        driver.findElement(By.xpath("//span[text()='(empty)']")).click();
        Thread.sleep(3000);
        String findPageHead=driver.findElement(By.xpath("//*[@id=\"cart_title\"]")).getText();
        Thread.sleep(3000);
        String findText=driver.findElement(By.xpath("//p[text()='Your shopping cart is empty.']")).getText();
       Assert.assertEquals(findPageHead,expectedHead);
        Assert.assertEquals(findText,expected);

    }
}
