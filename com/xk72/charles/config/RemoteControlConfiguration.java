package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("remoteControl")
public class RemoteControlConfiguration extends AbstractConfiguration {
  private boolean enabled;
  
  private boolean allowAnonymous;
  
  private List<RemoteControlConfiguration$RemoteControlUser> users = new ArrayList<>();
  
  public boolean isAllowAnonymous() {
    return this.allowAnonymous;
  }
  
  public void setAllowAnonymous(boolean paramBoolean) {
    this.allowAnonymous = paramBoolean;
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    boolean bool = this.enabled;
    this.enabled = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("enabled", bool, paramBoolean); 
  }
  
  public List<RemoteControlConfiguration$RemoteControlUser> getUsers() {
    return this.users;
  }
  
  public void setUsers(List<RemoteControlConfiguration$RemoteControlUser> paramList) {
    this.users = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\RemoteControlConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */