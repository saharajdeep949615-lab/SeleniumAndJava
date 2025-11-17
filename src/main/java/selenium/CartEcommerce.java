package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartEcommerce {
    public static void EcommerceApp(WebDriver driver,String[] names) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='product-name']")));
        boolean found=false;
       List<WebElement> lists=driver.findElements(By.xpath("//*[@class='product-name']"));
       int j=0;
       for(int i=0;i<lists.size();i++){
           String[] items=lists.get(i).getText().split("-");
           String iteamNeed=items[0].trim();
           for(int k=0;k<names.length;k++){
               if(iteamNeed.equalsIgnoreCase(names[k])){
                   j++;
                   driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
                   found=true;
                   if(j==names.length){
                       break;
                   }
               }
           }
       }
       if(!found){
           throw new RuntimeException("Not found");
       }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String[] names={"Brocolli","Tomato","Mushroom"};
        Thread.sleep(2000);
        EcommerceApp(driver,names);
    }
}
