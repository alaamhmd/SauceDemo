package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginWithInvalidUsernameOrPassword extends TestBase {
    LoginPage login;
    HomePage home;

    @DataProvider(name = "testData")
    public static Object[][] userData() throws IOException {
        ExcelReader reader = new ExcelReader();
        return reader.getExcelData();


    }

    @Test(dataProvider = "testData")
    public void loginWithInvalidUsernameAndPasswordTest(String username, String password, String url, String errorMsg) {

        login = new LoginPage(driver);
        softAssert = new SoftAssert();
        home = new HomePage(driver);
        login.login(username, password);
        softAssert.assertEquals(getCurrentPageURL(), url);
        softAssert.assertEquals(home.checkElementsStatus(), false);
        softAssert.assertEquals(login.getErrorMsgTxt(), errorMsg);

        softAssert.assertAll();

    }

}
