package com.xk72.charles.config;

import java.util.Properties;

public abstract class AbstractLegacySupportConfiguration extends AbstractConfiguration {
  public abstract void loadLegacyProperties(Properties paramProperties);
  
  protected int getIntProperty(Properties paramProperties, String paramString, int paramInt) {
    if (paramProperties.getProperty(paramString) != null)
      try {
        return Integer.parseInt(paramProperties.getProperty(paramString));
      } catch (Exception exception) {
        return paramInt;
      }  
    return paramInt;
  }
  
  protected double getDoubleProperty(Properties paramProperties, String paramString, double paramDouble) {
    if (paramProperties.getProperty(paramString) != null)
      try {
        return Double.parseDouble(paramProperties.getProperty(paramString));
      } catch (Exception exception) {
        return paramDouble;
      }  
    return paramDouble;
  }
  
  protected boolean getBooleanProperty(Properties paramProperties, String paramString, boolean paramBoolean) {
    return (paramProperties.getProperty(paramString) != null) ? paramProperties.getProperty(paramString).equals("1") : paramBoolean;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\AbstractLegacySupportConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */