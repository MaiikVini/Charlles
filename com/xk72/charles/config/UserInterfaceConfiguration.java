package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@XStreamAlias("userInterface")
public class UserInterfaceConfiguration extends AbstractLegacySupportConfiguration {
  public static final int BYTES_PER_SECOND = 0;
  
  public static final int BITS_PER_SECOND = 1;
  
  public static final int TIME_IN_SECONDS = 0;
  
  public static final int TIME_IN_MILLIS = 1;
  
  private String displayFont;
  
  private Integer lookAndFeelFontSize;
  
  private Integer displayFontSize;
  
  private boolean promptToSaveSessions;
  
  private boolean promptToClearSession = false;
  
  private boolean showLineNumbers = true;
  
  private boolean lineWrap = true;
  
  private boolean autoScroll = true;
  
  private boolean combineHeadersAndBody = true;
  
  private boolean combineRequestAndResponse = true;
  
  private boolean minimiseToTray = false;
  
  private boolean showMemoryUsage = false;
  
  private boolean enableHotkeys = true;
  
  private boolean alwaysOnTop = false;
  
  private boolean showTrayIcon = true;
  
  private boolean highlightTreeChanges = true;
  
  private boolean sequenceFocused = false;
  
  private int sessionNavStructureLayout = 0;
  
  private int sessionNavSequenceLayout = 1;
  
  private int unitsSpeed = 0;
  
  private int unitsTime = 0;
  
  private Map<String, Boolean> warningsSeen = new HashMap<>();
  
  private Map<String, Object> properties = new HashMap<>();
  
  public void loadLegacyProperties(Properties paramProperties) {
    setDisplayFont(paramProperties.getProperty("displayFont"));
    int i = getIntProperty(paramProperties, "displayFontSize", 0);
    if (i > 0) {
      this.displayFontSize = Integer.valueOf(i);
    } else {
      this.displayFontSize = null;
    } 
    setPromptToSaveSessions(getBooleanProperty(paramProperties, "promptToSaveSessions", this.promptToSaveSessions));
    setPromptToClearSession(getBooleanProperty(paramProperties, "promptToClearSessions", this.promptToClearSession));
  }
  
  public String getDisplayFont() {
    return this.displayFont;
  }
  
  public void setDisplayFont(String paramString) {
    this.displayFont = paramString;
  }
  
  public Integer getDisplayFontSize() {
    return this.displayFontSize;
  }
  
  public void setDisplayFontSize(Integer paramInteger) {
    this.displayFontSize = paramInteger;
  }
  
  public Integer getLookAndFeelFontSize() {
    return this.lookAndFeelFontSize;
  }
  
  public void setLookAndFeelFontSize(Integer paramInteger) {
    this.lookAndFeelFontSize = paramInteger;
  }
  
  public boolean isPromptToClearSession() {
    return this.promptToClearSession;
  }
  
  public void setPromptToClearSession(boolean paramBoolean) {
    this.promptToClearSession = paramBoolean;
  }
  
  public boolean isPromptToSaveSessions() {
    return this.promptToSaveSessions;
  }
  
  public void setPromptToSaveSessions(boolean paramBoolean) {
    this.promptToSaveSessions = paramBoolean;
  }
  
  public Map<String, Boolean> getWarningsSeen() {
    return this.warningsSeen;
  }
  
  public void setWarningsSeen(Map<String, Boolean> paramMap) {
    this.warningsSeen = paramMap;
  }
  
  public boolean alreadyWarned(String paramString) {
    return this.warningsSeen.containsKey(paramString);
  }
  
  public void changeWarned(String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      this.warningsSeen.put(paramString, Boolean.TRUE);
    } else {
      this.warningsSeen.remove(paramString);
    } 
  }
  
  public boolean isShowLineNumbers() {
    return this.showLineNumbers;
  }
  
  public void setShowLineNumbers(boolean paramBoolean) {
    this.showLineNumbers = paramBoolean;
  }
  
  public boolean isLineWrap() {
    return this.lineWrap;
  }
  
  public void setLineWrap(boolean paramBoolean) {
    this.lineWrap = paramBoolean;
  }
  
  public boolean isAutoScroll() {
    return this.autoScroll;
  }
  
  public void setAutoScroll(boolean paramBoolean) {
    boolean bool = this.autoScroll;
    this.autoScroll = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("autoScroll", bool, paramBoolean); 
  }
  
  public boolean isSequenceFocused() {
    return this.sequenceFocused;
  }
  
  public void setSequenceFocused(boolean paramBoolean) {
    boolean bool = this.sequenceFocused;
    this.sequenceFocused = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("sequenceFocused", bool, paramBoolean); 
  }
  
  @Deprecated
  public void setSessionFrameHorizontalLayout(boolean paramBoolean) {
    setSessionNavStructureLayout(paramBoolean ? 0 : 1);
  }
  
  public int getSessionNavSequenceLayout() {
    return this.sessionNavSequenceLayout;
  }
  
  public void setSessionNavSequenceLayout(int paramInt) {
    int i = this.sessionNavSequenceLayout;
    this.sessionNavSequenceLayout = paramInt;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("sessionNavSequenceLayout", i, paramInt); 
  }
  
  public int getSessionNavStructureLayout() {
    return this.sessionNavStructureLayout;
  }
  
  public void setSessionNavStructureLayout(int paramInt) {
    int i = this.sessionNavStructureLayout;
    this.sessionNavStructureLayout = paramInt;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("sessionNavStructureLayout", i, paramInt); 
  }
  
  public boolean isCombineHeadersAndBody() {
    return this.combineHeadersAndBody;
  }
  
  public void setCombineHeadersAndBody(boolean paramBoolean) {
    boolean bool = this.combineHeadersAndBody;
    this.combineHeadersAndBody = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("combineHeadersAndBody", bool, paramBoolean); 
  }
  
  public Map<String, Object> getProperties() {
    return this.properties;
  }
  
  public void setProperties(Map<String, Object> paramMap) {
    this.properties = paramMap;
  }
  
  public int getIntProperty(String paramString, int paramInt) {
    Integer integer = getPropertyInternal(paramString, Integer.class);
    return (integer != null) ? integer.intValue() : paramInt;
  }
  
  public void setIntProperty(String paramString, int paramInt) {
    setPropertyInternal(paramString, Integer.valueOf(paramInt));
  }
  
  public boolean getBooleanProperty(String paramString, boolean paramBoolean) {
    Boolean bool = getPropertyInternal(paramString, Boolean.class);
    return (bool != null) ? bool.booleanValue() : paramBoolean;
  }
  
  public void setBooleanProperty(String paramString, boolean paramBoolean) {
    setPropertyInternal(paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE);
  }
  
  public String getStringProperty(String paramString1, String paramString2) {
    String str = getPropertyInternal(paramString1, String.class);
    return (str != null) ? str : paramString2;
  }
  
  public void setStringProperty(String paramString1, String paramString2) {
    setPropertyInternal(paramString1, paramString2);
  }
  
  public <T extends UserInterfaceConfiguration$UserInterfaceProperty> T getProperty(String paramString, Class<T> paramClass) {
    return (T)getPropertyInternal(paramString, paramClass);
  }
  
  public void setProperty(String paramString, UserInterfaceConfiguration$UserInterfaceProperty paramUserInterfaceConfiguration$UserInterfaceProperty) {
    setPropertyInternal(paramString, paramUserInterfaceConfiguration$UserInterfaceProperty);
  }
  
  private <T> T getPropertyInternal(String paramString, Class<T> paramClass) {
    Object object = this.properties.get(paramString);
    return (T)(paramClass.isInstance(object) ? object : null);
  }
  
  private void setPropertyInternal(String paramString, Object paramObject) {
    Object object = this.properties.get(paramString);
    this.properties.put(paramString, paramObject);
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange(paramString, object, paramObject); 
  }
  
  public boolean isMinimiseToTray() {
    return this.minimiseToTray;
  }
  
  public void setMinimiseToTray(boolean paramBoolean) {
    this.minimiseToTray = paramBoolean;
  }
  
  public boolean isShowTrayIcon() {
    return this.showTrayIcon;
  }
  
  public void setShowTrayIcon(boolean paramBoolean) {
    boolean bool = this.showTrayIcon;
    this.showTrayIcon = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("showTrayIcon", bool, paramBoolean); 
  }
  
  public boolean isShowMemoryUsage() {
    return this.showMemoryUsage;
  }
  
  public void setShowMemoryUsage(boolean paramBoolean) {
    boolean bool = this.showMemoryUsage;
    this.showMemoryUsage = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("showMemoryUsage", bool, paramBoolean); 
  }
  
  public boolean isCombineRequestAndResponse() {
    return this.combineRequestAndResponse;
  }
  
  public void setCombineRequestAndResponse(boolean paramBoolean) {
    boolean bool = this.combineRequestAndResponse;
    this.combineRequestAndResponse = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("combineRequestAndResponse", bool, paramBoolean); 
  }
  
  public boolean isEnableHotkeys() {
    return this.enableHotkeys;
  }
  
  public void setEnableHotkeys(boolean paramBoolean) {
    boolean bool = this.enableHotkeys;
    this.enableHotkeys = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("enableHotkeys", bool, paramBoolean); 
  }
  
  public int getUnitsSpeed() {
    return this.unitsSpeed;
  }
  
  public void setUnitsSpeed(int paramInt) {
    this.unitsSpeed = paramInt;
  }
  
  public int getUnitsTime() {
    return this.unitsTime;
  }
  
  public void setUnitsTime(int paramInt) {
    this.unitsTime = paramInt;
  }
  
  public boolean isAlwaysOnTop() {
    return this.alwaysOnTop;
  }
  
  public void setAlwaysOnTop(boolean paramBoolean) {
    boolean bool = this.alwaysOnTop;
    this.alwaysOnTop = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("alwaysOnTop", bool, paramBoolean); 
  }
  
  public boolean isHighlightTreeChanges() {
    return this.highlightTreeChanges;
  }
  
  public void setHighlightTreeChanges(boolean paramBoolean) {
    boolean bool = this.highlightTreeChanges;
    this.highlightTreeChanges = paramBoolean;
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.firePropertyChange("highlightTreeChanges", bool, paramBoolean); 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\UserInterfaceConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */