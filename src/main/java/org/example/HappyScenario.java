package org.example;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HappyScenario {
    private final SHAFT.GUI.WebDriver driver;
    public String customerID;
    // Create Customer locators
    private final By new_customer_Button = By.cssSelector("body > div:nth-child(9) > div > ul > li:nth-child(2) > a");
    private final By user_Name = By.name("name");
    private final By user_male = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(1)");
    private final By user_female = By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)");
    private final By user_Date_Of_Birth = By.id("dob");
    private final By user_Address = By.name("addr");
    private final By user_City = By.name("city");
    private final By user_State = By.name("state");
    private final By user_PIN = By.name("pinno");
    private final By user_Mobile_Number = By.name("telephoneno");
    private final By user_Email= By.name("emailid");
    private final By user_Password = By.name("password");
    private final By submit_Button = By.name("sub");
    private final By message_Successfully = By.cssSelector("#customer > tbody > tr:nth-child(1) > td > p");

    private final By Customer_ID = By.cssSelector("#customer > tbody > tr:nth-child(4) > td:nth-child(2)");
    private final By Validate_Name = By.cssSelector("#customer > tbody > tr:nth-child(5) > td:nth-child(2)");
    private final By Validate_Gender = By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)");
    private final By Validate_Address = By.cssSelector("#customer > tbody > tr:nth-child(8) > td:nth-child(2)");
    private final By Validate_City = By.cssSelector("#customer > tbody > tr:nth-child(9) > td:nth-child(2)");
    private final By Validate_State = By.cssSelector("#customer > tbody > tr:nth-child(10) > td:nth-child(2)");
    private final By Validate_Pin = By.cssSelector("#customer > tbody > tr:nth-child(11) > td:nth-child(2)");
    private final By Validate_Mobile = By.cssSelector("#customer > tbody > tr:nth-child(12) > td:nth-child(2)");
    private final By Validate_Email = By.cssSelector("#customer > tbody > tr:nth-child(13) > td:nth-child(2)");


    // Add NewAccount  Locators
    private final By New_Account_button = By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(5) > a");
    private final By New_Account_Id = By.name("cusid");
    private final By New_Account_Select = By.name("selaccount");
    private final By New_Account_Deposit= By.name("inideposit");
    private final By New_Account_Submit_Button= By.name("button2");
    private final By message_Successfully_New_Account = By.cssSelector("#account > tbody > tr:nth-child(1) > td > p");
    private final By Validate_Customer_ID_Account = By.cssSelector("#account > tbody > tr:nth-child(5) > td:nth-child(2)");
    private final By Validate_Name_Account = By.cssSelector("#account > tbody > tr:nth-child(6) > td:nth-child(2)");
    private final By Validate_Email_Account = By.cssSelector("#account > tbody > tr:nth-child(7) > td:nth-child(2)");
    private final By Validate_Account_Type_Account = By.cssSelector("#account > tbody > tr:nth-child(8) > td:nth-child(2)");
    private final By Validate_Current_Amount_Account = By.cssSelector("#account > tbody > tr:nth-child(10) > td:nth-child(2)");



    public HappyScenario(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public HappyScenario create(
            String name,
            String gender,
            String date,
            String address,
            String city,
            String state,
            String pin,
            String mobileNumber,
            String email,
            String password
    ) {
        driver.element()
                .click(new_customer_Button)
                .type(user_Name, name);

        if(gender.equals("female") ) {
            driver.element()
                    .click(user_female);
        } else {
            driver.element()
                    .click(user_male);
        }
        driver.element()
                .type(user_Date_Of_Birth,date)
                .type(user_Address,address)
                .type(user_City,city)
                .type(user_State, state)
                .type(user_PIN,pin)
                .type(user_Mobile_Number,mobileNumber)
                .type(user_Email, email)
                .type(user_Password,password)
                .click(submit_Button);
        driver.element().assertThat(message_Successfully).text().isEqualTo("Customer Registered Successfully!!!").perform();
        driver.element().assertThat(Validate_Name).text().isEqualTo(name).perform();
        driver.element().assertThat(Validate_Gender).text().isEqualTo(gender).perform();
        driver.element().assertThat(Validate_Address).text().isEqualTo(address).perform();
        driver.element().assertThat(Validate_City).text().isEqualTo(city).perform();
        driver.element().assertThat(Validate_State).text().isEqualTo(state).perform();
        driver.element().assertThat(Validate_Pin).text().isEqualTo(pin).perform();
        driver.element().assertThat(Validate_Mobile).text().isEqualTo(mobileNumber).perform();
        driver.element().assertThat(Validate_Email).text().isEqualTo(email).perform();

       customerID = driver.element().getText(Customer_ID);

        return this;
    }

    public HappyScenario addNewAccoun(
            String name,
            String email,
            String type,
            String amount
    ){
        driver.element()
                .click(New_Account_button)
                .type(New_Account_Id, customerID)
                .select(New_Account_Select, type)
                .type(New_Account_Deposit, amount)
                .click(New_Account_Submit_Button);
        driver.element().assertThat(message_Successfully_New_Account).text().isEqualTo("Account Generated Successfully!!!").perform();
        driver.element().assertThat(Validate_Customer_ID_Account).text().isEqualTo(customerID).perform();
        driver.element().assertThat(Validate_Name_Account).text().isEqualTo(name).perform();
        driver.element().assertThat(Validate_Email_Account).text().isEqualTo(email).perform();
        driver.element().assertThat(Validate_Account_Type_Account).text().isEqualTo(type).perform();
        driver.element().assertThat(Validate_Current_Amount_Account).text().isEqualTo(amount).perform();



        return this;
    }


}
