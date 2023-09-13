package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.charles.lib.IPRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XStreamAlias("accessControl")
public class AccessControlConfiguration extends AbstractConfiguration {
  private boolean warn = true;
  
  private List<IPRange> ipRanges = new ArrayList<>();
  
  public boolean isWarn() {
    return this.warn;
  }
  
  public void setWarn(boolean paramBoolean) {
    this.warn = paramBoolean;
  }
  
  private void tidy() {
    Iterator<IPRange> iterator = this.ipRanges.iterator();
    while (iterator.hasNext()) {
      IPRange iPRange = iterator.next();
      if (iPRange == null)
        iterator.remove(); 
    } 
  }
  
  public List<IPRange> getIpRanges() {
    tidy();
    return this.ipRanges;
  }
  
  public void setIpRanges(List<IPRange> paramList) {
    this.ipRanges = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\AccessControlConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */