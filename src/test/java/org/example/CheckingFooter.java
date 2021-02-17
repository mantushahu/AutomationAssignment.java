package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CheckingFooter {
    @Test
    public void verifyFooter() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.get("http://automationpractice.com/index.php?controller=search");
       String expectedHead="Manage my customer account";
      String footerHead=driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[5]/h4/a")).getAttribute("title");
        List<String> expectedArr=new LinkedList<>(Arrays.asList("My orders","My credit slips","My addresses","My personal info"));
        List<WebElement> footers=driver.findElements(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li/a"));
        List<String> actualList=new ArrayList<>();
    for(WebElement footer:footers){
        actualList.add(footer.getText());
    }
        System.out.println(actualList);
        Assert.assertEquals(footerHead,expectedHead);
    Thread.sleep(3000);
    Assert.assertEquals(actualList,expectedArr);
    }
}
