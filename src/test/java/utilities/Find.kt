package utilities

import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver

fun scrollTo(driver: AppiumDriver, elementToBeFound: String) {
    try {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(resourceId(\"$elementToBeFound\"))"))
    } catch (e: Exception) {
        //Do nothing with the exception, just catch
    }
}