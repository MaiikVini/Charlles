package com.xk72.lib;

import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

class n extends DefaultHandler implements LexicalHandler {
  private final Stack<o> a = new Stack<>();
  
  private StringBuffer b;
  
  private boolean c;
  
  private boolean d;
  
  private n(k paramk) {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) {
    this.a.push(new o(this.b, this.d));
    this.b = new StringBuffer();
    this.n.b.n(paramString1, paramString2, paramString3, paramAttributes);
    this.d = false;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3) {
    this.n.b.n(paramString1, paramString2, paramString3, this.b.toString());
    o o = this.a.pop();
    this.b = o.n;
    this.d = o.a;
  }
  
  public void characters(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    String str = new String(paramArrayOfchar, paramInt1, paramInt2);
    if (str.length() != 0) {
      if (this.d || str.charAt(0) <= ' ')
        this.b.append(' '); 
      if (!this.c) {
        this.b.append(str.trim());
        this.d = (str.length() > 0 && str.charAt(str.length() - 1) <= ' ');
      } else {
        this.b.append(str);
        this.d = false;
      } 
    } 
  }
  
  public void startCDATA() {
    this.c = true;
  }
  
  public void endCDATA() {
    this.c = false;
  }
  
  public void comment(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
  
  public void startEntity(String paramString) {}
  
  public void endEntity(String paramString) {}
  
  public void startDTD(String paramString1, String paramString2, String paramString3) {}
  
  public void endDTD() {}
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\n.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */