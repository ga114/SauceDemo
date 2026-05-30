package pages;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2  // Автоматически создаёт logger
@RequiredArgsConstructor  // Генерирует конструктор для final полей
public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By readMore = By.xpath("/html/body/div/main/section[2]/div/div/div[1]/div/div[2]/div/a");
    //id кнопки добавить конкретного товара со страницы
    By productAdd = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    // id кнопки удалить конкретного товара
    By getProductRemove = By.cssSelector("[data-test=remove-sauce-labs-backpack]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получение заголовка")
    public String getTitle() {
        log.debug("Getting page title");
        String text = driver.findElement(title).getText();
        log.info("Page title: {}", text);
        return text;
    }

    @Step("Клик по кнопке добавить в корзину")
    public void clickButton() {
        log.info("Clicking 'Add to cart' button");
        driver.findElement(productAdd).click();
        log.debug("Button clicked successfully");
    }

    @Step("Клик по кнопке удалить продукт")
    public String checkButtonRemove() {
        log.trace("Checking remove button text");
        return driver.findElement(getProductRemove).getText();
    }



}