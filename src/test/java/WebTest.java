import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class WebTest {
    WebDriver driver;
    String url = "http://www.99-bottles-of-beer.net/";

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vkorenevskyy\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testFirst() {

        String expectedResult = "99 Bottles of Beer | Start";

        driver.get(url);
        driver.getCurrentUrl();

        String actual = driver.getTitle();

        Assert.assertEquals(actual, expectedResult);
    }

    @Test
    public void testSearch() {

        driver.get(url);

        driver.findElement(By.xpath("(//a[normalize-space()='Search Languages'])[1]")).click();
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("English");
        driver.findElement(By.cssSelector("input[value='GO']")).click();

        WebElement expectedResult = driver.findElement(By.xpath("(//th[normalize-space()='Language'])[1]"));

        Assert.assertTrue(expectedResult.isDisplayed());
    }
}
