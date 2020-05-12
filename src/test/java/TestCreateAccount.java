import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCreateAccount {
    WebDriver driver;

    @BeforeTest
    public void runDriver() {
        WebDriverManager.chromedriver().version("81.0.4044.138").setup();
        driver = new InitiateDriver(new ChromeDriver(), "https://www.monsterworksdemo.com/");
    }



    @Test
    public void testCreateAccount() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(1000);
        String homePageTitle = homePage.getPageTitleInvisibleElement();
        Assert.assertTrue(homePageTitle.toLowerCase().contains("home"));

        String visibleElementOnPage = homePage.getVisibleElement(1);
        Assert.assertTrue(visibleElementOnPage.toLowerCase().contains("already have"));
        homePage.clickCreateAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        Thread.sleep(1500);
        String accountPageTitle = accountPage.getPageTitleInvisibleElement();
        Assert.assertTrue(accountPageTitle.toLowerCase().contains("create an"));

        String accountPageText = accountPage.getPageText();
        Assert.assertTrue(accountPageText.toLowerCase().contains("email"));

        accountPage.enterEmailAdress("test10@yandex.ru");

        accountPage.enterPassword(AccountPage.decodedPassword("UXdlcnRfMTIzNDU="));
        accountPage.reEnterPassword(AccountPage.decodedPassword("UXdlcnRfMTIzNDU="));
        accountPage.enterJobCenter(1);
        accountPage.switchTermCondition(true);
        Thread.sleep(500);
        accountPage.pressCreateAccountBtn();

        DashboardPage dash = new DashboardPage(driver);
        Thread.sleep(1000);
        Assert.assertEquals(true, dash.getDashboardView().isDisplayed());
    }

    @AfterTest
    public void stopDriver() {
        driver.close();
    }


}
