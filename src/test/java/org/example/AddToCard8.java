package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCard8 {
    WebDriver driver=new ChromeDriver();
   @BeforeMethod
   public void lunchChrome(){
       WebDriverManager.chromedriver().setup();
       driver.get("http://automationpractice.com/index.php?");
   }

    @Test
    public void verifyCart() throws InterruptedException {
       String expectedItem="1";
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        String itemAdded=driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(itemAdded,expectedItem);
   }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
   }
}
