package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignupPage {
    private final By enterAccountInformationTextLocator = By.xpath("//h2 [.=\"Enter Account Information\"]");
    private final By maleGenderLocator = By.id("id_gender1");
    private final By femaleGenderLocator = By.id("id_gender2");
    private final By passwordFieldLocator = By.id("password");
    private final By daysFieldLocator = By.id("days");
    private final By monthsFieldLocator = By.id("months");
    private final By yearsFieldLocator = By.id("years");
    private final By firstnameFieldLocator = By.id("first_name");
    private final By lastnameFieldLocator = By.id("last_name");
    private final By companyFieldLocator = By.id("company");
    private final By address1FieldLocator = By.id("address1");
    private final By address2FieldLocator = By.id("address2");
    private final By countryFieldLocator = By.id("country");
    private final By stateFieldLocator = By.id("state");
    private final By cityFieldLocator = By.id("city");
    private final By zipcodeFieldLocator = By.id("zipcode");
    private final By mobileNumberFieldLocator = By.id("mobile_number");
    private final By newsletterCheckboxLocator = By.id("newsletter");
    private final By specialOfferCheckboxLocator = By.id("optin");
    private final By createAccountButtonLocator = By.xpath("//button [@data-qa=\"create-account\"]");

    private final WebDriver driver;

    public P03_SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyVisibilityOfEnterAccountInformationText() {
        return Utility.checkVisibilityOfElement(driver, enterAccountInformationTextLocator);
    }

    public P03_SignupPage fillDetails(String gender, String password, String day, String month, String year,
                                      String firstname, String lastname, String company, String address1,
                                      String address2, String country, String state, String city,
                                      String zipcode, String mobileNumber) {

        if (gender.equals("Male")) {
            Utility.clickOnElement(driver, maleGenderLocator);
        } else if (gender.equals("Female")) {
            Utility.clickOnElement(driver, femaleGenderLocator);
        }

        Utility.sendDataToElement(driver, passwordFieldLocator, password);

        Utility.handelDropdown(driver, daysFieldLocator, day);
        Utility.handelDropdown(driver, monthsFieldLocator, month);
        Utility.handelDropdown(driver, yearsFieldLocator, year);

        Utility.sendDataToElement(driver, firstnameFieldLocator, firstname);
        Utility.sendDataToElement(driver, lastnameFieldLocator, lastname);

        Utility.sendDataToElement(driver, companyFieldLocator, company);

        Utility.sendDataToElement(driver, address1FieldLocator, address1);
        Utility.sendDataToElement(driver, address2FieldLocator, address2);

        Utility.sendDataToElement(driver, countryFieldLocator, country);
        Utility.sendDataToElement(driver, stateFieldLocator, state);
        Utility.sendDataToElement(driver, cityFieldLocator, city);
        Utility.sendDataToElement(driver, zipcodeFieldLocator, zipcode);
        Utility.sendDataToElement(driver, mobileNumberFieldLocator, mobileNumber);

        return this;
    }

    public P03_SignupPage clickOnNewsletterCheckbox() {
        Utility.clickOnElement(driver, newsletterCheckboxLocator);
        return this;
    }

    public P03_SignupPage clickOnSpecialOfferCheckbox() {
        Utility.clickOnElement(driver, specialOfferCheckboxLocator);
        return this;
    }

    public P04_AccountCreatedPage clickOnCreateAccountButton() {
        Utility.scrollToElement(driver, createAccountButtonLocator);
        Utility.clickOnElement(driver, createAccountButtonLocator);
        return new P04_AccountCreatedPage(driver);
    }


}
