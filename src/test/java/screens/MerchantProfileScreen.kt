package screens

import elements.MerchantProfileElements
import elements.MerchantProfileElements.getCashbackButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.junit.Assert
import org.openqa.selenium.support.PageFactory

class MerchantProfileScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), MerchantProfileElements)
    }

    fun verifyVisitButtonDisplayed() {
        waitUntilElementClickable(getCashbackButton)
        Assert.assertTrue("***Visit button not displayed", getCashbackButton.isDisplayed)
    }

    fun tapOnMainCta() = getCashbackButton.click()
}