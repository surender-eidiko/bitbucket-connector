package org.mule.modules.bitbucket;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.modules.bitbucket.bean.CreateWebhookPostRequest;
import org.mule.modules.bitbucket.bean.CreateWebhookPostResponse;
import org.mule.modules.bitbucket.config.ConnectorConfig;


@Connector(name="bitbucket", friendlyName="Bitbucket")
public class BitbucketConnector {

    @Config
    ConnectorConfig config;

    private BitbucketClient client;
    
    @Start
	public void init() {
		setClient(new BitbucketClient(this));
	}
    
    @Processor
    public CreateWebhookPostResponse createWebHook(
      CreateWebhookPostRequest webhookPostRequest, String owner,String repositoryName) {
      return getClient().createWebHook(webhookPostRequest,owner,repositoryName);
    }


    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

    public BitbucketClient getClient() {
    	System.out.println("Getting client"+client);
    	return client;
		
	}


	public void setClient(BitbucketClient client) {
		System.out.println("setting client");
		this.client = client;
	}
}