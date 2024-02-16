package pages;

import core.BaseSeleniumPage;
import helper.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//article[@data-card-index='0']")
    private WebElement help;
    @FindBy(xpath = "//article[@data-card-index='0']//a[contains(@class, 'product-card__link')]")
    private WebElement title0;
    @FindBy(xpath = "//article[@data-card-index='0']//ins")
    private WebElement price0;
    @FindBy(xpath = "//article[@data-card-index='0']//a[contains(@class, 'product-card__add-basket')]")
    private WebElement button0;

    @FindBy(xpath = "//article[@data-card-index='1']//a[contains(@class, 'product-card__link')]")
    private WebElement title1;
    @FindBy(xpath = "//article[@data-card-index='1']//ins")
    private WebElement price1;
    @FindBy(xpath = "//article[@data-card-index='1']//a[contains(@class, 'product-card__add-basket')]")
    private WebElement button1;

    @FindBy(xpath = "//article[@data-card-index='2']//a[contains(@class, 'product-card__link')]")
    private WebElement title2;
    @FindBy(xpath = "//article[@data-card-index='2']//ins")
    private WebElement price2;
    @FindBy(xpath = "//article[@data-card-index='2']//a[contains(@class, 'product-card__add-basket')]")
    private WebElement button2;

    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    private WebElement basketButton;

    public MainPage() {
        driver.get("https://www.wildberries.ru/");
        PageFactory.initElements(driver, this);
    }

    private void checkPopup() {
        try {
            driver.findElement(By.xpath("//li[@class='sizes-list__item']//label")).click();
        } catch (Exception ignored) {

        }
    }

    public MainPage addToBasket() {
        Actions builder = new Actions(driver);
        builder.click(button0).build().perform();
        checkPopup();
        builder.click(button1).build().perform();
        checkPopup();
        builder.click(button2).build().perform();
        checkPopup();
        return this;
    }

    public BasketPage goToBasket() {
        basketButton.click();
        return new BasketPage();
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(Arrays.asList(
                new Item(title2.getAttribute("aria-label"), price2.getText()),
                new Item(title1.getAttribute("aria-label"), price1.getText()),
                new Item(title0.getAttribute("aria-label"), price0.getText())));
    }
}