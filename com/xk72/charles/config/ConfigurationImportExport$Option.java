package com.xk72.charles.config;

public interface ConfigurationImportExport$Option<T extends Configuration> {
  String getDisplayName();
  
  T get(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport);
  
  void set(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, T paramT);
  
  boolean trySet(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, Object paramObject);
  
  T get(CharlesConfiguration paramCharlesConfiguration);
  
  void set(CharlesConfiguration paramCharlesConfiguration, T paramT);
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigurationImportExport$Option.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */