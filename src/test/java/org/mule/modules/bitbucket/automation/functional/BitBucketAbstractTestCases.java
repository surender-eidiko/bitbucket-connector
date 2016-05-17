/**
 * Copyright � 1992-2016 Cisco, Inc.
 */
package org.mule.modules.bitbucket.automation.functional;


import org.junit.Before;
import org.mule.modules.bitbucket.BitbucketConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public abstract class BitBucketAbstractTestCases  extends AbstractTestCase<BitbucketConnector>{
		
	private BitbucketConnector connector;
	private ConnectorDispatcher<BitbucketConnector> dispatcher;
	
	public BitBucketAbstractTestCases(Class<BitbucketConnector> connector){
		super(connector);
	}
		
		
	protected BitbucketConnector getConnector() {
		return connector;
	}


	protected ConnectorDispatcher<BitbucketConnector> getDispatcher() {
		return dispatcher;
	}
	
	

	
	@SuppressWarnings("deprecation")
	@Before
	public void init() throws Exception {

		// Initialization for single-test run
		ConnectorTestContext.initialize(BitbucketConnector.class, false);

	    // Context instance
		ConnectorTestContext<BitbucketConnector> context = ConnectorTestContext
	      .getInstance(BitbucketConnector.class);

	    // Connector dispatcher
	    dispatcher = context.getConnectorDispatcher();

	    connector = dispatcher.createMockup();

	}
	


}
