package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SettingsElements {

    @AndroidFindBy(id = "settings_account_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'quidco+')]")
    lateinit var settingsEmail: WebElement

    @AndroidFindBy(id = "settings_marketing_emails")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Quidco Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeSwitch[1]/XCUIElementTypeSwitch")
    lateinit var marketingEmailsSwitch: WebElement

}