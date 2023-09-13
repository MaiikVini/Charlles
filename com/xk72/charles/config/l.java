package com.xk72.charles.config;

class l extends ConfigurationImportExport$AbstractOption<UserInterfaceConfiguration> {
  l(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<UserInterfaceConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public UserInterfaceConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getUserInterfaceConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, UserInterfaceConfiguration paramUserInterfaceConfiguration) {
    paramConfigurationImportExport$CharlesExport.setUserInterfaceConfiguration(paramUserInterfaceConfiguration);
  }
  
  public UserInterfaceConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getUserInterfaceConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, UserInterfaceConfiguration paramUserInterfaceConfiguration) {
    paramCharlesConfiguration.setUserInterfaceConfiguration(paramUserInterfaceConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\l.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */