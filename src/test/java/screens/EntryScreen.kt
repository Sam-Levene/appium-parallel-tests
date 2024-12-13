package screens

import elements.EntryElements
import elements.EntryElements.browseAsGuestLink
import elements.EntryElements.loadingAnimation
import elements.EntryElements.signInLink
import elements.EntryElements.signUpBtn
import elements.NavElements
import elements.NavElements.navHome
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class EntryScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), EntryElements)
        PageFactory.initElements(AppiumFieldDecorator(driver), NavElements)
    }

    fun verifyNotLoggedIn() = signUpBtn.isDisplayed

    fun clickLoginLink() = signInLink.click()

    fun clickSignUp() {
        waitUntilElementClickable(signUpBtn)
        signUpBtn.click()
    }

    fun clickBrowseAsGuest() = browseAsGuestLink.click()

    fun waitForLoadingAnimationToComplete() {
        waitUntilElementInvisible(loadingAnimation)
    }

    fun clickHome() = navHome
}