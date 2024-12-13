package screens

import elements.SocialMediaElements
import elements.SocialMediaElements.appleContinueButton
import elements.SocialMediaElements.appleEmailField
import elements.SocialMediaElements.applePasswordField
import elements.SocialMediaElements.appleSignInButton
import elements.SocialMediaElements.facebookAllowCookiesButton
import elements.SocialMediaElements.facebookLoginButton
import elements.SocialMediaElements.facebookPasswordField
import elements.SocialMediaElements.facebookPreviousLoginContinueButton
import elements.SocialMediaElements.facebookUsernameField
import elements.SocialMediaElements.paypalAcceptCookiesButton
import elements.SocialMediaElements.paypalEmailField
import elements.SocialMediaElements.paypalLoginButton
import elements.SocialMediaElements.paypalNextButton
import elements.SocialMediaElements.paypalPasswordField
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import java.lang.Exception

class SocialMediaScreen (driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SocialMediaElements)
    }

    fun loginToFacebook() {
        if (driver is IOSDriver) {
            try {
                waitUntilElementVisible(facebookAllowCookiesButton)
                facebookAllowCookiesButton.click()
            } catch (e: Exception) {
                // Do nothing, sometimes the allow cookies button does not show up.
            }

            facebookUsernameField.clear()
            facebookUsernameField.sendKeys("quidco.tester@gmail.com")
            facebookPasswordField.clear()
            facebookPasswordField.sendKeys("quidcotester@01")

            waitUntilElementClickable(facebookLoginButton)
            facebookLoginButton.click()
        } else {
            try {
                facebookUsernameField.clear()
                facebookUsernameField.sendKeys("quidco.tester@gmail.com")
                facebookPasswordField.clear()
                facebookPasswordField.sendKeys("quidcotester@01")

                waitUntilElementClickable(facebookLoginButton)
                facebookLoginButton.click()
            } catch (e: Exception) {
                // Do nothing. Sometimes this isn't needed
            }

            waitUntilElementClickable(facebookPreviousLoginContinueButton)
            facebookPreviousLoginContinueButton.click()
        }
    }

    fun loginToApple() {
        appleEmailField.clear()
        appleEmailField.sendKeys("mobile.quidco@gmail.com")
        waitUntilElementClickable(appleContinueButton)
        appleContinueButton.click()
        waitUntilElementVisible(applePasswordField)
        applePasswordField.sendKeys("T3stp4ss")
        waitUntilElementClickable(appleSignInButton)
        appleSignInButton.click()
    }

    fun loginToPayPal() {
        if (driver is IOSDriver) {
            waitUntilElementVisible(paypalAcceptCookiesButton)
            paypalAcceptCookiesButton.click()
            waitUntilElementVisible(paypalEmailField)
            paypalEmailField.sendKeys("quidco.tester+paypal001@quidco.com")
            waitUntilElementClickable(paypalNextButton)
            paypalNextButton.click()
            waitUntilElementVisible(paypalPasswordField)
            paypalPasswordField.sendKeys("Testpass1")
            waitUntilElementClickable(paypalLoginButton)
            paypalLoginButton.click()
        } else {
            waitUntilElementVisible(paypalEmailField)
            paypalEmailField.sendKeys("quidco.tester+paypal001@quidco.com")
            try {
                waitUntilElementClickable(paypalNextButton)
                paypalNextButton.click()
            } catch (e: Exception) {
                //Do nothing. Sometimes PayPal doesn't have a Next Button
            }
            waitUntilElementVisible(paypalPasswordField)
            paypalPasswordField.sendKeys("Testpass1")
            waitUntilElementClickable(paypalLoginButton)
            paypalLoginButton.click()
        }

    }

}