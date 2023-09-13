package com.xk72.charles.b;

import com.xk72.charles.lib.q;
import com.xk72.proxy.ProxyAdapter;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.ProxyException;
import com.xk72.util.Xsnk;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a extends ProxyAdapter {
  private static final Logger n = Logger.getLogger("com.xk72.charles.proxy.LoggingProxyListener");
  
  public void receivedRequestURL(ProxyEvent paramProxyEvent) {
    if (paramProxyEvent.getHost() != null && paramProxyEvent.getHost().equals("log.charles") && paramProxyEvent.getPath() != null) {
      String str2;
      String str1 = paramProxyEvent.getPath();
      if (str1.length() > 0)
        str1 = str1.substring(1); 
      if (paramProxyEvent.getQuery() != null) {
        q q = new q(paramProxyEvent.getQuery(), "UTF-8");
        str2 = q.a("msg");
      } else {
        str2 = "";
      } 
      if (!str1.equals("crossdomain.xml") && n.isLoggable(Level.INFO))
        n.info("LOG\t" + str1 + "\t" + str2); 
      try {
        b b = new b(paramProxyEvent);
        Xsnk.n(b);
        paramProxyEvent.setRemoteAddress(InetAddress.getByName(null));
        paramProxyEvent.setRemotePort(b.n());
      } catch (IOException iOException) {
        throw new ProxyException("Failed to start log server", iOException);
      } 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */