package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    By usernameTxtbox = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.xpath("//div[@class=\"error-message-container error\"]");

    public void login(String username, String pass) {
        setTextToElement(usernameTxtbox, username);
        setTextToElement(password, pass);
        clickBtn(loginBtn);
    }

    public String getErrorMsgTxt() {
        String errMsg;
        return errMsg = drvier.findElement(errorMsg).getText();
    }

}
