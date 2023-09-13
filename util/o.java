package com.xk72.util;

import java.awt.Color;

public class o {
  public static void n(char paramChar, StringBuilder paramStringBuilder) {
    switch (paramChar) {
      case '&':
        paramStringBuilder.append("&amp;");
        return;
      case '<':
        paramStringBuilder.append("&lt;");
        return;
      case '>':
        paramStringBuilder.append("&gt;");
        return;
      case '"':
        paramStringBuilder.append("&quot;");
        return;
      case '\'':
        paramStringBuilder.append("&#x27;");
        return;
      case '/':
        paramStringBuilder.append("&#x2F;");
        return;
    } 
    paramStringBuilder.append(paramChar);
  }
  
  public static String n(String paramString) {
    if (paramString == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramString.length(); b++)
      n(paramString.charAt(b), stringBuilder); 
    return stringBuilder.toString();
  }
  
  public static String a(String paramString) {
    if (paramString == null)
      return null; 
    paramString = K.n(paramString, "&amp;", "&");
    paramString = K.n(paramString, "&lt;", "<");
    paramString = K.n(paramString, "&gt;", ">");
    paramString = K.n(paramString, "&quot;", "\"");
    paramString = K.n(paramString, "&#x27;", "'");
    return K.n(paramString, "&#x2F;", "/");
  }
  
  public static String b(String paramString) {
    paramString = K.n(paramString, "\r\n", "<br />");
    paramString = K.n(paramString, "\n", "<br />");
    return K.n(paramString, "\r", "<br />");
  }
  
  public static String c(String paramString) {
    paramString = K.a(paramString, "<br />", "\n");
    paramString = K.a(paramString, "<br/>", "\n");
    return K.a(paramString, "<br>", "\n");
  }
  
  public static String d(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    int i = paramString.indexOf('<');
    int j = 0;
    while (i != -1) {
      int k = paramString.indexOf('>', i + 1);
      if (k != -1) {
        stringBuffer.append(paramString.substring(j, i));
        j = k + 1;
      } else {
        stringBuffer.append(paramString.substring(j, i));
        j = paramString.length();
        break;
      } 
      i = paramString.indexOf('<', j);
    } 
    stringBuffer.append(paramString.substring(j));
    return stringBuffer.toString();
  }
  
  public static String n(Color paramColor) {
    String str1 = Integer.toHexString(paramColor.getRed());
    String str2 = Integer.toHexString(paramColor.getGreen());
    String str3 = Integer.toHexString(paramColor.getBlue());
    StringBuffer stringBuffer = new StringBuffer(10);
    if (str1.length() < 2)
      stringBuffer.append('0'); 
    stringBuffer.append(str1);
    if (str2.length() < 2)
      stringBuffer.append('0'); 
    stringBuffer.append(str2);
    if (str3.length() < 2)
      stringBuffer.append('0'); 
    stringBuffer.append(str3);
    return stringBuffer.toString();
  }
  
  public static Color e(String paramString) {
    if (paramString.startsWith("#"))
      paramString = paramString.substring(1); 
    return new Color(E.n(paramString.substring(0, 2)), E.n(paramString.substring(2, 4)), E.n(paramString.substring(4, 6)));
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\o.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */