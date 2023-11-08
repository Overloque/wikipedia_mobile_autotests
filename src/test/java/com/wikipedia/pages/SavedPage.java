package com.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SavedPage {
    private final SelenideElement
            title = $(id("org.wikipedia.alpha:id/messageTitleView")),
            message = $(id("org.wikipedia.alpha:id/messageTextView")),
            loginButton = $(id("org.wikipedia.alpha:id/positiveButton")),
            notNowButton = $(id("org.wikipedia.alpha:id/positiveButton")),
            savedArticle = $(id("org.wikipedia.alpha:id/recycler_view"));


    public SavedPage checkTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public SavedPage checkMessage(String value) {
        message.shouldHave(text(value));

        return this;
    }

    public SavedPage checkLoginButton() {
        loginButton.shouldBe(visible);

        return this;
    }

    public SavedPage checkNotNowButton() {
        notNowButton.shouldBe(visible);

        return this;
    }

    public SavedPage checkSavedArticle() {
        savedArticle.shouldBe(visible);

        return this;
    }
}
