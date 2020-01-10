package com.test;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.SocketOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    WebDriver webDriver;

    @BeforeClass(description = "open browser")
    public void google() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement actualele;
        webDriver.get("https://savvytime.com/converter");
    }

    @Test
    public  void verify(){
        WebElement element=webDriver.findElement(By.className("title"));
        String foundText=element.getText();
        Assert.assertTrue(foundText.contains("Time Zone Converter"),"incorrect page");
    }

    @Test(priority = 1,description = "first place")
    public void searchp1() {
        webDriver.findElement(By.id("time-search")).sendKeys("Hyderabad");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@id='converter-quick-search-result']//a"));
        elements.get(0).click();
        List<WebElement> k= webDriver.findElements(By.xpath("//a[@class='time-abb']"));
        //  System.out.println(k.get(0).getText());
        Assert.assertTrue(k.get(0).getText().contains("Hyderabad, India"),"done");

    }


    @Test(priority = 2,description = "second place")
    public void searchp2() {
        webDriver.findElement(By.id("time-search")).sendKeys("Atlanta");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@id='converter-quick-search-result']//a"));
        elements.get(0).click();
      List<WebElement> k= webDriver.findElements(By.xpath("//a[@class='time-abb']"));
      //System.out.println(k.get(1).getText());
       Assert.assertTrue(k.get(1).getText().contains("Atlanta, Georgia, USA"),"done");
    }

    @Test(description = "swapping",priority = 3)
    public void swap() {
        List<WebElement> beforeList= webDriver.findElements(By.xpath("//a[@class='time-abb']"));
        List<String> bs=new ArrayList<String>();
        for (WebElement webElement:beforeList)
        {
            bs.add(webElement.getText());
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[@class='swap-tz btn']")).click();

        List<WebElement> afterList= webDriver.findElements(By.xpath("//a[@class='time-abb']"));
        List<String> as=new ArrayList<String>();
        for (WebElement webElement:afterList) {
        as.add(webElement.getText());
        }
        Collections.reverse(as);
        Assert.assertEquals(as,bs);
        //  Assert.assertEquals(beforeList.get(1).getText(),afterList.get(0).getText());
        //  System.out.println(beforeList.get(0).getText());
        // Assert.assertTrue(equals(beforeList.get(1).getText())==equals(afterList.get(0).getText()));
    }

    @Test(description = "deleting",priority = 4)
    public void delete() {
        List<WebElement> elements=webDriver.findElements(By.xpath("//div[@class='table-time row']"));
        int a=elements.size();
        webDriver.findElement(By.xpath("//div[@data-id='ga-atlanta']")).click();
        webDriver.findElement(By.xpath("//a[@class='delete-btn btn']")).click();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   List<WebElement> afterElement=webDriver.findElements(By.xpath("//div[@class='table-time row']"));
   int b= afterElement.size();
   Assert.assertEquals(a,b+1);
       // Assert.assertTrue(.contains("Time Zone convert"),"Expected Time Zone converter");
    }

    @Test(description = "Selecting Hyperlink",priority = 5)
    public void selection() {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[@class='time-abb']")).click();
    }

    @Test(priority = 6)
    public void quit() {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.close();
    }

}


