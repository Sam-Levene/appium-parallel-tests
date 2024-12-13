package screens

import elements.IntercomElements
import elements.IntercomElements.rootIntercomPage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class IntercomScreen (driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), IntercomElements)
    }

    fun checkVisibilityOfIntercom() {
        waitUntilElementVisible(rootIntercomPage)
        rootIntercomPage.isDisplayed
    }
}