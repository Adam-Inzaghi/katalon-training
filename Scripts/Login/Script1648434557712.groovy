import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData input = findTestData('Data Files/Login')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
    WebUI.openBrowser('')

    WebUI.navigateToUrl(GlobalVariable.Url)

    WebUI.maximizeWindow()

    WebUI.delay(1)

    WebUI.setText(findTestObject('Object Repository/Login/Page_OrangeHRM/input_LOGIN Panel_txtUsername'), input.getValue(
            'username', baris))

    WebUI.delay(1)

    WebUI.setText(findTestObject('Object Repository/Login/Page_OrangeHRM/input_Username_txtPassword'), input.getValue('password', 
            baris))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Login/Page_OrangeHRM/input_Password_Submit'))
}

TestData inputRegis = findTestData('Data Files/Register')

for (int row = 1; row <= inputRegis.getRowNumbers(); row++) {
    WebUI.click(findTestObject('Login/Page_OrangeHRM/b_Admin'))

    WebUI.click(findTestObject('Login/Page_OrangeHRM/input_Status_btnAdd'))

    WebUI.setText(findTestObject('Login/Page_OrangeHRM/input__systemUseremployeeNameempName'), inputRegis.getValue('employeeName', 
            row))

    WebUI.click(findTestObject('Login/Page_OrangeHRM/li_Admin A'))

    WebUI.setText(findTestObject('Login/Page_OrangeHRM/input__systemUseruserName'), inputRegis.getValue('username', row))

    WebUI.setText(findTestObject('Login/Page_OrangeHRM/input__systemUserpassword'), inputRegis.getValue('password', row))

    WebUI.setText(findTestObject('Login/Page_OrangeHRM/input__systemUserconfirmPassword'), inputRegis.getValue('confirmPassword', 
            row))

    WebUI.click(findTestObject('Login/Page_OrangeHRM/input__btnSave'))

    WebUI.verifyTextPresent(inputRegis.getValue('verify', row), false)
}

