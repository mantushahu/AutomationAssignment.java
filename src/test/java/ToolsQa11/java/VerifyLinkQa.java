package ToolsQa11.java;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;

public class VerifyLinkQa {
    WebDriver driver=new ChromeDriver();
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]")).click();
    }

    @Test
    public void testLink() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
        driver.findElement(By.id("firstName")).sendKeys("mahendra");
        driver.findElement(By.id("lastName")).sendKeys("Sunar");
        driver.findElement(By.id("userEmail")).sendKeys("name@example.com");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9868754562");
        WebElement element=driver.findElement(By.id("dateOfBirthInput"));
        String dateVal="28 Aug 1993";
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].value=arguments[1]", element, dateVal);
        Thread.sleep(3000);
        WebElement subject=driver.findElement(By.xpath("//*[@id=\"subjectsInput\"]"));
        subject.sendKeys("Accounting");
        Thread.sleep(3000);
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]")).sendKeys("C:\\Users\\user\\Desktop\\rusell.jpg");
        driver.findElement(By.id("currentAddress")).sendKeys("Dallas, texas");
        WebElement address=driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));
                address.sendKeys("Uttar");
                address.sendKeys(Keys.ARROW_DOWN);
                address.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement city=driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
                city.sendKeys("Locknow");
                city.sendKeys(Keys.ARROW_DOWN);
                city.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        String actualResult=driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]")).getText();
        driver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]")).click();
        Thread.sleep(3000);
//        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
//        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Assert.assertEquals(actualResult,"Thanks for submitting the form");
    }
}
