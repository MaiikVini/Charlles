package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@XStreamAlias("throttling")
public class ThrottlingConfiguration extends AbstractLegacySupportConfiguration {
  private double bandwidthDown = 57.6D;
  
  private double bandwidthUp = 33.6D;
  
  private int utilisationDown = 70;
  
  private int utilisationUp = 70;
  
  private int latency = 250;
  
  private int reliability = 100;
  
  private int mtu = 576;
  
  private int lowQuality = 100;
  
  private int highQuality = 100;
  
  private int stability = 100;
  
  private List<ThrottlingConfiguration$ThrottlePreset> customPresets = new ArrayList<>();
  
  private ListAdapter<ThrottlingConfiguration$ThrottleHost> hosts = new ConfigLegacyListAdapter$ThrottleHostConfigationLegacyAdapter();
  
  private boolean selectedHosts;
  
  public static final ThrottlingConfiguration$PermanentThrottlePreset[] PRESETS = new ThrottlingConfiguration$PermanentThrottlePreset[] { 
      new ThrottlingConfiguration$PermanentThrottlePreset("56 kbps Modem", 57.6D, 33.6D, 70, 70, 250, 576), new ThrottlingConfiguration$PermanentThrottlePreset("256 kbps ISDN/DSL", 256.0D, 100, 40, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("512 kbps ISDN/DSL", 512.0D, 100, 40, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("2 Mbps ADSL", 2048.0D, 512.0D, 100, 100, 40, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("8 Mbps ADSL2", 8192.0D, 1024.0D, 100, 100, 40, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("16 Mbps ADSL2+", 16384.0D, 1024.0D, 100, 100, 20, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("32 Mbps VDSL", 32768.0D, 8192.0D, 100, 100, 20, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("32 Mbps Fibre", 32768.0D, 100, 4, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("100 Mbps Fibre", 102400.0D, 100, 4, 1500), new ThrottlingConfiguration$PermanentThrottlePreset("3G", 4096.0D, 1024.0D, 100, 100, 120, 576), 
      new ThrottlingConfiguration$PermanentThrottlePreset("4G", 16384.0D, 8192.0D, 100, 100, 80, 576) };
  
  public void loadLegacyProperties(Properties paramProperties) {
    setBandwidth(getDoubleProperty(paramProperties, "throttleBandwidth", this.bandwidthDown));
    setUtilisation(getIntProperty(paramProperties, "throttleUtilisation", this.utilisationDown));
    setLatency(getIntProperty(paramProperties, "throttleLatency", this.latency));
  }
  
  public List<ThrottlingConfiguration$ThrottlePreset> getCustomPresets() {
    return this.customPresets;
  }
  
  public void setCustomPresets(List<ThrottlingConfiguration$ThrottlePreset> paramList) {
    this.customPresets = paramList;
  }
  
  public boolean isSelectedHosts() {
    return this.selectedHosts;
  }
  
  public void setSelectedHosts(boolean paramBoolean) {
    this.selectedHosts = paramBoolean;
  }
  
  public ListAdapter<ThrottlingConfiguration$ThrottleHost> getHosts() {
    return this.hosts;
  }
  
  public void setHosts(ListAdapter<ThrottlingConfiguration$ThrottleHost> paramListAdapter) {
    this.hosts = paramListAdapter;
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
  
  public void configure(ThrottlingConfiguration$ThrottleSetting paramThrottlingConfiguration$ThrottleSetting) {
    setBandwidthDown(paramThrottlingConfiguration$ThrottleSetting.getBandwidthDown());
    setBandwidthUp(paramThrottlingConfiguration$ThrottleSetting.getBandwidthUp());
    setUtilisationDown(paramThrottlingConfiguration$ThrottleSetting.getUtilisationDown());
    setUtilisationUp(paramThrottlingConfiguration$ThrottleSetting.getUtilisationUp());
    setLatency(paramThrottlingConfiguration$ThrottleSetting.getLatency());
    setMtu(paramThrottlingConfiguration$ThrottleSetting.getMtu());
    setReliability(paramThrottlingConfiguration$ThrottleSetting.getReliability());
    setStability(paramThrottlingConfiguration$ThrottleSetting.getStability());
    setLowQuality(paramThrottlingConfiguration$ThrottleSetting.getLowQuality());
    setHighQuality(paramThrottlingConfiguration$ThrottleSetting.getHighQuality());
  }
  
  public ThrottlingConfiguration$ThrottleSetting getGlobalThrottleSetting() {
    ThrottlingConfiguration$ThrottleSetting throttlingConfiguration$ThrottleSetting = new ThrottlingConfiguration$ThrottleSetting();
    throttlingConfiguration$ThrottleSetting.setBandwidthDown(getBandwidthDown());
    throttlingConfiguration$ThrottleSetting.setBandwidthUp(getBandwidthUp());
    throttlingConfiguration$ThrottleSetting.setUtilisationDown(getUtilisationDown());
    throttlingConfiguration$ThrottleSetting.setUtilisationUp(getUtilisationUp());
    throttlingConfiguration$ThrottleSetting.setLatency(getLatency());
    throttlingConfiguration$ThrottleSetting.setMtu(getMtu());
    throttlingConfiguration$ThrottleSetting.setReliability(getReliability());
    throttlingConfiguration$ThrottleSetting.setStability(getStability());
    throttlingConfiguration$ThrottleSetting.setLowQuality(getLowQuality());
    throttlingConfiguration$ThrottleSetting.setHighQuality(getHighQuality());
    return throttlingConfiguration$ThrottleSetting;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ThrottlingConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */