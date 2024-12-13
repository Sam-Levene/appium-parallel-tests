package cucumber.stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import screens.*
import utilities.JsonObject

class SignUpSteps : BaseSteps() {

    private val entryScreen = EntryScreen(driver)
    private val signUpScreen = SignUpScreen(driver)
    private val signedInHomeScreen = SignedInHomeScreen(driver)
    private val signedOutHomeScreen = SignedOutHomeScreen(driver)
    private val settingsScreen = SettingsScreen(driver)
    private val supportScreen = SupportScreen(driver)
    private val notificationsPermission = NotificationsPermission(driver)
    private val accountScreen = AccountScreen(driver)
    private val navScreen = NavScreen(driver)
    private lateinit var storedEmail: String


    @Given("a {string} is not logged in")
    fun verifyNotLoggedIn(user: String) {
        entryScreen.waitForLoadingAnimationToComplete()
        entryScreen.verifyNotLoggedIn()
        if (null != System.getenv("Ticket")) {
            entryScreen.clickBrowseAsGuest()
            notificationsPermission.skip()
            signedOutHomeScreen.clickSupport()
            supportScreen.changeHost()
        }
    }

    @Given("{string} has just registered")
    fun newUserRegistered(user: String) {
        entryScreen.waitForLoadingAnimationToComplete()
        val jsonObject = JsonObject()
        if (null != System.getenv("Ticket")) {
            entryScreen.clickBrowseAsGuest()
            notificationsPermission.skip()
            signedOutHomeScreen.clickSupport()
            supportScreen.changeHost()
        }

        storedEmail = jsonObject.getEmailAddress("Simple Email", user)
        entryScreen.clickSignUp()
        signUpScreen.enterJoinCredentials(
            storedEmail,
            jsonObject.getPassword("Simple Password", user)
        )
        signUpScreen.clickSignUp()
        Thread.sleep(10000)
    }

    @When("the user skips notifications and permissions")
    fun theUserSkipsNotificationsAndPermissions() {
        notificationsPermission.skip()
    }

    @When("{string} enters their credentials")
    fun enterJoinCredentials(user: String) {
        val jsonObject = JsonObject()
        entryScreen.clickSignUp()
        when (user) {
            "Referred User" -> {
                signUpScreen.enterJoinCredentials(
                    jsonObject.getEmailAddress("Email with Subdomain", user),
                    jsonObject.getPassword("Simple Password", user)
                )
                signUpScreen.clickSignUp()
            }
            "New User" -> {
                signUpScreen.enterJoinCredentials(
                        jsonObject.getEmailAddress("Simple Email", user),
                        jsonObject.getPassword("Simple Password", user)
                )
                signUpScreen.clickSignUp()
            }
            "Invalid Email" -> {
                signUpScreen.enterJoinCredentials(
                        jsonObject.getEmailAddress("Missing Address", user),
                        jsonObject.getPassword("Simple Password", user)
                )
                signUpScreen.clickSignUp()
            }
            "Invalid Password" -> {
                signUpScreen.enterJoinCredentials(
                        jsonObject.getEmailAddress("Underscore in Address", user),
                        jsonObject.getPassword("Invalid Password", user)
                )
                signUpScreen.clickSignUp()
            }
            "Valid User" -> {
                    signUpScreen.enterJoinCredentials(
                        jsonObject.getEmailAddress("Dot in Address", user),
                        jsonObject.getPassword("Simple Password", user)
                )
                signUpScreen.clickSignUp()
            }
        }
    }

    @When("{string} enters their credentials with Marketing consent accepted")
    fun enterJoinCredentialsWithMarketingConsent(user: String) {
        val jsonObject = JsonObject()
        entryScreen.clickSignUp()
        signUpScreen.enterJoinCredentials(
            jsonObject.getEmailAddress("Underscore in Address", user),
            jsonObject.getPassword("Password with non ASCII character", user)
        )
        signUpScreen.selectMarketingConsent()
        signUpScreen.clickSignUp()
    }

    @When("the {string} sign up link is used")
    fun the_sign_up_link_is_used(user: String) = signUpScreen.enterReferralLink("https://www-dev.quidco.com/raf/6600479/")

    @Then("{string} is logged into the app")
    fun verifyUserSignedIn(user: String) {
        notificationsPermission.skip()
        navScreen.clickHome()
        signedInHomeScreen.verifyToolbarBalance()
    }

    @Then("the related warning {string} is displayed")
    fun checkWarning(warning: String) = signUpScreen.checkErrorMsg(warning)

    @Then("{string} details are correct")
    fun verifyCorrectAccount(user: String) = Assert.assertEquals(storedEmail, settingsScreen.verifyAccount())

    @Then("{string} marketing consent is accepted")
    fun verifyMarketingConsentAccepted(user: String) {
        navScreen.clickAccount()
        accountScreen.clickSettings()
        settingsScreen.clickMarketingSettings()
    }

    @Then("The {string} warning is displayed")
    fun checkWarningDialog(warning: String) = signUpScreen.checkWarningDialog(warning)

    @Then("The signed in home screen {string} visible")
    fun theSignedInHomeScreenCheckVisibility(isVisible: String) {
        //TODO: Complete this
    }
}