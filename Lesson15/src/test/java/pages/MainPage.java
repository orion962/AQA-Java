package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public MainPage addToBasket() {
        Actions builder = new Actions(driver);
        builder.click(button0).pause(1000).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
        builder.click(button1).pause(1000).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
        builder.click(button2).pause(1000).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
//        button0.click();
//        button1.click();
//        button2.click();
        return this;
    }

    public BasketPage goToBasket() {
        basketButton.click();
        return new BasketPage();
    }

    public MainPage print() {
        System.out.println(title2.getAttribute("aria-label"));
        System.out.println(price2.getText());
        System.out.println(title1.getAttribute("aria-label"));
        System.out.println(price1.getText());
        System.out.println(title0.getAttribute("aria-label"));
        System.out.println(price0.getText());
        System.out.println();
        return this;
    }
}