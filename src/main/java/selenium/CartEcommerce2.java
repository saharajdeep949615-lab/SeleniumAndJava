package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartEcommerce2 {
    public static void CartEcommerce2(WebDriver driver,String[] names){
        List<WebElement> lists=driver.findElements(By.xpath("//*[@class='product-name']"));
        int j=0;
        boolean found=false;
        for(int i=0;i<lists.size();i++){
            String[] name=lists.get(i).getText().split("-");
            String itemsNeed=name[0].trim();
            for(int k=0;k<names.length;k++){
                if(itemsNeed.equalsIgnoreCase(names[k])){
                    driver.findElements(By.xpath("//*[@class='product-action']//button")).get(i).click();
                    found=true;
                    j++;
                    if(j==names.length){
                        break;
                    }
                }
            }
        }
        if(!found){
            throw new RuntimeException("Not Found");
        }
    }
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String[] names={"Brocolli","Tomato","Mushroom"};
        CartEcommerce2(driver,names);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@alt='Cart']")).click();
        driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoCode']")));
        driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());

    }
}
