package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SignedOutHomeElements {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"swipelayout\"]/android.widget.ScrollView/android.widget.ViewSwitcher/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[2]")
    @iOSXCUITFindBy(accessibility = "Already have an account? Sign In")
    lateinit var signedOutSignInLink: WebElement

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"swipelayout\"]/android.widget.ScrollView/android.widget.ViewSwitcher/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    lateinit var merchantElement: WebElement
}