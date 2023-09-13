package com.xk72.util;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

class HttpCache$1 extends LinkedHashMap<URI, s<T>> {
  private static final long serialVersionUID = 1L;
  
  HttpCache$1(int paramInt1, float paramFloat, boolean paramBoolean) {
    super(paramInt1, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<URI, s<T>> paramEntry) {
    return (size() > cacheLimit);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\HttpCache$1.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */