package screens

import elements.AccountElements
import elements.AccountElements.settingsCog
import elements.AccountElements.withdrawBalanceButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory


class AccountScreen(driver: AppiumDriver) : BaseScreen(driver) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), AccountElements)
    }

    fun clickSettings() {
        waitUntilElementVisible(settingsCog)
        settingsCog.click()
    }

    fun clickWithdraw() {
        waitUntilElementVisible(withdrawBalanceButton)
        withdrawBalanceButton.click()
    }
}