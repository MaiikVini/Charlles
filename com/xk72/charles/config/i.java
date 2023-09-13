package com.xk72.charles.config;

class i extends ConfigurationImportExport$AbstractOption<RemoteControlConfiguration> {
  i(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<RemoteControlConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public RemoteControlConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getRemoteControlConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, RemoteControlConfiguration paramRemoteControlConfiguration) {
    paramConfigurationImportExport$CharlesExport.setRemoteControlConfiguration(paramRemoteControlConfiguration);
  }
  
  public RemoteControlConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getRemoteControlConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, RemoteControlConfiguration paramRemoteControlConfiguration) {
    paramCharlesConfiguration.setRemoteControlConfiguration(paramRemoteControlConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */