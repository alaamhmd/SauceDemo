package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected static WebDriver drvier;


    public PageBase(WebDriver driver) {
        PageBase.drvier = driver;
    }

    protected static void clickBtn(By button) {
        waitForElement(button);
        drvier.findElement(button).click();

    }

    protected static void setTextToElement(By textbox, String value) {
        waitForElement(textbox);
        drvier.findElement(textbox).sendKeys(value);

    }

    protected static void clearTextbox(By textbox) {
        waitForElement(textbox);
        drvier.findElement(textbox).clear();

    }

    public static boolean waitForElement(By element) {
        boolean elemntExist;
        try {
            WebDriverWait wait = new WebDriverWait(drvier, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(drvier.findElement(element)));
            elemntExist = true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("This " + element + " Is not exist " + e);
            elemntExist = false;
        }

        return elemntExist;
    }

    public static boolean elementIsDisplayed(By element) {
        if (waitForElement(element) == true) {
            return drvier.findElement(element).isDisplayed();
        } else {
            return false;
        }

    }
}
