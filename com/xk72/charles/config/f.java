package com.xk72.charles.config;

class f extends ConfigurationImportExport$AbstractOption<ProxyConfiguration> {
  f(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<ProxyConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public ProxyConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getProxyConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ProxyConfiguration paramProxyConfiguration) {
    paramConfigurationImportExport$CharlesExport.setProxyConfiguration(paramProxyConfiguration);
  }
  
  public ProxyConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getProxyConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, ProxyConfiguration paramProxyConfiguration) {
    paramCharlesConfiguration.setProxyConfiguration(paramProxyConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\f.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */