package com.xk72.charles.b;

import com.xk72.proxy.Fields;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.http.HttpFields;
import com.xk72.proxy.io.k;
import com.xk72.proxy.io.l;
import com.xk72.util.K;
import com.xk72.util.w;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.activation.MimetypesFileTypeMap;

class b implements Runnable {
  protected ProxyEvent n;
  
  private final ServerSocket a;
  
  private final MimetypesFileTypeMap b = new MimetypesFileTypeMap();
  
  public b(ProxyEvent paramProxyEvent) {
    this.n = paramProxyEvent;
    this.a = new ServerSocket(0, 10, InetAddress.getByName(null));
  }
  
  public void run() {
    try {
      Socket socket = this.a.accept();
      try {
        k k = new k(socket.getInputStream());
        try {
          l l = new l(socket.getOutputStream());
          try {
            if (this.n.getPath().equals("/crossdomain.xml")) {
              n("/crossdomain.xml", new HashMap<>(), l);
            } else {
              HttpFields httpFields = new HttpFields();
              httpFields.setResponseStatus(200, "OK");
              httpFields.addField("Content-Type", "text/plain");
              httpFields.addField("Connection", "close");
              l.n((Fields)httpFields, true);
            } 
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
      a.n.log(Level.WARNING, iOException.toString(), iOException);
    } finally {
      try {
        this.a.close();
      } catch (IOException iOException) {
        a.n.log(Level.WARNING, iOException.toString(), iOException);
      } 
    } 
  }
  
  private void n(String paramString, Map<String, String> paramMap, l paraml) {
    HttpFields httpFields = new HttpFields();
    String str = null;
    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("log/static" + paramString);
    try {
      if (inputStream != null) {
        String str1 = this.b.getContentType(paramString);
        httpFields.setResponseStatus(200, "OK");
        httpFields.addField("Content-Type", str1);
        if (str1.startsWith("text/")) {
          str = w.n(inputStream, "UTF-8");
          for (String str2 : paramMap.keySet())
            str = K.n(str, "${" + str2 + "}", paramMap.get(str2)); 
        } 
      } else {
        httpFields.setResponseStatus(404, "Not Found");
      } 
      httpFields.addField("Connection", "close");
      paraml.n((Fields)httpFields, true);
      if (str != null) {
        paraml.n(str);
      } else if (inputStream != null) {
        byte[] arrayOfByte = new byte[8192];
        int i;
        for (i = inputStream.read(arrayOfByte); i != -1; i = inputStream.read(arrayOfByte))
          paraml.write(arrayOfByte, 0, i); 
      } 
      if (inputStream != null)
        inputStream.close(); 
    } catch (Throwable throwable) {
      if (inputStream != null)
        try {
          inputStream.close();
        } catch (Throwable throwable1) {
          throwable.addSuppressed(throwable1);
        }  
      throw throwable;
    } 
  }
  
  public int n() {
    return this.a.getLocalPort();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */