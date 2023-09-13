package com.xk72.lib;

import com.xk72.util.L;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Stack;
import java.util.logging.Logger;

public class XMLPrintWriter {
  private static final Logger b = Logger.getLogger("com.xk72.lib.XMLPrintWriter");
  
  public static final String n = "1.0";
  
  public static final String a = "UTF-8";
  
  private final PrintWriter c;
  
  private final Stack<String> d = new Stack<>();
  
  private boolean e;
  
  private boolean f;
  
  private boolean g;
  
  public static void main(String[] paramArrayOfString) {
    XMLPrintWriter xMLPrintWriter = new XMLPrintWriter(new PrintWriter(System.out));
    xMLPrintWriter.n("test");
    xMLPrintWriter.n("a").c();
    xMLPrintWriter.n("b").c();
    xMLPrintWriter.n("c").b("d", "e<f>").a("g").c();
    xMLPrintWriter.n("d").b("g").c();
    xMLPrintWriter.n("e").b("ok\na\nb\nc").c();
    xMLPrintWriter.n("f").b("testing <![CDATA[junk]]> ok").c();
    xMLPrintWriter.c();
    xMLPrintWriter.n();
  }
  
  public XMLPrintWriter(PrintWriter paramPrintWriter) {
    this.c = paramPrintWriter;
  }
  
  public void n() {
    if (!this.d.isEmpty())
      throw new IllegalStateException("Attempt to close XMLPrintWriter with unclosed elements"); 
    this.c.close();
  }
  
  public void a() {
    this.c.flush();
  }
  
  private void f() {
    if (this.e) {
      this.c.print('>');
      this.e = false;
    } 
  }
  
  public XMLPrintWriter b() {
    return n(null, "UTF-8");
  }
  
  public XMLPrintWriter n(String paramString1, String paramString2) {
    if (paramString1 == null)
      paramString1 = "1.0"; 
    this.c.print("<?xml version=\"");
    this.c.print(L.n(paramString1));
    this.c.print("\"");
    if (paramString2 != null) {
      this.c.print(" encoding=\"");
      this.c.print(L.n(paramString2));
      this.c.print("\"");
    } 
    this.c.print("?>");
    return this;
  }
  
  public XMLPrintWriter a(String paramString1, String paramString2) {
    return n(paramString1, null, paramString2, null);
  }
  
  public XMLPrintWriter n(String paramString1, String paramString2, String paramString3) {
    return n(paramString1, paramString2, paramString3, null);
  }
  
  public XMLPrintWriter n(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.c.print("<!DOCTYPE ");
    this.c.print(paramString1);
    if (paramString2 != null) {
      this.c.print(" PUBLIC \"");
      this.c.print(L.n(paramString2));
      this.c.print("\"");
    } else if (paramString3 != null) {
      this.c.print(" SYSTEM");
    } 
    if (paramString3 != null) {
      this.c.print(" \"");
      this.c.print(L.n(paramString3));
      this.c.print("\"");
    } 
    if (paramString4 != null) {
      this.c.print(" [ ");
      this.c.print(paramString4);
      this.c.print(" ]");
    } 
    this.c.print(">");
    if (this.g)
      this.c.println(); 
    return this;
  }
  
  public XMLPrintWriter n(String paramString) {
    f();
    if (this.g)
      this.c.println(); 
    this.c.print('<');
    this.c.print(paramString);
    this.d.add(paramString);
    this.e = true;
    return this;
  }
  
  public XMLPrintWriter c() {
    String str = this.d.pop();
    if (this.e) {
      this.c.print(" />");
      this.e = false;
    } else {
      this.c.print("</");
      this.c.print(str);
      this.c.print(">");
    } 
    return this;
  }
  
  public XMLPrintWriter b(String paramString1, String paramString2) {
    if (!this.e)
      throw new IllegalStateException("Cannot write attribute when there isn't an element open"); 
    if (paramString2 == null && this.f)
      return this; 
    this.c.print(' ');
    this.c.print(paramString1);
    this.c.print("=\"");
    if (paramString2 != null)
      this.c.print(L.n(paramString2)); 
    this.c.print('"');
    return this;
  }
  
  public XMLPrintWriter a(String paramString) {
    f();
    if (paramString != null)
      this.c.print(L.n(paramString)); 
    return this;
  }
  
  public XMLPrintWriter b(String paramString) {
    if (paramString == null)
      return this; 
    f();
    this.c.print("<![CDATA[");
    int i = paramString.indexOf("]]>");
    int j = 0;
    while (i != -1) {
      this.c.print(paramString.substring(j, i));
      this.c.print("]]]]><![CDATA[");
      j = i + 2;
      i = paramString.indexOf("]]>", j);
    } 
    this.c.print(paramString.substring(j));
    this.c.print("]]>");
    return this;
  }
  
  public boolean d() {
    return this.f;
  }
  
  public void n(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public boolean e() {
    return this.g;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void n(byte[] paramArrayOfbyte) {
    try {
      b(Base64.getEncoder().encodeToString(paramArrayOfbyte));
    } catch (OutOfMemoryError outOfMemoryError) {
      b.severe("XMLPrintWriter.base64 failed: " + outOfMemoryError);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\XMLPrintWriter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */