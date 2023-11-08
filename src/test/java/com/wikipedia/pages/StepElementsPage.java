package com.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class StepElementsPage {
    private final SelenideElement
            nextButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            pageTitle = $(id("org.wikipedia.alpha:id/primaryTextView")),
            addButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            icon = $(id("org.wikipedia.alpha:id/imageViewCentered")),
            rejectButton = $(id("org.wikipedia.alpha:id/rejectButton")),
            acceptButton = $(id("org.wikipedia.alpha:id/rejectButton")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    public StepElementsPage checkTitle(String value) {
        pageTitle.shouldHave(text(value));

        return this;
    }

    public StepElementsPage pressNext() {
        nextButton.click();

        return this;
    }

    public StepElementsPage pressSkip() {
        skipButton.click();

        return this;
    }

    public StepElementsPage checkAddButton() {
        addButton.shouldBe(visible);

        return this;
    }

    public StepElementsPage checkIcon() {
        icon.shouldBe(visible);

        return this;
    }

    public StepElementsPage checkRejectButton() {
        rejectButton.shouldBe(visible);

        return this;
    }

    public StepElementsPage checkAcceptButton() {
        acceptButton.shouldBe(visible);

        return this;
    }
}
