package com.xk72.charles.config;

class e extends ConfigurationImportExport$AbstractOption<ThrottlingConfiguration> {
  e(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<ThrottlingConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public ThrottlingConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getThrottlingConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ThrottlingConfiguration paramThrottlingConfiguration) {
    paramConfigurationImportExport$CharlesExport.setThrottlingConfiguration(paramThrottlingConfiguration);
  }
  
  public ThrottlingConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getThrottlingConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, ThrottlingConfiguration paramThrottlingConfiguration) {
    paramCharlesConfiguration.setThrottlingConfiguration(paramThrottlingConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\e.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */