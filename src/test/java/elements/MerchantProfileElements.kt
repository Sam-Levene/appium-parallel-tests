package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object MerchantProfileElements {

    @AndroidFindBy(id = "visit_button")
    @iOSXCUITFindBy(accessibility = "Get cashback")
    lateinit var getCashbackButton: WebElement

    @AndroidFindBy(id = "sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign In\"]")
    lateinit var merchantSignInButton: WebElement
}