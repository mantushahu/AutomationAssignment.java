package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollBar {

        WebDriver driver=new ChromeDriver();
        @Before
        public void lunchChrome(){
            WebDriverManager.chromedriver().setup();
            driver.get("http://automationpractice.com/index.php?");
            driver.manage().window().maximize();
        }
        @Test
        public void scrollPage() throws InterruptedException {
            ((JavascriptExecutor)driver).executeScript("scroll(0,1200)");
            int target=53;
            int x=245;
            int method=1;
            String expected="$53.00 - $53.00";
            Actions actions=new Actions(driver);
            driver.findElement(By.xpath("//a[@title='Women']")).click();
            Thread.sleep(3000);
            WebElement bar= driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
            Thread.sleep(3000);
            if(method==1){for(int i=1;i<=target;i=i+5){
                actions.dragAndDropBy(bar,i,0).build().perform();
            } } else {
                actions.dragAndDropBy(bar, x,0).build().perform();}

            String actual=driver.findElement(By.id("layered_price_range")).getText();
            Thread.sleep(3000);
            Assert.assertEquals(expected,actual);


        }
    }


