package utilities

import io.appium.java_client.AppiumDriver

object ThreadLocalDriver {
    private val tlDriver = ThreadLocal<AppiumDriver>()

    @get:Synchronized
    @set:Synchronized
    var tLDriver: AppiumDriver
        get() = tlDriver.get()
        set(driver) {
            tlDriver.set(driver)
        }
}