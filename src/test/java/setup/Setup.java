package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utility.Utility;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://courses.ultimateqa.com/users/sign_in");
    }
    @AfterMethod(groups = "login_positive") //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utility util = new Utility(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
