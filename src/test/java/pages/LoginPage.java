package pages;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Open(){
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    public void ClickMakeAppointmentButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@id='btn-make-appointment']"))).click();
    }

    public void VerifyTextBelowLoginAppeared(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Please login to make appointment.']")));
    }

    public void EnterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='txt-username']"))).sendKeys(username);
    }

    public void EnterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='txt-password']"))).sendKeys(password);
    }

    public void ClickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='btn-login']"))).click();
    }

    public void VerifyAfterSuccessfulLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='chk_hospotal_readmission']")))
                .isDisplayed();
        try {
            Thread.sleep(4000); // 4 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // assuming driver is already initialized
        // Alert alert = Hooks.driver.switchTo().alert();
        // alert.accept(); // clicks "OK"
    }

    public void VerifyAfterUnsuccessfulLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='lead text-danger']")))
                .isDisplayed();
    }

    public void Close(){
        driver.quit();
    }
}
