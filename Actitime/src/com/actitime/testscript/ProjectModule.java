package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class ProjectModule {
	@Test
	public void testCreateProject() {
		String projectName=f.getExcelData("CreateProject",1,3);
		String projectDescription=f.getExcelData("CreateProject",1,4);
		Reporter.log("Create Project",true);
		HomePage h=new HomePage(driver);
		h.setTasks();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getEnterProjectName().click();
		t.getCustomerDD().click();
		t.getOurCompanyTxt().clear();
		t.getEnterProjectDescription().click();
		Thread.sleep(4000);
		String actualProject=t.getActualProjectCreated().getText();
		Assert.assertEquals(actualProject,projectName);
	}
}