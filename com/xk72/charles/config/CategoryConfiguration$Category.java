package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xk72.net.Location;
import com.xk72.net.Xsnk;
import com.xk72.util.B;
import com.xk72.util.C;
import com.xk72.util.F;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("category")
@B
@C
public class CategoryConfiguration$Category implements Xsnk {
  private boolean enabled = true;
  
  private Color color;
  
  private Location location;
  
  private List<CategoryConfiguration$CategoryCondition> conditions = new ArrayList<>();
  
  public CategoryConfiguration$Category clone() {
    CategoryConfiguration$Category categoryConfiguration$Category = new CategoryConfiguration$Category();
    categoryConfiguration$Category.color = this.color;
    categoryConfiguration$Category.location = this.location.clone();
    categoryConfiguration$Category.conditions = F.n(this.conditions);
    return categoryConfiguration$Category;
  }
  
  public Color getColor() {
    return this.color;
  }
  
  public void setColor(Color paramColor) {
    this.color = paramColor;
  }
  
  public Location getLocation() {
    return this.location;
  }
  
  public void setLocation(Location paramLocation) {
    this.location = paramLocation;
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.enabled = paramBoolean;
  }
  
  public List<CategoryConfiguration$CategoryCondition> getConditions() {
    return this.conditions;
  }
  
  public void setConditions(List<CategoryConfiguration$CategoryCondition> paramList) {
    this.conditions = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\CategoryConfiguration$Category.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */