package Steps;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tika.metadata.PDF;
import org.junit.Assert;
import org.junit.BeforeClass;


import java.io.File;
import java.io.FileNotFoundException;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class MyStepdefs {

    Page Yandex;
    @BeforeClass
    public static void downloadSetup() {
        Selenide.closeWebDriver();
        //установка стандартной папки для скачивания файлов
        downloadsFolder = "D:\\папки\\Тесты\\Testy_3\\src\\main\\java\\Downloads";
        fileDownload = FileDownloadMode.FOLDER;
        proxyEnabled = false;
    }

    @Before
    public void Start(){
        Yandex =new Page();
        Yandex.open();
        headless = true;
    }

    @After
    public void Finish(){
    Yandex.CloseP();
    }
    @Given("I go to main page")
    public void iGoToMainPage() {
        Yandex
                .open();


    }

    @When("I login as {string} with password {string}")
    public void iLoginAsWithPassword(String login, String password) {
        Yandex.InputID("passp-field-login",login)
                .Click_LinkID("passp:sign-in")
                .InputID("passp-field-passwd",password)
                .Click_LinkID("passp:sign-in");
    }

    @Then("I have been successfully logged")
    public void iHaveBeenSuccessfullyLogged() {
        Yandex.shouldEl("user-pic__image");
    }

    @And("I check my services")
    public void iCheckMyServices() {
        Yandex.Click_Link("Мои сервисы");
    }

    @And("I check my email")
    public void iCheckMyAcademicRecord() {
        Yandex.Click_LinkClass("user-pic__image")
                .Click_Link("Почта");
    }

    @Then("I was convinced of the existence of such tabs")
    public void iWasConvincedOfTheExistenceOfSuchTabs() {
    }

    @And("I go to my Disk")
    public void iGoToMyDisk() {
        $(byClassName("user-pic__image")).click();
        $(byText("Мой диск")).click();
    }

    @And("I'm uploading a photo")
    public void iMUploadingAPhoto() {
        Configuration.timeout = 10000;
        $(byClassName("upload-button__attach")).uploadFile(new File("D:\\папки\\Тесты\\Testy_3\\src\\main\\java\\fileuo\\Горы_1.jpg"));
        //Фотка загружена

    }

    @And("I'm downloading file")
    public void iMDownloadingFile() throws FileNotFoundException {
        downloadsFolder = "D:\\папки\\Тесты\\Testy_3\\src\\main\\java\\Downloads";
        fileDownload = FileDownloadMode.FOLDER;
        proxyEnabled = false;

        Configuration.timeout = 10000;

        File certificateFile = null;
        //скачивание файла
        ElementsCollection resultLinks = $$(byClassName("clamped-text"));

        Configuration.timeout = 10000;
        resultLinks.findBy(text("Проверки.pdf")).contextClick();

        certificateFile = $(byValue("download")).download();
        //Фотка удалена
    }

    @And("I go to the applications section and download one of them")
    public void iGoToTheApplicationsSectionAndDownloadOneOfThem() throws FileNotFoundException {


    }

    @Then("I am certified that the photo has been uploaded ,the file has been downloaded")
    public void iAmCertifiedThatThePhotoHasBeenUploadedTheFileHasBeenDownloaded() {
    }
}
