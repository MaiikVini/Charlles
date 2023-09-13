package com.xk72.charles.config;

class g extends ConfigurationImportExport$AbstractOption<AccessControlConfiguration> {
  g(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<AccessControlConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public AccessControlConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getAccessControlConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, AccessControlConfiguration paramAccessControlConfiguration) {
    paramConfigurationImportExport$CharlesExport.setAccessControlConfiguration(paramAccessControlConfiguration);
  }
  
  public AccessControlConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getAccessControlConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, AccessControlConfiguration paramAccessControlConfiguration) {
    paramCharlesConfiguration.setAccessControlConfiguration(paramAccessControlConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\g.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */