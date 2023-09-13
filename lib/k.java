package com.xk72.lib;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class k {
  private boolean n = false;
  
  private boolean a = false;
  
  private m b;
  
  public k(m paramm) {
    this.b = paramm;
  }
  
  public void n(InputSource paramInputSource) {
    SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
    sAXParserFactory.setValidating(this.n);
    sAXParserFactory.setNamespaceAware(this.a);
    try {
      sAXParserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", this.n);
      SAXParser sAXParser = sAXParserFactory.newSAXParser();
      n n = new n(this);
      sAXParser.setProperty("http://xml.org/sax/properties/lexical-handler", n);
      XMLReader xMLReader = sAXParser.getXMLReader();
      xMLReader.setEntityResolver(new l(this));
      xMLReader.setContentHandler(n);
      try {
        xMLReader.parse(paramInputSource);
      } catch (SAXParseException sAXParseException) {
        throw new SAXException("Failed to Parse XML Document.\nReason: " + sAXParseException.getMessage() + "\nLine: " + sAXParseException.getLineNumber() + " Column: " + sAXParseException.getColumnNumber(), sAXParseException);
      } 
    } catch (ParserConfigurationException parserConfigurationException) {
      throw new SAXException(parserConfigurationException);
    } catch (SAXParseException sAXParseException) {
      throw new SAXException("Failed to Parse XML Document\nReason: " + sAXParseException.getMessage() + "\nLine: " + sAXParseException.getLineNumber() + " Column: " + sAXParseException.getColumnNumber(), sAXParseException);
    } 
  }
  
  public boolean n() {
    return this.n;
  }
  
  public void n(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public boolean a() {
    return this.a;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public m b() {
    return this.b;
  }
  
  public void n(m paramm) {
    this.b = paramm;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\k.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */