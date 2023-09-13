package com.xk72.net;

import com.xk72.proxy.a.Xsnk;
import com.xk72.util.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class a {
  private static final Logger l = Logger.getLogger("com.xk72.net.LocationMatching");
  
  public static final String n = "[a-z]";
  
  public static final String a = "[a-z]*";
  
  public static final String b = "://";
  
  public static final String c = "[^:/]";
  
  public static final String d = "[^:/]*";
  
  public static final char e = ':';
  
  public static final String f = "[0-9]";
  
  public static final String g = "[0-9]*";
  
  public static final String h = ".";
  
  public static final String i = "/.*";
  
  public static final String j = ".";
  
  public static final String k = "\\?.*";
  
  private static Map<Location, Pattern> m = new HashMap<>();
  
  public static boolean n(Location paramLocation, Collection<? extends Xsnk> paramCollection) {
    return n(paramLocation, paramCollection, true);
  }
  
  public static boolean n(Location paramLocation, Collection<? extends Xsnk> paramCollection, boolean paramBoolean) {
    return n(paramLocation, paramCollection, false, paramBoolean);
  }
  
  public static boolean n(Location paramLocation, Collection<? extends Xsnk> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
    return (paramCollection != null) ? ((a(paramLocation, paramCollection, paramBoolean1, paramBoolean2) != null)) : false;
  }
  
  public static <T extends Xsnk> T a(Location paramLocation, Collection<? extends T> paramCollection) {
    return a(paramLocation, paramCollection, true);
  }
  
  public static <T extends Xsnk> T n(Location paramLocation, Collection<? extends T> paramCollection, Predicate<T> paramPredicate) {
    return n(paramLocation, paramCollection, true, paramPredicate);
  }
  
  public static <T extends Xsnk> T a(Location paramLocation, Collection<? extends T> paramCollection, boolean paramBoolean) {
    return a(paramLocation, paramCollection, false, paramBoolean);
  }
  
  public static <T extends Xsnk> T n(Location paramLocation, Collection<? extends T> paramCollection, boolean paramBoolean, Predicate<T> paramPredicate) {
    return n(paramLocation, paramCollection, false, paramBoolean, paramPredicate);
  }
  
  public static <T extends Xsnk> T a(Location paramLocation, Collection<? extends T> paramCollection, boolean paramBoolean1, boolean paramBoolean2) {
    return n(paramLocation, paramCollection, paramBoolean1, paramBoolean2, null);
  }
  
  public static <T extends Xsnk> T n(Location paramLocation, Collection<? extends T> paramCollection, boolean paramBoolean1, boolean paramBoolean2, Predicate<T> paramPredicate) {
    if (paramCollection != null) {
      String str = paramLocation.toCanoncialString();
      for (Xsnk xsnk : paramCollection) {
        if (xsnk != null && (!paramBoolean2 || xsnk.isEnabled())) {
          Location location = xsnk.getLocation();
          if (location != null) {
            if (paramBoolean1)
              location = location.toHostPattern(); 
            try {
              Pattern pattern = a(location);
              if (pattern.matcher(str).matches() && (paramPredicate == null || paramPredicate.test((T)xsnk)))
                return (T)xsnk; 
            } catch (PatternSyntaxException patternSyntaxException) {
              l.log(Level.WARNING, patternSyntaxException.toString(), patternSyntaxException);
            } 
          } 
        } 
      } 
    } 
    return null;
  }
  
  public static <T extends Xsnk> Collection<T> b(Location paramLocation, Collection<? extends T> paramCollection) {
    ArrayList<Xsnk> arrayList = new ArrayList();
    if (paramCollection != null) {
      String str = paramLocation.toCanoncialString();
      for (Xsnk xsnk : paramCollection) {
        if (xsnk.isEnabled()) {
          Location location = xsnk.getLocation();
          if (location != null)
            try {
              Pattern pattern = a(location);
              if (pattern.matcher(str).matches())
                arrayList.add(xsnk); 
            } catch (PatternSyntaxException patternSyntaxException) {
              l.log(Level.WARNING, patternSyntaxException.toString(), patternSyntaxException);
            }  
        } 
      } 
    } 
    return (Collection)arrayList;
  }
  
  public static boolean n(Location paramLocation) {
    String str = paramLocation.getPath();
    if (str == null)
      return true; 
    int i = str.lastIndexOf('/');
    return (i != -1) ? ((str.indexOf('*', i + 1) != -1 || str.indexOf('?', i + 1) != -1)) : false;
  }
  
  public static String n(Location paramLocation, String paramString) {
    return n(paramLocation, false, paramString);
  }
  
  public static String n(Location paramLocation, boolean paramBoolean, String paramString) {
    try {
      Pattern pattern = n(paramLocation, paramBoolean);
      Matcher matcher = pattern.matcher(paramString);
      return (matcher.find() && matcher.start() == 0) ? paramString.substring(matcher.end()) : null;
    } catch (PatternSyntaxException patternSyntaxException) {
      l.log(Level.WARNING, patternSyntaxException.toString(), patternSyntaxException);
      return null;
    } 
  }
  
  private static Pattern n(Location paramLocation, boolean paramBoolean) {
    String str = paramLocation.getPath();
    if (str == null)
      str = "/"; 
    if (paramBoolean) {
      int i = str.lastIndexOf('/');
      if (i != -1)
        str = str.substring(0, i + 1); 
    } 
    return a(str);
  }
  
  public static String a(Location paramLocation, String paramString) {
    return a(paramLocation, false, paramString);
  }
  
  public static String a(Location paramLocation, boolean paramBoolean, String paramString) {
    try {
      Pattern pattern = n(paramLocation, paramBoolean);
      Matcher matcher = pattern.matcher(paramString);
      return (matcher.find() && matcher.start() == 0) ? matcher.group() : null;
    } catch (PatternSyntaxException patternSyntaxException) {
      l.log(Level.WARNING, patternSyntaxException.toString(), patternSyntaxException);
      return null;
    } 
  }
  
  public static Pattern a(Location paramLocation) {
    synchronized (m) {
      pattern = m.get(paramLocation);
    } 
    if (pattern != null)
      return pattern; 
    Pattern pattern = c(paramLocation);
    synchronized (m) {
      m.put(paramLocation.clone(), pattern);
    } 
    return pattern;
  }
  
  private static Pattern c(Location paramLocation) {
    String str = b(paramLocation);
    return H.n(str, 2);
  }
  
  private static String n(String paramString1, String paramString2) {
    StringBuffer stringBuffer = new StringBuffer(paramString1.length() + 10);
    int i = paramString1.length();
    boolean bool = false;
    for (byte b = 0; b < i; b++) {
      char c = paramString1.charAt(b);
      if (c == '\\') {
        bool = true;
        stringBuffer.append(c);
      } else if (bool) {
        bool = false;
        stringBuffer.append(c);
      } else if (c == '.') {
        stringBuffer.append(paramString2);
      } else {
        stringBuffer.append(c);
      } 
    } 
    return stringBuffer.toString();
  }
  
  private static String n(String paramString) {
    if (paramString.startsWith("/"))
      return paramString; 
    Matcher matcher = H.n(paramString).matcher("/");
    return (matcher.matches() || matcher.hitEnd()) ? paramString : ("/" + paramString);
  }
  
  protected static String b(Location paramLocation) {
    String str1 = paramLocation.getProtocol();
    String str2 = paramLocation.getHost();
    String str3 = paramLocation.getPort();
    String str4 = paramLocation.getPath();
    String str5 = paramLocation.getQuery();
    StringBuffer stringBuffer = new StringBuffer();
    if (str1 != null && str1.length() > 0) {
      stringBuffer.append(n(H.a(str1), "[a-z]"));
    } else {
      stringBuffer.append("[a-z]*");
    } 
    stringBuffer.append("://");
    if (str2 != null && str2.length() > 0) {
      if (Xsnk.a(str2)) {
        stringBuffer.append(Pattern.quote(str2));
      } else {
        stringBuffer.append(n(H.a(str2), "[^:/]"));
      } 
    } else {
      stringBuffer.append("[^:/]*");
    } 
    stringBuffer.append(':');
    if (str3 != null && str3.length() > 0) {
      String str = n(H.a(str3), "[0-9]");
      stringBuffer.append(str);
    } else {
      stringBuffer.append("[0-9]*");
    } 
    if (str4 != null && str4.length() > 0) {
      stringBuffer.append(n(H.a(str4)));
    } else {
      stringBuffer.append("/.*");
    } 
    if (str5 != null && str5.length() > 0) {
      stringBuffer.append("\\?");
      stringBuffer.append(".*");
      stringBuffer.append(H.a(str5));
      stringBuffer.append(".*");
    } else {
      stringBuffer.append("\\?.*");
    } 
    return stringBuffer.toString();
  }
  
  private static Pattern a(String paramString) {
    int i = paramString.lastIndexOf('/');
    int j = paramString.indexOf('*', i + 1);
    if (j != -1)
      paramString = paramString.substring(0, i + 1); 
    paramString = n(H.a(paramString));
    return H.n(paramString, 2);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\net\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */