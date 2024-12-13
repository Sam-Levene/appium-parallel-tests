package screens

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class BaseScreen(val driver: AppiumDriver) {

    var wait: WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(15))

    fun waitUntilElementVisible(e: WebElement): WebElement {
        wait.until(ExpectedConditions.visibilityOf(e))
        return e
    }

    fun waitUntilElementClickable(e: WebElement): WebElement {
        wait.until(ExpectedConditions.elementToBeClickable(e))
        return e
    }

    fun waitUntilElementInvisible(e: WebElement) {
        wait.until(ExpectedConditions.invisibilityOf(e))
    }
}