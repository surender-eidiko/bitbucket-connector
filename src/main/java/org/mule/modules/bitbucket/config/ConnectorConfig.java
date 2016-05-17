package org.mule.modules.bitbucket.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.rest.RestHeaderParam;

@SuppressWarnings("deprecation")
@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	@Configurable
	  @Optional
	  @Default("https://api.bitbucket.org/2.0")
	  private String url = "https://api.bitbucket.org/2.0";

	  @Configurable
	  @Optional
	  @RestHeaderParam("Authorization")
	  private String authorization = "Bearer Xt3jbn6i6cbWAzpa4IwuzAZOCHRYQwzifS-67VqUT0iubu7RUKu7Pyx-4sM1fesvoGEcYjPbARQEXdZKGLI=";

	  public String getUrl() {
	    return url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }

	  public String getAuthorization() {
	    return authorization;
	  }

	  public void setAuthorization(String authorization) {
	    this.authorization = authorization;
	  }

}