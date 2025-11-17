package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ScrollByValue {
    public static void scrollChecking(WebDriver driver){
        WebElement element=driver.findElement(By.xpath("//*[@class='tableFixHead']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

        List<WebElement> lists=driver.findElements(By.xpath("//*[@class='tableFixHead']//tbody//tr//td[4]"));
        int sum=0;
        for(int i=0;i<lists.size();i++){
            sum=sum+Integer.parseInt(lists.get(i).getText());
        }
        System.out.println("sum:"+sum);
        String text=driver.findElement(By.xpath("//*[@class='totalAmount']")).getText().split(":")[1].trim();
        System.out.println("text:"+text);
        if(text.equals(String.valueOf(sum))){
            System.out.println("It's is match");
        }else{
            System.out.println("It's not match");
        }
        driver.quit();
    }
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        scrollChecking(driver);
    }
}
