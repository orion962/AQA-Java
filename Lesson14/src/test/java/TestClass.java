import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @DisplayName("Проверка надписей в незаполненных полях каждого варианта оплаты услуг:" +
            " услуги связи, домашний интернет, рассрочка, задолженность")
    void checkLabels() {
        WebElement btn = driver.findElement(By.xpath("//div[@class='pay__form']//button[@class='select__header']"));
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='pay__form']//p[@class='select__option']"));
        Actions builder = new Actions(driver);
        for (WebElement elem : list) {
            builder.click(btn).build().perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='pay__form']//ul[@class='select__list']")));
            builder.pause(2000);
            builder.click(elem).build().perform();
            System.out.println(elem.getText() + ":");
            for (WebElement input : driver.findElements(By.xpath("//form[@class='pay-form opened']//input"))) {
                System.out.println(input.getAttribute("placeholder"));
            }
            System.out.println();
        }
    }

    @Test
    @DisplayName("Проверка работы фрейма с полями для ввода реквизитов карты")
    void checkFrame() {
        WebElement btn = driver.findElement(By.xpath("//div[@class='pay__wrapper']//button[text()='Продолжить']"));
        WebElement phoneField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='phone']"));
        WebElement moneyField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='total_rub']"));
        Actions builder = new Actions(driver);
        builder.sendKeys(phoneField, "297777777").build().perform();
        builder.sendKeys(moneyField, "100").build().perform();
        builder.click(btn).pause(5000).build().perform();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        WebElement dynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
        WebElement hd = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        WebElement sum = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        WebElement btnLb = driver.findElement(By.xpath("//button[contains(@class,'colored disabled')]"));
        List<WebElement> labels = driver.findElements(By.xpath(
                "//div[@class='app-wrapper__content']//div[contains(@class, 'card ng-tns')]//label"));
        System.out.println(sum.getText());
        System.out.println(hd.getText());
        System.out.println(btnLb.getText());
        System.out.println();
        for (WebElement label : labels) {
            System.out.println(label.getText());
        }
        Assertions.assertTrue(driver.findElement(
                By.xpath("//div[@class='app-wrapper__content']//div[contains(@class, 'cards-brands')]")).isDisplayed());
    }

    @AfterEach
    void finish() {
        driver.quit();
    }
}