package com.github.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");

    }
    @Step("Ищем репозиторий {repo}")
    public void searchRepoLink(String repo){
        $("[data-unscoped-placeholder='Search GitHub']").setValue(repo).pressEnter();

    }

    @Step("Кликаем по ссылке репозитория")
    public void clickRepoLink(){
        $(".repo-list li a").click();
    }
    @Step("Кликаем по кнопке 'Issues'")
    public void clickIssuesButton(){
        $("#issues-tab").click();

    }
    @Step("Проверяем наличие таска с номером: {issue}")
    public void isExistIssue(String issue){
        $("div[aria-label='Issues']").$(withText(issue)).shouldBe(Condition.visible);

    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
