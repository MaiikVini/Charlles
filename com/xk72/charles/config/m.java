package com.xk72.charles.config;

class m<T extends Configuration> extends ConfigurationImportExport$AbstractOption<T> {
  public m(String paramString, Class<T> paramClass) {
    super(paramString, paramClass);
  }
  
  public boolean trySet(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, Object paramObject) {
    if (this.a.equals(paramObject.getClass())) {
      set(paramConfigurationImportExport$CharlesExport, (T)paramObject);
      return true;
    } 
    return false;
  }
  
  public T get(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    ToolConfiguration toolConfiguration = paramConfigurationImportExport$CharlesExport.getToolConfiguration();
    return (T)((toolConfiguration == null) ? null : toolConfiguration.getConfig(getDisplayName()));
  }
  
  public void set(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, T paramT) {
    ToolConfiguration toolConfiguration = paramConfigurationImportExport$CharlesExport.getToolConfiguration();
    if (toolConfiguration == null) {
      toolConfiguration = new ToolConfiguration();
      paramConfigurationImportExport$CharlesExport.setToolConfiguration(toolConfiguration);
    } 
    toolConfiguration.setConfig(getDisplayName(), (Configuration)paramT);
  }
  
  public T get(CharlesConfiguration paramCharlesConfiguration) {
    return (T)paramCharlesConfiguration.getToolConfiguration().getConfig(getDisplayName());
  }
  
  public void set(CharlesConfiguration paramCharlesConfiguration, T paramT) {
    paramCharlesConfiguration.getToolConfiguration().setConfig(getDisplayName(), (Configuration)paramT);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\m.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */