import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.GoogleTranslator;

public class TestGoogleTranslator extends BaseTest {

    GoogleTranslator translator = new GoogleTranslator();
    String sourcePhrase = "Hello World";
    String translatedPhrase = "Hola Mundo";

    @Test(priority = 1)
    public void translatePhrase() {
        translator.openGoogleTranslator();
        translator.setInitialLanguage();
        translator.setResultLanguage();
        translator.fillSourcePhrase(sourcePhrase);
        Assert.assertEquals(translator.getTranslation(), translatedPhrase);
    }

    @Test(priority = 2)
    public void swapLanguages() {
        translator.clickSwapLanguages();
        Assert.assertEquals(translator.getTranslation(), sourcePhrase);
    }

    @Test(priority = 3)
    public void checkHistory() {
        translator.clickHistoryButton();
        translator.checkHistoryTabVisibility();
        Assert.assertEquals(translator.getNumberOfTranslations(), "2 translations");
    }

}
