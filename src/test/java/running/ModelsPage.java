package running;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverInstance.DriverInstance;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModelsPage {

    WebDriver driver;
    DriverInstance driverInstance = new DriverInstance();

    @Given("^User is on Home Page$")
    public void userIsOnHomePage() throws Throwable {
        driver = driverInstance.generateDriverInstance();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @When("^User is on Models Page$")
    public void userIsOnModelsPage() throws Throwable {
        driver=driverInstance.generateDriverInstance();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().to("https://www.rms.com/products/models");
    }

    @When("^Click on the \"([^\"]*)\" tab$")
    public void clickOnTheTab(String arg0) throws Throwable {
        driver.findElement(By.linkText(arg0)).click();
        Thread.sleep(3000);
    }

    @And("^Navigate to \"([^\"]*)\" link and click on it$")
    public void navigateToLinkAndClickOnIt(String arg0) throws Throwable {
        driver.findElement(By.linkText(arg0)).click();
        Thread.sleep(1000);
    }

    @Then("^User should be on website with URL - \"([^\"]*)\"$")
    public void userShouldBeOnURL (String arg0) throws Throwable {
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.rms.com/products/models"));
        driverInstance.closeDriverInstance(driver);
        }

    @Then("^The title of Web Page should be - \"([^\"]*)\"$")
    public void theTitleOfWebPageShouldBe(String arg0) throws Throwable {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(arg0));
        driverInstance.closeDriverInstance(driver);
    }

    @Then("^User can see \"([^\"]*)\" type of models$")
    public void userCanSeeTypeOfModels(String arg0) throws Throwable {
       Assert.assertTrue(String.valueOf(driver.findElement(By.partialLinkText(arg0))),true);
    }

    @Then("^User should see \"([^\"]*)\" type of models$")
    public void userShouldSeeTypeOfModels(String arg0) throws Throwable {
        Assert.assertTrue(String.valueOf(driver.findElement(By.partialLinkText(arg0))),true);
        driverInstance.closeDriverInstance(driver);
    }
}