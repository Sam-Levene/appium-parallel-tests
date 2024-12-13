package screens

import elements.ForgotPasswordElements
import elements.ForgotPasswordElements.emailSentCloseButton
import elements.ForgotPasswordElements.emailSentMessage
import elements.ForgotPasswordElements.forgotPasswordField
import elements.ForgotPasswordElements.resetPasswordButton
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import utilities.JsonObject

class ForgotPasswordScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), ForgotPasswordElements)
    }

    fun enterEmailIntoField(userType: String) {
        val jsonObject = JsonObject()
        waitUntilElementVisible(forgotPasswordField)
        forgotPasswordField.sendKeys(jsonObject.getEmailAddress("Simple Email", userType))
    }

    fun clickResetPasswordButton() {
        resetPasswordButton.click()
    }

    fun checkMessageIsDisplayed() {
        waitUntilElementVisible(emailSentMessage)
        if (driver is IOSDriver) {
            emailSentCloseButton.click()
        }
    }
}
