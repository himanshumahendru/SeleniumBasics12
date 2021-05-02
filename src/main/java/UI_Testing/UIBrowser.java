package UI_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The type Ui browser.
 */
public class UIBrowser {

    /**
     * The constant driver.
     */
    public static WebDriver driver;
    /**
     * The constant browser.
     */
    public static String browser = "chrome";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        if(browser.equals("chrome")) {
            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            // to remove chrome browser logs in console
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        }
            else if(browser.equals("firefox")) {
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
    driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
