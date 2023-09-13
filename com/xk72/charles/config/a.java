package com.xk72.charles.config;

class a extends ConfigurationImportExport$AbstractOption<ProtobufConfiguration> {
  a(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<ProtobufConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public ProtobufConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getProtobufConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ProtobufConfiguration paramProtobufConfiguration) {
    paramConfigurationImportExport$CharlesExport.setProtobufConfiguration(paramProtobufConfiguration);
  }
  
  public ProtobufConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getProtobufConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, ProtobufConfiguration paramProtobufConfiguration) {
    paramCharlesConfiguration.setProtobufConfiguration(paramProtobufConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */