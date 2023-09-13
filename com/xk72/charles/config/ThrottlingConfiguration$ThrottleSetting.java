package com.xk72.charles.config;

import com.xk72.util.B;
import com.xk72.util.C;
import java.text.DecimalFormat;

@B
@C
public class ThrottlingConfiguration$ThrottleSetting {
  protected double bandwidthDown;
  
  protected double bandwidthUp;
  
  protected int utilisationDown;
  
  protected int utilisationUp;
  
  protected int latency;
  
  protected int mtu;
  
  protected int reliability = 100;
  
  protected int stability = 100;
  
  protected int lowQuality = 100;
  
  protected int highQuality = 100;
  
  public ThrottlingConfiguration$ThrottleSetting() {}
  
  public ThrottlingConfiguration$ThrottleSetting(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.bandwidthDown = paramDouble1;
    this.bandwidthUp = paramDouble2;
    this.utilisationDown = paramInt1;
    this.utilisationUp = paramInt2;
    this.latency = paramInt3;
    this.mtu = paramInt4;
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    stringBuffer.append(decimalFormat.format(this.bandwidthDown));
    stringBuffer.append("k @ ");
    stringBuffer.append(this.utilisationDown);
    stringBuffer.append("% / ");
    stringBuffer.append(decimalFormat.format(this.bandwidthUp));
    stringBuffer.append("k @ ");
    stringBuffer.append(this.utilisationUp);
    stringBuffer.append("% ");
    stringBuffer.append(this.latency);
    stringBuffer.append("ms [");
    stringBuffer.append(this.reliability);
    stringBuffer.append("%] (");
    stringBuffer.append(this.lowQuality);
    stringBuffer.append(", ");
    stringBuffer.append(this.highQuality);
    stringBuffer.append(") ");
    stringBuffer.append(this.stability);
    stringBuffer.append("%");
    return stringBuffer.toString();
  }
  
  public int hashCode() {
    byte b = 31;
    null = 1;
    long l = Double.doubleToLongBits(this.bandwidthDown);
    null = 31 * null + (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.bandwidthUp);
    null = 31 * null + (int)(l ^ l >>> 32L);
    null = 31 * null + this.latency;
    null = 31 * null + this.reliability;
    null = 31 * null + this.mtu;
    null = 31 * null + this.stability;
    null = 31 * null + this.lowQuality;
    null = 31 * null + this.highQuality;
    null = 31 * null + this.utilisationDown;
    return 31 * null + this.utilisationUp;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    ThrottlingConfiguration$ThrottleSetting throttlingConfiguration$ThrottleSetting = (ThrottlingConfiguration$ThrottleSetting)paramObject;
    return (Double.doubleToLongBits(this.bandwidthDown) != Double.doubleToLongBits(throttlingConfiguration$ThrottleSetting.bandwidthDown)) ? false : ((Double.doubleToLongBits(this.bandwidthUp) != Double.doubleToLongBits(throttlingConfiguration$ThrottleSetting.bandwidthUp)) ? false : ((this.latency != throttlingConfiguration$ThrottleSetting.latency) ? false : ((this.reliability != throttlingConfiguration$ThrottleSetting.reliability) ? false : ((this.mtu != throttlingConfiguration$ThrottleSetting.mtu) ? false : ((this.stability != throttlingConfiguration$ThrottleSetting.stability) ? false : ((this.lowQuality != throttlingConfiguration$ThrottleSetting.lowQuality) ? false : ((this.highQuality != throttlingConfiguration$ThrottleSetting.highQuality) ? false : ((this.utilisationDown != throttlingConfiguration$ThrottleSetting.utilisationDown) ? false : (!(this.utilisationUp != throttlingConfiguration$ThrottleSetting.utilisationUp))))))))));
  }
  
  @Deprecated
  public void setBandwidth(double paramDouble) {
    setBandwidthDown(paramDouble);
    setBandwidthUp(paramDouble);
  }
  
  public int getLatency() {
    return this.latency;
  }
  
  public void setLatency(int paramInt) {
    this.latency = paramInt;
  }
  
  @Deprecated
  public void setUtilisation(int paramInt) {
    setUtilisationDown(paramInt);
    setUtilisationUp(paramInt);
  }
  
  public int getMtu() {
    return this.mtu;
  }
  
  public void setMtu(int paramInt) {
    this.mtu = paramInt;
  }
  
  public int getReliability() {
    return this.reliability;
  }
  
  public void setReliability(int paramInt) {
    this.reliability = paramInt;
  }
  
  public int getStability() {
    return this.stability;
  }
  
  public void setStability(int paramInt) {
    this.stability = paramInt;
  }
  
  public int getLowQuality() {
    return this.lowQuality;
  }
  
  public void setLowQuality(int paramInt) {
    this.lowQuality = paramInt;
  }
  
  public int getHighQuality() {
    return this.highQuality;
  }
  
  public void setHighQuality(int paramInt) {
    this.highQuality = paramInt;
  }
  
  public double getBandwidthDown() {
    return this.bandwidthDown;
  }
  
  public void setBandwidthDown(double paramDouble) {
    this.bandwidthDown = paramDouble;
  }
  
  public double getBandwidthUp() {
    return this.bandwidthUp;
  }
  
  public void setBandwidthUp(double paramDouble) {
    this.bandwidthUp = paramDouble;
  }
  
  public int getUtilisationDown() {
    return this.utilisationDown;
  }
  
  public void setUtilisationDown(int paramInt) {
    this.utilisationDown = paramInt;
  }
  
  public int getUtilisationUp() {
    return this.utilisationUp;
  }
  
  public void setUtilisationUp(int paramInt) {
    this.utilisationUp = paramInt;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ThrottlingConfiguration$ThrottleSetting.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */