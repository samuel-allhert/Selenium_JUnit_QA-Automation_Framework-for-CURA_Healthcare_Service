package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    public static WebDriver driver; // shared driver

    @Before
    public void setUp() {
        if (driver == null) {
            /*
            try {
                // Try to reuse existing browser
                if (driver != null) {
                    driver.getWindowHandle(); // similar to WebUI.getWindowIndex()
                    return;
                }
            } catch (Exception ignored) {
                // fall through and create new driver
            }

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options); // initialize driver once
            */

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-manager-reauthentication");
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");

            // Disable Chrome save password prompts
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("safebrowsing.enabled", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options); // initialize driver once
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(3000); // 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            driver = null; // reset for next run
        }
    }
}
