package tests;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Retry;

import static utils.AllureUtils.takeScreenshot;

public class CartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Проверка добавления товара в корзину", description = "Проверка добавления товара в корзину", retryAnalyzer = Retry.class)
    @Description  ("Проверка добавления товара в корзину")
    @Severity(SeverityLevel.MINOR)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
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