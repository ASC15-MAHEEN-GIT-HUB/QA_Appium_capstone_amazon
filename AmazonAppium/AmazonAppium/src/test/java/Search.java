import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Search {

    public static void main(String[] args) {
        AndroidDriver<MobileElement> driver = null;

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S24 FE");
            caps.setCapability(MobileCapabilityType.UDID, "R5CX92ZE6GT");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            // Amazon App
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.amazon.mShop.android.shopping");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.navigation.MainActivity");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);

            WebDriverWait wait = new WebDriverWait(driver, 20);

            // Wait for search box to be clickable
            MobileElement searchBox = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"in.amazon.mShop.android.shopping:id/chrome_search_hint_view\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(searchBox));

            // Click the search box
            searchBox.click();
            Thread.sleep(5000);

            // Type the product name
            MobileElement searchInput = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"in.amazon.mShop.android.shopping:id/rs_search_src_text\")"
            );
            searchInput.sendKeys("oppo");


            System.out.println("Search for oppo initiated!");
            Thread.sleep(5000);
            
            MobileElement enterBox = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().description(\"oppo\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(enterBox));

            // Click the search box
            enterBox.click();
            
            Thread.sleep(5000);
            
            MobileElement AddToCart = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"a-autoid-0-announce\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(AddToCart));
            AddToCart.click();
            
            Thread.sleep(5000);
            MobileElement GoCart = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().resourceId(\"in.amazon.mShop.android.shopping:id/bottom_tab_button_icon\").instance(3)"
            );
            wait.until(ExpectedConditions.elementToBeClickable(GoCart));

            // Click the search box
            GoCart.click();
            Thread.sleep(5000);
            
            
            MobileElement Remove = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().description(\"Delete OPPO Reno14 5G (Pearl White, 12GB RAM, 256GB Storage) with No Cost EMI/Additional Exchange Offers\").instance(1) "
            );
            wait.until(ExpectedConditions.elementToBeClickable(Remove));

            // Click the search box
            Remove.click();
            


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
