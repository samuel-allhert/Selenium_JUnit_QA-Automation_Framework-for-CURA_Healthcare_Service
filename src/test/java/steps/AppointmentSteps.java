package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AppointmentPage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hooks.Hooks;

public class AppointmentSteps{
    //public WebDriver driver;
    AppointmentPage appointmentPage;
    //LoginPage loginPage;

    @When("I fill the appointment form")
    public void fillAppointmentForm(){
        //driver = new ChromeDriver();
        appointmentPage = new AppointmentPage(Hooks.driver);
        appointmentPage.ChooseFacilityDropdown();
    }

    @Then("I should see booking confirmation text")
    public void verifyBookingSuccess(){
        appointmentPage.VerifyBookingConfirmationText();
    }
}
