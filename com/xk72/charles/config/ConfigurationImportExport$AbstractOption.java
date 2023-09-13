package com.xk72.charles.config;

abstract class ConfigurationImportExport$AbstractOption<T extends Configuration> implements ConfigurationImportExport$Option<T> {
  private final String n;
  
  protected final Class<T> a;
  
  public ConfigurationImportExport$AbstractOption(String paramString, Class<T> paramClass) {
    this.n = paramString;
    this.a = paramClass;
  }
  
  public boolean trySet(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, Object paramObject) {
    if (this.a.isInstance(paramObject)) {
      set(paramConfigurationImportExport$CharlesExport, (T)paramObject);
      return true;
    } 
    return false;
  }
  
  public String getDisplayName() {
    return this.n;
  }
  
  public String toString() {
    return this.n;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigurationImportExport$AbstractOption.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */