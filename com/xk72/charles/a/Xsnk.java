package com.xk72.charles.a;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Xsnk {
  public final NetworkInterface n;
  
  public final InetAddress a;
  
  public Xsnk(NetworkInterface paramNetworkInterface, InetAddress paramInetAddress) {
    this.n = paramNetworkInterface;
    this.a = paramInetAddress;
  }
  
  public NetworkInterface n() {
    return this.n;
  }
  
  public InetAddress a() {
    return this.a;
  }
  
  public static List<Xsnk> b() {
    ArrayList<Xsnk> arrayList = new ArrayList();
    Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
    while (enumeration.hasMoreElements()) {
      NetworkInterface networkInterface = enumeration.nextElement();
      Enumeration<InetAddress> enumeration1 = networkInterface.getInetAddresses();
      while (enumeration1.hasMoreElements()) {
        InetAddress inetAddress = enumeration1.nextElement();
        if (n(inetAddress))
          arrayList.add(new Xsnk(networkInterface, inetAddress)); 
      } 
    } 
    return arrayList;
  }
  
  public static Xsnk c() {
    List<Xsnk> list = b();
    Collections.sort(list, new G());
    return !list.isEmpty() ? list.get(0) : null;
  }
  
  private static boolean n(InetAddress paramInetAddress) {
    return (!paramInetAddress.isAnyLocalAddress() && !paramInetAddress.isLinkLocalAddress() && !paramInetAddress.isLoopbackAddress() && !paramInetAddress.isMulticastAddress());
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\a\Xsnk.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */