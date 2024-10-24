import io.github.bonigarcia.wdm.WebDriverManager;
import org.RoomDining.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InRoomDiningTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @Test
    public void testAccessInRoomDining()throws InterruptedException {
        mainPage
                .navigateToMainPage()
                .clickInRoomDining();

        // Assert that the user has navigated to the In-Room Dining page
        String expectedUrl = "https://app.thedigitalhotelier.com/53dec7e1-8b70-11ef-b728-0e96dd008680/restaurant/categories/10"; // Update with the expected URL
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User is not navigated to the In-Room Dining page.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
