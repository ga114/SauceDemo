package pages;


import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2  // Автоматически создаёт logger
@RequiredArgsConstructor  // Генерирует конструктор для final полей
public class InventoryPage {

    WebDriver driver;
    By searchLink = By.cssSelector("[data-test=inventory-item-name]");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке и инвентарь")
    public void clickToInventoryLink(){
        log.info("Clicking 'Add to cart' button");
        driver.findElement(searchLink).click();
        log.debug("Button clicked successfully");
    }

    @Step("Получение имени продукта")
    public String getNameProduct(){
        log.trace("Checking get name product.");
        return driver.findElement(searchLink).getText();
    }
}