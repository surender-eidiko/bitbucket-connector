package org.mule.modules.bitbucket;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.bitbucket.bean.CreateWebhookPostRequest;
import org.mule.modules.bitbucket.bean.CreateWebhookPostResponse;
import org.mule.modules.bitbucket.config.ConnectorConfig;


@Connector(name="bitbucket", friendlyName="Bitbucket")
public class BitbucketConnector {

    @Config
    ConnectorConfig config;

    private BitbucketClient client;
    
    @Processor
    public CreateWebhookPostResponse createWebHook(
      CreateWebhookPostRequest webhookPostRequest) {
      return getClient().createWebHook(webhookPostRequest);
    }


    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

    public BitbucketClient getClient() {
		return client;
	}


	public void setClient(BitbucketClient client) {
		this.client = client;
	}
}