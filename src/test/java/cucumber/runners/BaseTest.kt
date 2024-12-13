package cucumber.runners

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import utilities.ThreadLocalDriver
import utilities.getAndroidCapabilities
import utilities.getIOSCapabilities
import java.io.IOException
import java.net.URL


class BaseTest {
    
    @Before
    @Throws(IOException::class)
    fun setup() {
        val appiumUrl = URL(System.getenv("URL"))
        val isAndroidOS = System.getenv("OS").equals("Android")

        ThreadLocalDriver.tLDriver = when {
            isAndroidOS -> AndroidDriver(appiumUrl, getAndroidCapabilities())
            else -> IOSDriver(appiumUrl, getIOSCapabilities())
        }
    }

    @After
    @Synchronized
    fun teardown(scenario: Scenario) {
        if (scenario.isFailed) {
            val screenshot = (ThreadLocalDriver.tLDriver as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
            scenario.attach(screenshot, "image/png", java.util.UUID.randomUUID().toString())
        }
        ThreadLocalDriver.tLDriver.quit()
    }
}