package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object AccountElements {
    @AndroidFindBy(id = "settings")
    @iOSXCUITFindBy(accessibility = "settingsIcon")
    lateinit var settingsCog: WebElement

    @AndroidFindBy(id = "account_withdraw_balance")
    @iOSXCUITFindBy(accessibility = "Withdraw balance")
    lateinit var withdrawBalanceButton: WebElement

    @iOSXCUITFindBy(xpath = "/XCUIElementTypeStaticText[@name=\"Refer a friend\"]")
    lateinit var referAFriendLink: WebElement
}