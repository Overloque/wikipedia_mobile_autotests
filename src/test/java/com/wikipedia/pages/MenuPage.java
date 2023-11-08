package com.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MenuPage {
    private final SelenideElement
            username = $(By.xpath("//android.widget.EditText[@text='Username']")),
            password = $(By.xpath("//android.widget.EditText[@text='Password']")),
            repeatPassword = $(By.xpath("//android.widget.EditText[@text='Repeat password']")),
            email = $(By.xpath("//android.widget.EditText[@text='Email (Optional)']")),
            nextButton = $(id("org.wikipedia.alpha:id/create_account_submit_button")),
            loginButton = $(id("org.wikipedia.alpha:id/create_account_login_button")),
            loginMenuButton = $(id("org.wikipedia.alpha:id/main_drawer_login_button"));

    public MenuPage clickLoginMoreButton() {
        loginMenuButton.click();

        return this;
    }

    public MenuPage checkUsername() {
        username.shouldBe(visible);

        return this;
    }

    public MenuPage checkPassword() {
        password.shouldBe(visible);

        return this;
    }

    public MenuPage checkRepeatPassword() {
        repeatPassword.shouldBe(visible);

        return this;
    }

    public MenuPage checkEmail() {
        email.shouldBe(visible);

        return this;
    }

    public MenuPage checkLoginButton() {
        loginButton.shouldBe(visible);

        return this;
    }

    public MenuPage checkNextButton() {
        nextButton.shouldBe(visible);

        return this;
    }
}
