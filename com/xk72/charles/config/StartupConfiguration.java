package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

@XStreamAlias("startup")
public class StartupConfiguration extends AbstractLegacySupportConfiguration {
  private boolean newSession = true;
  
  private boolean throttling;
  
  private boolean checkUpdates = true;
  
  private boolean maximised;
  
  private boolean fullscreen = false;
  
  private Rectangle mainWindow;
  
  private String currentDirectory;
  
  private Date lastCheckUpdates;
  
  private String currentProfile;
  
  private Level loggingLevel;
  
  public void loadLegacyProperties(Properties paramProperties) {
    setNewSession(getBooleanProperty(paramProperties, "startupNewSession", this.newSession));
    setThrottling(getBooleanProperty(paramProperties, "startupThrottling", this.throttling));
    setCurrentDirectory(paramProperties.getProperty("currentDirectory"));
  }
  
  public boolean isNewSession() {
    return this.newSession;
  }
  
  public void setNewSession(boolean paramBoolean) {
    this.newSession = paramBoolean;
  }
  
  public boolean isThrottling() {
    return this.throttling;
  }
  
  public void setThrottling(boolean paramBoolean) {
    this.throttling = paramBoolean;
  }
  
  public Rectangle getMainWindow() {
    return this.mainWindow;
  }
  
  public void setMainWindow(Rectangle paramRectangle) {
    this.mainWindow = paramRectangle;
  }
  
  public String getCurrentDirectory() {
    return this.currentDirectory;
  }
  
  public void setCurrentDirectory(String paramString) {
    this.currentDirectory = paramString;
  }
  
  public boolean isCheckUpdates() {
    return this.checkUpdates;
  }
  
  public void setCheckUpdates(boolean paramBoolean) {
    this.checkUpdates = paramBoolean;
  }
  
  public boolean isMaximised() {
    return this.maximised;
  }
  
  public void setMaximised(boolean paramBoolean) {
    this.maximised = paramBoolean;
  }
  
  public Date getLastCheckUpdates() {
    return this.lastCheckUpdates;
  }
  
  public void setLastCheckUpdates(Date paramDate) {
    this.lastCheckUpdates = paramDate;
  }
  
  public boolean isFullscreen() {
    return this.fullscreen;
  }
  
  public void setFullscreen(boolean paramBoolean) {
    this.fullscreen = paramBoolean;
  }
  
  public String getCurrentProfile() {
    return this.currentProfile;
  }
  
  public void setCurrentProfile(String paramString) {
    this.currentProfile = paramString;
  }
  
  public Level getLoggingLevel() {
    return this.loggingLevel;
  }
  
  public void setLoggingLevel(Level paramLevel) {
    Level level = this.loggingLevel;
    this.loggingLevel = paramLevel;
    this.propertyChangeSupport.firePropertyChange("loggingLevel", level, paramLevel);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\StartupConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */