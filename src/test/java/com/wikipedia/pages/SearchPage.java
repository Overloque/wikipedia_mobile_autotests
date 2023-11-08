package com.wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SearchPage {
    private final SelenideElement
            searchField = $(accessibilityId("Search Wikipedia")),
            searchFieldInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            errorIcon = $(id("org.wikipedia.alpha:id/view_wiki_error_icon"));

    private final ElementsCollection
            tips = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            tipEntity = $$(id("org.wikipedia.alpha:id/page_list_item_container"));

    public SearchPage clickSearch() {
        searchField.click();

        return this;
    }

    public SearchPage sendData(String value) {
        searchFieldInput.sendKeys(value);

        return this;
    }

    public SearchPage checkTipsExist() {
        tips.shouldHave(sizeGreaterThan(0));

        return this;
    }

    public SearchPage clickFirstTip() {
        tipEntity.first().click();

        return this;
    }

    public SearchPage clickFirstTipLocal() {
        tips.first().click();

        return this;
    }

    public SearchPage checkExistingErrorIcon() {
        errorIcon.should(exist);

        return this;
    }
}
