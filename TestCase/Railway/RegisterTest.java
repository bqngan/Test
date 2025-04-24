package Railway;

import Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    public RegisterTest() {
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @Test(description = "TC07: User can register successfully")
    public void TC07() {
        System.out.println("TC07 - User can register successfully");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "testuser" + System.currentTimeMillis() + "@mail.com";
        registerPage.register(email, "Abcd1234@", "Abcd1234@", "123456789");

        String successMessage = registerPage.getSuccessMessage();
        String expectedSuccessMessage = "Thank you for registering your account";
        Assert.assertEquals(successMessage, expectedSuccessMessage, "Success message does not match expected value.");
    }

    @Test(description = "TC010: User cannot register with mismatched passwords")
    public void TC010() {
        System.out.println("TC010 - User cannot register with mismatched passwords");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "testuser" + System.currentTimeMillis() + "@mail.com";
        registerPage.register(email, "Abcd1234@", "Atcd1234@", "123456789");

        String errorMessage = registerPage.getErrorMessage();
        String expectedErrorMessage = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(errorMessage, expectedErrorMessage, "Error message does not match expected value.");
    }

    @Test
    public void TC11() {
        System.out.println("TC11 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        String password = "123456789";
        String confirmPassword = "123456789";
        String pid = "123456789";
        registerPage.register(email, password, confirmPassword, pid);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        if (Constant.WEBDRIVER != null) {
            Constant.WEBDRIVER.quit();
            Constant.WEBDRIVER = null;
        }
    }
}