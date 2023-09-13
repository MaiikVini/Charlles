package com.xk72.charles.b;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.config.RemoteControlConfiguration;
import com.xk72.charles.config.ThrottlingConfiguration;
import com.xk72.charles.export.c;
import com.xk72.charles.export.f;
import com.xk72.charles.export.g;
import com.xk72.charles.export.h;
import com.xk72.charles.export.l;
import com.xk72.charles.export.r;
import com.xk72.charles.export.s;
import com.xk72.charles.lib.e;
import com.xk72.charles.lib.q;
import com.xk72.charles.model.Session;
import com.xk72.charles.tools.lib.CharlesTool;
import com.xk72.proxy.Fields;
import com.xk72.proxy.ProxyEvent;
import com.xk72.proxy.http.HttpFields;
import com.xk72.proxy.io.k;
import com.xk72.proxy.io.l;
import com.xk72.util.K;
import com.xk72.util.o;
import com.xk72.util.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.SwingUtilities;

class d implements Runnable {
  private static final String a = "html";
  
  private final ProxyEvent b;
  
  private final ServerSocket c;
  
  private final MimetypesFileTypeMap d = new MimetypesFileTypeMap();
  
  public d(c paramc, ProxyEvent paramProxyEvent) {
    this.b = paramProxyEvent;
    this.c = new ServerSocket(0, 10, InetAddress.getByName(null));
  }
  
  public void run() {
    try {
      Socket socket = this.c.accept();
      try {
        k k = new k(socket.getInputStream());
        try {
          l l = new l(socket.getOutputStream());
          try {
            String str2;
            HttpFields httpFields = k.n(true);
            String str1 = this.b.getPath();
            if (str1.endsWith("/"))
              str1 = str1 + "index.html"; 
            int i = str1.lastIndexOf('.');
            if (i != -1) {
              str2 = str1.substring(i + 1);
              str1 = str1.substring(0, i);
            } else {
              str2 = "html";
            } 
            HashMap<Object, Object> hashMap = new HashMap<>();
            boolean bool = false;
            RemoteControlConfiguration remoteControlConfiguration = CharlesContext.getInstance().getConfiguration().getRemoteControlConfiguration();
            if (!remoteControlConfiguration.isEnabled()) {
              str1 = "/disabled";
            } else if (!remoteControlConfiguration.isAllowAnonymous() && !c.n((Fields)httpFields, remoteControlConfiguration)) {
              c.n(l);
            } else if (str1.equals("/throttling/activate")) {
              if (this.b.getQuery() != null) {
                q q = new q(this.b.getQuery(), e.b((Fields)httpFields));
                String str = q.a("preset");
                if (str != null && str.length() > 0) {
                  ThrottlingConfiguration.ThrottlePreset throttlePreset = a(str);
                  if (throttlePreset != null) {
                    CharlesContext.getInstance().getConfiguration().getThrottlingConfiguration().configure((ThrottlingConfiguration.ThrottleSetting)throttlePreset);
                    CharlesContext.getInstance().getProxyManager().j();
                  } else {
                    hashMap.put("ERROR", "Throttling Preset \"" + str + "\" not found");
                  } 
                } 
              } 
              CharlesContext.getInstance().getProxyManager().n(true);
              str1 = "/throttling/index";
            } else if (str1.equals("/throttling/deactivate")) {
              CharlesContext.getInstance().getProxyManager().n(false);
              str1 = "/throttling/index";
            } else if (str1.equals("/recording/start")) {
              this.n.n();
              str1 = "/recording/index";
            } else if (str1.equals("/recording/stop")) {
              CharlesContext.getInstance().getProxyManager().n(null);
              str1 = "/recording/index";
            } else if (str1.equals("/session/clear")) {
              Session session = CharlesContext.getInstance().getProxyManager().q();
              if (session != null)
                session.clear(); 
              str1 = "/session/index";
            } else if (str1.equals("/session/export-xml")) {
              if (n("text/xml", (g)new s(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/session/export-json")) {
              if (n("application/json", (g)new l(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/session/export-trace")) {
              if (n("text/plain", (g)new r(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/session/export-csv")) {
              if (n("text/csv", (g)new f(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/session/export-har")) {
              if (n("text/har", (g)new h(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/session/download")) {
              if (n("application/x-octet-stream", (g)new c(), l)) {
                str1 = null;
              } else {
                str1 = "/session/index";
              } 
            } else if (str1.equals("/quit")) {
              SwingUtilities.invokeLater(new e(this));
              str1 = "/quit";
            } else if (str1.startsWith("/tools/")) {
              String[] arrayOfString = K.b(str1.substring(1), "/");
              String str3 = (arrayOfString.length > 1) ? arrayOfString[1] : "";
              String str4 = (arrayOfString.length > 2) ? arrayOfString[2] : "";
              CharlesContext charlesContext = CharlesContext.getInstance();
              ArrayList arrayList = new ArrayList();
              arrayList.addAll(charlesContext.getProxyTools());
              arrayList.addAll(charlesContext.getUserTools());
              Iterator<CharlesTool> iterator = arrayList.iterator();
              StringBuffer stringBuffer = new StringBuffer();
              while (iterator.hasNext()) {
                CharlesTool charlesTool = iterator.next();
                if (charlesTool == null || !charlesTool.isActivatable())
                  continue; 
                stringBuffer.append("<li>");
                stringBuffer.append("<a href=\"");
                String str = n(charlesTool.getName());
                stringBuffer.append(str);
                stringBuffer.append("/\">");
                stringBuffer.append(charlesTool.getName());
                stringBuffer.append("</a>");
                if (charlesTool.isActive())
                  stringBuffer.append(" (Enabled)"); 
                stringBuffer.append("</li>");
                if (str3.equals(str)) {
                  if (str4.equals("enable")) {
                    charlesTool.activate(true);
                    str1 = "/tools/tool";
                  } else if (str4.equals("disable")) {
                    charlesTool.activate(false);
                    str1 = "/tools/tool";
                  } else {
                    str1 = "/tools/tool";
                  } 
                  hashMap.put("TOOL", charlesTool.getName());
                  hashMap.put("TOOL_STATUS", charlesTool.isActive() ? "Enabled" : "Disabled");
                } 
              } 
              hashMap.put("TOOL_LIST", stringBuffer.toString());
            } 
            if (str1 != null) {
              hashMap.put("THROTTLING_PRESETS", a());
              hashMap.put("RECORDING_STATUS", (CharlesContext.getInstance().getProxyManager().q() != null) ? "Recording" : "Recording Stopped");
              hashMap.put("THROTTLING_STATUS", CharlesContext.getInstance().getProxyManager().i() ? "Throttling" : "Throttling Stopped");
              n(str1, str2, (Map)hashMap, l);
            } 
            l.flush();
            l.close();
          } catch (Throwable throwable) {
            try {
              l.close();
            } catch (Throwable throwable1) {
              throwable.addSuppressed(throwable1);
            } 
            throw throwable;
          } 
          k.close();
        } catch (Throwable throwable) {
          try {
            k.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          } 
          throw throwable;
        } 
        if (socket != null)
          socket.close(); 
      } catch (Throwable throwable) {
        if (socket != null)
          try {
            socket.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (IOException iOException) {
      c.n.log(Level.WARNING, iOException.toString(), iOException);
    } finally {
      try {
        this.c.close();
      } catch (IOException iOException) {
        c.n.log(Level.WARNING, iOException.toString(), iOException);
      } 
    } 
  }
  
  private boolean n(String paramString, g paramg, l paraml) {
    return n(paramString, paramg.n(), paramg, paraml);
  }
  
  private boolean n(String paramString1, String paramString2, g paramg, l paraml) {
    Session session = this.n.a();
    if (session != null) {
      n(paramString1, paramString2, paraml);
      paramg.n(session, (OutputStream)paraml);
      return true;
    } 
    return false;
  }
  
  private void n(String paramString1, String paramString2, l paraml) {
    HttpFields httpFields = new HttpFields();
    httpFields.setResponseStatus(200, "OK");
    httpFields.addField("Content-Type", paramString1);
    if (paramString2 != null)
      httpFields.addField("Content-Disposition", "attachment; filename=" + paramString2); 
    httpFields.addField("Connection", "close");
    paraml.n((Fields)httpFields, true);
  }
  
  private String n(String paramString) {
    String str = paramString.toLowerCase();
    StringBuffer stringBuffer = new StringBuffer(str.length());
    for (byte b = 0; b < str.length(); b++) {
      char c1 = str.charAt(b);
      if (Character.isLetterOrDigit(c1)) {
        stringBuffer.append(c1);
      } else if (Character.isWhitespace(c1)) {
        stringBuffer.append('-');
      } 
    } 
    return stringBuffer.toString();
  }
  
  private void n(String paramString1, String paramString2, Map<String, String> paramMap, l paraml) {
    HttpFields httpFields = new HttpFields();
    String str = null;
    InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("control/static" + paramString1 + "." + paramString2);
    try {
      if (inputStream != null) {
        String str1 = this.d.getContentType(paramString1 + "." + paramString1);
        httpFields.setResponseStatus(200, "OK");
        httpFields.addField("Content-Type", str1);
        if (str1.startsWith("text/")) {
          str = w.n(inputStream, "UTF-8");
          for (String str2 : paramMap.keySet())
            str = K.n(str, "${" + str2 + "}", paramMap.get(str2)); 
        } 
      } else {
        httpFields.setResponseStatus(404, "Not Found");
      } 
      httpFields.addField("Connection", "close");
      paraml.n((Fields)httpFields, (inputStream != null));
      if (str != null) {
        paraml.n(str);
      } else if (inputStream != null) {
        byte[] arrayOfByte = new byte[8192];
        int i;
        for (i = inputStream.read(arrayOfByte); i != -1; i = inputStream.read(arrayOfByte))
          paraml.write(arrayOfByte, 0, i); 
      } 
      if (inputStream != null)
        inputStream.close(); 
    } catch (Throwable throwable) {
      if (inputStream != null)
        try {
          inputStream.close();
        } catch (Throwable throwable1) {
          throwable.addSuppressed(throwable1);
        }  
      throw throwable;
    } 
  }
  
  private String a() {
    StringBuffer stringBuffer = new StringBuffer();
    ThrottlingConfiguration.PermanentThrottlePreset[] arrayOfPermanentThrottlePreset = ThrottlingConfiguration.PRESETS;
    for (ThrottlingConfiguration.PermanentThrottlePreset permanentThrottlePreset : arrayOfPermanentThrottlePreset)
      stringBuffer.append("<option value=\"" + o.n(permanentThrottlePreset.getName()) + "\">" + o.n(permanentThrottlePreset.getName()) + "</option>\n"); 
    List list = CharlesContext.getInstance().getConfiguration().getThrottlingConfiguration().getCustomPresets();
    for (ThrottlingConfiguration.ThrottlePreset throttlePreset : list)
      stringBuffer.append("<option value=\"" + o.n(throttlePreset.getName()) + "\">" + o.n(throttlePreset.getName()) + "</option>\n"); 
    return stringBuffer.toString();
  }
  
  private ThrottlingConfiguration.ThrottlePreset a(String paramString) {
    ThrottlingConfiguration.PermanentThrottlePreset[] arrayOfPermanentThrottlePreset = ThrottlingConfiguration.PRESETS;
    for (ThrottlingConfiguration.PermanentThrottlePreset permanentThrottlePreset : arrayOfPermanentThrottlePreset) {
      if (permanentThrottlePreset.getName().equals(paramString))
        return (ThrottlingConfiguration.ThrottlePreset)permanentThrottlePreset; 
    } 
    List list = CharlesContext.getInstance().getConfiguration().getThrottlingConfiguration().getCustomPresets();
    for (ThrottlingConfiguration.ThrottlePreset throttlePreset : list) {
      if (throttlePreset.getName().equals(paramString))
        return throttlePreset; 
    } 
    return null;
  }
  
  public int n() {
    return this.c.getLocalPort();
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\b\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */