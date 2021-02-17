package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class xlReader15 {
    @Test
    public void excelReader() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        File file=new File("C:\\Users\\user\\Desktop\\HTML\\Project1.xlsx");
        FileInputStream ip=new FileInputStream(file);
        Workbook workbook=new XSSFWorkbook(ip);
        Sheet sheet=workbook.getSheet("Case1");
        Cell url=sheet.getRow(1).getCell(1);
        Cell username=sheet.getRow(1).getCell(2);
        Cell password=sheet.getRow(1).getCell(3);
        driver.get(url.getStringCellValue());
        driver.findElement(By.id("identifierId")).sendKeys(username.getStringCellValue());
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div")).click();
        driver.findElement(By.xpath("hiddenPassword")).sendKeys(password.getStringCellValue());
        driver.findElement(By.xpath("")).click();

        driver.close();
    }
}
