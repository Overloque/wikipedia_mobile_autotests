package demo.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import demo.qa.drivers.BrowserStackDriver;
import demo.qa.drivers.LocalDriver;
import demo.qa.helpers.Attach;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private final static String host = System.getProperty("host");

    @BeforeAll
    static void beforeAll() {
        switch (host) {
            case "browserstack":
                Configuration.browser = BrowserStackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalDriver.class.getName();
                break;
        }

        Configuration.browserSize = null;
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void tearDown() {
        switch (host) {
            case "browserstack":
                String sessionId = Selenide.sessionId().toString();

                Attach.pageSource();
                Attach.addVideo(sessionId);
                break;
            case "local":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
        }
        closeWebDriver();
    }
}
