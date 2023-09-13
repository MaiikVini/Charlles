package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Properties;

@XStreamAlias("recording")
public class RecordingConfiguration extends AbstractLegacySupportConfiguration {
  private int limit = 100;
  
  private int maxTransactions;
  
  private int maxWebSocketMessages = -1;
  
  private LocationPatternConfiguration ignoreHosts = new LocationPatternConfiguration();
  
  private LocationPatternConfiguration recordHosts = new LocationPatternConfiguration();
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    this.ignoreHosts.n();
    this.recordHosts.n();
  }
  
  public void loadLegacyProperties(Properties paramProperties) {}
  
  public int getLimit() {
    return this.limit;
  }
  
  public void setLimit(int paramInt) {
    this.limit = paramInt;
  }
  
  public LocationPatternConfiguration getIgnoreHosts() {
    return this.ignoreHosts;
  }
  
  public void setIgnoreHosts(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.ignoreHosts = paramLocationPatternConfiguration;
  }
  
  public LocationPatternConfiguration getRecordHosts() {
    return this.recordHosts;
  }
  
  public void setRecordHosts(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.recordHosts = paramLocationPatternConfiguration;
  }
  
  public int getMaxTransactions() {
    return this.maxTransactions;
  }
  
  public void setMaxTransactions(int paramInt) {
    int i = this.maxTransactions;
    this.maxTransactions = paramInt;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("maxTransactions", i, paramInt); 
  }
  
  public int getMaxWebSocketMessages() {
    return this.maxWebSocketMessages;
  }
  
  public void setMaxWebSocketMessages(int paramInt) {
    this.maxWebSocketMessages = paramInt;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\RecordingConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */