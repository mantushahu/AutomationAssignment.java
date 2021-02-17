package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

;

public class ViewImage7 {
    WebDriver driver=new ChromeDriver();
    @BeforeMethod
    public void lunchChrome(){
        WebDriverManager.chromedriver().setup();
        driver.get("http://automationpractice.com/index.php?");
        driver.manage().window().maximize();
    }
    @Test
    public void viewImage() throws InterruptedException {
        //WebDriverWait wait=new WebDriverWait(driver,15,100);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div/div[3]/div/div[2]/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='view_full_size']/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div[1]/a[2]")).click();
       /* WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product']/div[2]/div/div[1]/a[2]"))).click();*/

       for(int i=1;i<=4;i++){
           Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div[1]/a[2]/span")).click();
        }                            //*[@id="product"]/div[2]/div/div/div[1]/a[2]/span
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@title='Close']")).click();

    }
    @After
    public void quitPage(){
        driver.close();
    }
}
