package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginScenario;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LoginScenario loginScenario;

    @Test
    public void Login() throws InterruptedException {
        loginScenario = new LoginScenario(driver);
        String welcomeText = loginScenario.doLogin();
        Assert.assertEquals(welcomeText,"Welcome back, Shopware T!");
    }
}
