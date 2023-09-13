package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("dns")
public class DNSConfiguration extends AbstractConfiguration {
  private Boolean preferIPv6addresses;
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {
    super.init(paramCharlesConfiguration);
    if (this.preferIPv6addresses == null)
      this.preferIPv6addresses = Boolean.valueOf(paramCharlesConfiguration.getProxyConfiguration().isPreferIPv6addresses()); 
  }
  
  public boolean isPreferIPv6addresses() {
    return (this.preferIPv6addresses != null) ? this.preferIPv6addresses.booleanValue() : false;
  }
  
  public void setPreferIPv6addresses(boolean paramBoolean) {
    this.preferIPv6addresses = Boolean.valueOf(paramBoolean);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\DNSConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */