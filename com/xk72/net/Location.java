package com.xk72.net;

import com.xk72.util.B;
import com.xk72.util.C;

@B
@C
public class Location implements Cloneable {
  private String protocol;
  
  private String host;
  
  private String port;
  
  private String path;
  
  private String query;
  
  public Location() {}
  
  public Location(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.protocol = paramString1;
    this.host = paramString2;
    this.port = paramString3;
    this.path = paramString4;
    this.query = paramString5;
  }
  
  @Deprecated
  public Location(String paramString) {
    setPattern(paramString);
  }
  
  public Location(String paramString1, String paramString2) {
    this.protocol = paramString1;
    this.host = paramString2;
  }
  
  public Location(String paramString1, String paramString2, int paramInt) {
    this.protocol = paramString1;
    this.host = paramString2;
    this.port = (paramInt != -1) ? Integer.toString(paramInt) : null;
  }
  
  public Location(String paramString1, String paramString2, int paramInt, String paramString3) {
    this(paramString1, paramString2, paramInt);
    this.path = paramString3;
  }
  
  public Location(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {
    this(paramString1, paramString2, paramInt);
    this.path = paramString3;
    this.query = paramString4;
  }
  
  public Location clone() {
    try {
      return (Location)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new IllegalStateException(cloneNotSupportedException);
    } 
  }
  
  public Location toHostPattern() {
    return (this.query == null && this.path == null) ? this : new Location(this.protocol, this.host, this.port, null, null);
  }
  
  public String getHostAndPort() {
    return this.host + this.host;
  }
  
  @Deprecated
  private void setPattern(String paramString) {
    if (paramString != null) {
      this.protocol = protocolPart(paramString);
      this.host = hostPart(paramString, true);
      this.port = portPart(paramString, true);
      this.path = pathPart(paramString, true);
      if (this.path != null)
        if (this.path.endsWith("/")) {
          this.path += "*";
        } else if (this.path.endsWith("/$")) {
          this.path = this.path.substring(0, this.path.length() - 1);
        }  
      this.query = null;
    } 
  }
  
  public static Location parseURL(String paramString) {
    String str1 = protocolPart(paramString);
    String str2 = hostPart(paramString, true);
    String str3 = portPart(paramString, true);
    String str4 = pathPart(paramString, true);
    return new Location(str1, str2, str3, str4, null);
  }
  
  public String getProtocol() {
    return this.protocol;
  }
  
  public void setProtocol(String paramString) {
    this.protocol = paramString;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public void setHost(String paramString) {
    this.host = paramString;
  }
  
  public String getPort() {
    return this.port;
  }
  
  public void setPort(String paramString) {
    this.port = paramString;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public void setPath(String paramString) {
    this.path = paramString;
  }
  
  public String getQuery() {
    return this.query;
  }
  
  public void setQuery(String paramString) {
    this.query = paramString;
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    null = 31 * null + ((this.host == null) ? 0 : this.host.hashCode());
    null = 31 * null + ((this.path == null) ? 0 : this.path.hashCode());
    null = 31 * null + ((this.port == null) ? 0 : this.port.hashCode());
    null = 31 * null + ((this.protocol == null) ? 0 : this.protocol.hashCode());
    return 31 * null + ((this.query == null) ? 0 : this.query.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    Location location = (Location)paramObject;
    if (this.host == null) {
      if (location.host != null)
        return false; 
    } else if (!this.host.equals(location.host)) {
      return false;
    } 
    if (this.path == null) {
      if (location.path != null)
        return false; 
    } else if (!this.path.equals(location.path)) {
      return false;
    } 
    if (this.port == null) {
      if (location.port != null)
        return false; 
    } else if (!this.port.equals(location.port)) {
      return false;
    } 
    if (this.protocol == null) {
      if (location.protocol != null)
        return false; 
    } else if (!this.protocol.equals(location.protocol)) {
      return false;
    } 
    if (this.query == null) {
      if (location.query != null)
        return false; 
    } else if (!this.query.equals(location.query)) {
      return false;
    } 
    return true;
  }
  
  public String toCanoncialString() {
    StringBuffer stringBuffer = new StringBuffer();
    if (this.protocol != null && this.protocol.length() > 0)
      stringBuffer.append(this.protocol); 
    stringBuffer.append("://");
    if (this.host != null && this.host.length() > 0)
      stringBuffer.append(this.host); 
    stringBuffer.append(':');
    if (this.port != null && this.port.length() > 0)
      stringBuffer.append(this.port); 
    if (this.path != null && this.path.length() > 0) {
      if (this.path.startsWith("/")) {
        stringBuffer.append(this.path);
      } else {
        stringBuffer.append('/');
        stringBuffer.append(this.path);
      } 
    } else {
      stringBuffer.append('/');
    } 
    stringBuffer.append('?');
    if (this.query != null && this.query.length() > 0)
      stringBuffer.append(this.query); 
    return stringBuffer.toString();
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    if (this.protocol != null && this.protocol.length() > 0) {
      stringBuffer.append(this.protocol);
      stringBuffer.append("://");
    } 
    if (this.host != null && this.host.length() > 0) {
      stringBuffer.append(this.host);
    } else if ((this.protocol != null && this.protocol.length() > 0) || (this.port != null && this.port.length() > 0) || this.path == null || this.path.length() == 0) {
      stringBuffer.append('*');
    } 
    if (this.port != null && this.port.length() > 0) {
      stringBuffer.append(':');
      stringBuffer.append(this.port);
    } 
    if (this.path != null && this.path.length() > 0)
      if (this.path.startsWith("/")) {
        stringBuffer.append(this.path);
      } else {
        stringBuffer.append('/');
        stringBuffer.append(this.path);
      }  
    if (this.query != null && this.query.length() > 0) {
      stringBuffer.append('?');
      stringBuffer.append(this.query);
    } 
    return stringBuffer.toString();
  }
  
  @Deprecated
  public static String protocolPart(String paramString) {
    int i = paramString.indexOf("://");
    return (i != -1) ? paramString.substring(0, i) : null;
  }
  
  @Deprecated
  public static String hostPart(String paramString, boolean paramBoolean) {
    String str = hostPortPart(paramString, paramBoolean);
    if (str != null) {
      String str1;
      int i = str.indexOf(':');
      if (i == -1) {
        str1 = str;
      } else {
        if (i == 0 && paramBoolean)
          return null; 
        str1 = str.substring(0, i);
      } 
      return !str1.equals("*") ? str1 : null;
    } 
    return null;
  }
  
  @Deprecated
  public static String hostPart(String paramString) {
    return hostPart(paramString, false);
  }
  
  @Deprecated
  public static String portPart(String paramString, boolean paramBoolean) {
    String str = hostPortPart(paramString, paramBoolean);
    if (str != null) {
      int i = str.indexOf(':');
      return (i == -1) ? null : str.substring(i + 1);
    } 
    return null;
  }
  
  @Deprecated
  public static String portPart(String paramString) {
    return portPart(paramString, false);
  }
  
  @Deprecated
  public static String hostPortPart(String paramString, boolean paramBoolean) {
    int i = paramString.indexOf("://");
    if (i != -1)
      paramString = paramString.substring(i + 3); 
    int j = paramString.indexOf('/');
    return ((paramString.length() == 0 || j == 0) && paramBoolean) ? null : ((j != -1) ? paramString.substring(0, j) : paramString);
  }
  
  @Deprecated
  public static String hostPortPart(String paramString) {
    return hostPortPart(paramString, false);
  }
  
  @Deprecated
  public static String pathPart(String paramString, boolean paramBoolean) {
    int i = paramString.indexOf("://");
    if (i != -1)
      paramString = paramString.substring(i + 3); 
    int j = paramString.indexOf('/');
    return (j != -1) ? paramString.substring(j) : (paramBoolean ? null : "/");
  }
  
  @Deprecated
  public static String pathPart(String paramString) {
    return pathPart(paramString, false);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\net\Location.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */