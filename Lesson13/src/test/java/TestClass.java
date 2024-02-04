import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {
    private WebDriver driver;

    @BeforeEach
    @Deprecated
    void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        WebElement btn = driver.findElement(By.id("cookie-agree"));
        btn.click();
    }

    @Test
    @DisplayName("Проверка названия блока пополнения счёта")
    void checkTitle() {
        WebElement elem = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assertions.assertEquals("Онлайн пополнение без комиссии", elem.getText().replace('\n', ' '));
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    void checkLogo() {
        List<WebElement> elems = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        Assertions.assertTrue(elems.stream().allMatch(WebElement::isDisplayed));
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    void verifyLink() {
        WebElement elem = driver.findElement(By.xpath("//*[text()='Подробнее о сервисе']"));
        String linkUrl = elem.getAttribute("href");
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.connect();
            Assertions.assertTrue(httpURLConnect.getResponseCode() < 400);
        } catch (Exception ignored) {
        }
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Продолжить' после заполнения всех необходимых полей")
    void checkButton() {
        WebElement btn = driver.findElement(By.xpath("//div[@class='pay__wrapper']//button[text()='Продолжить']"));
        WebElement phoneField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='phone']"));
        WebElement moneyField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='total_rub']"));
        phoneField.sendKeys("297777777");
        moneyField.sendKeys("100");
        btn.click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        WebElement dynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(iframe));
        Assertions.assertTrue(iframe.isDisplayed());
    }

    @AfterEach
    void finish() {
        driver.quit();
    }
}
