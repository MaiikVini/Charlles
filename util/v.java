package com.xk72.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;

class v implements t {
  private final URLConnection n;
  
  private final int a;
  
  private v(URLConnection paramURLConnection, int paramInt) {
    this.n = paramURLConnection;
    this.a = paramInt;
  }
  
  public void n() {
    if (this.n instanceof HttpURLConnection)
      ((HttpURLConnection)this.n).disconnect(); 
  }
  
  public int a() {
    return this.a;
  }
  
  public InputStream b() {
    return this.n.getInputStream();
  }
  
  public long c() {
    return this.n.getDate();
  }
  
  public long d() {
    return this.n.getExpiration();
  }
  
  public long e() {
    return this.n.getLastModified();
  }
  
  public String n(String paramString) {
    return this.n.getHeaderField(paramString);
  }
  
  public long n(String paramString, int paramInt) {
    return this.n.getHeaderFieldInt(paramString, paramInt);
  }
  
  public List<String> a(String paramString) {
    return this.n.getHeaderFields().get(paramString);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\v.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */