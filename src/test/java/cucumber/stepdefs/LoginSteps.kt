package cucumber.stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import screens.*

class LoginSteps : BaseSteps() {

    private val forgotPasswordScreen = ForgotPasswordScreen(driver)
    private val loginScreen = LoginScreen(driver)
    private val entryScreen = EntryScreen(driver)
    private val notificationsPermission = NotificationsPermission(driver)
    private val supportScreen = SupportScreen(driver)
    private val signedOutHomeScreen = SignedOutHomeScreen(driver)
    private val socialMediaScreen = SocialMediaScreen(driver)

    @Given("A guest visits the site")
    fun aGuestVisitsTheSite() {
        entryScreen.waitForLoadingAnimationToComplete()
        entryScreen.clickBrowseAsGuest()
        notificationsPermission.skip()
        if (null != System.getenv("Ticket")) {
            signedOutHomeScreen.clickSupport()
            supportScreen.changeHost()
            entryScreen.clickHome()
        }
    }

    @When ("the user selects forgotten password")
    fun theUserSelectsForgottenPassword() {
        entryScreen.clickLoginLink()
        loginScreen.clickForgotPasswordLink()
    }

    @When ("{string} enters their Email")
    fun userEntersTheirEmail(userType: String) {
        forgotPasswordScreen.enterEmailIntoField(userType)
        forgotPasswordScreen.clickResetPasswordButton()
    }

    @Then ("message is displayed")
    fun messageIsDisplayed() {
        forgotPasswordScreen.checkMessageIsDisplayed()
    }

    @Then ("email {string} sent")
    fun emailIsSent(validation: String) {
        //No actions
    }

    @When("a {string} signs in at the start")
    fun aUserSignsInAtTheStart(userType: String) {
        if (userType != "Guest User") {
            entryScreen.clickLoginLink()
            loginScreen.tapOnEmailInput()
            loginScreen.enterEmail(userType)
            loginScreen.enterPassword(userType)
            loginScreen.tapSignInButton()
        }
    }

    @Given("A {string} signs in")
    fun aUserSignsIn(userType: String) {
        entryScreen.waitForLoadingAnimationToComplete()
        if (null != System.getenv("Ticket")) {
            entryScreen.clickBrowseAsGuest()
            notificationsPermission.skip()
            signedOutHomeScreen.clickSupport()
            supportScreen.changeHost()
        }
        entryScreen.clickLoginLink()
        loginScreen.tapOnEmailInput()
        loginScreen.enterEmail(userType)
        loginScreen.enterPassword(userType)
        loginScreen.tapSignInButton()
    }

    @When("the guest navigates to the {string}")
    fun theGuestNavigatesToThePage(pageName: String) {
        when (pageName) {
            "Home Page" -> signedOutHomeScreen.clickSignInLink()
            "Refer a Friend" -> signedOutHomeScreen.clickReferAFriendSignIn()
            "Merchant Page" -> signedOutHomeScreen.clickMerchantPageAndSignIn()
        }
    }

    @When("the guest signs in as a {string}")
    fun theGuestSignsInAsAUser(userType: String) {
        loginScreen.tapOnEmailInput()
        loginScreen.enterEmail(userType)
        loginScreen.enterPassword(userType)
        loginScreen.tapSignInButton()
    }

    @When("the user signs in using the {string} social media link")
    fun userSignsInUsingTheSocialMediaLink(socialMedia : String) {
        entryScreen.clickLoginLink()
        when (socialMedia) {
            "Facebook" -> {
                loginScreen.signInUsingFacebook()
                socialMediaScreen.loginToFacebook()
            }
            "Apple" -> {
                loginScreen.signInUsingApple()
                socialMediaScreen.loginToApple()
            }
            "Paypal" -> {
                loginScreen.signInUsingPaypal()
                socialMediaScreen.loginToPayPal()
            }
        }
    }

    @Then("the user is signed in at the {string}")
    fun theUserIsSignedInAtThePage(pageName: String) {
        //TODO: Complete this
    }
}