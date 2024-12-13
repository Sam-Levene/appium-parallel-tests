package cucumber.stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import screens.*

class MiscSteps : BaseSteps() {

    private val navScreen = NavScreen(driver)
    private val supportScreen = SupportScreen(driver)
    private val accountScreen = AccountScreen(driver)
    private val withdrawalScreen = WithdrawalScreen(driver)
    private val intercomScreen = IntercomScreen(driver)
    private val favouritesScreen = FavouritesScreen(driver)

    @When("the user taps on the {string} button in the app footer")
    fun userTapsOnSpecificButtonInTheFooter(button: String) {
        when (button) {
            "Settings" -> {
                navScreen.clickAccount()
                accountScreen.clickSettings()
            }
            "Favourites" -> {
                navScreen.clickFavourites()
            }
            "Support" -> {
                navScreen.clickSupport()
                supportScreen.clickMessenger()
            }
            else -> {
                //TODO: Work in progress
            }
        }
    }

    @When("the user attempts to withdraw {string} from their balance to their {string}")
    fun theUserAttemptsToWithdrawBalanceFromTheirBalanceToTheirAccount(balanceAmount: String, balanceType: String) {
        navScreen.clickAccount()
        accountScreen.clickWithdraw()
        withdrawalScreen.withdrawAmountByType(balanceAmount, balanceType)
    }

    @Then("the app displays the Favourites screen")
    fun theAppDisplaysTheFavouritesScreen() {
        favouritesScreen.isDisplayed()
    }

    @Then("the support page is visible")
    fun theSupportPageIsVisible() {
        intercomScreen.checkVisibilityOfIntercom()
    }

    @Then("the balance is reduced by the amount specified")
    fun theBalanceIsReducedByTheAmountSpecified() {
        //TODO: Work in progress
    }

    @Then("the screen shows content to prompt the user to add favourites")
    fun theScreenPromptsUserToAddFavourites() {
        favouritesScreen.checkFavouritesPromptToAdd()
    }
    @Then("the screen shows content to prompt the user to add more favourites")
    fun theScreenPromptsUserToAddMoreFavourites() {
        favouritesScreen.checkAddFavouritesPresent()
    }

    @Then("the app displays the Favourites screen with the all the user’s favourite merchant")
    fun theAppDisplaysTheFavouritesScreenWithTheUsersFavourites() {
        favouritesScreen.checkFavourites()
    }
}