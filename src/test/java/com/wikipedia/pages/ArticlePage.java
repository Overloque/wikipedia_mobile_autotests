package com.wikipedia.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class ArticlePage {
    private final SelenideElement
            saveButton = $(id("org.wikipedia.alpha:id/page_save")),
            backButton = $(AppiumBy.className("android.widget.ImageButton"));
    private final ElementsCollection
            contentArticle = $$(AppiumBy.className("android.view.View"));


    public ArticlePage clickSave() {
        saveButton.click();

        return this;
    }

    public ArticlePage clickBack() {
        backButton.click();

        return this;
    }

    public ArticlePage findText(String value) {
        contentArticle.findBy(text(value));

        return this;
    }
}
