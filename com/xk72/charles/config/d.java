package com.xk72.charles.config;

class d extends ConfigurationImportExport$AbstractOption<FocusConfiguration> {
  d(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<FocusConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public FocusConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getFocusConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, FocusConfiguration paramFocusConfiguration) {
    paramConfigurationImportExport$CharlesExport.setFocusConfiguration(paramFocusConfiguration);
  }
  
  public FocusConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getFocusConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, FocusConfiguration paramFocusConfiguration) {
    paramCharlesConfiguration.setFocusConfiguration(paramFocusConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */