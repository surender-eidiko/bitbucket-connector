package org.mule.modules.bitbucket;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.modules.bitbucket.bean.CreateWebhookPostRequest;
import org.mule.modules.bitbucket.bean.CreateWebhookPostResponse;
import org.mule.modules.bitbucket.bean.StatusResponse;
import org.mule.modules.bitbucket.BitbucketConnector;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class BitbucketClient {

	private Client client;
	private WebResource apiResource;

	public Client getClient() {
		return client;
	}

	private BitbucketConnector connector;
	private static final Logger log = Logger.getLogger(BitbucketClient.class
			.getName());

	public BitbucketClient(BitbucketConnector connector) {
		setConnector(connector);

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		this.client = Client.create(clientConfig);
		this.apiResource = this.client.resource(getConnector().getConfig()
				.getUrl());
	}

	public CreateWebhookPostResponse createWebHook(
			CreateWebhookPostRequest webhookPostRequest,String owner,String repositoryName) {
		   System.out.println("test");
			WebResource webResource = getApiResource().path("repositories").path(owner).path(repositoryName).path("hooks");
			System.out.println("test3"+webResource);
			log.info("Hitting... "+webResource.toString());
		    return (CreateWebhookPostResponse) postData(webhookPostRequest,
		      webResource, CreateWebhookPostResponse.class);
		  }
	  private Object postData(Object request, WebResource webResource,
	    Class<?> returnClass) {
	    WebResource.Builder builder = addHeader(webResource);
	    builder.type(MediaType.APPLICATION_JSON);
	    ObjectMapper mapper = new ObjectMapper();
	    String input = convertObjectToString(request, mapper);
	   
	    ClientResponse clientResponse = builder.post(ClientResponse.class,
	      input);
	 
	    return buildResponseObject(returnClass, clientResponse);
	  }

	 private WebResource.Builder addHeader(WebResource webResource) {
	    WebResource.Builder builder = webResource
	      .accept(MediaType.APPLICATION_JSON);

	    builder.header("Authorization", connector.getConfig()
	      .getAuthorization());
	    return builder;
	  }

	 private Object buildResponseObject(Class<?> returnClass,
	    ClientResponse clientResponse) {
		 
	    StatusResponse statusResponse = null;
	    if (clientResponse.getStatus() == 200) {
	      statusResponse = (StatusResponse) clientResponse
	        .getEntity(returnClass);
	      statusResponse.setStatusCode("200");
	    } else {
	     
	      String strResponse = clientResponse.getEntity(String.class);
	      try {
	        Constructor<?> ctor = returnClass.getConstructor();
	        statusResponse = (StatusResponse) ctor.newInstance();
	        statusResponse.setStatusCode(String.valueOf(clientResponse
	          .getStatus()));
	        statusResponse.setStatusMessage(strResponse);
	      } catch (Exception ex) {
	        log.log(Level.SEVERE, "Error", ex);
	      }
	    }
	  
	    return statusResponse;
	   
	  }

	  private String convertObjectToString(Object request, ObjectMapper mapper) {
	    String input = "";

	    try {
	      input = mapper.writeValueAsString(request);

	    } catch (Exception ex) {
	      log.log(Level.SEVERE, "Error", ex);
	    }
	    log.info("Input String = " + input);
	    return input;
	  }
	public void setClient(Client client) {
		this.client = client;
	}

	public WebResource getApiResource() {
		return apiResource;
	}

	public void setApiResource(WebResource apiResource) {
		this.apiResource = apiResource;
	}

	public BitbucketConnector getConnector() {
		return connector;
	}

	public void setConnector(BitbucketConnector connector) {
		this.connector = connector;
	}
}
