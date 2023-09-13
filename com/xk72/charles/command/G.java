package com.xk72.charles.command;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.l;
import com.xk72.charles.model.Session;
import java.io.File;
import java.io.IOException;

public class G implements Xsnk {
  private CharlesContext n;
  
  private String[] a;
  
  public G(String[] paramArrayOfString) {
    this.a = paramArrayOfString;
  }
  
  public void run() {
    Session session;
    if (this.a.length != 2) {
      System.err.println("Usage: convert <infile> <outfile>");
      System.exit(1);
    } 
    l l = this.n.getFileManager();
    try {
      session = l.n(new File(this.a[0]));
    } catch (IOException iOException) {
      System.err.println(iOException.getMessage());
      System.exit(1);
      return;
    } 
    File file = new File(this.a[1]);
    if (file.exists()) {
      System.err.println("Output file already exists: " + this.a[1]);
      System.exit(1);
      return;
    } 
    try {
      if (!l.n(session, file)) {
        System.err.println("Unsupported output file type: " + file.getName());
        System.exit(1);
        return;
      } 
    } catch (IOException iOException) {
      System.err.println(iOException.getMessage());
      System.exit(1);
      return;
    } 
    System.exit(0);
  }
  
  public void n(CharlesContext paramCharlesContext) {
    this.n = paramCharlesContext;
  }
  
  public static void n() {
    System.out.println("Convert");
    System.out.println("=======");
    System.out.println("Convert saved Charles sessions between formats.");
    System.out.println();
    System.out.println("Usage: convert <infile> <outfile>");
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk72\charles\command\G.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */