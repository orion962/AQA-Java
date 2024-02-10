package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage extends BaseSeleniumPage {
    @FindBy(xpath = "//span[@class='good-info__good-name']")
    private List<WebElement> titles;

    @FindBy(xpath = "//span[@class='good-info__good-brand ']")
    private List<WebElement> brands;

    @FindBy(xpath = "//div[@class='list-item__good']//a[contains(@class,'img-plug')]")
    private List<WebElement> icons;

    @FindBy(xpath = "//span[@class='price-block__price']//ins")
    private WebElement price;

    @FindBy(xpath = "//p[@class='b-top__total line']")
    private WebElement totalPrice;

    public BasketPage() {
        PageFactory.initElements(driver, this);
    }

    public void print() {
        Actions builder = new Actions(driver);
        for (int i = 0; i < titles.size(); ++i) {
            System.out.println(titles.get(i).getText() + brands.get(i).getText().substring(1));
            builder.click(icons.get(i)).build().perform();
            System.out.println(price.getText());
            builder.pause(1000).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
        }
        System.out.println(totalPrice.getText());
    }
}