import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashboard = By.xpath ("//div[@id='DashboardView']");
    private By pilipsJobLink = By.xpath("//a[text()[contains(.,'Philips Jobs')]]");
    private By searchResult = By.xpath("//div[@id='SearchResults']");
    private By searchElement = By.xpath("//div[@class='flex-row']");

    private By saveBtn = By.xpath("//a[@id='SaveJob']//span[@class='label'][text()[contains(.,'Save')]]");
    private By menuMyJobSearch = By.xpath("//a[@id='dropdown-My-job-search']");
    private By menuSavedJob = By.xpath("//a[@tabindex='0'][text()='Saved Jobs']");
    private By listSavedJobs = By.xpath("//div[@class='list display-table']/div");
    private By homeIcon = By.xpath("//a[@id='dropdown-Home']");


    public void pressLink() {
        driver.findElement(pilipsJobLink).click();
    }

    public List<WebElement> getListOfElements() {
        return driver.findElements(searchElement);
    }

    public WebElement getElementByNumber(int number) {
        return getListOfElements().get(number - 1);
    }

    public WebElement getLastElement() {
        List<WebElement> elements = driver.findElements(searchElement);
        int size = elements.size();
        return elements.get(size-1);

    }

    public void clickSaveBtn(){
       // driver.findElement(saveBtn).sendKeys(Keys.RETURN);
        org.openqa.selenium.interactions.Actions actions = new Actions(driver);
        WebElement button = driver.findElement(saveBtn);
        actions.doubleClick(button);
        actions.perform();
    }

    public void cursorMenuMyJobSearch() {
        org.openqa.selenium.interactions.Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(menuMyJobSearch);
        actions.moveToElement(menu);
        actions.perform();
    }


    public void clickMenuSavedJob(){
        driver.findElement(menuSavedJob).click();
    }

    public int getSavedJobsQuantity(){
        int quantity = new Select(driver.findElement(listSavedJobs)).getOptions().size();
        return quantity;
    }


    public WebElement getDashboardView(){
        WebElement dsh = driver.findElement(dashboard);
        return dsh;
    }
}
