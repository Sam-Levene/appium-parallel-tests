package screens

import elements.SignedInHomeElements
import elements.SignedInHomeElements.searchBar
import elements.SignedInHomeElements.toolbarBalance
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.junit.Assert
import org.openqa.selenium.support.PageFactory

class SignedInHomeScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SignedInHomeElements)
    }

    fun verifyToolbarBalance() {
        waitUntilElementVisible(toolbarBalance)
        Assert.assertTrue("***User registration failed", toolbarBalance.isDisplayed)
    }

    fun tapOnSearchField() = searchBar.click()
}