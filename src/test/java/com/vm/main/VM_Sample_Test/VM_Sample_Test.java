package com.vm.main.VM_Sample_Test;

import com.secura.ap.pages.BillingPage;
import com.secura.ap.pages.VendorPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.secura.ap.pages.LoginPage;
import com.secura.ap.pages.StartupPage;
import com.test.automation.common.BaseTest;
import com.test.automation.common.SeHelper;
import com.test.automation.common.Utils.TestPageFactory;
import com.test.automation.common.framework.Util;
import com.test.automation.common.framework.Browser.Browsers;

public class VM_Sample_Test extends BaseTest {

	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite(alwaysRun = true, groups = { "test" }, timeOut = 1800000000)
	public void beforeSuite() throws IOException {
		String homepath = new File(".").getCanonicalPath();
		extent = new ExtentReports(homepath + "\\Automation_Report\\" + "Run_" + Util.getCurrentDate() + "_" + Util.getCurrentTime() + "\\ReportSummary.html");
	}

	@BeforeMethod(alwaysRun = true, groups = { "test" }, timeOut = 1800000000)
	protected void beforeMethod(Method method, Object[] params) {
		super.beforeMethod(method, params);
		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName());
		test.assignAuthor("Sai Gnapika Thatiparthi");
		test.assignCategory(method.getName());
	}

	@AfterMethod(alwaysRun = true, groups = { "test" }, timeOut = 1800000000)
	protected void afterMethod(Method method, ITestResult result, Object[] params) {
		super.afterMethod(method, result, params);
		extent.endTest(test);
	}

	@AfterSuite(alwaysRun = true, groups = { "test" }, timeOut = 1800000000)
	public void afterSuite() throws IOException {
		extent.flush();
		extent.close();
	}

	@SuppressWarnings("unchecked")
	@Test(description = "VM Automation Framework", dataProvider = "browserXlsByCol", groups = {"VMTest"}, timeOut = 500000000)
	@TestDataXLS(fileName = "../../resources/test_data/VM_TestData_Sample.xlsx", sheetVersion = "new", sheetName = "Sample_Data_One")
	
	public void VM_Test_One(Browsers myBrowser, SeHelper se, Map<String, Object> params) throws IOException {

		StartupPage StartupPage = TestPageFactory.initElements(se, StartupPage.class);
		LoginPage LoginPage = TestPageFactory.initElements(se, LoginPage.class);
		//VendorPage vendorPage = TestPageFactory.initElements(se, VendorPage.class);
		//BillingPage billingPage = TestPageFactory.initElements(se, BillingPage.class);
		
		int iteration = 0;

		for (String name : params.keySet()) {
			List<Map<String, String>> table = new ArrayList<Map<String, String>>();
			table = (List<Map<String, String>>) params.get(name);
			while (iteration < table.size()) {
				try {
					Map<String, String> row = table.get(iteration);

					String strExecuteScript = (String) row.get("ExecuteScenario");

					if (strExecuteScript.equalsIgnoreCase("Yes")) {

						se.log().logTestStep("Connecting to URL");
						test.log(LogStatus.INFO, "Started Execution", "Connecting to URL");
						StartupPage.APStartUp(test, myBrowser);

						se.log().logTestStep("Loggin in to APApp");
						test.log(LogStatus.INFO, "Executing","<b style='color:blue;'>Page : </b>Login" + "<br>Login as : ");
						LoginPage.APLogin(row,test);
						//vendorPage.createVendor(row, test);
						//billingPage.makeSinglePayment(row, test);
					}
					iteration++;
				} catch (Exception e) {
					se.verify().verifyEquals("VM_Test_One failed", true, false, true, test);
					e.printStackTrace();
					iteration++;
				}
			}
		}
		//testTearDown(se);
	}
}
