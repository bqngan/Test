package Railway;

import Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ForgotTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.get("http://railwayb2.somee.com/Account/Login.cshtml"); // Điều hướng tới trang login
    }

    @Test
    public void TC12() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickForgotPassword();

        ForgotPage forgotPage = new ForgotPage();
        forgotPage.forgotPassword("khanhha27112003@gmail.com");

        // Giả sử sau khi nhập email, bạn được chuyển về trang có URL chứa 'PasswordChangeForm'
        String currentUrl = Constant.WEBDRIVER.getCurrentUrl();
        assertTrue(currentUrl.contains("PasswordChangeForm"), "Không chuyển sang trang Password Change như mong đợi!");
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
