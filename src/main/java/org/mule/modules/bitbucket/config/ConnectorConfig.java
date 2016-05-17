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
	  @Default("https://api.bitbucket.org/2.0/repositories/rakesh_t/test")
	  private String url = "https://api.bitbucket.org/2.0/repositories/rakesh_t/test";

	  @Configurable
	  @Optional
	  @RestHeaderParam("Authorization")
	  private String authorization = "Bearer 6-UdWWgUlm934Zjk88-9XbYTsMYTZ_dVlqFlevhFCsaOxLVMzpEpB97Rfv2Spr1gXTLkx-Z1d54i0553RQ==";

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