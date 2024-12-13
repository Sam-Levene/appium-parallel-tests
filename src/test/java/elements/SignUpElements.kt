package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SignUpElements {

    @AndroidFindBy(id = "join_email_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"email_text_field\"]")
    lateinit var joinEmailAddress: WebElement

    @AndroidFindBy(id = "join_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"password_text_field\"]")
    lateinit var joinPassword: WebElement

    @AndroidFindBy(id = "join_button_enabled")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create account\"]")
    lateinit var signUpButton: WebElement

    @AndroidFindBy(id = "textinput_error")
    @iOSXCUITFindBy(accessibility = "Email formatting is incorrect")
    lateinit var errorMsgEmail: WebElement

    @AndroidFindBy(id = "textinput_error")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Password must be 8 characters including at least 1 uppercase letter and number\"]")
    lateinit var errorMsgPassword: WebElement

    @AndroidFindBy(id = "skip")
    @iOSXCUITFindBy(accessibility = "Skip")
    lateinit var premiumEnrolmentSkip: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next:\"]")
    lateinit var nextButtonOnText: WebElement

    @AndroidFindBy(id = "marketing_consent_check_box")
    @iOSXCUITFindBy(accessibility = "tickInactive")
    lateinit var marketingConsentCheckbox: WebElement

    @AndroidFindBy(id= "snackbar_text")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"This email address is already registered. Please sign in.\"]")
    lateinit var warningDialog: WebElement

    @AndroidFindBy(id = "icon_expandable")
    @iOSXCUITFindBy(accessibility = "Were you referred by a friend?")
    lateinit var referralDropdown: WebElement

    @AndroidFindBy(id = "join_referral_link")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Quidco Dev\"]/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    lateinit var referralLinkText: WebElement
}