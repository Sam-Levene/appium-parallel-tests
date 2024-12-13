package screens

import elements.SignUpElements
import elements.SignUpElements.errorMsgEmail
import elements.SignUpElements.errorMsgPassword
import elements.SignUpElements.joinEmailAddress
import elements.SignUpElements.joinPassword
import elements.SignUpElements.marketingConsentCheckbox
import elements.SignUpElements.referralDropdown
import elements.SignUpElements.referralLinkText
import elements.SignUpElements.signUpButton
import elements.SignUpElements.warningDialog
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.junit.Assert
import org.openqa.selenium.support.PageFactory
import utilities.DriverKeyboardHandler

class SignUpScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SignUpElements)
    }

    fun enterJoinCredentials(email: String, password: String) {
        waitUntilElementVisible((joinEmailAddress))
        joinEmailAddress.sendKeys(email)
        joinPassword.sendKeys(password)
        DriverKeyboardHandler.hideKeyboard(driver)
    }

    fun clickSignUp() {
        waitUntilElementClickable(signUpButton)
        signUpButton.click()
    }

    fun checkErrorMsg(warning: String) {
        if (warning.contains("Email")) {
            Assert.assertEquals(warning, errorMsgEmail.text)
        } else {
            Assert.assertEquals(warning, errorMsgPassword.text)
        }
    }

    fun selectMarketingConsent() {
        waitUntilElementClickable(marketingConsentCheckbox)
        marketingConsentCheckbox.click()
    }

    fun checkWarningDialog(warning: String) {
        waitUntilElementVisible(warningDialog)
        Assert.assertEquals(warning, warningDialog.text)
    }

    fun enterReferralLink(referralLink: String) {
        waitUntilElementVisible(referralDropdown)
        referralDropdown.click()
        referralLinkText.sendKeys(referralLink)
    }
}