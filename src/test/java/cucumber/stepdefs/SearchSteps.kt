package cucumber.stepdefs

import io.cucumber.java.en.When
import screens.NavScreen
import screens.SearchScreen
import screens.SignedInHomeScreen

class SearchSteps : BaseSteps() {

    private val navScreen = NavScreen(driver)
    private val searchScreen = SearchScreen(driver)
    private val signedInHomeScreen = SignedInHomeScreen(driver)

    @When("the user searches for {string}")
    fun theUserSearchesFor(searchResults: String) {
        navScreen.clickHome()
        signedInHomeScreen.tapOnSearchField()
        searchScreen.searchForMerchant(searchResults)
        searchScreen.verifySearchResultsVisible(searchResults)
        searchScreen.tapOnMerchant(searchResults)
    }
}