package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object ForgotPasswordElements {

    @AndroidFindBy(id = "forgotten_password_email_address")
    @iOSXCUITFindBy(accessibility = "forgotten_password_email_address")
    lateinit var forgotPasswordField: WebElement

    @AndroidFindBy(id = "forgotten_password_button")
    @iOSXCUITFindBy(accessibility = "forgotten_password_button")
    lateinit var resetPasswordButton: WebElement

    @AndroidFindBy(id = "snackbar_text")
    @iOSXCUITFindBy(accessibility = "If this email exists, you will receive an email shortly with the steps to reset your password.")
    lateinit var emailSentMessage: WebElement

    @iOSXCUITFindBy(accessibility = "Close")
    lateinit var emailSentCloseButton: WebElement
}