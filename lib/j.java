package com.xk72.lib;

import com.xk72.charles.config.AbstractConfiguration;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;

public class j implements PropertyChangeListener {
  private final AbstractConfiguration n;
  
  private final WeakReference<PropertyChangeListener> a;
  
  public j(AbstractConfiguration paramAbstractConfiguration, PropertyChangeListener paramPropertyChangeListener) {
    this.n = paramAbstractConfiguration;
    this.a = new WeakReference<>(paramPropertyChangeListener);
  }
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent) {
    PropertyChangeListener propertyChangeListener = this.a.get();
    if (propertyChangeListener != null) {
      propertyChangeListener.propertyChange(paramPropertyChangeEvent);
    } else {
      this.n.removePropertyChangeListener(this);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\j.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */