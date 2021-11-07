import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class QAToolsTest {
    WebDriver driver;
    String baseUrl = "https://demoqa.com/";

    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*@AfterTest
    public void quitDriver() {
        driver.close();
        driver.quit();
    }*/

    @Test
    public void QAdemoTest() {
        driver.get(baseUrl);

        driver.switchTo().frame("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0");
        driver.findElement(By.xpath("//div[@id='cbb']")).click();
        driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]")).click();

        driver.getTitle();
    }
}
