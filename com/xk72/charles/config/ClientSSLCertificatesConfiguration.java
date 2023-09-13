package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("clientCertificates")
public class ClientSSLCertificatesConfiguration extends AbstractConfiguration {
  private List<ClientSSLCertificatesConfiguration$ClientSSLCertificate> certificates = new ArrayList<>();
  
  public List<ClientSSLCertificatesConfiguration$ClientSSLCertificate> getCertificates() {
    return this.certificates;
  }
  
  public void setCertificates(List<ClientSSLCertificatesConfiguration$ClientSSLCertificate> paramList) {
    this.certificates = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ClientSSLCertificatesConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */