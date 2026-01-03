package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Random;

public class AppointmentPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Random random = new Random();

    public AppointmentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ChooseFacilityDropdown(){
        System.out.println("GG1");
        int number = random.nextInt(2);
        number += 1;// For Choosing Facility
        System.out.println("Facility Number = " + number);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//select[@id='combo_facility']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//select[@id='combo_facility']/option[" + number + "]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='checkbox']"))).click();
        System.out.println("GG3");
        number = random.nextInt(2);
        number += 1; // For Choosing Healthcare Program
        System.out.println("Healthcare Program Number = " + number);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='col-sm-4']/label[" + number + "]"))).click();
        System.out.println("GG4");
        // Pick a date
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='glyphicon glyphicon-calendar']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[text()='15']"))).click();
        System.out.println("GG5");

        // Enter Comment
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//textarea[@id='txt_comment']")))
                .sendKeys("Isi Comment nya bos!!!");

        // Button book appointment
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='btn-book-appointment']"))).click();
    }

    public void VerifyBookingConfirmationText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@class='lead']")))
                .isDisplayed();
    }
}
