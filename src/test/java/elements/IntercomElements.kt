package elements;

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object IntercomElements {

    @AndroidFindBy(id = "action_bar_root")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow[@name=\"intercom window\"]")
    lateinit var rootIntercomPage: WebElement
}
