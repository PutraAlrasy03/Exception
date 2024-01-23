package ExceptionHandling;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionClass {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // Set ChromeDriver options (optional)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Maximize the browser window

            // Set the path to the ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dev\\Downloads\\chromedriver.exe");

            // Initialize the WebDriver with ChromeDriver and options
            driver = new ChromeDriver(options);

            // Set up waits
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Longer wait for explicit waits

            // Set up implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait with a timeout of 10 seconds

            // Step 1: Open the Google login page
            System.out.println("Step 1: Opening Google login page");
            driver.get("https://google.com");

            // Step 2: Simulate a click on an element that doesn't exist (for demonstration)
            System.out.println("Step 2: Attempting to click an element that doesn't exist.");
            try {
                WebElement fakeElement = driver.findElement(By.name("fake"));
                fakeElement.click();
            } catch (NoSuchElementException e) {
                // Handle NoSuchElementException
                System.out.println("NoSuchElementException occurred: Element 'fake' not found.");
                // You can add further error handling or logging here.
            }

            System.out.println("Not Found Elemet");
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            System.out.println("Exception occurred in the main block: " + e.getMessage());
            // You can add specific error handling or logging for other exceptions here.
        } finally {
            if (driver != null) {
                // Step 3: Close the browser
                System.out.println("Step 3: Closing the browser");
                driver.quit();
            }
        }
    }
}

