package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;

    private final By email_Input = By.name("uid");
    private final By password_Input =By.name("password");
    private final By login_Button = By.name("btnLogin");


    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage login(String email, String password) {
        driver.element().type(email_Input, email);
        driver.element().type(password_Input, password);
        driver.element().click(login_Button);
        return this;
    }

}
