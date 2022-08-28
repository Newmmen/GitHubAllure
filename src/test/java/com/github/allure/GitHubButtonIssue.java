package com.github.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubButtonIssue {
    @Test
    void isPresentIssues() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[data-unscoped-placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $(".repo-list li a").click();
        $("#issues-tab").click();
        $("div[aria-label='Issues']").$(withText("#1927")).shouldBe(Condition.visible);
    }
}
