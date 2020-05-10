
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//span[contains(text(),'CREATE ACCOUNT')]")
    WebElement createAccountBtn;
    @FindBy(xpath = "//title[@ng-bind='pageTitle']")
    WebElement titleText;
    @FindBy(xpath = "//div[@tab-id='1']//h3[@tabindex='0']")
    List<WebElement> visibleElement;


    public void clickCreateAccountBtn() {
        createAccountBtn.click();
    }

    public String getPageTitleInvisibleElement() {
        return titleText.getAttribute("textContent");
    }

    public String getVisibleElement(int num) {
        return visibleElement.get(num - 1).getText();
    }


}
