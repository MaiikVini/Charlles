package com.xk72.util;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.nativesupport.Xsnk;
import com.xk72.d.d;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class i {
  private static final String[] n = new String[] { "x-www-browser", "sensible-browser", "gnome-www-browser", "xdg-open" };
  
  public static void n(File paramFile) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().open(paramFile);
      } catch (IOException iOException) {
        CharlesContext.getInstance().error("Launch Application", "Failed to launch external application.", iOException);
      } 
    } else {
      CharlesContext.getInstance().error("Launch Application", "Launching an external application is not currently supported on this platform.");
    } 
  }
  
  public static void n(String paramString) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(new URI(paramString));
      } catch (IOException iOException) {
        CharlesContext.getInstance().error("Launch Browser", "Failed to launch external browser.\n" + paramString);
      } catch (URISyntaxException uRISyntaxException) {
        CharlesContext.getInstance().error("Launch Browser", "Invalid URL for external browser: " + paramString);
      } 
    } else if (Xsnk.b()) {
      a(paramString);
    } else {
      CharlesContext.getInstance().error("Launch Browser", "Launching an external browser is not currently supported on this platform.\n" + paramString);
    } 
  }
  
  private static void a(String paramString) {
    Process process = null;
    String[] arrayOfString = n;
    int j = arrayOfString.length;
    byte b = 0;
    while (b < j) {
      String str = arrayOfString[b];
      try {
        process = Runtime.getRuntime().exec(new String[] { str, paramString });
        break;
      } catch (IOException iOException) {
        b++;
      } 
    } 
    if (process != null) {
      d.n(process.getInputStream());
      d.n(process.getErrorStream());
    } else {
      CharlesContext.getInstance().error("Launch Browser", "Failed to launch external browser.\n" + paramString);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */