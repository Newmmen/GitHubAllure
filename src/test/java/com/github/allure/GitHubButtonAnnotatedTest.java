package com.github.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class GitHubButtonAnnotatedTest {

    public static final String REPOSITORY = "Selenide";
    public static final String TASKNUMBER = "#1927";
    WebTest step = new WebTest();

    @Test
    public void annotatedIssueButtonTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        step.openMainPage();
        step.searchRepoLink(REPOSITORY);
        step.clickRepoLink();
        step.clickIssuesButton();
        step.isExistIssue(TASKNUMBER);
        step.takeScreenShot();
    }

}
