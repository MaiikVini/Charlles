package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.B;
import com.xk72.util.C;
import com.xk72.util.f;

@XStreamAlias("remoteControlUser")
@B
@C
public class RemoteControlConfiguration$RemoteControlUser implements f {
  private String username;
  
  private String password;
  
  public RemoteControlConfiguration$RemoteControlUser() {}
  
  public RemoteControlConfiguration$RemoteControlUser(String paramString1, String paramString2) {
    this.username = paramString1;
    this.password = paramString2;
  }
  
  public RemoteControlConfiguration$RemoteControlUser clone() {
    try {
      return (RemoteControlConfiguration$RemoteControlUser)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String paramString) {
    this.password = paramString;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String paramString) {
    this.username = paramString;
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    null = 31 * null + ((this.password == null) ? 0 : this.password.hashCode());
    return 31 * null + ((this.username == null) ? 0 : this.username.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    RemoteControlConfiguration$RemoteControlUser remoteControlConfiguration$RemoteControlUser = (RemoteControlConfiguration$RemoteControlUser)paramObject;
    if (this.password == null) {
      if (remoteControlConfiguration$RemoteControlUser.password != null)
        return false; 
    } else if (!this.password.equals(remoteControlConfiguration$RemoteControlUser.password)) {
      return false;
    } 
    if (this.username == null) {
      if (remoteControlConfiguration$RemoteControlUser.username != null)
        return false; 
    } else if (!this.username.equals(remoteControlConfiguration$RemoteControlUser.username)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\RemoteControlConfiguration$RemoteControlUser.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */