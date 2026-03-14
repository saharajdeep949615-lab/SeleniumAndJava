package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    public static void takeScreenshot(WebDriver driver) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\sahar\\screenshot1.png"));

    }

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        takeScreenshot(driver);

        driver.quit();
    }
}
