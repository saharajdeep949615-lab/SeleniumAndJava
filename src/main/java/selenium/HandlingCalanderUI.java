package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class HandlingCalanderUI {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        String monthNumber="6";
        String date="15";
        String year="2027";

        String[] expectedList={"monthNumber","date","year"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.xpath("//*[contains(@class,'react-calendar__navigation__label')]")).click();
        driver.findElement(By.xpath("//*[contains(@class,'react-calendar__navigation__label')]")).click();
        driver.findElement(By.xpath("//*[text()='"+year+"']")).click();
        driver.findElements(By.xpath("//*[contains(@class,'react-calendar__year-view__months__month')]")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        List<WebElement> actualList = driver.findElements(By.xpath("//*[contains(@class, 'react-date-picker__inputGroup__input')]"));
        for(int i=0;i<actualList.size();i++){
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"),expectedList[i]);
        }
    }
}