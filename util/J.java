package com.xk72.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class j {
  private static final StringEncryptor n;
  
  public static String n(String paramString) {
    return (paramString == null) ? null : n.encrypt(paramString);
  }
  
  public static String a(String paramString) {
    return (paramString == null) ? null : n.decrypt(paramString);
  }
  
  static {
    StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
    String str1 = "VqHXUeovAOiNR6ivN8AsOhdKEx5GIfnvzRU2RIxfF0xkq7H0j6vSFo9UFv60fotpQzvPvdw18IUL9FBBIQTnF9oCCVwwcszQOJ3v";
    String str2 = "";
    standardPBEStringEncryptor.setPassword("VqHXUeovAOiNR6ivN8AsOhdKEx5GIfnvzRU2RIxfF0xkq7H0j6vSFo9UFv60fotpQzvPvdw18IUL9FBBIQTnF9oCCVwwcszQOJ3v");
    standardPBEStringEncryptor.initialize();
    n = (StringEncryptor)standardPBEStringEncryptor;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\j.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */