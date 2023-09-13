package com.xk72.c;

import com.xk72.a.Xsnk;
import com.xk72.a.e;
import com.xk72.a.m;
import com.xk72.a.n;
import com.xk72.net.Location;
import com.xk72.net.Xsnk;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.CommunicationException;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class a extends G {
  private static final Logger b = Logger.getLogger("com.xk72.dns.ExternalCapableDNSResolver");
  
  private static final InetAddress[] c = new InetAddress[0];
  
  private DirContext d;
  
  private String e;
  
  private List<Xsnk> f;
  
  private boolean g = true;
  
  private long h = 60000L;
  
  private long i = 2000L;
  
  private n<String, InetAddress[]> j = (n<String, InetAddress[]>)new m((e)new Xsnk(1000));
  
  private boolean k;
  
  public a(String paramString) {
    this(paramString, null);
  }
  
  public a(String paramString, List<Xsnk> paramList) {
    this.e = paramString;
    this.f = paramList;
  }
  
  protected InetAddress[] b(String paramString) {
    return (this.f != null && !com.xk72.net.a.n(new Location(null, paramString), this.f)) ? super.b(paramString) : c(paramString);
  }
  
  private DirContext e() {
    if (this.d != null)
      return this.d; 
    Hashtable<Object, Object> hashtable = new Hashtable<>();
    hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
    if (this.e != null)
      hashtable.put("java.naming.provider.url", this.e); 
    try {
      this.d = new InitialDirContext(hashtable);
    } catch (NamingException namingException) {
      b.log(Level.WARNING, "Failed to construct DNS service", namingException);
      this.d = null;
    } 
    return this.d;
  }
  
  InetAddress[] c(String paramString) {
    if ("localhost".equalsIgnoreCase(paramString))
      return new InetAddress[] { InetAddress.getLoopbackAddress() }; 
    if (paramString.toLowerCase().endsWith(".local"))
      return super.b(paramString); 
    if (e(paramString) || d(paramString))
      return super.b(paramString); 
    InetAddress[] arrayOfInetAddress = (InetAddress[])this.j.a(paramString);
    if (arrayOfInetAddress != null) {
      this.k = true;
      if (arrayOfInetAddress != c) {
        b.fine("Returning lookup from cache for " + paramString);
        return arrayOfInetAddress;
      } 
      b.fine("Returning failed lookup from cache for " + paramString);
      throw new UnknownHostException(paramString + ": not known (cached)");
    } 
    this.k = false;
    try {
      InetAddress[] arrayOfInetAddress1 = f(paramString);
      this.j.n(paramString, arrayOfInetAddress1, this.h);
      return arrayOfInetAddress1;
    } catch (UnknownHostException unknownHostException) {
      this.j.n(paramString, c, this.i);
      throw unknownHostException;
    } 
  }
  
  private InetAddress[] f(String paramString) {
    DirContext dirContext = e();
    if (dirContext == null) {
      if (this.g)
        return super.b(paramString); 
      throw new IllegalStateException("DNS Service not configured and fallback not allowed");
    } 
    b.fine("Looking up " + paramString);
    try {
      ArrayList<InetAddress> arrayList = new ArrayList();
      if (n()) {
        Attributes attributes = dirContext.getAttributes(paramString, new String[] { "AAAA" });
        n(paramString, attributes, "AAAA", arrayList);
        attributes = dirContext.getAttributes(paramString, new String[] { "A" });
        n(paramString, attributes, "A", arrayList);
      } else {
        Attributes attributes = dirContext.getAttributes(paramString, new String[] { "A" });
        n(paramString, attributes, "A", arrayList);
        attributes = dirContext.getAttributes(paramString, new String[] { "AAAA" });
        n(paramString, attributes, "AAAA", arrayList);
      } 
      if (arrayList.isEmpty())
        throw new UnknownHostException(paramString + ": no A or AAAA records found"); 
      return arrayList.<InetAddress>toArray(new InetAddress[arrayList.size()]);
    } catch (CommunicationException communicationException) {
      throw new UnknownHostException(paramString + ": dns server failed: " + paramString);
    } catch (NameNotFoundException nameNotFoundException) {
      throw new UnknownHostException(paramString + ": not known");
    } catch (NamingException namingException) {
      if (this.g) {
        b.log(Level.WARNING, "Failed to use DNS service for " + paramString, namingException);
        return super.b(paramString);
      } 
      throw new IllegalStateException("DNS Service failed and fallback not allowed", namingException);
    } 
  }
  
  static boolean d(String paramString) {
    if (paramString.isEmpty())
      return false; 
    if (paramString.startsWith("["))
      return true; 
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c != ':' && Character.digit(c, 16) == -1)
        return false; 
    } 
    return true;
  }
  
  static boolean e(String paramString) {
    if (paramString.isEmpty())
      return false; 
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c != '.' && Character.digit(c, 10) == -1)
        return false; 
    } 
    return true;
  }
  
  private void n(String paramString1, Attributes paramAttributes, String paramString2, Collection<InetAddress> paramCollection) {
    Attribute attribute = paramAttributes.get(paramString2);
    if (attribute != null) {
      NamingEnumeration<?> namingEnumeration = attribute.getAll();
      while (namingEnumeration.hasMoreElements()) {
        String str = (String)namingEnumeration.next();
        paramCollection.add(n(paramString1, str));
      } 
    } 
  }
  
  private static InetAddress n(String paramString1, String paramString2) {
    try {
      return InetAddress.getByAddress(paramString1, InetAddress.getByName(paramString2).getAddress());
    } catch (UnknownHostException unknownHostException) {
      throw new IllegalStateException("Cannot get UnknownHostException when constructing an InetAddress with a hostname and address");
    } 
  }
  
  public boolean a() {
    return this.g;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public long b() {
    return this.h;
  }
  
  public void n(long paramLong) {
    this.h = paramLong;
  }
  
  public long c() {
    return this.i;
  }
  
  public void a(long paramLong) {
    this.i = paramLong;
  }
  
  boolean d() {
    return this.k;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\c\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */