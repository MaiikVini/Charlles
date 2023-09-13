package com.xk72.charles.config;

import com.xk72.charles.lib.DefaultLocationMatch;
import com.xk72.net.Xsnk;
import com.xk72.util.B;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@B
public class LocationPatternConfiguration {
  private static final Logger n = Logger.getLogger("com.xk72.charles.config.LocationPatternConfiguration");
  
  @B
  private List<Xsnk> locationPatterns = new ArrayList<>();
  
  public LocationPatternConfiguration() {}
  
  public void n() {
    Iterator<Xsnk> iterator = this.locationPatterns.iterator();
    while (iterator.hasNext()) {
      Xsnk xsnk = iterator.next();
      if (xsnk == null || xsnk.getLocation() == null)
        iterator.remove(); 
    } 
  }
  
  public LocationPatternConfiguration(List<Xsnk> paramList) {}
  
  @B
  public List<Xsnk> getLocationPatterns() {
    return this.locationPatterns;
  }
  
  @B
  public void setLocationPatterns(List<Xsnk> paramList) {
    this.locationPatterns = paramList;
  }
  
  @B
  public boolean add(Object paramObject) {
    if (paramObject instanceof String) {
      if (((String)paramObject).length() > 0) {
        this.locationPatterns.add(new DefaultLocationMatch((String)paramObject));
        return true;
      } 
      if (n.isLoggable(Level.INFO))
        n.info("Correcting erroneous empty string LocationPattern"); 
      return false;
    } 
    if (paramObject == null) {
      if (n.isLoggable(Level.INFO))
        n.info("Correcting erroneous null LocationPattern"); 
      return false;
    } 
    n((Xsnk)paramObject);
    return true;
  }
  
  public LocationPatternConfiguration n(Xsnk paramXsnk) {
    this.locationPatterns.add(paramXsnk);
    return this;
  }
  
  public boolean a() {
    return this.locationPatterns.isEmpty();
  }
  
  public boolean b() {
    for (Xsnk xsnk : this.locationPatterns) {
      if (xsnk.isEnabled())
        return true; 
    } 
    return false;
  }
  
  public boolean a(Xsnk paramXsnk) {
    return this.locationPatterns.contains(paramXsnk);
  }
  
  public LocationPatternConfiguration c() {
    LocationPatternConfiguration locationPatternConfiguration = new LocationPatternConfiguration();
    for (Xsnk xsnk : this.locationPatterns)
      locationPatternConfiguration.locationPatterns.add(xsnk.clone()); 
    return locationPatternConfiguration;
  }
  
  public boolean b(Xsnk paramXsnk) {
    return this.locationPatterns.remove(paramXsnk);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\LocationPatternConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */