package com.computechis.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computechis.factory.ConfigProvider;

public class ConfigProviderUnitTest {
	
	@Test
	public void testConfigLib() {
		ConfigProvider config = new ConfigProvider();
		String data = config.getValue("testConfig");
		Assert.assertEquals(data, "TestingConfigFile");
	}

}
