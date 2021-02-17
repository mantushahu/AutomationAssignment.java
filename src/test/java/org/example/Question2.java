package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question2 {
    @Test
    public void test() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=search");
        Thread.sleep(3000);
        WebElement searchBtn= driver.findElement(By.xpath("//input[@id='search_query_top']"));
        searchBtn.sendKeys("Saree");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        Thread.sleep(3000);
        String msg=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
         Assert.assertEquals(msg,"No results were found for your search \"Saree\"");
    }

}
