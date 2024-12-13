package screens

import elements.FavouritesElements
import elements.FavouritesElements.addFavouritesScreenText
import elements.FavouritesElements.confirmSelectionButton
import elements.FavouritesElements.editFavouritesButton
import elements.FavouritesElements.favouritesBackButton
import elements.FavouritesElements.favouritesEditFavouritesButton
import elements.FavouritesElements.favouritesFavouriteMerchantsList
import elements.FavouritesElements.favouritesPopularMerchantsList
import elements.FavouritesElements.favouritesScreenTitle
import elements.FavouritesElements.favouritesSearchNothingToShow
import elements.FavouritesElements.favouritesSearchResultsList
import elements.FavouritesElements.favouritesSelectedMerchantsList
import elements.FavouritesElements.minimumBrandsSubtitle
import elements.FavouritesElements.searchBar
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class FavouritesScreen(driver: AppiumDriver) : BaseScreen(driver) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), FavouritesElements)
    }

    fun isDisplayed() {
        waitUntilElementVisible(favouritesScreenTitle)
        assert(favouritesScreenTitle.isDisplayed)
    }

    fun isDisplayedWithFavourites() {
        waitUntilElementVisible(favouritesFavouriteMerchantsList)
        assert(favouritesFavouriteMerchantsList.isDisplayed)
    }

    fun checkFavouritesPromptToAdd() {
       waitUntilElementVisible(addFavouritesScreenText)
       assert(addFavouritesScreenText.isDisplayed)
    }

    fun checkFavourites() {
        waitUntilElementVisible(editFavouritesButton)
        editFavouritesButton.click()

        if (driver is IOSDriver) {
            waitUntilElementClickable(favouritesEditFavouritesButton)
            favouritesEditFavouritesButton.click()
        } else {
            waitUntilElementVisible(favouritesPopularMerchantsList)
            val popularMerchantList = favouritesPopularMerchantsList
            val favouriteMerchants = popularMerchantList.findElements(By.className("android.view.ViewGroup"))
            favouriteMerchants[1].click()
        }

        waitUntilElementVisible(favouritesSelectedMerchantsList)
        assert(favouritesSelectedMerchantsList.isDisplayed)
    }

    fun checkAddFavouritesPresent() {
        waitUntilElementVisible(addFavouritesScreenText)
        assert(minimumBrandsSubtitle.isDisplayed)
    }

    fun addAFavourite() {
        waitUntilElementVisible(editFavouritesButton)
        editFavouritesButton.click()

        waitUntilElementVisible(favouritesPopularMerchantsList)
        val currentElement: WebElement = favouritesPopularMerchantsList

        if (driver is IOSDriver) {
            val favouriteMerchants = currentElement.findElements(By.className("XCUIElementTypeButton"))
            favouriteMerchants[1].click()

            waitUntilElementVisible(favouritesSelectedMerchantsList)
            val favouriteSelectedMerchants = favouritesSelectedMerchantsList.findElements(By.className("XCUIElementTypeButton"))
            assert(favouriteSelectedMerchants.size > 0)
            waitUntilElementClickable(confirmSelectionButton)
            confirmSelectionButton.click()
        } else {
            val favouriteMerchants = currentElement.findElements(By.className("android.view.ViewGroup"))
            favouriteMerchants[2].click()
            waitUntilElementVisible(favouritesSelectedMerchantsList)
            val favouriteSelectedMerchants = favouritesSelectedMerchantsList.findElements(By.className("android.view.ViewGroup"))
            assert(favouriteSelectedMerchants.size > 0)
            waitUntilElementClickable(confirmSelectionButton)
            confirmSelectionButton.click()
        }

    }

    fun removeAFavourite() {
        waitUntilElementVisible(editFavouritesButton)
        editFavouritesButton.click()

        if (driver is IOSDriver) {
            waitUntilElementClickable(favouritesEditFavouritesButton)
            favouritesEditFavouritesButton.click()
            waitUntilElementVisible(favouritesSelectedMerchantsList)
            val favouriteSelectedMerchants =
                favouritesSelectedMerchantsList.findElements(By.className("XCUIElementTypeButton"))
            favouriteSelectedMerchants[0].findElement(By.xpath("//XCUIElementTypeImage[@name=\"favourites_remove\"]"))
                .click()
        } else {
            waitUntilElementVisible(favouritesPopularMerchantsList)
            val currentElement: WebElement = favouritesPopularMerchantsList

            val favouriteMerchants = currentElement.findElements(By.className("android.view.ViewGroup"))
            favouriteMerchants[2].click()
            waitUntilElementVisible(favouritesSelectedMerchantsList)
            val favouriteSelectedMerchants = favouritesSelectedMerchantsList.findElements(By.className("android.view.ViewGroup"))
            assert(favouriteSelectedMerchants.size > 0)
            waitUntilElementClickable(confirmSelectionButton)
            confirmSelectionButton.click()
        }

    }

    fun searchForFavourite(favouriteType: String) {
        var searchFound = false
        if (favouriteType == "Invalid Search") {
            Thread.sleep(5000)
            waitUntilElementClickable(editFavouritesButton)
            editFavouritesButton.click()

            waitUntilElementVisible(searchBar)
            searchBar.sendKeys("\"\"\"\"\"\"")

            waitUntilElementVisible(favouritesSearchNothingToShow)
            assert(favouritesSearchNothingToShow.isDisplayed)
        } else {
            Thread.sleep(5000)
            waitUntilElementClickable(editFavouritesButton)
            editFavouritesButton.click()

            waitUntilElementVisible(searchBar)
            searchBar.sendKeys("Argos")

            waitUntilElementVisible(favouritesSearchResultsList)
            assert(favouritesSearchResultsList.isDisplayed)

            val favouritesSearchResults: List<WebElement> = if (driver is IOSDriver) {
                favouritesSearchResultsList.findElements(By.className("XCUIElementTypeButton"))
            } else {
                favouritesSearchResultsList.findElements(By.className("android.view.ImageView"))
            }

            for (searchElement: WebElement in favouritesSearchResults) {
                if (driver is IOSDriver) {
                    if (searchElement.getAttribute("name") == "Argos") {
                        searchFound = true
                        break
                    }
                } else {
                    if (searchElement.getAttribute("content-desc") == "Argos") {
                        searchFound = true
                        break
                    }
                }
            }

            if (searchFound) {
                assert(true)
            } else {
                assert(false)
            }
        }
    }

    fun cancelJourney() {
        waitUntilElementVisible(favouritesBackButton)
        favouritesBackButton.click()
    }

    fun checkSearchResults() {
        waitUntilElementVisible(favouritesSearchResultsList)
        assert(favouritesSearchResultsList.isDisplayed)
    }
}