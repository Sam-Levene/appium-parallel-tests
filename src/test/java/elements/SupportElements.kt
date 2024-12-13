package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SupportElements {

    @AndroidFindBy(id = "support_app_version")
    lateinit var appVersion: WebElement

    @iOSXCUITFindBy(accessibility = "ml-staging.cashbacksrv.com")
    lateinit var middleLayerStagingVersion: WebElement

    @iOSXCUITFindBy(accessibility = "middlelayer.mobile-dev.int.syrupme.net")
    lateinit var middleLayerDevVersion: WebElement

    @AndroidFindBy(id = "add_host_button")
    lateinit var androidAddNewHostElement: WebElement

    @AndroidFindBy(id = "address")
    lateinit var androidHostAddressField: WebElement

    @AndroidFindBy(id = "alias")
    lateinit var androidHostNameField: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]")
    lateinit var androidElementHostNewestHost: WebElement

    @AndroidFindBy(id = "btn_save")
    lateinit var androidSaveButton: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Quidco Dev\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    lateinit var iOSHostAddressField: WebElement

    @iOSXCUITFindBy(accessibility = "Add")
    lateinit var iOSAddNewHostButton: WebElement

    @iOSXCUITFindBy(accessibility = "Save")
    lateinit var iOSSaveHostButton: WebElement

    @iOSXCUITFindBy(accessibility = "No")
    lateinit var iOSIsCaptchaRequiredNoButton: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Messenger\"]")
    lateinit var supportMessenger: WebElement
}