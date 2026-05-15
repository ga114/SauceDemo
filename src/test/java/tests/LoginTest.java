package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Retry;

public class LoginTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Проверка авторизации", description = "Проверка авторизации", retryAnalyzer = Retry.class)
    @Description  ("Проверка авторизации с корректными данными")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
        softAssert.assertAll();
    }

    @Test(testName = "Проверка заблокированного пользователя", description = "Проверка заблокированного пользователя", retryAnalyzer = Retry.class)
    @Description  ("Проверка заблокированного пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
    public void checkUserLocked() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @Test(testName = "Проверка без пароля", description ="Проверка без пароля", retryAnalyzer = Retry.class)
    @Description  ("Проверка без пароля")
    @Severity(SeverityLevel.MINOR)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
    public void checkWithoutPassword() {
        loginPage.open();
        loginPage.login("standart_user", "");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @Test(testName = "Проверка без логина", description = "Проверка без логина", retryAnalyzer = Retry.class)
    @Description  ("Проверка без логина")
    @Severity(SeverityLevel.MINOR)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
    public void checkWithoutLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось");
        softAssert.assertAll();
    }

    @DataProvider(name = "Тестовые данные для негативного логина")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"test","test","Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(testName = "Проверка ввода разных логинов и паролей", description = "Проверка ввода разных логинов и паролей", dataProvider = "Тестовые данные для негативного логина", retryAnalyzer = Retry.class)
    @Description  ("Проверка ввода разных логинов и паролей")
    @Severity(SeverityLevel.MINOR)
    @Epic("Saucedemo-1.0")
    @Feature("auth in saucedemo")
    @Story("Авторизация")
    @TmsLink("http://www.jira.simple/CM-112")
    @Issue("http://www.jira.simple/CM-1112")
    @Flaky
    public void checkInputLoginPassword(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        softAssert.assertEquals(loginPage.getErrorMessage(),
                message,
                "Логин не выполнен");
        softAssert.assertAll();
    }
}