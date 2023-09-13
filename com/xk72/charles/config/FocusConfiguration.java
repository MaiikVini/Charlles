package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("focus")
public class FocusConfiguration extends AbstractConfiguration {
  private LocationPatternConfiguration hosts = new LocationPatternConfiguration();
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    this.hosts.n();
  }
  
  public LocationPatternConfiguration getHosts() {
    return this.hosts;
  }
  
  public void setHosts(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.hosts = paramLocationPatternConfiguration;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\FocusConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */