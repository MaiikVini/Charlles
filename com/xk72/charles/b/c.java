package com.xk72.charles.b;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.config.RemoteControlConfiguration;
import com.xk72.charles.lib.AuthorizationUtils;
import com.xk72.charles.model.Session;
import com.xk72.proxy.Fields;
import com.xk72.proxy.ProxyAdapter;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.ProxyException;
import com.xk72.proxy.http.HttpFields;
import com.xk72.proxy.io.l;
import com.xk72.util.Xsnk;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class c extends ProxyAdapter {
  private static final Logger n = Logger.getLogger("com.xk72.charles.proxy.RemoteControlProxyListener");
  
  public void receivedRequestURL(ProxyEvent paramProxyEvent) {
    if (paramProxyEvent.getHost() != null && paramProxyEvent.getHost().equals("control.charles") && paramProxyEvent.getPath() != null)
      try {
        d d = new d(this, paramProxyEvent);
        Xsnk.n(d);
        paramProxyEvent.setRemoteAddress(InetAddress.getByName(null));
        paramProxyEvent.setRemotePort(d.n());
      } catch (IOException iOException) {
        throw new ProxyException("Failed to start Web Interface server", iOException);
      }  
  }
  
  private static boolean n(Fields paramFields, RemoteControlConfiguration paramRemoteControlConfiguration) {
    try {
      AuthorizationUtils.Authorization authorization = AuthorizationUtils.n(paramFields);
      if (authorization != null && authorization instanceof AuthorizationUtils.BasicAuthorization) {
        AuthorizationUtils.BasicAuthorization basicAuthorization = (AuthorizationUtils.BasicAuthorization)authorization;
        if (n(basicAuthorization, paramRemoteControlConfiguration))
          return true; 
      } 
    } catch (ParseException parseException) {
      n.log(Level.WARNING, parseException.toString(), parseException);
    } 
    return false;
  }
  
  private static boolean n(AuthorizationUtils.BasicAuthorization paramBasicAuthorization, RemoteControlConfiguration paramRemoteControlConfiguration) {
    List list = paramRemoteControlConfiguration.getUsers();
    if (list != null) {
      RemoteControlConfiguration.RemoteControlUser remoteControlUser = new RemoteControlConfiguration.RemoteControlUser(paramBasicAuthorization.getUserId(), paramBasicAuthorization.getPassword());
      if (remoteControlUser.getUsername() != null && remoteControlUser.getPassword() != null)
        for (RemoteControlConfiguration.RemoteControlUser remoteControlUser1 : list) {
          if (remoteControlUser.equals(remoteControlUser1))
            return true; 
        }  
    } 
    return false;
  }
  
  private static void n(l paraml) {
    HttpFields httpFields = new HttpFields();
    httpFields.setResponseStatus(401, "Authorization Required");
    httpFields.addField("WWW-Authenticate", "Basic realm=\"Charles Web Interface\"");
    paraml.n((Fields)httpFields, false);
  }
  
  private static void n(String paramString, l paraml) {
    HttpFields httpFields = new HttpFields();
    httpFields.setResponseStatus(302, "Moved Temporarily");
    httpFields.addField("Location", paramString);
    paraml.n((Fields)httpFields, false);
  }
  
  protected void n() {
    CharlesContext.getInstance().getProxyManager().n(new Session());
  }
  
  protected Session a() {
    return CharlesContext.getInstance().getProxyManager().q();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */