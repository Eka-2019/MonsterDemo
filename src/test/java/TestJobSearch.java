import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestJobSearch {
    WebDriver driver;


    @BeforeTest
    public void runDriver() {
        WebDriverManager.chromedriver().version("81.0.4044.138").setup();
        driver = new InitiateDriver(new ChromeDriver(), "https://www.monsterworksdemo.com/");
    }


    @Test
    public void searchJobTest() {

        DashboardPage dshPage = new DashboardPage(driver);
        dshPage.pressLink();
        dshPage.getElementByNumber(2).click();
        dshPage.clickSaveBtn();

        dshPage.getLastElement().click();
        dshPage.clickSaveBtn();

        dshPage.cursorMenuMyJobSearch();
        dshPage.clickMenuSavedJob();
        dshPage.getSavedJobsQuantity();

        Assert.assertEquals(dshPage.getSavedJobsQuantity(),2);

    }


    @AfterTest
    public void stopDriver() {
        driver.close();
    }


}
