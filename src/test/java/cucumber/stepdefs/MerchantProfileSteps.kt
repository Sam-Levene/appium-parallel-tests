package cucumber.stepdefs

import io.cucumber.java.en.When
import screens.MerchantProfileScreen

class MerchantProfileSteps : BaseSteps() {
    private val merchantProfileScreen = MerchantProfileScreen(driver)

    @When("I see the merchant page has loaded")
    fun verifyMerchantPageDisplayed() = merchantProfileScreen.verifyVisitButtonDisplayed()

    @When("I tap on the main CTA")
    fun tapMainCta() = merchantProfileScreen.tapOnMainCta()
}