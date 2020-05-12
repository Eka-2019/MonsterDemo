import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class TestCreateAccountAndSearchJobSelenide {

    @BeforeTest
    public void runDriver() {
        WebDriverManager.chromedriver().version("81.0.4044.138").setup();
    }

    @Test
    public void testCreateAccountandSearchJobs() {
        ElementsCollection savedJobsCollection = $$(By.xpath("//div[@class='list display-table']/div"));
        SelenideElement menuSavedJob = $(By.xpath("//a[@tabindex='0'][text()='Saved Jobs']"));

        /**
         * main page open
         */
        open("https://www.monsterworksdemo.com/");
        // wait(2000);

        $(By.xpath("//div[@tab-id='1']//h3[@tabindex='0']")).shouldHave(text("already have"));
        $(By.xpath("//span[contains(text(),'CREATE ACCOUNT')]")).click();

        /**
         * account page open
         */
        open("https://www.monsterworksdemo.com/account/account-lite");

        $(By.xpath("//label[@id='label-elem_0']")).shouldHave(text("email"));
        $(By.xpath("//input[@id='c_elem_0']")).setValue("test72@yandex.ru");
        $(By.xpath("//input[@id='a_elem_1']")).setValue("Qa_Qa_123");
        $(By.xpath("//input[@id='a_elem_2']")).setValue("Qa_Qa_123");
        $(By.xpath("//select[@id='elem_3']")).selectOption(1);
        $(By.xpath("//label[@id='id_option_label_elem_5-true']/span")).click();
        $(By.xpath("//button[text()[contains(.,'Create')]]")).click();

        /**
        * new Dashboard page should be open
         */

        $(By.xpath(".//h2[contains(text(), 'My Check')]")).isDisplayed();
        $(By.xpath("//a[text()[contains(.,'Philips Jobs')]]")).click();
        $$(By.xpath("//div[@class='flex-row']")).get(1).click();
        $(By.xpath("//a[@id='SaveJob']//span[@class='label'][text()[contains(.,'Save')]]")).click();
        int lastElementIndex = savedJobsCollection.size();
        $$(By.xpath("//div[@class='flex-row']")).get(lastElementIndex).click();
        $(By.xpath("//a[@id='SaveJob']//span[@class='label'][text()[contains(.,'Save')]]")).click();
        $(By.xpath("//a[@id='dropdown-My-job-search']")).hover().selectOption(String.valueOf(menuSavedJob));

        savedJobsCollection.shouldHave(size(2));

    }
}
