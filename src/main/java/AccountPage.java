import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleText = By.xpath("//title[@ng-bind='pageTitle']");
    private By pageText = By.xpath("//label[@id='label-elem_0']");
    private By emailAddressFiled = By.xpath("//input[@id='c_elem_0']");
    private By passwordField = By.xpath("//input[@id='a_elem_1']");
    private By reEnterPasswordField = By.xpath("//input[@id='a_elem_2']");
    private By jobCorpsCenterField = By.xpath("//select[@id='elem_3']");
    private By termConditionCheckBox = By.xpath("//label[@id='id_option_label_elem_5-true']/span");
    private By createAccountBtn = By.xpath("//button[text()[contains(.,'Create')]]");



    public String getPageTitleInvisibleElement() {
        return driver.findElement(titleText).getAttribute("textContent");
    }

    public void enterEmailAdress(String email) {
        driver.findElement(emailAddressFiled).sendKeys(email);
    }

    public static String decodedPassword(String password){
        byte[] decodedPassword = Base64.decodeBase64(password);
        return new String(decodedPassword);
    }

    public void enterPassword(String psw) {
        driver.findElement(passwordField).sendKeys(psw);
    }

    public void reEnterPassword(String psw) {
        driver.findElement(reEnterPasswordField).sendKeys(psw);
    }


    public void enterJobCenter(int num) {
        Select jobCenter = new Select(driver.findElement(jobCorpsCenterField));
        jobCenter.selectByIndex(num);
    }

    public void switchTermCondition(boolean value) {
        WebElement checkbox = driver.findElement(termConditionCheckBox);
        if (!checkbox.isSelected() == value) {
            checkbox.click();
        }
    }

    public void pressCreateAccountBtn() {
        driver.findElement(createAccountBtn).sendKeys(Keys.RETURN);
    }

    public String getPageText() {
        return driver.findElement(pageText).getText();
    }

}
