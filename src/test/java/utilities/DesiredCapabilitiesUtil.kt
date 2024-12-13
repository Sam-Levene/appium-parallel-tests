package utilities

import io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_ACTIVITY
import io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_PACKAGE
import io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID
import io.appium.java_client.remote.IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID
import io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_ORG_ID
import io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_SIGNING_ID
import io.appium.java_client.remote.MobileCapabilityType.APP
import io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME
import io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME
import io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION
import org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.UnknownHostException

fun getAndroidCapabilities() = DesiredCapabilities().apply {

    val localFile: String = if (System.getenv("env").equals("Staging")) {
        System.getProperty("user.dir") + "/QuidcoStaging.apk"
    } else if (System.getenv("env").equals("Dev")) {
        System.getProperty("user.dir") + "/QuidcoDev.apk"
    } else if (System.getenv("env").equals("Prod")) {
        System.getProperty("user.dir") + "/QuidcoProd.apk"
    } else {
        throw UnknownHostException("Unknown Environment Host")
    }

    val bitriseApkPath: String = if (System.getenv("BITRISE_APK_PATH").isNullOrBlank()) {
        localFile
    } else {
        System.getenv("BITRISE_APK_PATH")
    }
    val androidDevice = System.getenv("ANDROID_DEVICE")

    setCapability(AUTOMATION_NAME, "uiautomator2")
    setCapability(APP, bitriseApkPath)
    if (System.getenv("env").equals("Staging")) {
        setCapability(APP_WAIT_PACKAGE, "com.quidco.staging")
    } else if (System.getenv("env").equals("Dev")) {
        setCapability(APP_WAIT_PACKAGE, "com.quidco.dev")
    } else if (System.getenv("env").equals("Prod")) {
        setCapability(APP_WAIT_PACKAGE, "com.quidco.prod")
    } else {
        throw UnknownHostException("Unknown Environment Host")
    }

    setCapability(APP_WAIT_ACTIVITY, "com.quidco.features.sign_join.entry.EntryActivity")
    setCapability(DEVICE_NAME, androidDevice)
    setCapability(PLATFORM_NAME, "Android")
}

fun getIOSCapabilities() = DesiredCapabilities().apply {
    val localFile: String = if (System.getenv("env").equals("Staging")) {
        System.getProperty("user.dir") + "/QuidcoStaging.app"
    } else if (System.getenv("env").equals("Dev")) {
        System.getProperty("user.dir") + "/QuidcoDev.app"
    } else if (System.getenv("env").equals("Prod")) {
        System.getProperty("user.dir") + "/QuidcoProd.app"
    } else {
        throw UnknownHostException("Unknown Environment Host")
    }

    val bitriseAppPath: String = if (System.getenv("BITRISE_APP_PATH").isNullOrBlank()) {
        localFile
    } else {
        System.getenv("BITRISE_APP_PATH")
    }
    val iosDevice = System.getenv("IOS_DEVICE")

    setCapability(AUTOMATION_NAME, "xcuitest")
    setCapability(APP, bitriseAppPath)

    if (System.getenv("env").equals("Staging")) {
        setCapability(BUNDLE_ID, "com.quidco.staging")
    }  else if (System.getenv("env").equals("Dev")) {
        setCapability(BUNDLE_ID, "com.quidco.dev")
    } else if (System.getenv("env").equals("Prod")) {
        setCapability(BUNDLE_ID, "com.quidco.prod")
    } else {
        throw UnknownHostException("Unknown Environment Host")
    }

    setCapability(UPDATE_WDA_BUNDLEID, "io.appium.WebDriverAgentRunner")
    setCapability(XCODE_ORG_ID, "LCGP6W5532")
    setCapability(XCODE_SIGNING_ID, "iPhone Developer")
    setCapability(DEVICE_NAME, iosDevice)
    setCapability(PLATFORM_VERSION, "16.1")
}
