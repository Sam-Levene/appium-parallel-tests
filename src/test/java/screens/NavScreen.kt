package screens

import elements.NavElements
import elements.NavElements.navAccount
import elements.NavElements.navFavourites
import elements.NavElements.navHome
import elements.NavElements.navSupport
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class NavScreen(driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), NavElements)
    }

    fun clickAccount() {
        waitUntilElementClickable(navAccount)
        navAccount.click()
    }

    fun clickHome() {
        waitUntilElementClickable(navHome)
        navHome.click()
    }

    fun clickFavourites() {
        waitUntilElementClickable(navFavourites)
        navFavourites.click()
    }

    fun clickSupport() {
        waitUntilElementClickable(navSupport)
        navSupport.click()
    }
}