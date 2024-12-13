package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object NavElements {

    @AndroidFindBy(id = "groupAccount")
    @iOSXCUITFindBy(accessibility = "Account")
    lateinit var navAccount: WebElement

    @AndroidFindBy(id = "compare")
    @iOSXCUITFindBy(accessibility = "Compare")
    lateinit var navCompare: WebElement

    @AndroidFindBy(id = "groupHome")
    @iOSXCUITFindBy(accessibility = "Home")
    lateinit var navHome: WebElement

    @AndroidFindBy(id = "groupRaf")
    @iOSXCUITFindBy(accessibility = "Referrals")
    lateinit var navReferrals: WebElement

    @AndroidFindBy(id = "groupFavouritesOrRaf")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Favourites\"]")
    lateinit var navFavourites: WebElement

    @AndroidFindBy(id = "support")
    @iOSXCUITFindBy(accessibility = "Support")
    lateinit var navSupport: WebElement

}