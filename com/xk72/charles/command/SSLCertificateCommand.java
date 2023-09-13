package com.xk72.charles.command;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.ssl.G;
import com.xk72.util.K;
import com.xk72.util.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.bouncycastle.operator.OperatorCreationException;

public class SSLCertificateCommand implements Xsnk {
  private CharlesContext n;
  
  private String[] a;
  
  public SSLCertificateCommand(String[] paramArrayOfString) {
    this.a = paramArrayOfString;
  }
  
  public void run() {
    if (this.a.length == 0) {
      System.err.println("Usage: ssl <command>");
      System.err.println();
      System.err.println("Commands: export, iossim");
      System.exit(1);
    } 
    String str = this.a[0];
    if ("export".equals(str)) {
      a();
      System.exit(0);
    } else if ("iossim".equals(str)) {
      b();
      System.exit(0);
    } else {
      System.err.println("Unsupported command: " + str);
      System.exit(1);
    } 
  }
  
  private void a() {
    b b = c();
    switch (a.n[b.a().ordinal()]) {
      case 1:
        b(b);
        break;
      case 2:
        n(b);
        break;
      case 3:
        a(b);
        break;
    } 
  }
  
  private void b() {
    G.n();
  }
  
  private void n(b paramb) {
    File file = CharlesContext.getInstance().getSSLManager().d();
    n(paramb, file);
  }
  
  private void a(b paramb) {
    File file = CharlesContext.getInstance().getSSLManager().c();
    n(paramb, file);
  }
  
  private void n(b paramb, File paramFile) {
    if (paramFile.exists()) {
      try {
        if (paramb.n() != null) {
          w.n(paramFile, new File(paramb.n()));
        } else {
          n(paramFile);
        } 
      } catch (IOException iOException) {
        System.err.println("Failed to output the certificate file.");
        System.exit(1);
      } 
    } else {
      System.err.println("Couldn't find certifiate file.");
      System.exit(1);
    } 
  }
  
  private void n(File paramFile) {
    FileInputStream fileInputStream = new FileInputStream(paramFile);
    try {
      w.n(fileInputStream, System.out);
      fileInputStream.close();
    } catch (Throwable throwable) {
      try {
        fileInputStream.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
  }
  
  private void b(b paramb) {
    try {
      this.n.getSSLManager().n(paramb.b().toCharArray(), (paramb.n() != null) ? new File(paramb.n()) : null);
    } catch (UnrecoverableKeyException unrecoverableKeyException) {
      System.err.println("Failed to extract the Charles Root Certificate details.");
      System.exit(1);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      System.err.println("Failed to extract the Charles Root Certificate details.");
      System.exit(1);
    } catch (CertificateException certificateException) {
      System.err.println("Failed to extract the Charles Root Certificate details.");
      System.exit(1);
    } catch (KeyStoreException keyStoreException) {
      System.err.println("Failed to extract the Charles Root Certificate details.");
      System.exit(1);
    } catch (OperatorCreationException operatorCreationException) {
      System.err.println("Failed to extract the Charles Root Certificate details.");
      System.exit(1);
    } catch (IOException iOException) {
      System.err.println("Failed to find the Charles Root Certificate.");
      System.exit(1);
    } 
  }
  
  private b c() {
    SSLCertificateCommand$SSLExportType sSLCertificateCommand$SSLExportType;
    if (this.a.length < 2) {
      d();
      return null;
    } 
    byte b = 1;
    String str = this.a[b++];
    if ("-".equals(str)) {
      str = null;
      if (this.a.length > b) {
        try {
          sSLCertificateCommand$SSLExportType = SSLCertificateCommand$SSLExportType.valueOf(this.a[b++].toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
          d();
          return null;
        } 
      } else {
        if (this.a.length != b) {
          d();
          return null;
        } 
        sSLCertificateCommand$SSLExportType = SSLCertificateCommand$SSLExportType.n;
      } 
    } else {
      try {
        String str1 = K.e(str).substring(1);
        try {
          sSLCertificateCommand$SSLExportType = SSLCertificateCommand$SSLExportType.valueOf(str1.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
          System.err.println("Unsupported file extension: " + str1);
          d();
          return null;
        } 
      } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
        d();
        return null;
      } 
    } 
    if (sSLCertificateCommand$SSLExportType == SSLCertificateCommand$SSLExportType.b) {
      if (this.a.length == b + 1) {
        String str1 = this.a[b++];
        return new b(str, sSLCertificateCommand$SSLExportType, str1);
      } 
      d();
      return null;
    } 
    if (this.a.length == b)
      return new b(str, sSLCertificateCommand$SSLExportType); 
    d();
    return null;
  }
  
  private void d() {
    e();
    System.exit(1);
  }
  
  private static void e() {
    System.out.println("Usage: ssl export <file.pem>");
    System.out.println("       ssl export <file.crt>");
    System.out.println("       ssl export - pem");
    System.out.println("       ssl export - crt");
    System.out.println("       ssl export - p12 <password>");
  }
  
  public void n(CharlesContext paramCharlesContext) {
    this.n = paramCharlesContext;
  }
  
  public static void n() {
    System.out.println("SSL Root Certificates");
    System.out.println("=====================");
    System.out.println("Export Charles SSL root certificate.");
    e();
    System.out.println();
    System.out.println("Install Charles SSL root certificate in iOS simulators");
    System.out.println("Usage: ssl iossim");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\command\SSLCertificateCommand.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */