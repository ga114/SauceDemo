package pages;


import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2  // Автоматически создаёт logger
@RequiredArgsConstructor  // Генерирует конструктор для final полей
public class CartPage {

    WebDriver driver;
    By title = By.cssSelector("[data-test=title]");
    By cartLink = By.cssSelector("[data-test=shopping-cart-link]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получение заголовка в Корзине")
    public String getTitle() {
        log.debug("Getting page title");
        String text = driver.findElement(title).getText();
        log.info("Page title: {}", text);
        return text;
    }

    @Step("Клик по ссылке Коризна")
    public void clickToCartLink() {
        log.trace("Checking click to cart link");
        driver.findElement(cartLink).click();
    }
}