package running;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverInstance.DriverInstance;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class HomePage_Steps {
    WebDriver driver;
    DriverInstance dInstance=new DriverInstance();
    ResourceBundle config = ResourceBundle.getBundle("configuration");
   // ResourceBundle elements = ResourceBundle.getBundle("elements");

 // ############ Given steps ######################

    @Given("^User on Home Page$")
    public void user_on_Home_Page() throws Throwable {
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
    }

    @Given("^User enters app Address$")
    public void user_enters_app_Address() throws Throwable {
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.rms.com/how-we-serve");
        driver.navigate().back();
        driver.navigate().refresh();

    }
    @Given("^User enters \"([^\"]*)\"$")
    public void userEnters(String arg1) throws Throwable {
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(arg1);
        Thread.sleep(3000);
    }

 // ############### When steps ########################

    @When("^Click on the on \"([^\"]*)\" tab$")
    public void clickOnTheOnTab(String arg0) throws Throwable {
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        driver.findElement(By.linkText(arg0)).click();
        Thread.sleep(3000);
    }

    @When("^User move cursor on the \"([^\"]*)\" tab$")
    public void userMoveCursorOnTheTab(String arg0) throws Throwable {
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText(arg0))).perform();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(scrFile, new File("C:/Users/User/Desktop/ud282-master/ud282-master/Java_Cucumber/screenshot.jpg"));
        Thread.sleep(3000);
    }

    // ############### And steps ########################

    @And("^User should see \"([^\"]*)\" as the inner_tab$")
    public void user_should_see_as_the_inner_tab(String arg1) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(arg1));
        Thread.sleep(2000);
    }

// ################## Then steps ##########################

    @Then("^User should be logged$")
    public void user_should_be_logged() throws Throwable {
    //    System.out.println("Hi");
        dInstance.closeDriverInstance(driver);
    }

    @Then("^The Home Page title should be - \"([^\"]*)\"$")
    public void userShouldBeOnTheHomePageWithTitle(String arg1) throws Throwable {
        Assert.assertEquals(driver.getTitle(), arg1);
    //    System.out.println(driver.getTitle());
        dInstance.closeDriverInstance(driver);
    }



    @Then("^The \"([^\"]*)\" page should be open$")
    public void theWindowShouldBeOpen(String arg0) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(arg0));
        System.out.println(driver.getTitle());
        dInstance.closeDriverInstance(driver);
    }


    @Then("^User should see \"([^\"]*)\" sub_tab$")
    public void userShouldSeeSubtab(String arg0) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(arg0));
        Thread.sleep(2000);
        dInstance.closeDriverInstance(driver);
    }

    @Then("^User should see \"([^\"]*)\" inner_tab$")
    public void userShouldSeeInner_tab(String arg1) throws Throwable {
        Assert.assertTrue(String.valueOf(driver.findElement(By.xpath("//strong[contains(text(),'" + arg1  + "')]"))),true);
     //   System.out.println("Element is presented");
        Thread.sleep(2000);
        dInstance.closeDriverInstance(driver);
    }

    @Then("^The Home Page URL should be correct$")
    public void the_Home_Page_URL_should_be_correct() throws Throwable {
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(config.getString("appURL")));
        dInstance.closeDriverInstance(driver);


    }
}
