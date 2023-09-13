package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.j;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

@XStreamAlias("gist")
public class GistIntegrationConfiguration extends AbstractConfiguration {
  private static final Logger LOG = Logger.getLogger("com.xk72.charles.config.GistIntegrationConfiguration");
  
  private static final int DEFAULT_MAX_PUBLISH_SIZE = 10;
  
  private int publishLimit = 10;
  
  private boolean secret = true;
  
  private transient String authToken = null;
  
  private String encryptedAuthToken = null;
  
  private boolean openGist = true;
  
  private boolean enterpriseGitHub = false;
  
  private String enterpriseURL = null;
  
  private transient URI enterpriseURI = null;
  
  public int getPublishLimit() {
    return this.publishLimit;
  }
  
  public void setPublishLimit(int paramInt) {
    this.publishLimit = paramInt;
  }
  
  public boolean isSecret() {
    return this.secret;
  }
  
  public void setSecret(boolean paramBoolean) {
    this.secret = paramBoolean;
  }
  
  public synchronized String getAuthToken() {
    if (this.encryptedAuthToken == null)
      return null; 
    if (this.authToken == null)
      try {
        this.authToken = j.a(this.encryptedAuthToken);
        if (!this.authToken.matches("^gh[a-z]_.*")) {
          this.authToken = null;
          LOG.info("Forgetting legacy GitHub OAuth token");
        } 
      } catch (RuntimeException runtimeException) {
        LOG.log(Level.WARNING, "Error decrypting saved OAuth token", runtimeException);
        this.authToken = null;
        this.encryptedAuthToken = null;
      }  
    return this.authToken;
  }
  
  public synchronized void setAuthToken(String paramString) {
    this.encryptedAuthToken = j.n(paramString);
    this.authToken = paramString;
  }
  
  public boolean isOpenGist() {
    return this.openGist;
  }
  
  public void setOpenGist(boolean paramBoolean) {
    this.openGist = paramBoolean;
  }
  
  public boolean isEnterpriseGitHub() {
    return this.enterpriseGitHub;
  }
  
  public void setEnterpriseGitHub(boolean paramBoolean) {
    this.enterpriseGitHub = paramBoolean;
  }
  
  public String getEnterpriseURL() {
    return this.enterpriseURL;
  }
  
  public void setEnterpriseURL(String paramString) {
    this.enterpriseURL = paramString;
    this.enterpriseURI = null;
  }
  
  public URI getEnterpriseURI() {
    if (this.enterpriseURL == null)
      return null; 
    if (this.enterpriseURI == null)
      try {
        this.enterpriseURI = parseURL(this.enterpriseURL);
      } catch (URISyntaxException uRISyntaxException) {
        throw new RuntimeException(uRISyntaxException);
      }  
    return this.enterpriseURI;
  }
  
  public static URI parseURL(String paramString) {
    return (paramString.indexOf(':') >= 0 || paramString.indexOf('/') >= 0) ? new URI(paramString) : new URI(null, paramString, null, null);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\GistIntegrationConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */