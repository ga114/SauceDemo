package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
        softAssert.assertAll();
    }

    @Test
    public void checkUserLocked() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @Test
    public void checkWithoutPassword() {
        loginPage.open();
        loginPage.login("standart_user", "");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @Test
    public void checkWithoutLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @Test
    public void checkInputLoginPassword(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        softAssert.assertEquals(loginPage.getErrorMessage(),
                message,
                "Логин не выполнен");
        softAssert.assertAll();
    }
}