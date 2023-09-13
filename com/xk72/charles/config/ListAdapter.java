package com.xk72.charles.config;

import com.xk72.util.B;
import com.xk72.util.C;
import java.util.List;

@B
@C
public interface ListAdapter<T> {
  List<T> getList();
  
  void setList(List<T> paramList);
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ListAdapter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */