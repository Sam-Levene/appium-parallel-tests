package utilities

import elements.LoginElements.loginButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.By

object DriverKeyboardHandler {
    fun hideKeyboard(driver: AppiumDriver) {
        if (driver is AndroidDriver) {
            driver.hideKeyboard()
        } else {
            (driver as IOSDriver).findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]"))
                .click()
        }
    }

    fun hideSecondKeyboard(driver: AppiumDriver) {
        if (driver is AndroidDriver) {
            driver.hideKeyboard()
            loginButton.click()
        } else {
            (driver as IOSDriver).findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"))
                .click()
        }
    }

    fun hideSearchKeyboard(driver: AppiumDriver) {
        if (driver is AndroidDriver) {
            driver.hideKeyboard()
        } else if (driver is IOSDriver) {
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Search\"]")).click()
        }
    }
}