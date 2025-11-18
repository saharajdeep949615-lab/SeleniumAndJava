package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Checklinks {
    public static void checkLinkscheck(WebDriver driver) throws InterruptedException {
        System.out.println("check links:"+driver.findElements(By.tagName("a")).size());

        WebElement footerdriver=driver.findElement(By.xpath("//*[@id='gf-BIG']"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement coloumDriver=driver.findElement(By.xpath("//*[@class='gf-t']//tbody//tr//td[1]//ul"));
        System.out.println(coloumDriver.findElements(By.tagName("a")).size());

        for(int i=1;i<coloumDriver.findElements(By.tagName("a")).size();i++){
            String clickonLinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
            coloumDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
            Thread.sleep(2000);
        }
        Set<String> abc=driver.getWindowHandles();
        Iterator<String> it=abc.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        checkLinkscheck(driver);
    }
}
