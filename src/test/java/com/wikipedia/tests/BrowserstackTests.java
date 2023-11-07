package com.wikipedia.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("browserstack")
@Epic(value = "Проверка мобильного приложения Wikipedia")
@Feature(value = "Проверка основных страниц приложения")
@Owner("Overloque")
public class BrowserstackTests extends BaseTest {
    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка непустой выдачи при запросе")
    void successfulSearchTest() {
        step("Ввести запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверить что выдача не пустая", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка отображения иконки ошибки при переходе в статью")
    void checkErrorIcon() {
        step("Ввести запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверить что выдача не пустая", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Кликнуть на первый элемент", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click());

        step("Проверить что на странице отображается иконка ошибки", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_icon")).should(exist);
        });
    }
}
