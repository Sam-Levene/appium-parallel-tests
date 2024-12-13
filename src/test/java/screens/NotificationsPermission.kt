package screens

import elements.NotificationElements
import elements.NotificationElements.dialogAllow
import elements.NotificationElements.primerOk
import elements.SignUpElements.premiumEnrolmentSkip
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.support.PageFactory

class NotificationsPermission(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), NotificationElements)
    }

    fun skip() {
        try {
            if (driver is IOSDriver) {
                try {
                    waitUntilElementVisible(premiumEnrolmentSkip)
                    premiumEnrolmentSkip.click()
                    Thread.sleep(2000)
                } catch (e: Exception) {
                    // Do nothing with the Exception, just skip.
                }
                waitUntilElementVisible(primerOk)
                primerOk.click()
                waitUntilElementVisible(dialogAllow)
                dialogAllow.click()
                Thread.sleep(2000)
                waitUntilElementVisible(primerOk)
                primerOk.click()
                waitUntilElementVisible(dialogAllow)
                dialogAllow.click()
            } else {
                try {
                    waitUntilElementVisible(premiumEnrolmentSkip)
                    premiumEnrolmentSkip.click()
                    Thread.sleep(2000)
                } catch (e: Exception) {
                    // Do nothing with the Exception, just skip.
                }
                waitUntilElementVisible(primerOk)
                primerOk.click()
                waitUntilElementVisible(dialogAllow)
                dialogAllow.click()
                Thread.sleep(2000)
                waitUntilElementVisible(primerOk)
                primerOk.click()
                waitUntilElementVisible(dialogAllow)
                dialogAllow.click()
            }
        } catch (e: Exception) {
        // Do nothing with the Exception, just skip.
        }
    }
}