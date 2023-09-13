package com.xk72.charles.config;

class k extends ConfigurationImportExport$AbstractOption<GistIntegrationConfiguration> {
  k(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<GistIntegrationConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public GistIntegrationConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getGistIntegrationConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, GistIntegrationConfiguration paramGistIntegrationConfiguration) {
    paramConfigurationImportExport$CharlesExport.setGistIntegrationConfiguration(paramGistIntegrationConfiguration);
  }
  
  public GistIntegrationConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getGistIntegrationConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, GistIntegrationConfiguration paramGistIntegrationConfiguration) {
    paramCharlesConfiguration.setGistIntegrationConfiguration(paramGistIntegrationConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\k.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */