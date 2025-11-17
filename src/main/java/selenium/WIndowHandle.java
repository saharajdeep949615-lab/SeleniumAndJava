package selenium;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowHandle {
    public static void windowHandle(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='blinkingText']")).click();
        Thread.sleep(2000);
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentID=it.next();
        String childId=it.next();
        driver.switchTo().window(childId);
        String emailID=driver.findElement(By.xpath("//*[@class='im-para red']")).getText().split("at")[1].split("with")[0].trim();
        System.out.println("emailID="+emailID);
        driver.switchTo().window(parentID);
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(emailID);
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        windowHandle(driver);
    }
}