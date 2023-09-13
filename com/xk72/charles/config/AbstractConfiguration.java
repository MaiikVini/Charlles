package com.xk72.charles.config;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractConfiguration implements Configuration {
  protected transient PropertyChangeSupport propertyChangeSupport;
  
  public void init(CharlesConfiguration paramCharlesConfiguration) {}
  
  public synchronized void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener) {
    if (this.propertyChangeSupport == null)
      this.propertyChangeSupport = new PropertyChangeSupport(this); 
    this.propertyChangeSupport.addPropertyChangeListener(paramPropertyChangeListener);
  }
  
  public synchronized void addPropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener) {
    if (this.propertyChangeSupport == null)
      this.propertyChangeSupport = new PropertyChangeSupport(this); 
    this.propertyChangeSupport.addPropertyChangeListener(paramString, paramPropertyChangeListener);
  }
  
  public synchronized void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener) {
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.removePropertyChangeListener(paramPropertyChangeListener); 
  }
  
  public synchronized void removePropertyChangeListener(String paramString, PropertyChangeListener paramPropertyChangeListener) {
    if (this.propertyChangeSupport != null)
      this.propertyChangeSupport.removePropertyChangeListener(paramString, paramPropertyChangeListener); 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\AbstractConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */