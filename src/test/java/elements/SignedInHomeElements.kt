package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object SignedInHomeElements {
    
    @AndroidFindBy(id = "toolbar_balance")
    @iOSXCUITFindBy(accessibility = "balance_label")
    lateinit var toolbarBalance: WebElement

    @AndroidFindBy(id = "search_bar")
    @iOSXCUITFindBy(accessibility = "Search popular brands")
    lateinit var searchBar: WebElement

}