package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("ind");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui-menu-item']")));

        List<WebElement> lists=driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
        boolean found = false;
        for(int i=0;i<lists.size();i++){
            String country=lists.get(i).getText();
            if(country.equalsIgnoreCase("India")){
                lists.get(i).click();
                System.out.println("Country: "+country);
                found = true;
                break;
            }
        }
        if(!found){
            throw new RuntimeException("Country not found!");
        }
        driver.quit();
    }
}
