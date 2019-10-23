package pageObjects;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class GoogleTranslator extends BasePage {

    String url = "https://translate.google.com/";

    @Step("Open Google Translator page")
    public void openGoogleTranslator() {
        openUrl(url);
    }

    @Step("Set English as a source language")
    public void setInitialLanguage() {
        $(byXpath("//*[@class='sl-more tlid-open-source-language-list']")).click();
        $(byXpath("//*[@class='language-list-unfiltered-langs-sl_list']//*[text()='English']")).click();
    }

    @Step("Set Spanish as a result language")
    public void setResultLanguage() {
        $(byXpath("//*[@class='tl-more tlid-open-target-language-list']")).click();
        $(byXpath("//*[@class='language-list-unfiltered-langs-tl_list']//*[text()='Spanish']")).click();
    }

    @Step("Fill source Phrase")
    public void fillSourcePhrase(String phrase) {
        $(byId("source")).sendKeys(phrase);
    }

    @Step("Get translation")
    public String getTranslation() {
        String translation = $(byXpath("//*[@class='tlid-translation translation']/span")).getText();
        return translation;
    }

    @Step("Click button swap languages")
    public void clickSwapLanguages() {
        $(".swap .jfk-button-img").click();
    }

    @Step("Click button History")
    public void clickHistoryButton() {
        $(byId("ft-icon-img-hst")).click();
    }

    @Step("Check History tab is visible")
    public void checkHistoryTabVisibility() {
        $(byXpath("//*[@class='title'][text()='History']")).shouldBe(Condition.visible);
    }

    @Step("Get number of translations")
    public String getNumberOfTranslations() {
        String translations = $(byXpath("//*[@class='tlid-history-num-entries num-entries']")).getText();
        return translations;
    }
}
