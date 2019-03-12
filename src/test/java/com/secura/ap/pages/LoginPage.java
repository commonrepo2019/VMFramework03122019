package com.secura.ap.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.repository.OR_Common;

public class LoginPage extends OR_Common {

	String CA = "Commercial Auto";
	String WC = "Workers Comp";

	public void APLogin(Map<String, String> row,ExtentTest test) throws IOException {

      // String searchbox = (String) row.get("searchbox");
	//	String partnerNumber = (String) row.get("partnerNumber");
     //  System.out.println("searchbox :>>>>>>   " +partnerNumber);
	    String UserName = (String) row.get("UserName");
	    System.out.println("UserName :>>>>>>   " +UserName);
		String password = (String) row.get("password");
		System.out.println("password :>>>>>>   " +password);
		String Company = (String) row.get("Company");
		String FirstName = (String) row.get("FirstName");
		String LastName = (String) row.get("LastName");
		try {
			se.verify().verifyEquals("Login Page is displayed", getUsername().isDisplayed(),true,true, test);
			//se.element().enterText(getPartnerNumber(), partnerNumber);
			se.element().enterText(getUsername(), UserName);
			se.element().enterText(getPassword(), password);
			se.element().Click(getpropertycas());
			 Thread.sleep(1000);
			System.out.println("clicked on Login");
			se.element().Click(getlifeann());
			 Thread.sleep(2000);
			 System.out.println("clicked on getlifeann");
			se.element().Click(gethealthc());
			 Thread.sleep(2000);
			 Actions a = new Actions(driver);
			 a.sendKeys(Keys.ARROW_DOWN).build().perform();
			 a.sendKeys(Keys.ENTER).build().perform();
			 Thread.sleep(3000);
			 se.element().enterText(getCompanyName(), Company);
			 Thread.sleep(3000);
			 se.element().Click(gettitle());
			 Thread.sleep(2000);
			 a.sendKeys(Keys.ARROW_DOWN).build().perform();
			 a.sendKeys(Keys.ENTER).build().perform();
			 Thread.sleep(2000);
			 se.element().enterText(getFirstName(), FirstName);
			 Thread.sleep(2000);
			 se.element().enterText(getLastName(), LastName);
			 Thread.sleep(20000);
			/* System.out.println("clicked on gethealthc");
			se.element().Click(getbanking());
			Thread.sleep(5000);
			System.out.println("clicked on getbanking");
			Thread.sleep(5000);
			System.out.println("clicked on getcontactus");
			se.element().Click(getcontactus());*/
			
			
//			test.log(LogStatus.INFO, "Entering text in USERNAME & PASSWORD fields","<b>USERNAME : " + strLgnUsername + "<br> <b>PASSWORD : " + strLgnPassword);
//			test.log(LogStatus.INFO, "Clicking on the button", "Click on LOGIN");
		} catch (Exception e) {
			se.verify().verifyEquals("Issue with login screen", true, false, true, test);
		}
	}
}
