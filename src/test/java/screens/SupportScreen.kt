package screens

import elements.EntryElements
import elements.EntryElements.loadingAnimation
import elements.NavElements
import elements.NavElements.navAccount
import elements.SupportElements
import elements.SupportElements.androidAddNewHostElement
import elements.SupportElements.androidElementHostNewestHost
import elements.SupportElements.androidHostAddressField
import elements.SupportElements.androidHostNameField
import elements.SupportElements.androidSaveButton
import elements.SupportElements.appVersion
import elements.SupportElements.iOSAddNewHostButton
import elements.SupportElements.iOSHostAddressField
import elements.SupportElements.iOSIsCaptchaRequiredNoButton
import elements.SupportElements.iOSSaveHostButton
import elements.SupportElements.middleLayerDevVersion
import elements.SupportElements.middleLayerStagingVersion
import elements.SupportElements.supportMessenger
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import java.lang.UnsupportedOperationException

class SupportScreen (driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SupportElements)
        PageFactory.initElements(AppiumFieldDecorator(driver), EntryElements)
        PageFactory.initElements(AppiumFieldDecorator(driver), NavElements)
    }

    fun changeHost() {
        val ticketNumber = System.getenv("Ticket")

        if (null != ticketNumber && System.getenv("OS").equals("Android")) {
            waitUntilElementVisible(appVersion)
            appVersion.click()
            waitUntilElementVisible(androidAddNewHostElement)
            androidAddNewHostElement.click()

            if (ticketNumber.equals("Cognito")) {
                androidHostAddressField.sendKeys("middlelayer.cognito.int.syrupme.net")
                androidHostNameField.sendKeys("Cognito")
            } else if (ticketNumber.equals("Dev")) {
                androidHostAddressField.sendKeys("middlelayer.dev.int.syrupme.net")
                androidHostNameField.sendKeys("DevOpt")
            }
            waitUntilElementClickable(androidSaveButton)
            androidSaveButton.click()
            androidElementHostNewestHost.click()
            waitUntilElementInvisible(loadingAnimation)

            if (ticketNumber.equals("Mercury")) {
                driver.navigate().back()
                navAccount.click()
            }

        } else if (null != ticketNumber && System.getenv("OS").equals("iOS")) {
            if (System.getenv("env").equals("Staging")) {
                middleLayerStagingVersion.click()
            } else if (System.getenv("env").equals("Dev")) {
                middleLayerDevVersion.click()
            } else {
                throw UnsupportedOperationException("Unsupported Operation! Environment not Staging or Dev!")
            }

            if (ticketNumber.equals("Cognito")) {
                iOSHostAddressField.sendKeys("middlelayer.cognito.int.syrupme.net")
            } else if (ticketNumber.equals("Dev")) {
                iOSHostAddressField.sendKeys("middlelayer.dev.int.syrupme.net")
            }

            iOSAddNewHostButton.click()
            Thread.sleep(5000)
            iOSIsCaptchaRequiredNoButton.click()
            iOSSaveHostButton.click()
            navAccount.click()
        } else if (!System.getenv("OS").equals("iOS") && !System.getenv("OS").equals("Android")) {
            throw UnsupportedOperationException("Unsupported Operating System. Must be iOS or Android")
        }
    }

    fun clickMessenger() {
        waitUntilElementVisible(supportMessenger)
        supportMessenger.click()
    }
}