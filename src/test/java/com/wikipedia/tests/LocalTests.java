package com.wikipedia.tests;

import com.wikipedia.pages.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;

@Tag("local")
@Epic(value = "Проверка мобильного приложения Wikipedia")
@Feature(value = "Проверка основных страниц приложения")
@Owner("Overloque")
public class LocalTests extends BaseTest {
    StepElementsPage stepElementsPage = new StepElementsPage();
    MainPage mainPage = new MainPage();
    SavedPage savedPage = new SavedPage();
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();
    MenuPage menuPage = new MenuPage();

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка стартовых страниц wiki")
    void checkStepsTest() {
        step("Проверка 1-й страницы", () -> {
            step("Проверка заголовка", () ->
                    stepElementsPage.checkTitle("The Free Encyclopedia"));
            step("Проверка кнопки добавления языков", () ->
                    stepElementsPage.checkAddButton());
        });

        step("Переход на 2-й шаг", () ->
                stepElementsPage.pressNext());

        step("Проверка 2-й страницы", () -> {
            step("Проверка наличия иконки", () ->
                    stepElementsPage.checkIcon());
            step("Проверка заголовка", () ->
                    stepElementsPage.checkTitle("New ways to explore"));
        });

        step("Переход на 3-й шаг", () ->
                stepElementsPage.pressNext());

        step("Проверка 3-й страницы", () -> {
            step("Проверка наличия иконки", () ->
                    stepElementsPage.checkIcon());
            step("Проверка заголовка", () ->
                    stepElementsPage.checkTitle("Reading lists with sync"));
        });

        step("Переход на 4-й шаг", () ->
                stepElementsPage.pressNext());

        step("Проверка 4-й страницы", () -> {
            step("Проверка наличия иконки", () ->
                    stepElementsPage.checkIcon());
            step("Проверка заголовка", () ->
                    stepElementsPage.checkTitle("Send anonymous data"));
            step("Проверка наличия иконки", () ->
                    stepElementsPage.checkAcceptButton());
            step("Проверка наличия иконки", () ->
                    stepElementsPage.checkRejectButton());
        });
    }

    @Test
    @Severity(MINOR)
    @DisplayName("Проверка компонента Saved")
    void checkSavedPage() {
        step("Пропуск стартовых шагов", () ->
                stepElementsPage.pressSkip());

        step("Переход в раздел Saved", () ->
                mainPage.clickSavedComponent());

        step("Проверка компонента Saved", () -> {
            step("Проверка заголовка", () ->
                    savedPage.checkTitle("Sync reading lists"));
            step("Проверка сообщения", () ->
                    savedPage.checkMessage("Reading lists can now be synced across devices. " +
                            "Log in to your Wikipedia account and allow your lists to be saved."));
            step("Проверка наличия кнопки 'Log in'", () ->
                    savedPage.checkLoginButton());
            step("Проверка наличия кнопки 'Not now'", () ->
                    savedPage.checkNotNowButton());
        });
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверка добавления статьи в компонент Saved")
    void checkSearchFromComponent() {
        step("Пропуск стартовых шагов", () ->
                stepElementsPage.pressSkip());

        step("Переход в раздел Search", () ->
                mainPage.clickSearchComponent());

        step("Поиск статьи", () -> {
            step("Клик на поисковое поле", () ->
                    searchPage.clickSearch());
            step("Ввод текста в поисковое поле", () ->
                    searchPage.sendData("Autotesting"));
            step("Проверка, что подсказки появились", () ->
                    searchPage.checkTipsExist());
            step("Клик на первый элемент", () ->
                    searchPage.clickFirstTipLocal());
        });

        step("Сохранение статьи", () ->
                articlePage.clickSave());

        step("Переход обратно на глвную страницу", () -> {
            articlePage.clickBack();
            articlePage.clickBack();
        });

        step("Переход в раздел Saved", () ->
                mainPage.clickSavedComponent());

        step("Проверка отображения статьи в сохранённых", () ->
                savedPage.checkSavedArticle());
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка компонента More")
    void checkMoreComponent() {
        step("Пропуск стартовых шагов", () ->
                stepElementsPage.pressSkip());

        step("Переход в раздел More", () -> {
            mainPage.clickMoreComponent();
            menuPage.clickLoginMoreButton();
        });

        step("Проверка наличия полей ввода", () -> {
            step("Проверка поля Username", () ->
                    menuPage.checkUsername());
            step("Проверка поля Password", () ->
                    menuPage.checkPassword());
            step("Проверка поля Repeat password", () ->
                    menuPage.checkRepeatPassword());
            step("Проверка поля Email", () ->
                    menuPage.checkEmail());
        });

        step("Проверка наличия кнопок", () -> {
            step("Проверка кнопки Next", () ->
                    menuPage.checkNextButton());
            step("Проверка кнопки Log in", () ->
                    menuPage.checkLoginButton());
        });
    }
}
