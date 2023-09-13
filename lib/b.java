package com.xk72.lib;

import com.xk72.util.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class b extends ResourceBundle {
  private final ResourceBundle n;
  
  private final Map<String, String> a = new HashMap<>();
  
  public b(ResourceBundle paramResourceBundle) {
    this.n = paramResourceBundle;
  }
  
  public Enumeration<String> getKeys() {
    return this.n.getKeys();
  }
  
  public Locale getLocale() {
    return this.n.getLocale();
  }
  
  protected Object handleGetObject(String paramString) {
    if (this.a.containsKey(paramString))
      return this.a.get(paramString); 
    Object object = this.n.getObject(paramString);
    if (object instanceof String) {
      String str = (String)object;
      if (str.startsWith("@")) {
        String str2;
        String str1 = str.substring(1);
        int i = str1.lastIndexOf('.');
        if (i != -1) {
          str2 = str1.substring(i);
          str1 = str1.substring(0, i);
        } else {
          str2 = "";
        } 
        try {
          InputStream inputStream = n(str1, getLocale(), str2);
          try {
            if (inputStream != null) {
              String str3 = w.n(inputStream, "UTF-8");
              str3 = n(str3);
              this.a.put(paramString, str3);
              String str4 = str3;
              if (inputStream != null)
                inputStream.close(); 
              return str4;
            } 
            throw new MissingResourceException("Failed to load referenced file: " + str1 + str2, getClass().getName(), paramString);
          } catch (Throwable throwable) {
            if (inputStream != null)
              try {
                inputStream.close();
              } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
              }  
            throw throwable;
          } 
        } catch (IOException iOException) {
          throw new MissingResourceException("IOException loading referenced file: " + str1 + str2 + ": " + iOException.getMessage(), getClass().getName(), paramString);
        } 
      } 
    } 
    return object;
  }
  
  private String n(String paramString) {
    int i = paramString.indexOf("@@");
    while (i != -1) {
      int j = paramString.indexOf("@@", i + 2);
      if (j != -1) {
        String str = paramString.substring(i + 2, j);
        paramString = paramString.substring(0, i) + paramString.substring(0, i) + getString(str);
        i = paramString.indexOf("@@", i);
      } 
    } 
    return paramString;
  }
  
  private InputStream n(String paramString1, Locale paramLocale, String paramString2) {
    InputStream inputStream = getClass().getResourceAsStream(paramString1 + "_" + paramString1 + "_" + paramLocale.getLanguage() + paramLocale.getCountry());
    if (inputStream != null)
      return inputStream; 
    inputStream = getClass().getResourceAsStream(paramString1 + "_" + paramString1 + paramLocale.getLanguage());
    return (inputStream != null) ? inputStream : getClass().getResourceAsStream(paramString1 + paramString1);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\b.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */