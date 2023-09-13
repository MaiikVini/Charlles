package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.B;
import com.xk72.util.C;

@XStreamAlias("charles-export")
@B
@C
public class ConfigurationImportExport$CharlesExport {
  private ProxyConfiguration proxyConfiguration;
  
  private RecordingConfiguration recordingConfiguration;
  
  private AccessControlConfiguration accessControlConfiguration;
  
  private ExternalProxyConfiguration externalProxyConfiguration;
  
  private ThrottlingConfiguration throttlingConfiguration;
  
  private StartupConfiguration startupConfiguration;
  
  private UserInterfaceConfiguration userInterfaceConfiguration;
  
  private RegistrationConfiguration registrationConfiguration;
  
  private ToolConfiguration toolConfiguration = new ToolConfiguration();
  
  private RemoteControlConfiguration remoteControlConfiguration;
  
  private ClientSSLCertificatesConfiguration clientSSLCertificatesConfiguration;
  
  private ProtobufConfiguration protobufConfiguration;
  
  private GistIntegrationConfiguration gistConfiguration;
  
  private FocusConfiguration focusConfiguration;
  
  private CategoryConfiguration categoryConfiguration;
  
  public AccessControlConfiguration getAccessControlConfiguration() {
    return this.accessControlConfiguration;
  }
  
  public void setAccessControlConfiguration(AccessControlConfiguration paramAccessControlConfiguration) {
    this.accessControlConfiguration = paramAccessControlConfiguration;
  }
  
  public ExternalProxyConfiguration getExternalProxyConfiguration() {
    return this.externalProxyConfiguration;
  }
  
  public void setExternalProxyConfiguration(ExternalProxyConfiguration paramExternalProxyConfiguration) {
    this.externalProxyConfiguration = paramExternalProxyConfiguration;
  }
  
  public ProxyConfiguration getProxyConfiguration() {
    return this.proxyConfiguration;
  }
  
  public void setProxyConfiguration(ProxyConfiguration paramProxyConfiguration) {
    this.proxyConfiguration = paramProxyConfiguration;
  }
  
  public RecordingConfiguration getRecordingConfiguration() {
    return this.recordingConfiguration;
  }
  
  public void setRecordingConfiguration(RecordingConfiguration paramRecordingConfiguration) {
    this.recordingConfiguration = paramRecordingConfiguration;
  }
  
  public StartupConfiguration getStartupConfiguration() {
    return this.startupConfiguration;
  }
  
  public void setStartupConfiguration(StartupConfiguration paramStartupConfiguration) {
    this.startupConfiguration = paramStartupConfiguration;
  }
  
  public ThrottlingConfiguration getThrottlingConfiguration() {
    return this.throttlingConfiguration;
  }
  
  public void setThrottlingConfiguration(ThrottlingConfiguration paramThrottlingConfiguration) {
    this.throttlingConfiguration = paramThrottlingConfiguration;
  }
  
  public UserInterfaceConfiguration getUserInterfaceConfiguration() {
    return this.userInterfaceConfiguration;
  }
  
  public void setUserInterfaceConfiguration(UserInterfaceConfiguration paramUserInterfaceConfiguration) {
    this.userInterfaceConfiguration = paramUserInterfaceConfiguration;
  }
  
  public RegistrationConfiguration getRegistrationConfiguration() {
    return this.registrationConfiguration;
  }
  
  public void setRegistrationConfiguration(RegistrationConfiguration paramRegistrationConfiguration) {
    this.registrationConfiguration = paramRegistrationConfiguration;
  }
  
  public ToolConfiguration getToolConfiguration() {
    return this.toolConfiguration;
  }
  
  public void setToolConfiguration(ToolConfiguration paramToolConfiguration) {
    this.toolConfiguration = paramToolConfiguration;
  }
  
  public RemoteControlConfiguration getRemoteControlConfiguration() {
    return this.remoteControlConfiguration;
  }
  
  public void setRemoteControlConfiguration(RemoteControlConfiguration paramRemoteControlConfiguration) {
    this.remoteControlConfiguration = paramRemoteControlConfiguration;
  }
  
  public ClientSSLCertificatesConfiguration getClientSSLCertificatesConfiguration() {
    return this.clientSSLCertificatesConfiguration;
  }
  
  public void setClientSSLCertificatesConfiguration(ClientSSLCertificatesConfiguration paramClientSSLCertificatesConfiguration) {
    this.clientSSLCertificatesConfiguration = paramClientSSLCertificatesConfiguration;
  }
  
  public ProtobufConfiguration getProtobufConfiguration() {
    return this.protobufConfiguration;
  }
  
  public void setProtobufConfiguration(ProtobufConfiguration paramProtobufConfiguration) {
    this.protobufConfiguration = paramProtobufConfiguration;
  }
  
  public GistIntegrationConfiguration getGistIntegrationConfiguration() {
    return this.gistConfiguration;
  }
  
  public void setGistIntegrationConfiguration(GistIntegrationConfiguration paramGistIntegrationConfiguration) {
    this.gistConfiguration = paramGistIntegrationConfiguration;
  }
  
  public FocusConfiguration getFocusConfiguration() {
    return this.focusConfiguration;
  }
  
  public void setFocusConfiguration(FocusConfiguration paramFocusConfiguration) {
    this.focusConfiguration = paramFocusConfiguration;
  }
  
  public CategoryConfiguration getCategoryConfiguration() {
    return this.categoryConfiguration;
  }
  
  public void setCategoryConfiguration(CategoryConfiguration paramCategoryConfiguration) {
    this.categoryConfiguration = paramCategoryConfiguration;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigurationImportExport$CharlesExport.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */