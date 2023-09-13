package com.xk72.charles.config;

class c extends ConfigurationImportExport$AbstractOption<CategoryConfiguration> {
  c(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<CategoryConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public CategoryConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getCategoryConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, CategoryConfiguration paramCategoryConfiguration) {
    paramConfigurationImportExport$CharlesExport.setCategoryConfiguration(paramCategoryConfiguration);
  }
  
  public CategoryConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getCategoryConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, CategoryConfiguration paramCategoryConfiguration) {
    paramCharlesConfiguration.setCategoryConfiguration(paramCategoryConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */