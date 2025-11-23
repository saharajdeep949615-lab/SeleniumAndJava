package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokeLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

//        WebElement soapUI=driver.findElement(By.xpath("//*[text()='SoapUI']"));
//        String url=soapUI.getAttribute("href");
//        System.out.println(url);

//        String url=driver.findElement(By.xpath("//*[text()='SoapUI']")).getAttribute("href");
//        System.out.println(url);
//        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
//        urlConnection.setRequestMethod("HEAD");
//        urlConnection.connect();
//        int respCode= urlConnection.getResponseCode();
//        System.out.println(respCode);

        List<WebElement> links=driver.findElements(By.xpath("//*[@id='gf-BIG']//a"));
        SoftAssert a=new SoftAssert();
        for(int i=0;i<links.size();i++){
            String urls=links.get(i).getAttribute("href");
            HttpURLConnection conn=(HttpURLConnection) new URL(urls).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode=conn.getResponseCode();
            a.assertTrue(responseCode<400,links.get(i).getText()+"is broken with code"+responseCode);
        }
        a.assertAll();
    }
}
