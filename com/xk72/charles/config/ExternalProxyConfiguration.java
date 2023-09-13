package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.proxy.a;
import com.xk72.proxy.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

@XStreamAlias("externalProxy")
public class ExternalProxyConfiguration extends AbstractLegacySupportConfiguration {
  private static final Logger LOG = Logger.getLogger("com.xk72.charles.config.ExternalProxyConfiguration");
  
  public static final String HTTP = "http";
  
  public static final String HTTPS = "https";
  
  public static final String SOCKS = "socks";
  
  private Map<String, a> configurations = new HashMap<>();
  
  private List<String> bypassDomains;
  
  private boolean enabled;
  
  private boolean alwaysBypassLocalhost = true;
  
  public ExternalProxyConfiguration() {
    setConfiguration("http", (a)new ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl());
    setConfiguration("https", (a)new ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl());
    setConfiguration("socks", (a)new ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl());
  }
  
  public void loadLegacyProperties(Properties paramProperties) {
    ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl externalProxyConfiguration$MutableExternalProxyConfigurationImpl = (ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl)getConfiguration("http").getMutable();
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setActive(getBooleanProperty(paramProperties, "externalProxy", getConfiguration("http").isActive()));
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setHost(paramProperties.getProperty("externalProxyHost"));
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setPort(getIntProperty(paramProperties, "externalProxyPort", 0));
    setConfiguration("http", (a)externalProxyConfiguration$MutableExternalProxyConfigurationImpl);
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl = (ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl)getConfiguration("https").getMutable();
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setActive(getBooleanProperty(paramProperties, "externalProxy", getConfiguration("https").isActive()));
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setHost(paramProperties.getProperty("externalProxyHost"));
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setPort(getIntProperty(paramProperties, "externalProxyPort", 0));
    setConfiguration("https", (a)externalProxyConfiguration$MutableExternalProxyConfigurationImpl);
  }
  
  @Deprecated
  public void setActivated(boolean paramBoolean) {
    b b = getConfiguration("http").getMutable();
    b.setActive(paramBoolean);
    setConfiguration("http", (a)b);
    b = getConfiguration("https").getMutable();
    b.setActive(paramBoolean);
    setConfiguration("https", (a)b);
  }
  
  @Deprecated
  public void setProxyHost(String paramString) {
    ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl externalProxyConfiguration$MutableExternalProxyConfigurationImpl = (ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl)getConfiguration("http").getMutable();
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setHost(paramString);
    setConfiguration("http", (a)externalProxyConfiguration$MutableExternalProxyConfigurationImpl);
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl = (ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl)getConfiguration("https").getMutable();
    externalProxyConfiguration$MutableExternalProxyConfigurationImpl.setHost(paramString);
    setConfiguration("https", (a)externalProxyConfiguration$MutableExternalProxyConfigurationImpl);
  }
  
  @Deprecated
  public void setProxyPort(int paramInt) {
    b b = getConfiguration("http").getMutable();
    b.setPort(paramInt);
    setConfiguration("http", (a)b);
    b = getConfiguration("https").getMutable();
    b.setPort(paramInt);
    setConfiguration("https", (a)b);
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    boolean bool = this.enabled;
    this.enabled = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("enabled", bool, paramBoolean); 
  }
  
  public List<String> getBypassDomains() {
    return this.bypassDomains;
  }
  
  public void setBypassDomains(List<String> paramList) {
    this.bypassDomains = paramList;
  }
  
  public boolean isAlwaysBypassLocalhost() {
    return this.alwaysBypassLocalhost;
  }
  
  public void setAlwaysBypassLocalhost(boolean paramBoolean) {
    this.alwaysBypassLocalhost = paramBoolean;
  }
  
  public a getConfiguration(String paramString) {
    a a = this.configurations.get(paramString);
    if (a != null)
      return a; 
    throw new IllegalArgumentException("Unsupported external proxy protocol: " + paramString);
  }
  
  public void setConfiguration(String paramString, a parama) {
    a a1 = this.configurations.get(paramString);
    this.configurations.put(paramString, parama);
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange(paramString, a1, parama); 
  }
  
  public Map<String, a> getConfigurations() {
    return this.configurations;
  }
  
  public void setConfigurations(Map<String, a> paramMap) {
    this.configurations = paramMap;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ExternalProxyConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */