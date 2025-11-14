package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownlooping {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement checkCount=driver.findElement(By.xpath("//*[@id='divpaxinfo']"));
        System.out.println(checkCount.getText());
        checkCount.click();
        Thread.sleep(2000);
        WebElement button=driver.findElement(By.xpath("//*[@id='hrefIncAdt']"));
        for(int i=1;i<=4;i++){
            button.click();
            Thread.sleep(1000);
        }
        System.out.println(checkCount.getText());
        driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
        driver.quit();
    }
}
