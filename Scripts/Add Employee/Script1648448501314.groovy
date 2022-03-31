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
import org.openqa.selenium.Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

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

    WebUI.click(findTestObject('PIM/b_PIM'))

    WebUI.click(findTestObject('PIM/input_Sub Unit_btnAdd'))
}

TestData inputEmployee = findTestData('Data Files/Add Employee')

for (int row = 1; row <= inputEmployee.getRowNumbers(); row++) {
    WebUI.setText(findTestObject('Object Repository/PIM/input__firstName'), inputEmployee.getValue('firstname', row))

    WebUI.setText(findTestObject('Object Repository/PIM/input_Middle Name_middleName'), inputEmployee.getValue('middlename', row))

    WebUI.setText(findTestObject('Object Repository/PIM/input__lastName'), inputEmployee.getValue('lastname', row))

    WebUI.sendKeys(findTestObject('PIM/input_Employee Id_employeeId'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.setText(findTestObject('PIM/input_Employee Id_employeeId'), inputEmployee.getValue('id', row))
	
	String userDir = RunConfiguration.getProjectDir()
	
	WebUI.uploadFile(findTestObject('Object Repository/PIM/input_Photograph_photofile'), userDir + GlobalVariable.PathPhoto)
	
	if (inputEmployee.getValue('CreateLogin', row) == 'Yes') {
		WebUI.click(findTestObject('Object Repository/PIM/input_Create Login Details_chkLogin'))
		
		WebUI.setText(findTestObject('Object Repository/PIM/input__user_name'), inputEmployee.getValue('username', row))
		
		WebUI.setText(findTestObject('Object Repository/PIM/input__user_password'), inputEmployee.getValue('password', row))
		
		WebUI.setText(findTestObject('Object Repository/PIM/input__re_password'), inputEmployee.getValue('confirmPassword', row))
		
		WebUI.click(findTestObject('Object Repository/PIM/select_EnabledDisabled'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/PIM/div_'+inputEmployee.getValue('status', row)))
		
		WebUI.click(findTestObject('Object Repository/PIM/input__btnSave'))
	}
}

