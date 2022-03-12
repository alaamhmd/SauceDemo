package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By shoppingCartContainer = By.id("shopping_cart_container");
    By productsHeaderBanner = By.xpath("//div[@class=\"header_secondary_container\"]");

    public boolean checkElementsStatus() {

        return elementIsDisplayed(shoppingCartContainer);
    }

}

