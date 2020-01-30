package driverInstance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;

public class DriverInstance {
    public WebDriver generateDriverInstance() {
        WebDriver driver;
        ResourceBundle config = ResourceBundle.getBundle("configuration");

        if (config.getString("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            driver = new ChromeDriver();
        }else if(config.getString("browser").equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            driver = new ChromeDriver();
        }
     //   driver.get(config.getString("appURL"));
        driver.get("https://www.rms.com/");
        return driver;
    }

    public void closeDriverInstance(WebDriver driver){
        driver.quit();
    }
}