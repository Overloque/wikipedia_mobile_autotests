package com.wikipedia.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    private final SelenideElement
            savedButton = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists")),
            searchButton = $(id("org.wikipedia.alpha:id/nav_tab_search")),
            moreButton = $(id("org.wikipedia.alpha:id/menu_icon"));

    public MainPage clickSavedComponent() {
        savedButton.click();

        return this;
    }

    public MainPage clickSearchComponent() {
        searchButton.click();

        return this;
    }

    public MainPage clickMoreComponent() {
        moreButton.click();

        return this;
    }
}
