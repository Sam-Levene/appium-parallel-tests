package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object JoinUsOrSignInElements {

    @AndroidFindBy(id = "sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign In\"]")
    lateinit var joinUsOrSignInLoginButton: WebElement
}