package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
@Test
public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
	String customerName=f.getExcelData("CreateCustomer",1,2);
	String customerDescription=f.getExcelData("CreateCustomer",1,3);
	Reporter.log("Create customer",true);
	HomePage h=new HomePage(driver);
	h.setTasks();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomer().click();
	t.getEnterCustomerNameTbx().sendKeys(customerName);
	t.getEnterCustomerDescription().sendKeys(customerDescription);
	t.getSelectCustomerDD().click();
	t.getOurCompany().click();
	t.getCreateCustomer().click();
	Thread.sleep(4000);
	String actualCustomerTx=t.getActualCustomerCreated().getText();
	Assert.assertEquals(actualCustomerTx, customerName);
	}
}
