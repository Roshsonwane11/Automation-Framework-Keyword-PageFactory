package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.utils.TestUtils;

public class TestBase {
	private Keyword keyword = new Keyword();

//	@BeforeMethod
//	@Parameters("browser-name")
//	public void setUpForCBT(String browserName) throws Exception {
//		keyword.openBrowser(browserName);
//		keyword.launchUrl("https://www.bigbasket.com/");
//		keyword.maximizeBrowser();
//	}
//
//	@BeforeMethod(groups = { "RegressionTests", "SanityTests" })
//	public void setUp() throws Exception {
//		keyword.openBrowser("Firefox");
//		keyword.launchUrl("https://www.bigbasket.com/");
//		keyword.maximizeBrowser();
//	}
	
    @BeforeMethod(groups = { "RegressionTests", "SanityTests" })
    public void setUp() throws Exception {
        keyword.openBrowser(TestUtils.getBrowserName());
        keyword.launchUrl(TestUtils.getURL());
        keyword.maximizeBrowser();
    }
    
    @Parameters("browser-name")
    @AfterMethod(groups = { "RegressionTests", "SanityTests" })
    public void tearDown() {
        keyword.quitBrowser(); 
    }
}
