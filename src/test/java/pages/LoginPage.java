package pages;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2  // Автоматически создаёт logger
@RequiredArgsConstructor  // Генерирует конструктор для final полей
public class LoginPage {

    private final WebDriver driver;  // final + конструктор от Lombok

    // Locators
    private final By userField = By.cssSelector("[data-test=username]");
    private final By passwordField = By.cssSelector("[data-test=password]");
    private final By loginButton = By.cssSelector("[data-test=login-button]");
    private final By errorMessage = By.cssSelector("[data-test=error]");

    public void open() {
        log.info("Opening login page");  // 🔹 Логирование
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String password) {
        log.info("Attempting login with user: {}", user);  // Параметризованное логирование
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        log.debug("Login button clicked");
    }

    public String getErrorMessage() {
        log.trace("Getting error message");
        return driver.findElement(errorMessage).getText();
    }
}