package com.xk72.util;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;

public class u implements q {
  private static final int n = 10000;
  
  private static final int a = 10000;
  
  public t n(URI paramURI, long paramLong, String paramString) {
    char c;
    URLConnection uRLConnection = paramURI.toURL().openConnection();
    uRLConnection.setConnectTimeout(10000);
    uRLConnection.setReadTimeout(10000);
    uRLConnection.setDoInput(true);
    uRLConnection.setDoOutput(false);
    if (paramLong > 0L)
      uRLConnection.setIfModifiedSince(paramLong); 
    if (paramString != null)
      uRLConnection.setRequestProperty("If-None-Match", paramString); 
    uRLConnection.connect();
    if (uRLConnection instanceof HttpURLConnection) {
      c = ((HttpURLConnection)uRLConnection).getResponseCode();
    } else if (paramLong > 0L && paramLong == uRLConnection.getLastModified()) {
      c = 'İ';
    } else {
      c = 'È';
    } 
    return new v(uRLConnection, c);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\uti\\u.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */