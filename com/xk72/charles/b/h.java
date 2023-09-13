package com.xk72.charles.b;

import com.xk72.proxy.ProxyAdapter;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.ProxyException;
import com.xk72.util.Xsnk;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Logger;

public class h extends ProxyAdapter {
  private static final Logger n = Logger.getLogger("com.xk72.charles.proxy.VersionProxyListener");
  
  public void receivedRequestURL(ProxyEvent paramProxyEvent) {
    if (paramProxyEvent.getHost() != null && paramProxyEvent.getHost().equals("version.charles") && paramProxyEvent.getPath() != null)
      try {
        i i = new i(paramProxyEvent);
        Xsnk.n(i);
        paramProxyEvent.setRemoteAddress(InetAddress.getByName(null));
        paramProxyEvent.setRemotePort(i.n());
      } catch (IOException iOException) {
        throw new ProxyException("Failed to start log server", iOException);
      }  
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\h.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */