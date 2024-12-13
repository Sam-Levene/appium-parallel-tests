package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object FavouritesElements {

    @AndroidFindBy(id = "header")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Favourites\"]")
    lateinit var favouritesScreenTitle: WebElement

    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Favourites\"]")
    lateinit var addFavouritesScreenText: WebElement

    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"search_bar_text_field\"]")
    lateinit var searchBar: WebElement

    @AndroidFindBy(id = "edit_favourite")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit\"]")
    lateinit var editFavouritesButton: WebElement

    @AndroidFindBy(id = "toolbar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select a minimum of 5 brands\"]")
    lateinit var minimumBrandsSubtitle: WebElement

    @AndroidFindBy(id = "button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm selection\"]")
    lateinit var confirmSelectionButton: WebElement

    @AndroidFindBy(id = "selected_retails")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name=\"selected_merchants_list\"]")
    lateinit var favouritesSelectedMerchantsList: WebElement

    @AndroidFindBy(id = "favourites_recycler_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"favourite_merchants_grid\"]")
    lateinit var favouritesFavouriteMerchantsList: WebElement

    @AndroidFindBy(id = "popular_or_search_result_rv")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"popular_merchants_grid\"]")
    lateinit var favouritesPopularMerchantsList: WebElement

    @AndroidFindBy(id = "popular_or_search_result_rv")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"search_results_grid\"]")
    lateinit var favouritesSearchResultsList: WebElement

    @AndroidFindBy(id = "empty_search_result_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nothing to show\"]")
    lateinit var favouritesSearchNothingToShow: WebElement

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit Favourites\"]")
    lateinit var favouritesEditFavouritesButton: WebElement

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"back_btn\"]")
    lateinit var favouritesBackButton: WebElement
}