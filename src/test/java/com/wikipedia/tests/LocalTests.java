package com.wikipedia.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;

@Tag("local")
@Epic(value = "Проверка мобильного приложения Wikipedia")
@Feature(value = "Проверка основных страниц приложения")
@Owner("Overloque")
public class LocalTests extends BaseTest {
    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка страницы 1-го шага")
    void firstWikiPageTest() {
        step("Открыть страницу и проверить текст кнопки добавления языков", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia"));
        });

        step("Проверка кнопки добавления языков", () ->
                $(id("org.wikipedia.alpha:id/addLanguageButton"))
                        .should(exist));
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка страницы 2-го шага")
    void secondWikiPageTest() {
        step("Перейти на 2-й шаг", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Проверка наличия иконки", () ->
                $(id("org.wikipedia.alpha:id/imageViewCentered"))
                        .should(exist));

        step("Проверка заголовка страницы", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка страницы 3-го шага")
    void thirdWikiPageTest() {
        step("Перейти на 3-й шаг", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Проверка наличия иконки", () ->
                $(id("org.wikipedia.alpha:id/imageViewCentered"))
                        .should(exist));

        step("Проверка заголовка страницы", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка страницы 4-го шага")
    void fourthWikiPageTest() {
        step("Перейти на 4-й шаг", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Проверка наличия иконки", () ->
                $(id("org.wikipedia.alpha:id/imageViewCentered"))
                        .should(exist));

        step("Проверка заголовка страницы", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));

        step("Проверка наличия кнопки Reject", () ->
                $(id("org.wikipedia.alpha:id/rejectButton"))
                        .shouldBe(visible));

        step("Проверка наличия кнопки Accept", () ->
                $(id("org.wikipedia.alpha:id/acceptButton"))
                        .shouldBe(visible));
    }
}
