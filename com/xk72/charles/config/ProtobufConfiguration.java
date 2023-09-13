package com.xk72.charles.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("protobuf")
public class ProtobufConfiguration extends AbstractConfiguration {
  private static final long DEFAULT_HEURISTIC_TTL = 300000L;
  
  private boolean hideUnvaluedFields = true;
  
  private boolean cacheDescriptors = true;
  
  private long heuristicTTL = 300000L;
  
  private List<ProtobufConfiguration$DescriptorFile> descriptors = new ArrayList<>();
  
  public boolean isHideUnvaluedFields() {
    return this.hideUnvaluedFields;
  }
  
  public void setHideUnvaluedFields(boolean paramBoolean) {
    this.hideUnvaluedFields = paramBoolean;
  }
  
  public boolean isCacheDescriptors() {
    return this.cacheDescriptors;
  }
  
  public void setCacheDescriptors(boolean paramBoolean) {
    this.cacheDescriptors = paramBoolean;
  }
  
  public long getHeuristicTTL() {
    return this.heuristicTTL;
  }
  
  public void setHeuristicTTL(long paramLong) {
    this.heuristicTTL = paramLong;
  }
  
  public List<ProtobufConfiguration$DescriptorFile> getDescriptors() {
    return this.descriptors;
  }
  
  public void setDescriptors(List<ProtobufConfiguration$DescriptorFile> paramList) {
    this.descriptors = paramList;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\config\ProtobufConfiguration.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */