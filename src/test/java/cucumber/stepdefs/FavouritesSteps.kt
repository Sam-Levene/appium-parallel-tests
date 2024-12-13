package cucumber.stepdefs

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import screens.FavouritesScreen

class FavouritesSteps : BaseSteps() {
    private val favouritesScreen = FavouritesScreen(driver)

    @When("the user {string} their list of favourites")
    fun theUserAdjustsTheirListOfFavourites(modification: String) {
        when (modification) {
            "removes a favourite from" -> {
                favouritesScreen.removeAFavourite()
            }
            "adds a favourite to" -> {
                favouritesScreen.addAFavourite()
            }
            else -> {
                throw NoSuchMethodError("No such option to edit Favourites")
            }
        }
    }

    @When("the user searches for a {string}")
    fun theUserSearchesForAFavourite(favouriteType : String) {
        favouritesScreen.searchForFavourite(favouriteType)
    }

    @When("the user cancels their journey")
    fun theUserCancelsTheirJourney() {
        favouritesScreen.cancelJourney()
    }

    @Then("the user is returned to the Favourites Screen")
    fun theUserIsReturnedToTheFavouritesScreen() {
        favouritesScreen.isDisplayedWithFavourites()
    }

    @Then("the favourite search results {string} displayed")
    fun theFavouriteSearchResultsDisplayed(displayResults: String) {
        favouritesScreen.checkSearchResults()
    }

    @Then("the number of favourites is increased by one")
    fun theNumberOfFavouritesIsIncreased() {
        //TODO: Work in progress
    }

    @Then("the number of favourites is decreased by one")
    fun theNumberOfFavouritesIsDecreased() {
        //TODO: Work in progress
    }

    @Then("the user is not logged in and cannot access favourites")
    fun theUserIsNotLoggedInAndCannotAccessFavourites() {
        //TODO: Work in progress
    }
}