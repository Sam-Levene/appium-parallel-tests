package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object NotificationElements {

//  Keychain
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not Now\"]")
    lateinit var keychainNotNow: WebElement

//  ATT/PN primer Ok button
    @AndroidFindBy(id = "ok")
    @iOSXCUITFindBy(accessibility = "confirm_button")
    lateinit var primerOk: WebElement

//  ATT/PN dialog Allow button
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
    lateinit var dialogAllow: WebElement

//  Not Now element
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Not Now\"")
    lateinit var notNowButton: WebElement

}