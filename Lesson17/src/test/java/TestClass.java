import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass {
    private AndroidDriver driver;

    @BeforeTest
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 6a");
        capabilities.setCapability("platformName", "Android");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4808/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click();
    }

    @Test
    public void addition() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        Assert.assertEquals("3",
                driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }

    @Test
    public void subtraction() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        Assert.assertEquals("−1",
                driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }

    @Test
    public void multiply() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        Assert.assertEquals("2",
                driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }

    @Test
    public void division() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        Assert.assertEquals("0.5",
                driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }

    @AfterTest
    void finish() {
        if (driver != null) {
            driver.quit();
        }
    }
}