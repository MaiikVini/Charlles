package com.xk72.charles.config;

class h extends ConfigurationImportExport$AbstractOption<ExternalProxyConfiguration> {
  h(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<ExternalProxyConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public ExternalProxyConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getExternalProxyConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ExternalProxyConfiguration paramExternalProxyConfiguration) {
    paramConfigurationImportExport$CharlesExport.setExternalProxyConfiguration(paramExternalProxyConfiguration);
  }
  
  public ExternalProxyConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getExternalProxyConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, ExternalProxyConfiguration paramExternalProxyConfiguration) {
    paramCharlesConfiguration.setExternalProxyConfiguration(paramExternalProxyConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */