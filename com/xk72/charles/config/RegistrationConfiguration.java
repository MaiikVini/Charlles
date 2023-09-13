package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Properties;

@XStreamAlias("registration")
public class RegistrationConfiguration extends AbstractLegacySupportConfiguration {
  private String name;
  
  private String key;
  
  public void loadLegacyProperties(Properties paramProperties) {
    setName(paramProperties.getProperty("registeredName"));
    setKey(paramProperties.getProperty("registeredSerial"));
  }
  
  public String getKey() {
    return this.key;
  }
  
  public void setKey(String paramString) {
    this.key = paramString;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\RegistrationConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */