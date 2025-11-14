package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assigmenet2 {
    public static void loginCheck(WebDriver driver,String username,String password) throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]")).sendKeys(username);
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[2]")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
        Thread.sleep(2000);
        String text=driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
        if(text.equals("Epic sadface: Username and password do not match any user in this service")){
            System.out.println("Is match");
        }else{
            System.out.println("Is not match");
        }

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String username="standard_user";
        String passowrd="secret";
        loginCheck(driver,username,passowrd);
    }
}
