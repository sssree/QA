//package test;
//
//import io.github.bonigarcia.wdm.DriverManagerType;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class localtimeTest {
//    WebDriver webDriver;
//
//    @BeforeClass(description = "open browser")
//    public void google() {
//        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
//        webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        webDriver.get("https://savvytime.com/local");
//
//    }
//    @Test(description = "search a place",priority = 1)
//    public void test(){
//        webDriver.findElement(By.id("place-search")).sendKeys("India");
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        webDriver.findElement(By.className("list-group-item")).sendKeys("India");
//        List<WebElement> elements = webDriver.findElements(By.xpath("//a[@class='list-group-item']//a"));
//        elements.get(0).click();
//    }
//
//}
