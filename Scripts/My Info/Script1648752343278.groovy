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

TestData input = findTestData('Data Files/Demo Web')

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

    WebUI.click(findTestObject('PIM/input_Sub Unit_btnAdd'))
}

WebUI.click(findTestObject('My Info/b_My Info'))

WebUI.click(findTestObject('My Info/input__btnSave'))

TestData fullname = findTestData('Data Files/Fullname')

for (int rowName = 1; rowName <= fullname.getRowNumbers(); rowName++) {
    WebUI.setText(findTestObject('Object Repository/My Info/input__personaltxtEmpFirstName'), fullname.getValue('firstname', 
            rowName))

    WebUI.setText(findTestObject('Object Repository/My Info/input_Middle Name_personaltxtEmpMiddleName'), fullname.getValue(
            'middlename', rowName))

    WebUI.setText(findTestObject('Object Repository/My Info/input__personaltxtEmpLastName'), fullname.getValue('lastname', 
            rowName))

    TestData myInfo = findTestData('Data Files/My Info')

    for (int rowInfo = 1; rowInfo <= myInfo.getRowNumbers(); rowInfo++) {
        WebUI.setText(findTestObject('Object Repository/My Info/input_Employee Id_personaltxtEmployeeId'), myInfo.getValue(
                'empID', rowInfo))

        WebUI.setText(findTestObject('Object Repository/My Info/input_concat(Driver, , s License Number)_personaltxtLicenNo'), 
            myInfo.getValue('driverNumber', rowInfo))

        WebUI.setText(findTestObject('Object Repository/My Info/input_SSN Number_personaltxtNICNo'), myInfo.getValue('SSN', 
                rowInfo))

        WebUI.setText(findTestObject('Object Repository/My Info/input_Other Id_personaltxtOtherID'), myInfo.getValue('otherID', 
                rowInfo))

        WebUI.setText(findTestObject('Object Repository/My Info/input_License Expiry Date_personaltxtLicExpDate'), fullname.getValue(
                'expired', rowName))

        WebUI.click(findTestObject('Object Repository/My Info/input_Employee Id_personaltxtEmployeeId'))

        WebUI.setText(findTestObject('Object Repository/My Info/input_SIN Number_personaltxtSINNo'), myInfo.getValue('SIN', 
                rowInfo))

        if (myInfo.getValue('gender', rowInfo) == 'Male') {
            WebUI.click(findTestObject('Object Repository/My Info/input_Gender_personaloptGenderMale'))
        } else {
            WebUI.click(findTestObject('Object Repository/My Info/input_Male_personaloptGenderFemale'))
        }
        
        WebUI.click(findTestObject('Object Repository/My Info/select_-- Select --Afghan'))

        if (myInfo.getValue('nationality', rowInfo) == 'Belgian') {
            WebUI.click(findTestObject('Object Repository/My Info/div_Belgian'))
        }
        
        WebUI.click(findTestObject('Object Repository/My Info/select_-- Select --SingleMarriedOther'))

        if (myInfo.getValue('marital', rowInfo) == 'Single') {
            WebUI.click(findTestObject('Object Repository/My Info/div_Single'))
        } else if (myInfo.getValue('marital', rowInfo) == 'Married') {
            WebUI.click(findTestObject('Object Repository/My Info/div_Married'))
        } else {
            WebUI.click(findTestObject('Object Repository/My Info/div_Other'))
        }
        
        WebUI.setText(findTestObject('Object Repository/My Info/input_Date of Birth_personalDOB'), fullname.getValue('birth', 
                rowName))

        WebUI.click(findTestObject('Object Repository/My Info/input_Nick Name_personaltxtEmpNickName'))

        WebUI.setText(findTestObject('Object Repository/My Info/input_Nick Name_personaltxtEmpNickName'), myInfo.getValue(
                'nick', rowInfo))

        WebUI.setText(findTestObject('Object Repository/My Info/input_Military Service_personaltxtMilitarySer'), myInfo.getValue(
                'military', rowInfo))

        if (myInfo.getValue('smoker', rowInfo) == 'Yes') {
            WebUI.click(findTestObject('Object Repository/My Info/input_Smoker_personalchkSmokeFlag'))
        }
        
        WebUI.click(findTestObject('My Info/input__btnSave'))
    }
}