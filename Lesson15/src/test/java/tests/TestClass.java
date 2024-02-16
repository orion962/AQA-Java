package tests;

import core.BaseSeleniumTest;
import helper.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.ArrayList;

public class TestClass extends BaseSeleniumTest {
    @Test
    @DisplayName("Проверка первых трёх позиций товара с главной страницы сайта")
        // после добавления товара в корзину есть некоторое ожидание
        // оно связано с поиском кнопки выбора одежды
        // такая кнопка отображается если в корзину добавляется одежда с выбором размера на главной странице
        // в противном случае такой кнопки нет
    void check() {
        MainPage main_page = new MainPage();
        ArrayList<Item> mp_list = main_page.getItems();
        ArrayList<Item> bp_list = main_page.addToBasket().goToBasket().getItems();
        for (int i = 0; i < mp_list.size(); ++i) {
            Assertions.assertEquals(mp_list.get(i), bp_list.get(i));
        }
    }
}
