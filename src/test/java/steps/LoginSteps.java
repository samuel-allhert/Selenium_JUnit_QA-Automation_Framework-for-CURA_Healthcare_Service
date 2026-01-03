package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Alert;
import hooks.Hooks;

public class LoginSteps{
    //public WebDriver driver;
    LoginPage loginPage;

    @Given("I open the login page")
    public void OpenLoginPage(){
        //driver = new ChromeDriver();
        loginPage = new LoginPage(Hooks.driver);

        loginPage.Open();
        loginPage.ClickMakeAppointmentButton();
        loginPage.VerifyTextBelowLoginAppeared();
    }

    @When("I enter username {string} and password {string}")
    public void EnterCredentials(String username, String password){
        loginPage.EnterUsername(username);
        loginPage.EnterPassword(password);
    }

    @And("I click login")
    public void ClickLogin(){
        loginPage.ClickLoginButton();
    }

    @Then("I should see the dashboard")
    public void VerifySuccesfulLogin(){
        loginPage.VerifyAfterSuccessfulLogin();
        System.out.println("Sukses");
    }

    @Then("I should see login failed message")
    public void VerifyUnsuccessfulLogin(){
        loginPage.VerifyAfterUnsuccessfulLogin();
        System.out.println("Tidak Sukses");
    }
}
