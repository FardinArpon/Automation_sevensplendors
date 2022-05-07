package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScenario {
    WebDriver driver;

    @FindBy(id = "user[email]")
    WebElement email;
    @FindBy(name = "user[password]")
    WebElement password;
    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]")
    WebElement signIn;
    @FindBy(xpath = "//p[contains(text(),'Welcome back, Shopware T!')]")
    WebElement welcomeBack;

    public LoginScenario(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String doLogin() throws InterruptedException {
        email.sendKeys("test@shop-ware.com");
        password.sendKeys("technicalTest");
        Thread.sleep(1000);
        signIn.click();
        return welcomeBack.getText();
    }
}
