package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VerifyNewsletter {

    public boolean checkNews(String email) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?");
        String msg="Already register";
        driver.findElement(By.name("email")).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@name='submitNewsletter']")).click();
        String invalidText=driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText();
        String successText=driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText();
        if(invalidText.equals(" Newsletter : Invalid email address.")) {
            return false;}
        else return successText.equals("Newsletter : You have successfully subscribed to this newsletter.");
    }
    @Test
    public void testNewsletter() throws IOException, InterruptedException {

        Assert.assertFalse(checkNews("without @ or .com"));
        //Thread.sleep(5000);
        //Assert.assertTrue(checkNews("jam@gmail.com"));
    }
}
