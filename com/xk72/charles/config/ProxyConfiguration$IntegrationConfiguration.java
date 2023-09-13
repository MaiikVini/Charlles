package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("integration")
public class ProxyConfiguration$IntegrationConfiguration extends AbstractConfiguration {
  private boolean useHTTP = true;
  
  private boolean useSOCKS = false;
  
  private boolean enableAtStartup = true;
  
  public boolean isUseHTTP() {
    return this.useHTTP;
  }
  
  public void setUseHTTP(boolean paramBoolean) {
    this.useHTTP = paramBoolean;
  }
  
  public boolean isUseSOCKS() {
    return this.useSOCKS;
  }
  
  public void setUseSOCKS(boolean paramBoolean) {
    this.useSOCKS = paramBoolean;
  }
  
  public boolean isEnableAtStartup() {
    return this.enableAtStartup;
  }
  
  public void setEnableAtStartup(boolean paramBoolean) {
    this.enableAtStartup = paramBoolean;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ProxyConfiguration$IntegrationConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */