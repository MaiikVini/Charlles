package com.xk72.net;

import java.util.Comparator;

public class G implements Comparator<Xsnk> {
  private int n(Location paramLocation1, Location paramLocation2) {
    return (paramLocation1 == null && paramLocation2 == null) ? 0 : ((paramLocation1 == null) ? -1 : ((paramLocation2 == null) ? 1 : 0));
  }
  
  private int n(String paramString1, String paramString2) {
    return (paramString1 == null && paramString2 == null) ? 0 : ((paramString1 == null) ? -1 : ((paramString2 == null) ? 1 : paramString1.compareTo(paramString2)));
  }
  
  public int n(Xsnk paramXsnk1, Xsnk paramXsnk2) {
    int i = n(paramXsnk1.getLocation(), paramXsnk2.getLocation());
    if (i != 0)
      return i; 
    int j = n(paramXsnk1.getLocation().getHostAndPort(), paramXsnk2.getLocation().getHostAndPort());
    if (j != 0)
      return j; 
    int k = n(paramXsnk1.getLocation().getProtocol(), paramXsnk2.getLocation().getProtocol());
    if (k != 0)
      return k; 
    int m = n(paramXsnk1.getLocation().getPath(), paramXsnk2.getLocation().getPath());
    if (m != 0)
      return m; 
    int n = n(paramXsnk1.getLocation().getQuery(), paramXsnk2.getLocation().getQuery());
    return (n != 0) ? n : 0;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\net\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */