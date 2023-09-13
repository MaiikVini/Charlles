package com.xk72.e;

import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final Field n;
  
  public static void n(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (paramJSONObject instanceof Xsnk) {
      ((Xsnk)paramJSONObject).n(paramString1, paramString2);
    } else {
      if (paramJSONObject.has(paramString2))
        throw new JSONException("Name '" + paramString2 + "' already exists."); 
      paramJSONObject.put(paramString2, paramJSONObject.remove(paramString1));
    } 
  }
  
  public static void n(JSONArray paramJSONArray, int paramInt) {
    if (paramInt < 0)
      throw new JSONException("JSONArray[" + paramInt + "] not found."); 
    if (paramInt < paramJSONArray.length())
      n(paramJSONArray).remove(paramInt); 
  }
  
  private static List<?> n(JSONArray paramJSONArray) {
    try {
      return (List)n.get(paramJSONArray);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } 
  }
  
  public static void n(JSONArray paramJSONArray, int paramInt, Object paramObject) {
    if (paramInt < 0)
      throw new JSONException("JSONArray[" + paramInt + "] not found."); 
    if (paramInt < paramJSONArray.length()) {
      List<?> list = n(paramJSONArray);
      list.add(paramInt, null);
      try {
        paramJSONArray.put(paramInt, paramObject);
      } catch (JSONException jSONException) {
        list.remove(paramInt);
        throw jSONException;
      } catch (RuntimeException runtimeException) {
        list.remove(paramInt);
        throw runtimeException;
      } 
    } else {
      paramJSONArray.put(paramInt, paramObject);
    } 
  }
  
  public static void n(JSONArray paramJSONArray, int paramInt1, int paramInt2) {
    Object object1 = paramJSONArray.get(paramInt1);
    Object object2 = paramJSONArray.get(paramInt2);
    paramJSONArray.put(paramInt1, object2);
    paramJSONArray.put(paramInt2, object1);
  }
  
  public static Object n(String paramString) {
    if (paramString.length() == 0)
      return ""; 
    try {
      return (new G(paramString)).nextValue();
    } catch (JSONException jSONException) {
      if (paramString.charAt(0) == '"' && paramString.indexOf('"', 1) < 0)
        try {
          return (new G(paramString + "\"")).nextValue();
        } catch (JSONException jSONException1) {} 
      if (paramString.charAt(0) == '\'' && paramString.indexOf('\'', 1) < 0)
        try {
          return (new G(paramString + "'")).nextValue();
        } catch (JSONException jSONException1) {} 
      throw jSONException;
    } 
  }
  
  public static String n(Object paramObject) {
    if (paramObject instanceof Number)
      try {
        return JSONObject.numberToString((Number)paramObject);
      } catch (JSONException jSONException) {
        return "0";
      }  
    return (paramObject instanceof String) ? JSONObject.quote((String)paramObject) : String.valueOf(paramObject);
  }
  
  static {
    try {
      n = JSONArray.class.getDeclaredField("myArrayList");
      n.setAccessible(true);
    } catch (SecurityException securityException) {
      throw new RuntimeException(securityException);
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new RuntimeException(noSuchFieldException);
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\e\a.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */