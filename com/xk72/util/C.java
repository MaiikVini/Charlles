package com.xk72.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class c implements A {
  private static final Logger n = Logger.getLogger(c.class.getName());
  
  private final ScriptableObject a;
  
  private final Scriptable b;
  
  private final Function c;
  
  public c() {
    Context context = Context.enter();
    context.setOptimizationLevel(9);
    try {
      this.a = context.initStandardObjects(null, true);
      this.a.sealObject();
      this.b = context.newObject((Scriptable)this.a);
      this.b.put("indent_size", this.b, Integer.valueOf(1));
      this.b.put("indent_char", this.b, "\t");
      this.b.put("indent_level", this.b, Integer.valueOf(1));
      InputStream inputStream = c.class.getResourceAsStream("/jsbeautifier/beautify.js");
      try {
        String str = w.n(inputStream, "UTF-8");
        this.c = context.compileFunction((Scriptable)this.a, str, null, 1, null);
        if (inputStream != null)
          inputStream.close(); 
      } catch (Throwable throwable) {
        if (inputStream != null)
          try {
            inputStream.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (RhinoException rhinoException) {
      throw new IllegalStateException("Could not load the jsbeautifier JavaScript", rhinoException);
    } catch (IOException iOException) {
      throw new IllegalStateException("Could not load the jsbeautifier JavaScript", iOException);
    } finally {
      Context.exit();
    } 
  }
  
  public String n(String paramString) {
    if (b(paramString) || a(paramString)) {
      Context context = Context.enter();
      try {
        return this.c.call(context, (Scriptable)this.a, null, new Object[] { paramString, this.b }).toString();
      } catch (RhinoException rhinoException) {
        n.log(Level.INFO, "Error occurred formatting script: " + rhinoException.getMessage(), (Throwable)rhinoException);
      } finally {
        Context.exit();
      } 
    } 
    return paramString;
  }
  
  private boolean a(String paramString) {
    return b("var result = " + paramString);
  }
  
  private boolean b(String paramString) {
    Context context = Context.enter();
    context.setOptimizationLevel(-1);
    context.setLanguageVersion(150);
    context.setErrorReporter(new d(this));
    try {
      Script script = context.compileString(paramString, null, 1, null);
      if (script != null)
        return true; 
    } catch (RhinoException rhinoException) {
      n.log(Level.FINER, "Script is not valid, error occurred compiling script: " + rhinoException.getMessage(), (Throwable)rhinoException);
    } finally {
      Context.exit();
    } 
    return false;
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\c.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */