package tests;

import data.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginWithValidUsernameAndPassword extends TestBase {
    LoginPage login;
    HomePage home;
    JSONDataReader jsonReader;

    @Test
    public void loginWithValidUsernameAndPasswordTest() throws IOException, ParseException {

        login = new LoginPage(driver);
        jsonReader = new JSONDataReader();
        softAssert = new SoftAssert();
       // home = new HomePage(driver);
        jsonReader.jsonReader();
      //  login.login(jsonReader.vUsername, jsonReader.vPassword);
        softAssert.assertEquals(jsonReader.homePageURL, getCurrentPageURL());
        softAssert.assertEquals(home.checkElementsStatus(), true);
        softAssert.assertAll();

    }

}
