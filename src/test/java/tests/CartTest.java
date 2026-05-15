package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();
    @Test()
    public void checkAddProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
        productsPage.clickButton();
        softAssert.assertEquals(productsPage.checkButtonRemove(),
                "Remove",
                "Кнопка Удалить не появилась");
        cartPage.clickToCartLink();
        //проверяем, что мы на странице с title = You cart
        softAssert.assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход в корзину не удался");
        //проверить, что кнопка удалить именно от добавленного товара присутствует на странице корзины
        softAssert.assertEquals(productsPage.checkButtonRemove(),
                "Remove",
                "Кнопка Удалить не появилась");
        inventoryPage.clickToInventoryLink();
        // проверяем, что открыта страница товара
        softAssert.assertEquals(inventoryPage.getNameProduct(),
                "Sauce Labs Backpack",
                "Открыт не тот товар");
        softAssert.assertAll();
    }
}