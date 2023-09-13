package com.xk72.throttle;

import com.xk72.proxy.io.c;
import com.xk72.proxy.o;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class o extends o {
  private final Xsnk n;
  
  private final l a;
  
  private final l b;
  
  private OutputStream c;
  
  private InputStream d;
  
  private G e;
  
  public o(InetAddress paramInetAddress, int paramInt, Xsnk paramXsnk, l paraml1, l paraml2) {
    super(paramInetAddress, paramInt);
    this.n = paramXsnk;
    this.a = paraml1;
    this.b = paraml2;
  }
  
  public OutputStream getOutputStream() {
    if (this.c == null)
      this.c = new n(new LatencyOutputStream(this.n, super.getOutputStream()), this.b); 
    return this.c;
  }
  
  public InputStream getInputStream() {
    if (this.d == null) {
      this.e = new G(this.n, super.getInputStream());
      this.d = new m((InputStream)new c(this.e), this.a);
    } 
    return this.d;
  }
  
  public boolean b() {
    return (this.d == null || this.e.n());
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\throttle\o.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */