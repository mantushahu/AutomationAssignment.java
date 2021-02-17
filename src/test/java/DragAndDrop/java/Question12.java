package DragAndDrop.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Question12 {
    WebDriver driver=new ChromeDriver();
    Actions action=new Actions(driver);
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        ((JavascriptExecutor)driver).executeScript("scroll(0,800)");
    }
    @Test
    public void testDragDrop() throws InterruptedException {
        WebElement box = driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        String expDebit = "0";
        String expCredit = "0";
        action.dragAndDrop(box, target).release().build().perform();
        Thread.sleep(3000);
        String amountDebit = driver.findElement(By.xpath("//*[@id=\"t7\"]")).getText();
        String amountCredit = driver.findElement(By.xpath("//*[@id=\"t8\"]")).getText();
        Assert.assertEquals(amountDebit, expDebit);
        Assert.assertEquals(amountCredit, expCredit);
        WebElement box1 = driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
        WebElement target1 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        action.dragAndDrop(box1, target1).release().build().perform();
        Thread.sleep(2000);
        String amountDebit1 = driver.findElement(By.xpath("//*[@id=\"t7\"]")).getText();
        String amountCredit1 = driver.findElement(By.xpath("//*[@id=\"t8\"]")).getText();
        String expDebit1 = "5000";
        String expCredit1 = "0";
        Thread.sleep(2000);
        Assert.assertEquals(amountDebit1, expDebit1);
        Assert.assertEquals(amountCredit1, expCredit1);
    }

@Test
        public void test2() throws InterruptedException {
        WebElement box4=driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
        WebElement target4= driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        String expDebit4="0";
        String expCredit4="0";
        action.dragAndDrop(box4,target4).release().build().perform();
        Thread.sleep(3000);
        String amountDebit4=driver.findElement(By.xpath("//*[@id=\"t7\"]")).getText();
        String amountCredit4=driver.findElement(By.xpath("//*[@id=\"t8\"]")).getText();
        Assert.assertEquals(amountDebit4,expDebit4);
        Assert.assertEquals(amountCredit4,expCredit4);
        WebElement box5=driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
        WebElement target5= driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        action.dragAndDrop(box5,target5).release().build().perform();
        Thread.sleep(2000);
        String amountDebit5=driver.findElement(By.xpath("//*[@id=\"t7\"]")).getText();
        String amountCredit5=driver.findElement(By.xpath("//*[@id=\"t8\"]")).getText();
        String expDebit5="0";
        String expCredit5="5000";
        Thread.sleep(2000);
        Assert.assertEquals(amountDebit5,expDebit5);
        Assert.assertEquals(amountCredit5,expCredit5);

    }
   @Test
    public void verifyPerfectBtn() throws InterruptedException {
       WebElement box = driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
       WebElement target = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
       action.dragAndDrop(box, target).release().build().perform();
       Thread.sleep(3000);
       WebElement box1 = driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
       WebElement target1 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
       action.dragAndDrop(box1, target1).release().build().perform();
       Thread.sleep(2000);
       WebElement box4=driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
       WebElement target4= driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
       action.dragAndDrop(box4,target4).release().build().perform();
       Thread.sleep(3000);
       String expectedText="Perfect!";
       WebElement box5=driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
       WebElement target5= driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
       action.dragAndDrop(box5,target5).release().build().perform();
       String actualText=driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText();
       Thread.sleep(2000);
       Assert.assertEquals(actualText,expectedText);


   }
}
