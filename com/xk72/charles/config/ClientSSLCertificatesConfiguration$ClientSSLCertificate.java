package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.charles.CharlesContext;
import com.xk72.charles.ssl.CertificateConfiguration;
import com.xk72.net.Location;
import com.xk72.net.Xsnk;
import com.xk72.util.B;
import com.xk72.util.C;
import java.io.File;
import java.io.IOException;

@XStreamAlias("clientCertificate")
@B
@C
public class ClientSSLCertificatesConfiguration$ClientSSLCertificate implements Xsnk {
  private Location location;
  
  private boolean enabled = true;
  
  private CertificateConfiguration certificate;
  
  public ClientSSLCertificatesConfiguration$ClientSSLCertificate clone() {
    try {
      return (ClientSSLCertificatesConfiguration$ClientSSLCertificate)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  @Deprecated
  public String getPattern() {
    return null;
  }
  
  @Deprecated
  public void setPattern(String paramString) {
    if (paramString != null)
      this.location = new Location(paramString); 
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.enabled = paramBoolean;
  }
  
  @Deprecated
  public String getCertificatePath() {
    return null;
  }
  
  @Deprecated
  public void setCertificatePath(String paramString) {
    try {
      File file = new File(paramString);
      String str = CharlesContext.getInstance().getFileStore().n(file);
      this.certificate = new CertificateConfiguration(file.getName(), str);
    } catch (IOException iOException) {}
  }
  
  public Location getLocation() {
    return this.location;
  }
  
  public void setLocation(Location paramLocation) {
    this.location = paramLocation;
  }
  
  public CertificateConfiguration getCertificate() {
    return this.certificate;
  }
  
  public void setCertificate(CertificateConfiguration paramCertificateConfiguration) {
    this.certificate = paramCertificateConfiguration;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ClientSSLCertificatesConfiguration$ClientSSLCertificate.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */