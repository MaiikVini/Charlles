package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.util.B;
import com.xk72.util.C;

@XStreamAlias("throttlePreset")
@B
@C
public class ThrottlingConfiguration$ThrottlePreset extends ThrottlingConfiguration$ThrottleSetting {
  private String name;
  
  public ThrottlingConfiguration$ThrottlePreset() {}
  
  public ThrottlingConfiguration$ThrottlePreset(String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.name = paramString;
  }
  
  public String toString() {
    return getName();
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public boolean contentEquals(ThrottlingConfiguration$ThrottleSetting paramThrottlingConfiguration$ThrottleSetting) {
    return (Double.doubleToLongBits(this.bandwidthDown) != Double.doubleToLongBits(paramThrottlingConfiguration$ThrottleSetting.bandwidthDown)) ? false : ((Double.doubleToLongBits(this.bandwidthUp) != Double.doubleToLongBits(paramThrottlingConfiguration$ThrottleSetting.bandwidthUp)) ? false : ((this.latency != paramThrottlingConfiguration$ThrottleSetting.latency) ? false : ((this.mtu != paramThrottlingConfiguration$ThrottleSetting.mtu) ? false : ((this.reliability != paramThrottlingConfiguration$ThrottleSetting.reliability) ? false : ((this.stability != paramThrottlingConfiguration$ThrottleSetting.stability) ? false : ((this.lowQuality != paramThrottlingConfiguration$ThrottleSetting.lowQuality) ? false : ((this.highQuality != paramThrottlingConfiguration$ThrottleSetting.highQuality) ? false : ((this.utilisationDown != paramThrottlingConfiguration$ThrottleSetting.utilisationDown) ? false : (!(this.utilisationUp != paramThrottlingConfiguration$ThrottleSetting.utilisationUp))))))))));
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ThrottlingConfiguration$ThrottlePreset.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */