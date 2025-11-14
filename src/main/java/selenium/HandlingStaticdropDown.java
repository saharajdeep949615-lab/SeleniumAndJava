package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLSyntaxErrorException;

public class HandlingStaticdropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

       Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']")));
       Thread.sleep(2000);
       dropdown.selectByValue("USD");
       System.out.println(dropdown.getFirstSelectedOption().getText());
       Thread.sleep(2000);
       dropdown.selectByIndex(2);
       System.out.println(dropdown.getFirstSelectedOption().getText());
       Thread.sleep(2000);
       dropdown.selectByVisibleText("INR");
       System.out.println(dropdown.getFirstSelectedOption().getText());

       driver.quit();
    }
}
