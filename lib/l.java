package com.xk72.lib;

import java.io.InputStream;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

class l implements EntityResolver {
  l(k paramk) {}
  
  public InputSource resolveEntity(String paramString1, String paramString2) {
    if (paramString2 != null) {
      int i = paramString2.lastIndexOf('/');
      if (i >= 0) {
        String str = paramString2.substring(i + 1);
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(str);
        if (inputStream != null)
          return new InputSource(inputStream); 
      } 
    } 
    return null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\l.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */