package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.charles.CharlesContext;
import com.xk72.charles.ssl.CertificateConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@XStreamAlias("proxy")
public class ProxyConfiguration extends AbstractLegacySupportConfiguration {
  private boolean enableSOCKSProxy = false;
  
  private boolean dynamicHTTPPort = false;
  
  private boolean dynamicSOCKSPort = false;
  
  private boolean enableSOCKSTransparentHTTPProxying = true;
  
  private int port = 8888;
  
  private int SOCKSPort = 8889;
  
  private boolean decryptSSL = true;
  
  private boolean transparentProxy = false;
  
  private boolean supportsH2 = true;
  
  private String firefoxProfilePath;
  
  private boolean preferIPv6addresses = false;
  
  private List<String> bypassDomains;
  
  private LocationPatternConfiguration sslLocations = new LocationPatternConfiguration();
  
  private LocationPatternConfiguration sslExcludeLocations = new LocationPatternConfiguration();
  
  private CertificateConfiguration sslRootCertificate;
  
  private boolean defaultSOCKSTransparentHTTPProxyPorts = true;
  
  private int[] socksTransparentHTTPProxyPorts;
  
  private int[] socksTransparentHTTPProxyPortRanges;
  
  private ProxyConfiguration$IntegrationConfiguration windowsConfiguration = new ProxyConfiguration$IntegrationConfiguration();
  
  private ProxyConfiguration$IntegrationConfiguration macOSXConfiguration = new ProxyConfiguration$IntegrationConfiguration();
  
  private ProxyConfiguration$IntegrationConfiguration mozillaFirefoxConfiguration = new ProxyConfiguration$IntegrationConfiguration();
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    if (System.getProperty("charles.proxyPort") != null)
      try {
        this.port = Integer.parseInt(System.getProperty("charles.proxyPort"));
      } catch (NumberFormatException numberFormatException) {} 
    if (System.getProperty("charles.socksProxyPort") != null)
      try {
        this.SOCKSPort = Integer.parseInt(System.getProperty("charles.socksProxyPort"));
      } catch (NumberFormatException numberFormatException) {} 
    this.sslLocations.n();
  }
  
  public void loadLegacyProperties(Properties paramProperties) {
    setPort(getIntProperty(paramProperties, "proxyPort", getPort()));
    setAutoConfigureWindowsProxy(getBooleanProperty(paramProperties, "win32AutoconfigureProxy", getWindowsConfiguration().isEnableAtStartup()));
    setDecryptSSL(getBooleanProperty(paramProperties, "proxySSL", isDecryptSSL()));
  }
  
  public boolean isDecryptSSL() {
    return this.decryptSSL;
  }
  
  public void setDecryptSSL(boolean paramBoolean) {
    boolean bool = this.decryptSSL;
    this.decryptSSL = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("decryptSSL", bool, paramBoolean); 
  }
  
  public LocationPatternConfiguration getSSLLocations() {
    return this.sslLocations;
  }
  
  public void setSSLLocations(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.sslLocations = paramLocationPatternConfiguration;
  }
  
  public LocationPatternConfiguration getSSLExcludeLocations() {
    return this.sslExcludeLocations;
  }
  
  public void setSSLExcludeLocations(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.sslExcludeLocations = paramLocationPatternConfiguration;
  }
  
  public int getPort() {
    return this.port;
  }
  
  public void setPort(int paramInt) {
    int i = this.port;
    this.port = paramInt;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("port", i, paramInt); 
  }
  
  @Deprecated
  public void setAutoConfigureWindowsProxy(boolean paramBoolean) {
    getWindowsConfiguration().setEnableAtStartup(paramBoolean);
  }
  
  @Deprecated
  public void setAutoConfigureMacOSXProxy(boolean paramBoolean) {
    getMacOSXConfiguration().setEnableAtStartup(paramBoolean);
  }
  
  @Deprecated
  public void setAutoConfigureFirefoxProxy(boolean paramBoolean) {
    getMozillaFirefoxConfiguration().setEnableAtStartup(paramBoolean);
  }
  
  public List<String> getBypassDomains() {
    return this.bypassDomains;
  }
  
  public void setBypassDomains(List<String> paramList) {
    this.bypassDomains = paramList;
  }
  
  public int getSOCKSPort() {
    return this.SOCKSPort;
  }
  
  public void setSOCKSPort(int paramInt) {
    this.SOCKSPort = paramInt;
  }
  
  @Deprecated
  public void setDynamicPorts(boolean paramBoolean) {
    this.dynamicHTTPPort = paramBoolean;
    this.dynamicSOCKSPort = paramBoolean;
  }
  
  @Deprecated
  public boolean isPreferIPv6addresses() {
    return this.preferIPv6addresses;
  }
  
  @Deprecated
  public void setPreferIPv6addresses(boolean paramBoolean) {
    this.preferIPv6addresses = paramBoolean;
  }
  
  public String getFirefoxProfilePath() {
    return this.firefoxProfilePath;
  }
  
  public void setFirefoxProfilePath(String paramString) {
    this.firefoxProfilePath = paramString;
  }
  
  public boolean isDynamicSOCKSPort() {
    return this.dynamicSOCKSPort;
  }
  
  public void setDynamicSOCKSPort(boolean paramBoolean) {
    this.dynamicSOCKSPort = paramBoolean;
  }
  
  public boolean isDynamicHTTPPort() {
    return this.dynamicHTTPPort;
  }
  
  public void setDynamicHTTPPort(boolean paramBoolean) {
    this.dynamicHTTPPort = paramBoolean;
  }
  
  public boolean isEnableSOCKSProxy() {
    return this.enableSOCKSProxy;
  }
  
  public void setEnableSOCKSProxy(boolean paramBoolean) {
    this.enableSOCKSProxy = paramBoolean;
  }
  
  public boolean isEnableSOCKSTransparentHTTPProxying() {
    return this.enableSOCKSTransparentHTTPProxying;
  }
  
  public void setEnableSOCKSTransparentHTTPProxying(boolean paramBoolean) {
    boolean bool = this.enableSOCKSTransparentHTTPProxying;
    this.enableSOCKSTransparentHTTPProxying = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("enableSOCKSTransparentHTTPProxying", bool, paramBoolean); 
  }
  
  public boolean isDefaultSOCKSTransparentHTTPProxyPorts() {
    return this.defaultSOCKSTransparentHTTPProxyPorts;
  }
  
  public void setDefaultSOCKSTransparentHTTPProxyPorts(boolean paramBoolean) {
    boolean bool = this.defaultSOCKSTransparentHTTPProxyPorts;
    this.defaultSOCKSTransparentHTTPProxyPorts = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("defaultSOCKSTransparentHTTPProxyPorts", bool, paramBoolean); 
  }
  
  public int[] getSocksTransparentHTTPProxyPorts() {
    return this.socksTransparentHTTPProxyPorts;
  }
  
  public void setSocksTransparentHTTPProxyPorts(int[] paramArrayOfint) {
    int[] arrayOfInt = this.socksTransparentHTTPProxyPorts;
    this.socksTransparentHTTPProxyPorts = paramArrayOfint;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("socksTransparentHTTPProxyPorts", arrayOfInt, paramArrayOfint); 
  }
  
  public int[] getSocksTransparentHTTPProxyPortRanges() {
    return this.socksTransparentHTTPProxyPortRanges;
  }
  
  public void setSocksTransparentHTTPProxyPortRanges(int[] paramArrayOfint) {
    int[] arrayOfInt = this.socksTransparentHTTPProxyPortRanges;
    this.socksTransparentHTTPProxyPortRanges = paramArrayOfint;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("socksTransparentHTTPProxyPortRanges", arrayOfInt, paramArrayOfint); 
  }
  
  public ProxyConfiguration$IntegrationConfiguration getWindowsConfiguration() {
    return this.windowsConfiguration;
  }
  
  public void setWindowsConfiguration(ProxyConfiguration$IntegrationConfiguration paramProxyConfiguration$IntegrationConfiguration) {
    this.windowsConfiguration = paramProxyConfiguration$IntegrationConfiguration;
  }
  
  public ProxyConfiguration$IntegrationConfiguration getMacOSXConfiguration() {
    return this.macOSXConfiguration;
  }
  
  public void setMacOSXConfiguration(ProxyConfiguration$IntegrationConfiguration paramProxyConfiguration$IntegrationConfiguration) {
    this.macOSXConfiguration = paramProxyConfiguration$IntegrationConfiguration;
  }
  
  public ProxyConfiguration$IntegrationConfiguration getMozillaFirefoxConfiguration() {
    return this.mozillaFirefoxConfiguration;
  }
  
  public void setMozillaFirefoxConfiguration(ProxyConfiguration$IntegrationConfiguration paramProxyConfiguration$IntegrationConfiguration) {
    this.mozillaFirefoxConfiguration = paramProxyConfiguration$IntegrationConfiguration;
  }
  
  @Deprecated
  public String getSSLCACertificatePath() {
    return null;
  }
  
  @Deprecated
  public void setSSLCACertificatePath(String paramString) {
    try {
      File file = new File(paramString);
      String str = CharlesContext.getInstance().getFileStore().n(file);
      this.sslRootCertificate = new CertificateConfiguration(file.getName(), str);
    } catch (IOException iOException) {}
  }
  
  public CertificateConfiguration getSSLRootCertificate() {
    return this.sslRootCertificate;
  }
  
  public void setSSLRootCertificate(CertificateConfiguration paramCertificateConfiguration) {
    CertificateConfiguration certificateConfiguration = this.sslRootCertificate;
    this.sslRootCertificate = paramCertificateConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("sslRootCertificate", certificateConfiguration, paramCertificateConfiguration); 
  }
  
  public boolean isTransparentProxy() {
    return this.transparentProxy;
  }
  
  public void setTransparentProxy(boolean paramBoolean) {
    boolean bool = this.transparentProxy;
    this.transparentProxy = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("transparentProxy", bool, paramBoolean); 
  }
  
  public boolean isSupportsH2() {
    return this.supportsH2;
  }
  
  public void setSupportsH2(boolean paramBoolean) {
    boolean bool = this.supportsH2;
    this.supportsH2 = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("supportsH2", bool, paramBoolean); 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ProxyConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */