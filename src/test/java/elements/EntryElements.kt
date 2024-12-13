package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object EntryElements {

    @AndroidFindBy(id = "sign_in_btn")
    @iOSXCUITFindBy(accessibility = "Already have an account? Sign In")
    lateinit var signInLink: WebElement

    @AndroidFindBy(id = "join_us_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Join now for free\"]")
    lateinit var signUpBtn: WebElement

    @AndroidFindBy(id = "browse_as_guest_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Browse as guest\"]")
    lateinit var browseAsGuestLink: WebElement

    @AndroidFindBy(id = "animation_view")
    @iOSXCUITFindBy(id = "LaunchIcon")
    lateinit var loadingAnimation: WebElement
}