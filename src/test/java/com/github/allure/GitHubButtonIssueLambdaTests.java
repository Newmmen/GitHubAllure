package com.github.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubButtonIssueLambdaTests {
    public static final String REPOSITORY = "Selenide";
    public static final String TASKNUMBER = "#1927";

    @Test
    void isPresentIssuesStepTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
                    open("https://github.com");
                });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-unscoped-placeholder='Search GitHub']").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(".repo-list li a").click();
        });
        step("Кликаем по кнопке 'Issues'", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие таска с номером: " + TASKNUMBER, () -> {
            $("div[aria-label='Issues']").$(withText(TASKNUMBER)).shouldBe(Condition.visible);
        });

    }
}
