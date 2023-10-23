package demo.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("local")
public class LocalTests extends TestBase {
    @Test
    @DisplayName("Проверка 1-го шага")
    void firstWikiPageTest() {
        step("Открыть страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Проверка кнопки добавления языков", () ->
                $(id("org.wikipedia.alpha:id/addLanguageButton"))
                        .should(exist));
    }

    @Test
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
    @DisplayName("Проверка страницы 3-го шага")
    void thirdWikiPageTest() {
        step("Перейти на 3-й шаг", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Проверка наличия иконки", () ->
                $(id("org.wikipedia.alpha:id/imageViewCentered"))
                        .should(exist));

        step("Проверка заголовка страницы", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @DisplayName("Перейти на 4-й шаг")
    void fourthWikiPageTest() {
        step("Перейти на 4-й шаг", () -> {
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
