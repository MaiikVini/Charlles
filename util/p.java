package com.xk72.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class p<T, E extends Exception> {
  private static final int n = 100;
  
  private final Map<URI, s<T>> a;
  
  private final q b;
  
  private final r<T, E> c;
  
  private int d = 0;
  
  private int e = 0;
  
  private int f = 0;
  
  public p(q paramq, r<T, E> paramr) {
    this(100, paramq, paramr);
  }
  
  public p(int paramInt, q paramq, r<T, E> paramr) {
    this.a = new HttpCache$1(this, paramInt * 4 / 3, 0.75F, true, paramInt);
    this.b = paramq;
    this.c = paramr;
  }
  
  public synchronized void n() {
    this.a.clear();
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public synchronized int a() {
    return this.d;
  }
  
  public synchronized int b() {
    return this.e;
  }
  
  public synchronized int c() {
    return this.f;
  }
  
  public synchronized int d() {
    return this.a.size();
  }
  
  public synchronized List<URI> e() {
    return new ArrayList<>(this.a.keySet());
  }
  
  public synchronized T n(URI paramURI, boolean paramBoolean, long paramLong) throws IOException, E {
    s<T> s = this.a.get(paramURI);
    try {
      s<T> s1 = n(paramURI, paramBoolean ? s : null, paramLong);
      if (s1 != s)
        if (paramBoolean && n(s1)) {
          this.a.put(paramURI, s1);
        } else if (s != null) {
          this.a.remove(paramURI);
        }  
      return s1.n();
    } catch (RuntimeException runtimeException) {
      if (s != null)
        this.a.remove(paramURI); 
      throw runtimeException;
    } catch (IOException iOException) {
      if (s != null)
        this.a.remove(paramURI); 
      throw iOException;
    } catch (Exception exception1) {
      if (s != null)
        this.a.remove(paramURI); 
      Exception exception2 = exception1;
      throw exception2;
    } 
  }
  
  private boolean n(s<T> params) {
    return (params.b() > 0L || params.a() != null || params.c() > 0L);
  }
  
  private s<T> n(t paramt, T paramT, long paramLong1, long paramLong2, long paramLong3) {
    long l3;
    long l4;
    long l1 = paramt.e();
    String str1 = paramt.n("ETag");
    String str2 = paramt.n("Pragma");
    if ("no-cache".equals(str2))
      return new s<>(paramT, null, 0L, 0L); 
    List<String> list = n(paramt);
    if (list != null && list.contains("no-cache"))
      return new s<>(paramT, null, 0L, 0L); 
    long l2 = paramt.c();
    if (list != null && list.contains("must-revalidate")) {
      l3 = 0L;
    } else {
      l4 = n(list);
      if (l4 == 0L) {
        l3 = 0L;
      } else if (l4 > 0L) {
        l3 = l2 + l4;
      } else if (paramt.d() > 0L) {
        l3 = paramt.d();
      } else if (paramLong3 <= 0L || l1 > 0L || str1 != null) {
        l3 = 0L;
      } else {
        l3 = ((l2 == 0L) ? paramLong1 : l2) + paramLong3;
      } 
    } 
    if (l3 > 0L) {
      long l5 = paramt.n("Age", 0) * 1000L;
      long l6 = Math.max(paramLong2 - l2, l5);
      l4 = l3 - l2 - l6 + paramLong1;
    } else {
      l4 = 0L;
    } 
    return new s<>(paramT, str1, l1, l4);
  }
  
  private List<String> n(t paramt) {
    List<String> list = paramt.a("Cache-Control");
    if (list == null || list.isEmpty())
      return list; 
    if (list.size() == 1 && ((String)list.get(0)).indexOf(',') < 0)
      return list; 
    ArrayList<String> arrayList = new ArrayList();
    for (String str : list) {
      for (String str1 : str.split(","))
        arrayList.add(str1.trim()); 
    } 
    return arrayList;
  }
  
  private long n(List<String> paramList) {
    if (paramList != null)
      for (String str : paramList) {
        if (str.startsWith("max-age")) {
          String str1 = str.substring(str.indexOf('=') + 1);
          try {
            return Long.parseLong(str1) * 1000L;
          } catch (NumberFormatException numberFormatException) {
            return -1L;
          } 
        } 
      }  
    return -1L;
  }
  
  private s<T> n(URI paramURI, s<T> params, long paramLong) throws IOException, E {
    long l2;
    String str;
    long l1 = System.currentTimeMillis();
    if (params != null && l1 < params.c()) {
      this.d++;
      return params;
    } 
    if (params != null) {
      l2 = params.b();
      str = params.a();
    } else {
      l2 = 0L;
      str = null;
    } 
    t t = this.b.n(paramURI, l2, str);
    try {
      int i = t.a();
      if (i == 304 && params != null) {
        this.f++;
        return params;
      } 
      if (i == 200) {
        InputStream inputStream = t.b();
        try {
          this.e++;
          s<T> s1 = n(t, this.c.a(inputStream), l1, System.currentTimeMillis(), paramLong);
          if (inputStream != null)
            inputStream.close(); 
          return s1;
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
      throw new IOException("Unexpected response code '" + i + "' received from: " + paramURI.toString());
    } finally {
      t.n();
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\p.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */