package com.xk72.d;

import com.xk72.util.K;
import java.io.PrintWriter;

public class c {
  private static final String n = "\"";
  
  private static final String a = "\"\"";
  
  private static final char b = '\r';
  
  private static final char c = '\n';
  
  private static final String d = "\r\n";
  
  private String e;
  
  private String f = "\"";
  
  private String g = "\"\"";
  
  private String h = "\r\n";
  
  private final PrintWriter i;
  
  private boolean j;
  
  public c(PrintWriter paramPrintWriter, String paramString) {
    this.i = paramPrintWriter;
    this.e = paramString;
    this.j = false;
  }
  
  @Deprecated
  public c a(String paramString) {
    return a(paramString);
  }
  
  public c a(Object paramObject) {
    if (this.j) {
      this.i.print(this.e);
    } else {
      this.j = true;
    } 
    if (paramObject != null)
      this.i.print(b(paramObject.toString())); 
    return this;
  }
  
  public c e() {
    return a((Object)null);
  }
  
  @Deprecated
  public c d() {
    return c();
  }
  
  public c c() {
    this.i.print(this.h);
    this.j = false;
    return this;
  }
  
  public void f() {
    this.i.close();
  }
  
  protected String b(String paramString) {
    paramString = K.n(paramString, this.h);
    return c(paramString) ? (this.f + K.n(paramString, this.f, this.g) + this.f) : paramString;
  }
  
  protected boolean c(String paramString) {
    return (paramString.indexOf(this.f) != -1 || paramString.indexOf(this.e) != -1 || paramString.indexOf('\r') != -1 || paramString.indexOf('\n') != -1);
  }
  
  public String g() {
    return this.e;
  }
  
  public void d(String paramString) {
    this.e = paramString;
  }
  
  public String h() {
    return this.f;
  }
  
  public void e(String paramString) {
    this.f = paramString;
  }
  
  public String i() {
    return this.g;
  }
  
  public void f(String paramString) {
    this.g = paramString;
  }
  
  public String j() {
    return this.h;
  }
  
  public void g(String paramString) {
    this.h = paramString;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\d\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */