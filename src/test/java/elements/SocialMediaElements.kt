package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SocialMediaElements {

    @iOSXCUITFindBy(accessibility = "Allow all cookies")
    lateinit var facebookAllowCookiesButton: WebElement

    @AndroidFindBy(id = "m_login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField")
    lateinit var facebookUsernameField: WebElement

    @AndroidFindBy(id = "m_login_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField")
    lateinit var facebookPasswordField: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Log In")
    lateinit var facebookLoginButton: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button")
    @iOSXCUITFindBy(accessibility = "Continue")
    lateinit var facebookPreviousLoginContinueButton: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sign in with Apple ID\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField")
    lateinit var appleEmailField: WebElement

    @iOSXCUITFindBy(accessibility = "Continue")
    lateinit var appleContinueButton: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sign in with Apple ID\"]/XCUIElementTypeOther[8]/XCUIElementTypeSecureTextField")
    lateinit var applePasswordField: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sign In\"]")
    lateinit var appleSignInButton: WebElement

    @iOSXCUITFindBy(accessibility = "Accept")
    lateinit var paypalAcceptCookiesButton: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
    lateinit var paypalEmailField: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next\"]")
    lateinit var paypalNextButton: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeSecureTextField")
    lateinit var paypalPasswordField: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Log In\"]")
    lateinit var paypalLoginButton: WebElement
}