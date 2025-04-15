package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.util.Map;

public class NegativeScenarios {
    private final SHAFT.GUI.WebDriver driver;

    // Locators
    private final By new_customer_Button = By.cssSelector("body > div:nth-child(9) > div > ul > li:nth-child(2) > a");
    private final By user_Name = By.name("name");
    private final By user_Name_Validation = By.id("message");
    private final By user_male = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)");
    private final By user_Date_Of_Birth = By.id("dob");
    private final By user_Date_Of_Birth_Validation = By.id("message24");
    private final By user_Address = By.name("addr");
    private final By user_Address_Validation = By.id("message3");
    private final By user_City = By.name("city");
    private final By user_City_Validation = By.id("message4");
    private final By user_State = By.name("state");
    private final By user_State_Validation = By.id("message5");
    private final By user_PIN = By.name("pinno");
    private final By user_PIN_Validation = By.id("message6");
    private final By user_Mobile_Number = By.name("telephoneno");
    private final By user_Mobile_Number_Validation = By.id("message7");
    private final By user_Email = By.name("emailid");
    private final By user_Email_Validation = By.id("message9");
    private final By user_Password = By.name("password");
    private final By user_Password_Validation = By.id("message18");

    public NegativeScenarios(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Reusable method to open form
    private void openCustomerForm() {
        driver.element().click(new_customer_Button);
    }

    // Reusable validator
    private void validateField(By field, By validationLocator, Map<String, String> inputsWithMessages) {
        inputsWithMessages.forEach((input, expectedMessage) -> {
            driver.element().type(field, input);
            driver.element().assertThat(validationLocator).text().isEqualTo(expectedMessage).perform();
        });
    }

    public void blankValidationsMessages() {
        openCustomerForm();

        driver.element().click(user_Name)
                .click(user_Date_Of_Birth)
                .click(user_Address)
                .click(user_City)
                .click(user_State)
                .click(user_PIN)
                .click(user_Mobile_Number)
                .click(user_Email)
                .click(user_Password)
                .click(user_male);

        driver.element().assertThat(user_Name_Validation).text().isEqualTo("Customer name must not be blank").perform();
        driver.element().assertThat(user_Date_Of_Birth_Validation).text().isEqualTo("Date Field must not be blank").perform();
        driver.element().assertThat(user_Address_Validation).text().isEqualTo("Address Field must not be blank").perform();
        driver.element().assertThat(user_City_Validation).text().isEqualTo("City Field must not be blank").perform();
        driver.element().assertThat(user_State_Validation).text().isEqualTo("State must not be blank").perform();
        driver.element().assertThat(user_PIN_Validation).text().isEqualTo("PIN Code must not be blank").perform();
        driver.element().assertThat(user_Mobile_Number_Validation).text().isEqualTo("Mobile no must not be blank").perform();
        driver.element().assertThat(user_Email_Validation).text().isEqualTo("Email-ID must not be blank").perform();
        driver.element().assertThat(user_Password_Validation).text().isEqualTo("Password must not be blank").perform();
    }

    public void validateUserNameField(String blank, String number, String special, String space) {
        openCustomerForm();
        validateField(user_Name, user_Name_Validation, Map.of(
                "", blank,
                "1234", number,
                "@#", special,
                " ", space
        ));
    }

    public void validateUserAddressField(String blank, String special, String space) {
        openCustomerForm();
        validateField(user_Address, user_Address_Validation, Map.of(
                "", blank,
                "@#", special,
                " ", space
        ));
    }

    public void validateUserCityField(String blank, String number, String special, String space) {
        openCustomerForm();
        validateField(user_City, user_City_Validation, Map.of(
                "", blank,
                "1234", number,
                "@#", special,
                " ", space
        ));
    }

    public void validateUserStateField(String blank, String number, String special, String space) {
        openCustomerForm();
        validateField(user_State, user_State_Validation, Map.of(
                "", blank,
                "1234", number,
                "@#", special,
                " ", space
        ));
    }

    public void validateUserPinField(String blank, String string, String special, String min, String space) {
        openCustomerForm();
        validateField(user_PIN, user_PIN_Validation, Map.of(
                "", blank,
                "12345", min,
                "abc", string,
                "@#", special,
                " ", space
        ));
    }
}