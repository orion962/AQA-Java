package pages;

import core.BaseSeleniumPage;
import helper.Item;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BaseSeleniumPage {
    @FindBy(xpath = "//span[@class='good-info__good-name']")
    private List<WebElement> titles;

    @FindBy(xpath = "//span[@class='good-info__good-brand ']")
    private List<WebElement> brands;

    @FindBy(xpath = "//div[@class='list-item__good']//a[contains(@class,'img-plug')]")
    private List<WebElement> icons;

    @FindBy(xpath = "//span[@class='price-block__price']//span")
    private WebElement price;

    @FindBy(xpath = "//p[@class='b-top__total line']")
    private WebElement totalPrice;

    public BasketPage() {
        PageFactory.initElements(driver, this);
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> list = new ArrayList<>();
        Actions builder = new Actions(driver);
        for (int i = 0; i < titles.size(); ++i) {
            String titleValue = titles.get(i).getText().trim() + " " + brands.get(i).getText().substring(1).trim();
            builder.click(icons.get(i)).build().perform();
            String priceValue = price.getText();
            builder.pause(1000).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
            list.add(new Item(titleValue, priceValue));
        }
        return list;
    }
}