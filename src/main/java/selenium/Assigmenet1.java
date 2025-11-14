package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Assigmenet1 {
    public static void loginCheck(WebDriver driver,String username,String password) throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]")).sendKeys(username);
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[2]")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
        String title= driver.getCurrentUrl();
        System.out.println(title);
        if(title.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("title is oky");
        }else{
            System.out.println("title is not oky");
        }
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
        driver.quit();
    }
    public static void main(String [] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--user-data-dir=C:/Temp/ChromeTestProfile");
        options.addArguments("--password-store=basic");
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerUI,PasswordManagerEnabled");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");   // optional but works best

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String username="standard_user";
        String passowrd="secret_sauce";
        loginCheck(driver,username,passowrd);
    }
}
