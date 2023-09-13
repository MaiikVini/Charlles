package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.HashMap;
import java.util.Map;

@XStreamAlias("tools")
public class ToolConfiguration extends AbstractConfiguration {
  private Map<String, Configuration> configs = new HashMap<>();
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    for (Configuration configuration : this.configs.values()) {
      if (configuration != null)
        configuration.init(paramCharlesConfiguration); 
    } 
  }
  
  public Configuration getConfig(String paramString) {
    return this.configs.get(paramString);
  }
  
  public void setConfig(String paramString, Configuration paramConfiguration) {
    this.configs.put(paramString, paramConfiguration);
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange(paramString, (Object)null, paramConfiguration); 
  }
  
  public void createConfig(String paramString, Configuration paramConfiguration) {
    Configuration configuration = this.configs.put(paramString, paramConfiguration);
    if (configuration != null)
      throw new IllegalStateException("Tool configuration already existed."); 
  }
  
  public Map<String, Configuration> getConfigs() {
    return this.configs;
  }
  
  public void setConfigs(Map<String, Configuration> paramMap) {
    this.configs = paramMap;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ToolConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */