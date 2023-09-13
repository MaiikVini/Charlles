package com.xk72.util.lexar;

import de.sciss.syntaxpane.DefaultSyntaxKit;
import de.sciss.syntaxpane.Lexer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CssSyntaxKit extends DefaultSyntaxKit {
  private static final long serialVersionUID = 1L;
  
  private static final Logger n = Logger.getLogger("com.xk72.util.lexar.CssSyntaxKit");
  
  public CssSyntaxKit() {
    super(n());
  }
  
  private static Lexer n() {
    try {
      return Class.forName("com.xk72.util.lexar.Xsnk").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Throwable throwable) {
      n.log(Level.SEVERE, "Failed to load lexer: " + throwable, throwable);
      return null;
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\lexar\CssSyntaxKit.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */