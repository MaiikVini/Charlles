package com.xk72.charles.config;

class b extends ConfigurationImportExport$AbstractOption<StartupConfiguration> {
  b(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<StartupConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public StartupConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getStartupConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, StartupConfiguration paramStartupConfiguration) {
    paramConfigurationImportExport$CharlesExport.setStartupConfiguration(paramStartupConfiguration);
  }
  
  public StartupConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getStartupConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, StartupConfiguration paramStartupConfiguration) {
    paramCharlesConfiguration.setStartupConfiguration(paramStartupConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */