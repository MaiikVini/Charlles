package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.proxy.b;
import com.xk72.util.B;
import com.xk72.util.C;
import com.xk72.util.j;
import java.util.logging.Level;

@XStreamAlias("mutableExternalProxyConfiguration")
@B
@C
public class ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl implements b, Cloneable {
  private boolean active;
  
  private boolean requiresAuthentication;
  
  private String host;
  
  private int port;
  
  private String domain;
  
  private String username;
  
  private String password;
  
  private transient String decryptedPassword;
  
  private String encryptedPassword;
  
  public b getMutable() {
    try {
      return (b)clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public boolean isActive() {
    return this.active;
  }
  
  public void setActive(boolean paramBoolean) {
    this.active = paramBoolean;
  }
  
  public String getHost() {
    return this.host;
  }
  
  public void setHost(String paramString) {
    this.host = paramString;
  }
  
  public String getPassword() {
    if (this.password != null)
      setPassword(this.password); 
    if (this.encryptedPassword == null)
      return null; 
    if (this.decryptedPassword == null)
      try {
        this.decryptedPassword = j.a(this.encryptedPassword);
      } catch (RuntimeException runtimeException) {
        ExternalProxyConfiguration.LOG.log(Level.WARNING, "Error decrypting saved proxy password", runtimeException);
        this.decryptedPassword = null;
        this.encryptedPassword = null;
      }  
    return this.decryptedPassword;
  }
  
  public void setPassword(String paramString) {
    this.encryptedPassword = j.n(paramString);
    this.decryptedPassword = paramString;
    this.password = null;
  }
  
  public int getPort() {
    return this.port;
  }
  
  public void setPort(int paramInt) {
    this.port = paramInt;
  }
  
  public boolean isRequiresAuthentication() {
    return this.requiresAuthentication;
  }
  
  public void setRequiresAuthentication(boolean paramBoolean) {
    this.requiresAuthentication = paramBoolean;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String paramString) {
    this.username = paramString;
  }
  
  public String getDomain() {
    return this.domain;
  }
  
  public void setDomain(String paramString) {
    this.domain = paramString;
  }
  
  public int hashCode() {
    byte b1 = 31;
    null = 1;
    null = 31 * null + (this.active ? 1231 : 1237);
    null = 31 * null + ((this.domain == null) ? 0 : this.domain.hashCode());
    null = 31 * null + ((this.host == null) ? 0 : this.host.hashCode());
    null = 31 * null + ((this.password == null) ? 0 : this.password.hashCode());
    null = 31 * null + this.port;
    null = 31 * null + (this.requiresAuthentication ? 1231 : 1237);
    return 31 * null + ((this.username == null) ? 0 : this.username.hashCode());
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl externalProxyConfiguration$MutableExternalProxyConfigurationImpl = (ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl)paramObject;
    if (this.active != externalProxyConfiguration$MutableExternalProxyConfigurationImpl.active)
      return false; 
    if (this.domain == null) {
      if (externalProxyConfiguration$MutableExternalProxyConfigurationImpl.domain != null)
        return false; 
    } else if (!this.domain.equals(externalProxyConfiguration$MutableExternalProxyConfigurationImpl.domain)) {
      return false;
    } 
    if (this.host == null) {
      if (externalProxyConfiguration$MutableExternalProxyConfigurationImpl.host != null)
        return false; 
    } else if (!this.host.equals(externalProxyConfiguration$MutableExternalProxyConfigurationImpl.host)) {
      return false;
    } 
    if (this.password == null) {
      if (externalProxyConfiguration$MutableExternalProxyConfigurationImpl.password != null)
        return false; 
    } else if (!this.password.equals(externalProxyConfiguration$MutableExternalProxyConfigurationImpl.password)) {
      return false;
    } 
    if (this.port != externalProxyConfiguration$MutableExternalProxyConfigurationImpl.port)
      return false; 
    if (this.requiresAuthentication != externalProxyConfiguration$MutableExternalProxyConfigurationImpl.requiresAuthentication)
      return false; 
    if (this.username == null) {
      if (externalProxyConfiguration$MutableExternalProxyConfigurationImpl.username != null)
        return false; 
    } else if (!this.username.equals(externalProxyConfiguration$MutableExternalProxyConfigurationImpl.username)) {
      return false;
    } 
    return true;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ExternalProxyConfiguration$MutableExternalProxyConfigurationImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */