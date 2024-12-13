package screens

import elements.SearchElements
import elements.SearchElements.searchResultsView
import elements.SearchElements.searchView
import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utilities.DriverKeyboardHandler

class SearchScreen(driver: AppiumDriver) : BaseScreen(driver) {
    lateinit var storedElement: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), SearchElements)
    }

    fun searchForMerchant(searchTerms: String) {
        searchView.sendKeys(searchTerms)
        DriverKeyboardHandler.hideSearchKeyboard(driver)
    }

    fun verifySearchResultsVisible(searchResults: String) {
        Thread.sleep(5000)
        waitUntilElementVisible(searchResultsView)
        if (System.getenv("OS").equals("iOS")) {
           val searchResultsArray = searchResultsView.findElements(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"merchant_cell_name\"])"))

            for (searchResultsElement: WebElement in searchResultsArray) {
                if (searchResultsElement.text.equals(searchResults)) {
                    storedElement = searchResultsElement
                    println("Search Results Found.")
                    break;
                }
            }
        } else {
            var isBoolean = false;
            val searchResultsArray = searchResultsView.findElements(AppiumBy.id("container"))
            Thread.sleep(2000)
            for (item: WebElement in searchResultsArray) {
                var iterativeLinearLayoutElements = item.findElement(AppiumBy.id("container")).findElements(AppiumBy.className("android.widget.LinearLayout"))

                for (items: WebElement in iterativeLinearLayoutElements) {
                    try {
                        if (items.findElement(By.id("brand_name")).text == searchResults) {
                            storedElement = items.findElement(By.id("brand_name"))
                            isBoolean = true;
                            println("Search Results Found.")
                            break;
                        }
                    } catch (e: java.lang.Exception) {
                        // Do nothing. I want to search ALL items in list, not crash out!
                    }
                }
                if (isBoolean) {
                    break;
                }
            }
        }
    }

    fun tapOnMerchant(searchResults: String) {
        try {
            if (storedElement.text == searchResults) {
                storedElement.click()
            }
        } catch (e: Exception) {
            println("Stored Element was null, perhaps search results were not visible?")
        }
    }
}