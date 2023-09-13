package com.xk72.charles.config;

class j extends ConfigurationImportExport$AbstractOption<ClientSSLCertificatesConfiguration> {
  j(ConfigurationImportExport paramConfigurationImportExport, String paramString, Class<ClientSSLCertificatesConfiguration> paramClass) {
    super(paramString, paramClass);
  }
  
  public ClientSSLCertificatesConfiguration n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    return paramConfigurationImportExport$CharlesExport.getClientSSLCertificatesConfiguration();
  }
  
  public void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ClientSSLCertificatesConfiguration paramClientSSLCertificatesConfiguration) {
    paramConfigurationImportExport$CharlesExport.setClientSSLCertificatesConfiguration(paramClientSSLCertificatesConfiguration);
  }
  
  public ClientSSLCertificatesConfiguration n(CharlesConfiguration paramCharlesConfiguration) {
    return paramCharlesConfiguration.getClientSSLCertificatesConfiguration();
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, ClientSSLCertificatesConfiguration paramClientSSLCertificatesConfiguration) {
    paramCharlesConfiguration.setClientSSLCertificatesConfiguration(paramClientSSLCertificatesConfiguration);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\j.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */