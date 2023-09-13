package com.xk72.b;

import java.security.Key;
import java.security.cert.Certificate;

public class Xsnk {
  private final String n;
  
  private final Certificate a;
  
  private final Key b;
  
  private final Certificate[] c;
  
  public Xsnk(String paramString, Certificate paramCertificate, Key paramKey, Certificate[] paramArrayOfCertificate) {
    this.n = paramString;
    this.a = paramCertificate;
    this.b = paramKey;
    this.c = paramArrayOfCertificate;
  }
  
  public String n() {
    return this.n;
  }
  
  public Certificate a() {
    return this.a;
  }
  
  public Key b() {
    return this.b;
  }
  
  public Certificate[] c() {
    return this.c;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\b\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */