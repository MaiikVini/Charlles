package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("categories")
public class CategoryConfiguration extends AbstractConfiguration {
  private List<CategoryConfiguration$Category> categories = new ArrayList<>();
  
  public List<CategoryConfiguration$Category> getCategories() {
    return this.categories;
  }
  
  public void setCategories(List<CategoryConfiguration$Category> paramList) {
    this.categories = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\CategoryConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */