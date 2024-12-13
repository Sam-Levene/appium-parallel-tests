package screens

import elements.WithdrawalElements
import elements.WithdrawalElements.amazonGiftCard
import elements.WithdrawalElements.bankAccountWithdrawSpecificAmountButton
import elements.WithdrawalElements.cancelWithdrawal
import elements.WithdrawalElements.confirmButton
import elements.WithdrawalElements.confirmCancelButton
import elements.WithdrawalElements.continueButton
import elements.WithdrawalElements.editValue
import elements.WithdrawalElements.getGiftCardButton
import elements.WithdrawalElements.valueField
import elements.WithdrawalElements.withdrawToBankAccount
import elements.WithdrawalElements.withdrawToGiftCardValueField
import elements.WithdrawalElements.withdrawToPayPal
import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import utilities.DriverKeyboardHandler.hideKeyboard

class WithdrawalScreen (driver: AppiumDriver) : BaseScreen(driver) {

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), WithdrawalElements)
    }

    fun withdrawAmountByType(balanceAmount: String, balanceType: String) {
        when (balanceType) {
            "Paypal" -> {
                waitUntilElementVisible(amazonGiftCard)
                waitUntilElementClickable(withdrawToPayPal)
                withdrawToPayPal.click()
                waitUntilElementClickable(editValue)
                editValue.click()
                valueField.clear()
                valueField.sendKeys(balanceAmount)
                hideKeyboard(driver)
                waitUntilElementClickable(confirmButton)
                confirmButton.click()
                if (driver is IOSDriver) {
                    waitUntilElementClickable(getGiftCardButton)
                    getGiftCardButton.click()
                }
            }
            "Bank Account" -> {
                waitUntilElementVisible(amazonGiftCard)
                waitUntilElementClickable(withdrawToBankAccount)
                withdrawToBankAccount.click()
                waitUntilElementClickable(editValue)
                editValue.click()
                valueField.clear()
                valueField.sendKeys(balanceAmount)
                waitUntilElementClickable(bankAccountWithdrawSpecificAmountButton)
                bankAccountWithdrawSpecificAmountButton.click()
            }
            "Amazon Gift Card" -> {
                waitUntilElementVisible(amazonGiftCard)
                waitUntilElementClickable(amazonGiftCard)
                amazonGiftCard.click()
                if (driver is IOSDriver) {
                    waitUntilElementClickable(editValue)
                    editValue.click()
                    valueField.clear()
                    valueField.sendKeys(balanceAmount)
                } else {
                    withdrawToGiftCardValueField.clear()
                    withdrawToGiftCardValueField.sendKeys(balanceAmount)
                }
                hideKeyboard(driver)
                if (driver is IOSDriver) {
                    waitUntilElementClickable(confirmButton)
                    confirmButton.click()
                } else {
                    waitUntilElementClickable(continueButton)
                    continueButton.click()
                }
                waitUntilElementClickable(getGiftCardButton)
                getGiftCardButton.click()
            }
            else -> throw UnknownError("Balance Type not supported")
        }
        waitUntilElementVisible(cancelWithdrawal)
        cancelWithdrawal.click()
        waitUntilElementVisible(confirmCancelButton)
        confirmCancelButton.click()
    }
}