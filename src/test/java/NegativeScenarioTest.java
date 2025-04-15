import com.shaft.driver.SHAFT;
import org.example.LoginPage;
import org.example.NegativeScenarios;
import org.testng.annotations.*;

public class NegativeScenarioTest {
    private final ThreadLocal<SHAFT.GUI.WebDriver> driver = new ThreadLocal<>();
    private SHAFT.TestData.JSON loginData;
    private SHAFT.TestData.JSON validationMessages;
    private NegativeScenarios negativeScenarios;

    private static final String LOGIN_DATA_FILE = "LoginData.json";
    private static final String VALIDATION_MESSAGES_FILE = "ValidationMessages.json";

    @BeforeClass
    public void beforeClassSetup() {
        loginData = new SHAFT.TestData.JSON(LOGIN_DATA_FILE);
        validationMessages = new SHAFT.TestData.JSON(VALIDATION_MESSAGES_FILE);
    }

    @BeforeMethod
    public void beforeMethodSetUp() {
        driver.set(new SHAFT.GUI.WebDriver());
        driver.get().browser().navigateToURL(loginData.getTestData("url"));

        new LoginPage(driver.get()).login(
                loginData.getTestData("email"),
                loginData.getTestData("password")
        );

        negativeScenarios = new NegativeScenarios(driver.get());
    }

    @AfterMethod
    public void afterMethodTearDown() {
        driver.get().quit();
        driver.remove();
    }

    @Test
    public void negativeScenario() {
        negativeScenarios.blankValidationsMessages();
    }

    @Test
    public void userNameScenarios() {
        negativeScenarios.validateUserNameField(
                validationMessages.getTestData("user.blank"),
                validationMessages.getTestData("number"),
                validationMessages.getTestData("specialCharacter"),
                validationMessages.getTestData("space")
        );
    }

    @Test
    public void userAddressScenarios() {
        negativeScenarios.validateUserAddressField(
                validationMessages.getTestData("address.blank"),
                validationMessages.getTestData("specialCharacter"),
                validationMessages.getTestData("space")
        );
    }

    @Test
    public void userCityScenarios() {
        negativeScenarios.validateUserCityField(
                validationMessages.getTestData("city.blank"),
                validationMessages.getTestData("number"),
                validationMessages.getTestData("specialCharacter"),
                validationMessages.getTestData("space")

        );
    }

    @Test
    public void userStateScenarios() {
        negativeScenarios.validateUserStateField(
                validationMessages.getTestData("state.blank"),
                validationMessages.getTestData("number"),
                validationMessages.getTestData("specialCharacter"),
                validationMessages.getTestData("space")
        );
    }

    @Test
    public void userPINScenarios() {
        negativeScenarios.validateUserPinField(
                validationMessages.getTestData("pin.blank"),
                validationMessages.getTestData("string"),
                validationMessages.getTestData("specialCharacter"),
                validationMessages.getTestData("min"),
                validationMessages.getTestData("space")
        );
    }
}