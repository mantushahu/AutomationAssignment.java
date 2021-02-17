package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartFunctionality {
    WebDriver driver=new ChromeDriver();
    @BeforeMethod
    public void lunchChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("http://automationpractice.com/index.php?");

    }
    @Test
    public void VerifySize() throws InterruptedException {
        String expectedColorSize="Yellow, L";
        String expectedQuantity="3";
        String expectedTotal="$49.20";
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,1400)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/div[2]/a[2]/span")).click();
        driver.findElement(By.xpath("//*[@id='view_full_size']/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Close']")).click();
        for(int i=1;i<3;i++){
            driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")).click();
        }
        Thread.sleep(3000);
        Select sizeOptions=new Select(driver.findElement(By.xpath("//*[@id=\"group_1\"]")));
        sizeOptions.selectByValue("3");
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        Thread.sleep(5000);
        String actualQuantity=driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]")).getText();
        String actualTotal=driver.findElement(By.xpath("//*[@id='layer_cart_product_price']")).getText();
        String actualColorSize=driver.findElement(By.xpath("//*[@id=\"layer_cart_product_attributes\"]")).getText();
        Thread.sleep(5000);
        Assert.assertEquals(actualColorSize,expectedColorSize);
        Assert.assertEquals(actualQuantity,expectedQuantity);
        Assert.assertEquals(actualTotal,expectedTotal);
    }

}
