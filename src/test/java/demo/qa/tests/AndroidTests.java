package demo.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class AndroidTests extends TestBase {
    @Test
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
    @DisplayName("Проверка отображения иконки ошибки при переходе в статью")
    void checkErrorMessage() {
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
