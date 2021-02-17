package QaToolsExercise.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickSimpleAlert {
    WebDriver driver=new ChromeDriver();
    @BeforeMethod
    public void lunchBro(){
        WebDriverManager.chromedriver().setup();
        driver.get("https://demoqa.com/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div")).click();
        WebDriverWait wait=new WebDriverWait(driver,10,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ text()='Alerts'and @class='text']"))).click();
    }
    @Test
    public void simpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
        String expectedText="You clicked a button";
        Alert alert=driver.switchTo().alert();
        String actualAlertText= alert.getText();
        alert.accept();
        Assert.assertEquals(actualAlertText,expectedText);
    }

    @Test
    public void ConfirmAlert() {
        driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
        Alert alert=driver.switchTo().alert();
        String actualAlertText=alert.getText();
        String expectedText="Do you confirm action?";
        alert.dismiss();
        Assert.assertEquals(actualAlertText,expectedText);
    }

    @Test
    public void promptAlert() {
        driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Mahendra sunar");
        alert.accept();
    }
}
