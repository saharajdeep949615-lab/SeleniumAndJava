package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DaynamicValue {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://practice.expandtesting.com/dynamic-table");
        driver.manage().window().maximize();

        List<WebElement> rows=driver.findElements(By.xpath("//*[@class='table-responsive']//tbody//tr"));
        for(int i=1;i<=rows.size();i++){
            ////*[@class='table-responsive']//tbody//tr[2]//td[1]
        String name=driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr["+i+"]//td[1]")).getText();
            if(name.equals("Chrome")){
               String cpuLoad=driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
               String value=driver.findElement(By.xpath("//*[@id='chrome-cpu']")).getText().split(":")[1].trim();
               if(cpuLoad.equals(value)){
                   System.out.println("Match");
               }else{
                   System.out.println("Not Match");
               }
               break;
            }
        }
    }
}
