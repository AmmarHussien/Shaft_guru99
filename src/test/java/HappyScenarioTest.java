import com.shaft.driver.SHAFT;
import org.example.HappyScenario;
import org.example.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;


public class HappyScenarioTest {
    private final ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();
    private SHAFT.TestData.JSON LoginData;
    private SHAFT.TestData.JSON UserData;

    @Test
    public void happyScenario() {
        String email =  UserData.getTestData("User.Email");
        String uuid = UUID.randomUUID().toString().substring(0, 6);
        String uniqueEmail = email.replace("@", uuid + "@");

        new HappyScenario(driver.get()).create(
                UserData.getTestData("User.Name"),
                UserData.getTestData("User.Gender"),
                UserData.getTestData("User.DateOfBirth"),
                UserData.getTestData("User.Address"),
                UserData.getTestData("User.City"),
                UserData.getTestData("User.State"),
                UserData.getTestData("User.Pin"),
                UserData.getTestData("User.MobileNumber"),
                uniqueEmail,
                UserData.getTestData("User.Password")
        ).addNewAccoun(
                UserData.getTestData("User.Name"),
                uniqueEmail,
                UserData.getTestData("User.Account.type"),
                UserData.getTestData("User.Account.amount")
        );
    }

    @BeforeClass
    public void beforeClassSetup() {
        LoginData = new SHAFT.TestData.JSON("LoginData.json");
        UserData = new SHAFT.TestData.JSON("UserData.json");

    }

    @BeforeMethod
    public void beforeMethodSetUp() {
        driver.set(new SHAFT.GUI.WebDriver());
        driver.get().browser().navigateToURL(LoginData.getTestData("url"));

        new LoginPage(driver.get())
                .login(
                        LoginData.getTestData("email"),
                        LoginData.getTestData("password")
                );
    }

    @AfterMethod
    public void afterMethodTearDown() {
        driver.get().quit();
    }
}
