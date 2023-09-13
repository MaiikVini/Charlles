package com.xk72.util;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

class d implements ErrorReporter {
  d(c paramc) {}
  
  public void warning(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2) {}
  
  public EvaluatorException runtimeError(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2) {
    return new EvaluatorException(paramString1, paramString2, paramInt1, paramString3, paramInt2);
  }
  
  public void error(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2) {
    throw new EvaluatorException(paramString1, paramString2, paramInt1, paramString3, paramInt2);
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\d.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */