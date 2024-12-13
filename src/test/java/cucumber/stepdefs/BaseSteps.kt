package cucumber.stepdefs

import utilities.ThreadLocalDriver
import kotlin.properties.Delegates

open class BaseSteps {

    val driver = ThreadLocalDriver.tLDriver

}