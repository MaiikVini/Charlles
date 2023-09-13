package com.xk72.lib;

import com.xk72.charles.config.AbstractConfiguration;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;

public abstract class i<T> implements PropertyChangeListener {
  private final AbstractConfiguration n;
  
  private final WeakReference<T> a;
  
  public i(AbstractConfiguration paramAbstractConfiguration, T paramT) {
    this.n = paramAbstractConfiguration;
    this.a = new WeakReference<>(paramT);
  }
  
  public abstract void n(T paramT, PropertyChangeEvent paramPropertyChangeEvent);
  
  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent) {
    T t = this.a.get();
    if (t != null) {
      n(t, paramPropertyChangeEvent);
    } else {
      this.n.removePropertyChangeListener(this);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\lib\i.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */