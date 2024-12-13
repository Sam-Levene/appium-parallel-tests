package screens

import elements.SettingsElements
import elements.SettingsElements.settingsEmail
import elements.SettingsElements.marketingEmailsSwitch
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class SettingsScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SettingsElements)
    }

    fun verifyAccount(): String {
        waitUntilElementVisible(settingsEmail)
        return settingsEmail.text
    }

    fun clickMarketingSettings() {
        waitUntilElementVisible(marketingEmailsSwitch)
        marketingEmailsSwitch.click()
    }
}