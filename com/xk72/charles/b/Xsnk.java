package com.xk72.charles.b;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.config.LocationPatternConfiguration;
import com.xk72.charles.config.RecordingConfiguration;
import com.xk72.net.a;
import com.xk72.proxy.OrderedProxyListener;
import com.xk72.proxy.ProxyAdapter;
import com.xk72.proxy.ProxyEvent;

public class Xsnk extends ProxyAdapter implements OrderedProxyListener {
  public void receivedRequestURL(ProxyEvent paramProxyEvent) {
    if (n(paramProxyEvent)) {
      paramProxyEvent.setAttribute("com.xk72.charles.ProxyManager.DONT_RECORD", Boolean.TRUE);
    } else {
      paramProxyEvent.removeAttribute("com.xk72.charles.ProxyManager.DONT_RECORD");
    } 
  }
  
  public void receivedRequestAddress(ProxyEvent paramProxyEvent) {
    if (n(paramProxyEvent))
      paramProxyEvent.setAttribute("com.xk72.charles.ProxyManager.DONT_RECORD", Boolean.TRUE); 
  }
  
  private boolean n(ProxyEvent paramProxyEvent) {
    String str1 = paramProxyEvent.getHost();
    String str2 = paramProxyEvent.getPath();
    if (str1 != null && str2 != null && str1.equals("www.charlesproxy.com") && str2.equals("/latest-auto.do"))
      return true; 
    RecordingConfiguration recordingConfiguration = CharlesContext.getInstance().getConfiguration().getRecordingConfiguration();
    LocationPatternConfiguration locationPatternConfiguration1 = recordingConfiguration.getIgnoreHosts();
    if (a.n(paramProxyEvent.toLocation(), locationPatternConfiguration1.getLocationPatterns()))
      return true; 
    LocationPatternConfiguration locationPatternConfiguration2 = recordingConfiguration.getRecordHosts();
    return (locationPatternConfiguration2.b() && !a.n(paramProxyEvent.toLocation(), locationPatternConfiguration2.getLocationPatterns()));
  }
  
  public int getOrder() {
    return 2147483646;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */