package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

@XStreamAlias("listAdapter")
public class ConfigLegacyListAdapter$ThrottleHostConfigationLegacyAdapter extends ConfigLegacyListAdapter<ThrottlingConfiguration$ThrottleHost> {
  public Class<ThrottlingConfiguration$ThrottleHost> getBeanClass() {
    return ThrottlingConfiguration$ThrottleHost.class;
  }
  
  public List<ThrottlingConfiguration$ThrottleHost> getLocationPatterns() {
    return getList();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigLegacyListAdapter$ThrottleHostConfigationLegacyAdapter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */