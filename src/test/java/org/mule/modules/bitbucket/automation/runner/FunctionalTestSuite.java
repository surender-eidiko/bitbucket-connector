/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.bitbucket.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.bitbucket.BitbucketConnector;
import org.mule.modules.bitbucket.automation.functional.CreateWebHookTestCases;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

//@RunWith(Categories.class)
//@IncludeCategory(RegressionTests.class)
//
//@SuiteClasses({
//	GreetTestCases.class
//	,AddEntityTestCases.class
//	
//})

@RunWith(Suite.class)
@SuiteClasses({CreateWebHookTestCases.class})

public class FunctionalTestSuite {
	
	@BeforeClass
	public static void initialiseSuite() {

		ConnectorTestContext.initialize(BitbucketConnector.class);

	}

	@AfterClass
	public static void shutdownSuite() {

		ConnectorTestContext.shutDown();

	}
	
}