package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("external-dns")
public class ExternalDNSResolverConfiguration extends AbstractConfiguration {
  private boolean enabled;
  
  private boolean selectedLocations;
  
  private String externalResolverAddress;
  
  private LocationPatternConfiguration locations = new LocationPatternConfiguration();
  
  private Long ttl;
  
  private Long negativeTtl;
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    boolean bool = this.enabled;
    this.enabled = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("enabled", bool, paramBoolean); 
  }
  
  public boolean isSelectedLocations() {
    return this.selectedLocations;
  }
  
  public void setSelectedLocations(boolean paramBoolean) {
    this.selectedLocations = paramBoolean;
  }
  
  public String getExternalResolverAddress() {
    return this.externalResolverAddress;
  }
  
  public void setExternalResolverAddress(String paramString) {
    this.externalResolverAddress = paramString;
  }
  
  public LocationPatternConfiguration getLocations() {
    return this.locations;
  }
  
  public void setLocations(LocationPatternConfiguration paramLocationPatternConfiguration) {
    this.locations = paramLocationPatternConfiguration;
  }
  
  public Long getTtl() {
    return this.ttl;
  }
  
  public void setTtl(Long paramLong) {
    this.ttl = paramLong;
  }
  
  public Long getNegativeTtl() {
    return this.negativeTtl;
  }
  
  public void setNegativeTtl(Long paramLong) {
    this.negativeTtl = paramLong;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ExternalDNSResolverConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */