package tests;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class TestClass extends BaseSeleniumTest {
    @Test
    @DisplayName("Проверка первых трёх позиций товара с главной страницы сайта")
    // если среди этих позиций будет одежда с выбором размера (случайное событие), то эта позиция добавлена не будет
    void check() {
        MainPage obj = new MainPage();
        obj.addToBasket().print().goToBasket().print();
    }
}
