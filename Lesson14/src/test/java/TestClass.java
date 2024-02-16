import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> titles = new ArrayList<>(Arrays.asList("Номер телефона", "Номер абонента", "Номер счета на 44", "Номер счета на 2073"));
        Actions builder = new Actions(driver);
        for (int i = 0; i < list.size(); ++i) {
            builder.click(btn).build().perform();
            builder.pause(1000);
            builder.click(list.get(i)).build().perform();
            List<WebElement> input = driver.findElements(By.xpath("//form[@class='pay-form opened']//input"));
            Assertions.assertEquals(titles.get(i), input.get(0).getAttribute("placeholder"));
            Assertions.assertEquals("Сумма", input.get(1).getAttribute("placeholder"));
            Assertions.assertEquals("E-mail для отправки чека", input.get(2).getAttribute("placeholder"));
        }
    }

    @Test
    @DisplayName("Проверка работы фрейма с полями для ввода реквизитов карты")
    void checkFrame() {
        WebElement btn = driver.findElement(By.xpath("//div[@class='pay__wrapper']//button[text()='Продолжить']"));
        WebElement phoneField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='phone']"));
        WebElement moneyField = driver.findElement(By.xpath("//div[@class='pay__wrapper']//input[@class='total_rub']"));
        List<String> titles = new ArrayList<>(Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"));
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
        Assertions.assertTrue(sum.getText().contains("100"));
        Assertions.assertTrue(btnLb.getText().contains("100"));
        Assertions.assertTrue(hd.getText().contains("297777777"));
        for (int i = 0; i < 4; ++i) {
            Assertions.assertEquals(titles.get(i), labels.get(i).getText());
        }
        List<WebElement> card_brands = driver.findElements(By.xpath("//div[@class='app-wrapper__content']//" +
                "div[contains(@class, 'cards-brands')]//img"));
        for (WebElement elem : card_brands) {
            Assertions.assertTrue(elem.isDisplayed());
        }
    }

    @AfterEach
    void finish() {
        driver.close();
        driver.quit();
    }
}