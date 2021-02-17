package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ScreenShot13 {
    WebDriver driver=new ChromeDriver();
    @Test
    public void loginScreenShot() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.gmail.com");
       // Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[text()='Use another account']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("qatesting00567@gmail.com");
        takeShot();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div")).click();
        Thread.sleep(3000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("Test@123");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div")).click();
        Thread.sleep(3000);
        String errText=driver.findElement(By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']")).getText();
        Thread.sleep(3000);
        if(errText.equals("Wrong password. Try again or click Forgot password to reset it.")){
        takeShot();}
        Thread.sleep(3000);
        takeShot();
        driver.close();
    }
    public void takeShot() throws IOException {
        Random r=new Random();
        int fileName=r.nextInt(100);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File save = new File("C:\\Users\\user\\IdeaProjects\\AutomationAssignment.java\\src\\test\\java\\org"+ fileName + ".jpg");
        FileUtils.copyFile(file,save);
    }
    @Test
    public void loginFailer() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.gmail.com");
        // Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[text()='Use another account']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("qatesting00567@gmail.com");
        takeShot();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div")).click();
        Thread.sleep(3000);
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("Test@124");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div")).click();
        Thread.sleep(3000);
        String errText=driver.findElement(By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']")).getText();
        Thread.sleep(3000);
        if(errText.equals("Wrong password. Try again or click Forgot password to reset it.")){
            takeShot();}
        Thread.sleep(3000);
        takeShot();
        driver.close();
    }

    }

