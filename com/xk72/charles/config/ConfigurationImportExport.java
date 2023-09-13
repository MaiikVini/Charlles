package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.charles.CharlesContext;
import com.xk72.charles.tools.lib.CharlesTool;
import com.xk72.util.F;
import com.xk72.util.L;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConfigurationImportExport {
  private static final Logger n = Logger.getLogger("com.xk72.charles.gui.settings.ConfigurationImportExport");
  
  private static volatile ConfigurationImportExport a;
  
  private final ConfigurationImportExport$Option<?>[] b;
  
  private static final String c = ((XStreamAlias)ConfigurationImportExport$CharlesExport.class.<XStreamAlias>getAnnotation(XStreamAlias.class)).value();
  
  private static final String d = ((XStreamAlias)CharlesConfiguration.class.<XStreamAlias>getAnnotation(XStreamAlias.class)).value();
  
  public static synchronized ConfigurationImportExport n() {
    if (a == null)
      a = new ConfigurationImportExport(); 
    return a;
  }
  
  public ConfigurationImportExport() {
    ArrayList<G> arrayList = new ArrayList();
    arrayList.add(new G(this, "Recording", RecordingConfiguration.class));
    arrayList.add(new e(this, CharlesContext.getInstance().getBundle().getString("tools.Throttling.name"), ThrottlingConfiguration.class));
    for (CharlesTool charlesTool : CharlesContext.getInstance().getProxyTools()) {
      if (charlesTool != null) {
        Class<Configuration> clazz = charlesTool.getConfigurationClass();
        if (clazz != null)
          arrayList.add((G)new m<>(charlesTool.getName(), clazz)); 
      } 
    } 
    arrayList.add(new f(this, "Proxy Settings", ProxyConfiguration.class));
    arrayList.add(new g(this, "Access Control", AccessControlConfiguration.class));
    arrayList.add(new h(this, CharlesContext.getInstance().getBundle().getString("settings.externalproxy.name"), ExternalProxyConfiguration.class));
    arrayList.add(new i(this, "Web Interface", RemoteControlConfiguration.class));
    arrayList.add(new j(this, CharlesContext.getInstance().getBundle().getString("settings.clientSSLCertificates.name"), ClientSSLCertificatesConfiguration.class));
    for (CharlesTool charlesTool : CharlesContext.getInstance().getUserTools()) {
      if (charlesTool != null) {
        Class<Configuration> clazz = charlesTool.getConfigurationClass();
        if (clazz != null)
          arrayList.add((G)new m<>(charlesTool.getName(), clazz)); 
      } 
    } 
    arrayList.add(new k(this, "Publish Gist", GistIntegrationConfiguration.class));
    arrayList.add(new l(this, CharlesContext.getInstance().getBundle().getString("settings.ui.name"), UserInterfaceConfiguration.class));
    arrayList.add(new a(this, "Protocol Buffers", ProtobufConfiguration.class));
    arrayList.add(new b(this, "Startup", StartupConfiguration.class));
    arrayList.add(new c(this, CharlesContext.getInstance().getBundle().getString("settings.highlight.name"), CategoryConfiguration.class));
    arrayList.add(new d(this, CharlesContext.getInstance().getBundle().getString("settings.focussed.name"), FocusConfiguration.class));
    try {
      arrayList.add((G)new m(CharlesContext.getInstance().getBundle().getString("tools.ViewerContentType.name"), Class.forName("com.xk72.charles.gui.transaction.viewers.TransactionViewerContentTypeManager$ViewerContentTypeMappingConfiguration")));
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("Cannot load ViewerContentTypeMappingConfiguration class", classNotFoundException);
    } 
    this.b = (ConfigurationImportExport$Option<?>[])arrayList.<ConfigurationImportExport$Option>toArray(new ConfigurationImportExport$Option[arrayList.size()]);
  }
  
  public ConfigurationImportExport$Option<?>[] a() {
    return this.b;
  }
  
  public ConfigurationImportExport$Option<?> n(String paramString) {
    for (ConfigurationImportExport$Option<?> configurationImportExport$Option : this.b) {
      if (configurationImportExport$Option.getDisplayName().equals(paramString))
        return configurationImportExport$Option; 
    } 
    return null;
  }
  
  public List<ConfigurationImportExport$Option<?>> n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport) {
    ArrayList<ConfigurationImportExport$Option<?>> arrayList = new ArrayList();
    for (ConfigurationImportExport$Option<?> configurationImportExport$Option : this.b) {
      if (configurationImportExport$Option.get(paramConfigurationImportExport$CharlesExport) != null)
        arrayList.add(configurationImportExport$Option); 
    } 
    return arrayList;
  }
  
  public void n(CharlesConfiguration paramCharlesConfiguration, File paramFile) {
    ConfigurationImportExport$CharlesExport configurationImportExport$CharlesExport = new ConfigurationImportExport$CharlesExport();
    n(paramCharlesConfiguration, configurationImportExport$CharlesExport, Arrays.asList(this.b));
    n(configurationImportExport$CharlesExport, paramFile);
  }
  
  public static void n(CharlesConfiguration paramCharlesConfiguration, ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, Collection<ConfigurationImportExport$Option<?>> paramCollection) {
    for (ConfigurationImportExport$Option<Configuration> configurationImportExport$Option : paramCollection)
      n(paramCharlesConfiguration, paramConfigurationImportExport$CharlesExport, configurationImportExport$Option); 
  }
  
  private static <T extends Configuration> void n(CharlesConfiguration paramCharlesConfiguration, ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, ConfigurationImportExport$Option<T> paramConfigurationImportExport$Option) {
    paramConfigurationImportExport$Option.set(paramConfigurationImportExport$CharlesExport, paramConfigurationImportExport$Option.get(paramCharlesConfiguration));
  }
  
  public static boolean n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, File paramFile) {
    try {
      L.n(paramFile, paramConfigurationImportExport$CharlesExport);
      return true;
    } catch (Exception exception) {
      n.log(Level.WARNING, exception.toString(), exception);
      CharlesContext.getInstance().error("Export Settings", String.format("Unable to save configuration to file '%s': %s", new Object[] { paramFile.getName(), exception.getMessage() }));
      return false;
    } 
  }
  
  public void n(File paramFile, CharlesConfiguration paramCharlesConfiguration) {
    ConfigurationImportExport$CharlesExport configurationImportExport$CharlesExport = n(paramFile);
    n(configurationImportExport$CharlesExport, paramCharlesConfiguration, n(configurationImportExport$CharlesExport));
  }
  
  public static void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, CharlesConfiguration paramCharlesConfiguration, Collection<ConfigurationImportExport$Option<?>> paramCollection) {
    a(paramConfigurationImportExport$CharlesExport, paramCharlesConfiguration, paramCollection);
  }
  
  private static void a(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, CharlesConfiguration paramCharlesConfiguration, Collection<ConfigurationImportExport$Option<?>> paramCollection) {
    for (ConfigurationImportExport$Option<Configuration> configurationImportExport$Option : paramCollection)
      n(paramConfigurationImportExport$CharlesExport, paramCharlesConfiguration, configurationImportExport$Option); 
  }
  
  private static <T extends Configuration> void n(ConfigurationImportExport$CharlesExport paramConfigurationImportExport$CharlesExport, CharlesConfiguration paramCharlesConfiguration, ConfigurationImportExport$Option<T> paramConfigurationImportExport$Option) {
    T t1 = paramConfigurationImportExport$Option.get(paramConfigurationImportExport$CharlesExport);
    T t2 = paramConfigurationImportExport$Option.get(paramCharlesConfiguration);
    if (t2 == null) {
      paramConfigurationImportExport$Option.set(paramCharlesConfiguration, t1);
    } else {
      F.a(t1, t2);
      paramConfigurationImportExport$Option.set(paramCharlesConfiguration, t2);
    } 
  }
  
  public ConfigurationImportExport$CharlesExport n(File paramFile) {
    try {
      ConfigurationImportExport$CharlesExport configurationImportExport$CharlesExport = a(paramFile);
      if (configurationImportExport$CharlesExport == null)
        CharlesContext.getInstance().error("Incorrect settings type", String.format("The file '%s' did not contain a valid Charles settings file.", new Object[] { paramFile.getName() })); 
      return configurationImportExport$CharlesExport;
    } catch (Exception exception) {
      n.log(Level.WARNING, exception.toString(), exception);
      CharlesContext.getInstance().error("Import Settings", String.format("Unable to parse the content of file '%s'.  Please ensure you have selected a valid Charles settings file.", new Object[] { paramFile.getName() }));
      return null;
    } 
  }
  
  private ConfigurationImportExport$CharlesExport a(File paramFile) {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
    try {
      ConfigurationImportExport$CharlesExport configurationImportExport$CharlesExport = n(bufferedInputStream);
      bufferedInputStream.close();
      return configurationImportExport$CharlesExport;
    } catch (Throwable throwable) {
      try {
        bufferedInputStream.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
  }
  
  public ConfigurationImportExport$CharlesExport n(InputStream paramInputStream) {
    Document document = L.a(paramInputStream);
    Element element = document.getDocumentElement();
    if (c.equals(element.getNodeName()))
      return (ConfigurationImportExport$CharlesExport)L.n(element); 
    if (d.equalsIgnoreCase(element.getNodeName())) {
      document.renameNode(element, null, c);
      return (ConfigurationImportExport$CharlesExport)L.n(element);
    } 
    Object object = L.n(element);
    if (object instanceof ConfigurationImportExport$CharlesExport)
      return (ConfigurationImportExport$CharlesExport)object; 
    ConfigurationImportExport$CharlesExport configurationImportExport$CharlesExport = new ConfigurationImportExport$CharlesExport();
    for (ConfigurationImportExport$Option<?> configurationImportExport$Option : this.b) {
      if (configurationImportExport$Option.trySet(configurationImportExport$CharlesExport, object))
        return configurationImportExport$CharlesExport; 
    } 
    return null;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigurationImportExport.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */