package com.xk72.charles.b;

import com.xk72.charles.CharlesContext;
import com.xk72.proxy.Fields;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.http.HttpFields;
import com.xk72.proxy.io.k;
import com.xk72.proxy.io.l;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

class i implements Runnable {
  private final ServerSocket n = new ServerSocket(0, 10, InetAddress.getByName(null));
  
  public i(ProxyEvent paramProxyEvent) {}
  
  public void run() {
    try {
      Socket socket = this.n.accept();
      try {
        k k = new k(socket.getInputStream());
        try {
          l l = new l(socket.getOutputStream());
          try {
            HttpFields httpFields = new HttpFields();
            httpFields.setResponseStatus(200, "OK");
            httpFields.addField("Content-Type", "text/plain");
            httpFields.addField("Connection", "close");
            l.n((Fields)httpFields, true);
            l.n(CharlesContext.getInstance().getVersionName());
            l.flush();
            l.close();
          } catch (Throwable throwable) {
            try {
              l.close();
            } catch (Throwable throwable1) {
              throwable.addSuppressed(throwable1);
            } 
            throw throwable;
          } 
          k.close();
        } catch (Throwable throwable) {
          try {
            k.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          } 
          throw throwable;
        } 
        if (socket != null)
          socket.close(); 
      } catch (Throwable throwable) {
        if (socket != null)
          try {
            socket.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (IOException iOException) {
      h.n.log(Level.WARNING, iOException.toString(), iOException);
    } finally {
      try {
        this.n.close();
      } catch (IOException iOException) {
        h.n.log(Level.WARNING, iOException.toString(), iOException);
      } 
    } 
  }
  
  public int n() {
    return this.n.getLocalPort();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */