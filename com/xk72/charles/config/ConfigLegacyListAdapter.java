package com.xk72.charles.config;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ConfigLegacyListAdapter<T> implements ListAdapter<T> {
  private static final Logger LOG = Logger.getLogger("com.xk72.charles.config.ConfigLegacyListAdapter");
  
  private List<T> list = new ArrayList<>();
  
  public void add(Object paramObject) {
    Class<T> clazz = getBeanClass();
    if (paramObject != null)
      if (clazz.isInstance(paramObject)) {
        this.list.add((T)paramObject);
      } else {
        try {
          this.list.add((T)clazz.getMethod("valueOf", new Class[] { paramObject.getClass() }).invoke(null, new Object[] { paramObject }));
        } catch (IllegalAccessException illegalAccessException) {
          LOG.log(Level.WARNING, illegalAccessException.toString(), illegalAccessException);
        } catch (InvocationTargetException invocationTargetException) {
          LOG.log(Level.WARNING, invocationTargetException.toString(), invocationTargetException);
        } catch (NoSuchMethodException noSuchMethodException) {
          LOG.log(Level.WARNING, noSuchMethodException.toString(), noSuchMethodException);
        } 
      }  
  }
  
  public abstract Class<T> getBeanClass();
  
  public List<T> getList() {
    return this.list;
  }
  
  public void setList(List<T> paramList) {
    this.list = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ConfigLegacyListAdapter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */