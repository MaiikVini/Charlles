package com.xk72.charles.b;

import com.xk72.proxy.ProxyAdapter;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.ProxyException;
import com.xk72.util.Xsnk;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Logger;

public class f extends ProxyAdapter {
  private static final Logger n = Logger.getLogger("com.xk72.charles.proxy.SSLCACertificateProxyListener");
  
  public void receivedRequestURL(ProxyEvent paramProxyEvent) {
    if (n(paramProxyEvent))
      try {
        g g = new g(paramProxyEvent);
        Xsnk.n(g);
        paramProxyEvent.setRemoteAddress(InetAddress.getByName(null));
        paramProxyEvent.setRemotePort(g.n());
      } catch (IOException iOException) {
        throw new ProxyException("Failed to start log server", iOException);
      }  
  }
  
  private boolean n(ProxyEvent paramProxyEvent) {
    return (paramProxyEvent.getHost() == null) ? false : ("ssl.charles".equals(paramProxyEvent.getHost()) ? true : (("http".equals(paramProxyEvent.getProtocol()) && ("www.charlesproxy.com".equals(paramProxyEvent.getHost()) || "charlesproxy.com".equals(paramProxyEvent.getHost())) && ("/getssl".equals(paramProxyEvent.getPath()) || "/getssl/".equals(paramProxyEvent.getPath())))));
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\f.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */