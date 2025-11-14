package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
        driver.findElement(By.xpath("//*[text()=' Bengaluru (BLR)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//*[text()=' Chennai (MAA)']")).click();

    }
}
