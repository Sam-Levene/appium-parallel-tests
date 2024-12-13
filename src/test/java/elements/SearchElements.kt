package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import io.cucumber.java.en_scouse.An
import org.openqa.selenium.WebElement

object SearchElements {

    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(accessibility = "Search popular brands")
    lateinit var searchView: WebElement

    @AndroidFindBy(id = "search_result_recycler_view")
    @iOSXCUITFindBy(accessibility = "home_view")
    lateinit var  searchResultsView: WebElement

    @AndroidFindBy(id = "brand_name")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"merchant_cell_name\"])[1]")
    lateinit var merchantName: WebElement

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Argos']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Argos\"")
    lateinit var argosSearchMerchant: WebElement

}