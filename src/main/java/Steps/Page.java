package Steps;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Page {
    public Page open() {
        Selenide.open("https://passport.yandex.ru/auth");
        return this;
    }

    public  Page Click_LinkID(String Path){
        $(By.id(Path)).click();
        return this;
    }

    public  Page Click_LinkClass(String Path){
        $(byClassName(Path)).click();
        return this;
    }

    public  Page Click_Link(String Path){
        $(byText(Path)).click();
        return this;
    }

    public Page Input(String Xp,String text) {
        $(byClassName(Xp)).setValue(text);
        return this;
    }

    public Page InputID(String Xp,String text) {
        $(By.id(Xp)).setValue(text);
        return this;
    }

    public Page HaveText(String path, String text1){
        $(By.id(path)).shouldHave(text(text1));
        return this;
    }

    public void CloseP(){
        Selenide.closeWebDriver();
    }

    public void shouldEl(String path) {

        $(byClassName(path)).should(exist);
    }

}