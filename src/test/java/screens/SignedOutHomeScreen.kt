package screens

import elements.EntryElements.signInLink
import elements.MerchantProfileElements
import elements.MerchantProfileElements.getCashbackButton
import elements.MerchantProfileElements.merchantSignInButton
import elements.NavElements
import elements.NavElements.navHome
import elements.NavElements.navReferrals
import elements.NavElements.navSupport
import elements.SignedOutHomeElements
import elements.SignedOutHomeElements.signedOutSignInLink
import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class SignedOutHomeScreen(driver: AppiumDriver) : BaseScreen(driver) {
    fun clickSignInLink() = signedOutSignInLink.click()

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SignedOutHomeElements)
        PageFactory.initElements(AppiumFieldDecorator(driver), MerchantProfileElements)
        PageFactory.initElements(AppiumFieldDecorator(driver), NavElements)
    }
    
    fun clickReferAFriendSignIn() {
        navReferrals.click()
        signInLink.click()
    }

    fun clickMerchantPageAndSignIn() {
        navHome.click()
        lateinit var homePage: WebElement
        if (System.getenv("OS").equals("iOS")) {
            homePage = driver.findElement(AppiumBy.accessibilityId("home_collection_view"))
            val featuredOfferList = homePage.findElements(AppiumBy.className("XCUIElementTypeCell"))
            featuredOfferList[3].click()
            waitUntilElementVisible(getCashbackButton)
            getCashbackButton.click()
            waitUntilElementVisible(merchantSignInButton)
            merchantSignInButton.click()
        } else {
            homePage = driver.findElement(AppiumBy.id("view_switcher"))
            Thread.sleep(3000)
            val featuredOfferList = homePage.findElements(AppiumBy.id("retailer_offer_layout"))
            featuredOfferList[1].click()
            waitUntilElementVisible(getCashbackButton)
            getCashbackButton.click()
            waitUntilElementVisible(merchantSignInButton)
            merchantSignInButton.click()
        }

    }

    fun clickSupport() {
        navSupport.click()
    }
}