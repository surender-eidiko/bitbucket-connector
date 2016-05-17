package org.mule.modules.bitbucket.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.bitbucket.BitbucketConnector;
import org.mule.modules.bitbucket.automation.runner.FunctionalTestSuite;
import org.mule.modules.bitbucket.bean.CreateWebhookPostRequest;
import org.mule.modules.bitbucket.bean.CreateWebhookPostResponse;

public class CreateWebHookTestCases extends BitBucketAbstractTestCases {
	
	public CreateWebHookTestCases()
	{
		super(BitbucketConnector.class);
	}
	@Test
    @Category({FunctionalTestSuite.class})
    public void testCreateWebhook() throws Exception {
		
		//String id = "P7N387X";
		CreateWebhookPostRequest request = new CreateWebhookPostRequest();
		request.setActive("true");
		request.setUrl("http://183.82.99.100:7070/test2");
		String events[] = {"repo:push","issue:created","issue:updated"};
		request.setEvents(events);
		request.setDescription("Webhook Test Description");
		CreateWebhookPostResponse response = getConnector().createWebHook(request, "rakesh_t", "test");
		assertNotNull(response);
	    assertEquals("201", response.getStatusCode() );
	}
}
