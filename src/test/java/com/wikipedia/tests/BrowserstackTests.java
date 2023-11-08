package com.wikipedia.tests;

import com.wikipedia.pages.ArticlePage;
import com.wikipedia.pages.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;

@Tag("browserstack")
@Epic(value = "Проверка мобильного приложения Wikipedia")
@Feature(value = "Проверка поиска в приложении")
@Owner("Overloque")
public class BrowserstackTests extends BaseTest {
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка отображения подсказок при вводе запроса")
    void successfulSearchTest() {
        step("Клик на поисковое поле", () ->
                searchPage.clickSearch());

        step("Ввод значения в поисковое поле", () ->
                searchPage.sendData("Appium"));

        step("Проверка, что подсказки появились", () ->
                searchPage.checkTipsExist());
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка отображения иконки ошибки при переходе в некорректную статью")
    void checkErrorIcon() {
        step("Кликнуть на поисковое поле", () ->
                searchPage.clickSearch());

        step("Ввод значение в поисковое поле", () ->
                searchPage.sendData("Appium"));

        step("Проверка, что подсказки появились", () ->
                searchPage.checkTipsExist());

        step("Клик на первый элемент", () ->
                searchPage.clickFirstTip());

        step("Проверка отображения иконки ошибки", () ->
                searchPage.checkExistingErrorIcon());
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка выдачи существующей статьи")
    void checkExisingArticle() {
        step("Кликнуть на поисковое поле", () ->
                searchPage.clickSearch());

        step("Ввод значение в поисковое поле", () ->
                searchPage.sendData("Autotests"));

        step("Проверка, что подсказки появились", () ->
                searchPage.checkTipsExist());

        step("Клик на первый элемент", () ->
                searchPage.clickFirstTip());

        step("Проверка отображения иконки ошибки", () ->
                articlePage.findText("Autotests"));
    }
}
