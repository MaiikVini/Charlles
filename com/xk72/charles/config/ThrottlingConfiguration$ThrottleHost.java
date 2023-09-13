package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.net.Location;
import com.xk72.net.Xsnk;
import com.xk72.util.B;
import com.xk72.util.C;

@XStreamAlias("throttleHost")
@B
@C
public class ThrottlingConfiguration$ThrottleHost implements Xsnk {
  private Location location;
  
  private boolean enabled = true;
  
  public ThrottlingConfiguration$ThrottleHost() {
    this(null, true);
  }
  
  public ThrottlingConfiguration$ThrottleHost(Location paramLocation) {
    this(paramLocation, true);
  }
  
  public ThrottlingConfiguration$ThrottleHost(Location paramLocation, boolean paramBoolean) {
    this.location = paramLocation;
    this.enabled = paramBoolean;
  }
  
  public ThrottlingConfiguration$ThrottleHost clone() {
    try {
      return (ThrottlingConfiguration$ThrottleHost)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public static ThrottlingConfiguration$ThrottleHost valueOf(String paramString) {
    return new ThrottlingConfiguration$ThrottleHost(new Location(null, paramString, null, null, null));
  }
  
  public static ThrottlingConfiguration$ThrottleHost valueOf(Location paramLocation) {
    return new ThrottlingConfiguration$ThrottleHost(paramLocation);
  }
  
  @Deprecated
  public String getPattern() {
    return null;
  }
  
  @Deprecated
  public void setPattern(String paramString) {
    if (paramString != null)
      this.location = new Location(paramString); 
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.enabled = paramBoolean;
  }
  
  public Location getLocation() {
    return this.location;
  }
  
  public void setLocation(Location paramLocation) {
    this.location = paramLocation;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ThrottlingConfiguration$ThrottleHost.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */