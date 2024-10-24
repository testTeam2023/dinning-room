package org.RoomDining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for In-Room Dining option
    private By inRoomDiningOption = By.xpath("//a[contains(@class, 'trans') and @id='trans-anime']");

    // method to navigate to the main page
    public MainPage navigateToMainPage()throws InterruptedException{
        driver.get("https://app.thedigitalhotelier.com/53dec7e1-8b70-11ef-b728-0e96dd008680/qr-code");
       Thread.sleep(5000);
        return this ;
    }



    // Method to click on In-Room Dining
    public void clickInRoomDining() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inRoomDiningOption));
        driver.findElement(inRoomDiningOption).click();
    }
}