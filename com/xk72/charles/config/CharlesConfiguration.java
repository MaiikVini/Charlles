package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Properties;

@XStreamAlias("configuration")
public class CharlesConfiguration extends AbstractConfiguration {
  private ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
  
  private DNSConfiguration dnsConfiguration = new DNSConfiguration();
  
  private RecordingConfiguration recordingConfiguration = new RecordingConfiguration();
  
  private AccessControlConfiguration accessControlConfiguration = new AccessControlConfiguration();
  
  private ExternalProxyConfiguration externalProxyConfiguration = new ExternalProxyConfiguration();
  
  private ExternalDNSResolverConfiguration externalDNSResolverConfiguration = new ExternalDNSResolverConfiguration();
  
  private ThrottlingConfiguration throttlingConfiguration = new ThrottlingConfiguration();
  
  private StartupConfiguration startupConfiguration = new StartupConfiguration();
  
  private UserInterfaceConfiguration userInterfaceConfiguration = new UserInterfaceConfiguration();
  
  private RegistrationConfiguration registrationConfiguration = new RegistrationConfiguration();
  
  private ToolConfiguration toolConfiguration = new ToolConfiguration();
  
  private RemoteControlConfiguration remoteControlConfiguration = new RemoteControlConfiguration();
  
  private ClientSSLCertificatesConfiguration clientSSLCertificatesConfiguration = new ClientSSLCertificatesConfiguration();
  
  private ProtobufConfiguration protobufConfiguration = new ProtobufConfiguration();
  
  private GistIntegrationConfiguration gistConfiguration = new GistIntegrationConfiguration();
  
  private FocusConfiguration focusConfiguration = new FocusConfiguration();
  
  private CategoryConfiguration categoryConfiguration = new CategoryConfiguration();
  
  public void init() {
    init(this);
  }
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    this.proxyConfiguration.init(paramCharlesConfiguration);
    this.dnsConfiguration.init(paramCharlesConfiguration);
    this.recordingConfiguration.init(paramCharlesConfiguration);
    this.accessControlConfiguration.init(paramCharlesConfiguration);
    this.externalProxyConfiguration.init(paramCharlesConfiguration);
    this.externalDNSResolverConfiguration.init(paramCharlesConfiguration);
    this.throttlingConfiguration.init(paramCharlesConfiguration);
    this.startupConfiguration.init(paramCharlesConfiguration);
    this.userInterfaceConfiguration.init(paramCharlesConfiguration);
    this.registrationConfiguration.init(paramCharlesConfiguration);
    this.toolConfiguration.init(paramCharlesConfiguration);
    this.remoteControlConfiguration.init(paramCharlesConfiguration);
    this.clientSSLCertificatesConfiguration.init(paramCharlesConfiguration);
    this.protobufConfiguration.init(paramCharlesConfiguration);
    if (this.gistConfiguration == null)
      this.gistConfiguration = new GistIntegrationConfiguration(); 
    this.gistConfiguration.init(paramCharlesConfiguration);
    this.focusConfiguration.init(paramCharlesConfiguration);
  }
  
  public AccessControlConfiguration getAccessControlConfiguration() {
    return this.accessControlConfiguration;
  }
  
  public void setAccessControlConfiguration(AccessControlConfiguration paramAccessControlConfiguration) {
    this.accessControlConfiguration = paramAccessControlConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("accessControlConfiguration", (Object)null, paramAccessControlConfiguration); 
  }
  
  public ExternalProxyConfiguration getExternalProxyConfiguration() {
    return this.externalProxyConfiguration;
  }
  
  public void setExternalProxyConfiguration(ExternalProxyConfiguration paramExternalProxyConfiguration) {
    this.externalProxyConfiguration = paramExternalProxyConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("externalProxyConfiguration", (Object)null, paramExternalProxyConfiguration); 
  }
  
  public DNSConfiguration getDNSConfiguration() {
    return this.dnsConfiguration;
  }
  
  public void setDNSConfiguration(DNSConfiguration paramDNSConfiguration) {
    this.dnsConfiguration = paramDNSConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("dnsConfiguration", (Object)null, paramDNSConfiguration); 
  }
  
  public ExternalDNSResolverConfiguration getExternalDNSResolverConfiguration() {
    return this.externalDNSResolverConfiguration;
  }
  
  public void setExternalDNSResolverConfiguration(ExternalDNSResolverConfiguration paramExternalDNSResolverConfiguration) {
    this.externalDNSResolverConfiguration = paramExternalDNSResolverConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("externalDNSResolverConfiguration", (Object)null, paramExternalDNSResolverConfiguration); 
  }
  
  public ProxyConfiguration getProxyConfiguration() {
    return this.proxyConfiguration;
  }
  
  public void setProxyConfiguration(ProxyConfiguration paramProxyConfiguration) {
    this.proxyConfiguration = paramProxyConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("proxyConfiguration", (Object)null, paramProxyConfiguration); 
  }
  
  public RecordingConfiguration getRecordingConfiguration() {
    return this.recordingConfiguration;
  }
  
  public void setRecordingConfiguration(RecordingConfiguration paramRecordingConfiguration) {
    this.recordingConfiguration = paramRecordingConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("recordingConfiguration", (Object)null, paramRecordingConfiguration); 
  }
  
  public StartupConfiguration getStartupConfiguration() {
    return this.startupConfiguration;
  }
  
  public void setStartupConfiguration(StartupConfiguration paramStartupConfiguration) {
    this.startupConfiguration = paramStartupConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("startupConfiguration", (Object)null, paramStartupConfiguration); 
  }
  
  public ThrottlingConfiguration getThrottlingConfiguration() {
    return this.throttlingConfiguration;
  }
  
  public void setThrottlingConfiguration(ThrottlingConfiguration paramThrottlingConfiguration) {
    this.throttlingConfiguration = paramThrottlingConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("throttlingConfiguration", (Object)null, paramThrottlingConfiguration); 
  }
  
  public UserInterfaceConfiguration getUserInterfaceConfiguration() {
    return this.userInterfaceConfiguration;
  }
  
  public void setUserInterfaceConfiguration(UserInterfaceConfiguration paramUserInterfaceConfiguration) {
    this.userInterfaceConfiguration = paramUserInterfaceConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("userInterfaceConfiguration", (Object)null, paramUserInterfaceConfiguration); 
  }
  
  public RegistrationConfiguration getRegistrationConfiguration() {
    return this.registrationConfiguration;
  }
  
  public void setRegistrationConfiguration(RegistrationConfiguration paramRegistrationConfiguration) {
    this.registrationConfiguration = paramRegistrationConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("registrationConfiguration", (Object)null, paramRegistrationConfiguration); 
  }
  
  public ToolConfiguration getToolConfiguration() {
    return this.toolConfiguration;
  }
  
  public void setToolConfiguration(ToolConfiguration paramToolConfiguration) {
    this.toolConfiguration = paramToolConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("toolConfiguration", (Object)null, paramToolConfiguration); 
  }
  
  public RemoteControlConfiguration getRemoteControlConfiguration() {
    return this.remoteControlConfiguration;
  }
  
  public void setRemoteControlConfiguration(RemoteControlConfiguration paramRemoteControlConfiguration) {
    this.remoteControlConfiguration = paramRemoteControlConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("remoteControlConfiguration", (Object)null, paramRemoteControlConfiguration); 
  }
  
  public ClientSSLCertificatesConfiguration getClientSSLCertificatesConfiguration() {
    return this.clientSSLCertificatesConfiguration;
  }
  
  public void setClientSSLCertificatesConfiguration(ClientSSLCertificatesConfiguration paramClientSSLCertificatesConfiguration) {
    this.clientSSLCertificatesConfiguration = paramClientSSLCertificatesConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("clientSSLCertificatesConfiguration", (Object)null, paramClientSSLCertificatesConfiguration); 
  }
  
  public ProtobufConfiguration getProtobufConfiguration() {
    return this.protobufConfiguration;
  }
  
  public void setProtobufConfiguration(ProtobufConfiguration paramProtobufConfiguration) {
    this.protobufConfiguration = paramProtobufConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("protobufConfiguration", (Object)null, paramProtobufConfiguration); 
  }
  
  public GistIntegrationConfiguration getGistIntegrationConfiguration() {
    return this.gistConfiguration;
  }
  
  public void setGistIntegrationConfiguration(GistIntegrationConfiguration paramGistIntegrationConfiguration) {
    this.gistConfiguration = paramGistIntegrationConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("gistConfiguration", (Object)null, paramGistIntegrationConfiguration); 
  }
  
  public FocusConfiguration getFocusConfiguration() {
    return this.focusConfiguration;
  }
  
  public void setFocusConfiguration(FocusConfiguration paramFocusConfiguration) {
    this.focusConfiguration = paramFocusConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("focusConfiguration", (Object)null, paramFocusConfiguration); 
  }
  
  public CategoryConfiguration getCategoryConfiguration() {
    return this.categoryConfiguration;
  }
  
  public void setCategoryConfiguration(CategoryConfiguration paramCategoryConfiguration) {
    this.categoryConfiguration = paramCategoryConfiguration;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("categoryConfiguration", (Object)null, paramCategoryConfiguration); 
  }
  
  public void loadLegacyProperties(Properties paramProperties) {
    this.proxyConfiguration.loadLegacyProperties(paramProperties);
    this.recordingConfiguration.loadLegacyProperties(paramProperties);
    this.externalProxyConfiguration.loadLegacyProperties(paramProperties);
    this.throttlingConfiguration.loadLegacyProperties(paramProperties);
    this.startupConfiguration.loadLegacyProperties(paramProperties);
    this.userInterfaceConfiguration.loadLegacyProperties(paramProperties);
    this.registrationConfiguration.loadLegacyProperties(paramProperties);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\CharlesConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */