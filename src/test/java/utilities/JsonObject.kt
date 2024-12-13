package utilities

import org.json.JSONObject
import java.io.File
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.text.Typography.less

class JsonObject {
    private lateinit var emailAddress: JSONObject
    private lateinit var password: JSONObject

    init {
        try {
            emailAddress = JSONObject(File(System.getProperty("user.dir") + "/email-addresses.json").readText(Charsets.UTF_8))
            password = JSONObject(File(System.getProperty("user.dir") + "/passwords.json").readText(Charsets.UTF_8))
        } catch (e: Exception) {
            for (ste in e.stackTrace) {
                println(ste.toString())
            }
        }
    }

    fun getEmailAddress(objectKey: String, userType: String): String {
        return when (userType) {
            "Referred User", "New User", "Unregistered Email" -> {
                val jsonSplit = emailAddress.getJSONObject("Valid Email Addresses").getString(objectKey).split("@")
                jsonSplit.first() + "+" + System.currentTimeMillis() + "@" + jsonSplit.last()
            }
            "Valid User", "User with less than 5 favourites", "Invalid Password", "Valid Balance User" -> {
                emailAddress.getJSONObject("Valid Email Addresses").getString(objectKey)
            }
            else -> {
                emailAddress.getJSONObject("Invalid Email Addresses").getString(objectKey)
            }
        }
    }

    fun getPassword(objectKey: String, userType: String): String {
        return when(userType) {
            "Invalid Password", "Invalid User" -> password.getJSONObject("Invalid Passwords").getString(objectKey)
            else -> password.getJSONObject("Valid Passwords").getString(objectKey)
        }
    }
}