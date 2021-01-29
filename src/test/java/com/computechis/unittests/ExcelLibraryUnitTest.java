package com.computechis.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computechis.factory.ExcelReader;

public class ExcelLibraryUnitTest {
	
	@Test
	public void testExcelLib() {
		ExcelReader excel = new ExcelReader();
		String expData = "TestingExcel";
		String actData =excel.getStringData("TestSheet", 0, 0);
		System.out.println("Actual Data : " + actData);
		Assert.assertEquals(actData, expData);
	}

}
