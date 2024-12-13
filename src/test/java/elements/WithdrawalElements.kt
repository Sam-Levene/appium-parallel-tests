package elements

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

object WithdrawalElements {

    @AndroidFindBy(id = "paypal_card")
    @iOSXCUITFindBy(accessibility = "paypal_withdraw_button")
    lateinit var withdrawToPayPal: WebElement

    @AndroidFindBy(id = "bank_account_card")
    @iOSXCUITFindBy(accessibility = "bacs_withdraw_button")
    lateinit var withdrawToBankAccount: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.ViewSwitcher/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(accessibility = "Amazon")
    lateinit var amazonGiftCard: WebElement

    @AndroidFindBy(id = "edit_amount")
    @iOSXCUITFindBy(accessibility = "edit")
    lateinit var editValue: WebElement

    @AndroidFindBy(id = "account_balance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Quidco Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    lateinit var valueField: WebElement

    @AndroidFindBy(id = "amount_to_withdraw")
    lateinit var withdrawToGiftCardValueField: WebElement

    @AndroidFindBy(id = "go_to_summary_button")
    lateinit var continueButton: WebElement

    @AndroidFindBy(id = "confirm_button")
    @iOSXCUITFindBy(accessibility = "Confirm")
    lateinit var confirmButton: WebElement

    @AndroidFindBy(id = "get_giftcard")
    @iOSXCUITFindBy(accessibility = "Get Gift Card")
    lateinit var getGiftCardButton: WebElement

    @AndroidFindBy(id = "confirm_button")
    @iOSXCUITFindBy(accessibility = "Withdraw £10.00")
    lateinit var bankAccountWithdrawSpecificAmountButton: WebElement

    @AndroidFindBy(id = "cancel_withdrawal")
    @iOSXCUITFindBy(accessibility = "Cancel withdrawal")
    lateinit var cancelWithdrawal: WebElement

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSXCUITFindBy(accessibility = "Yes")
    lateinit var confirmCancelButton: WebElement
}