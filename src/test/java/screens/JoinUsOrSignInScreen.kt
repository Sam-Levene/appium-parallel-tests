package screens

import elements.JoinUsOrSignInElements
import elements.JoinUsOrSignInElements.joinUsOrSignInLoginButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.junit.Assert
import org.openqa.selenium.support.PageFactory

class JoinUsOrSignInScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), JoinUsOrSignInElements)
    }

    fun verifySignInButtonVisible() {
        waitUntilElementClickable(joinUsOrSignInLoginButton)
        Assert.assertTrue("***Join button not visible", joinUsOrSignInLoginButton.isDisplayed)
    }

    fun tapOnSignIn() = joinUsOrSignInLoginButton.click()
}