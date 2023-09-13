package com.xk72.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class w {
  private static final int n = 8192;
  
  public static boolean n(File paramFile) {
    if (!paramFile.isDirectory() && !paramFile.mkdirs())
      return false; 
    File file = new File(paramFile, String.valueOf(System.currentTimeMillis()) + ".tmp");
    try {
      return file.createNewFile();
    } catch (IOException iOException) {
      return false;
    } finally {
      file.delete();
    } 
  }
  
  public static void n(File paramFile, x paramx) {
    if (paramFile.getParentFile() != null && !paramFile.getParentFile().exists())
      paramFile.getParentFile().mkdirs(); 
    File file = File.createTempFile("charles", null);
    try {
      paramx.n(file);
    } catch (IOException iOException) {
      file.delete();
      throw iOException;
    } catch (RuntimeException runtimeException) {
      file.delete();
      throw runtimeException;
    } 
    if (!file.renameTo(paramFile)) {
      if (paramFile.exists() && paramFile.delete() && file.renameTo(paramFile))
        return; 
      n(file, paramFile);
      file.delete();
    } 
  }
  
  public static void n(File paramFile1, File paramFile2) {
    a(new FileInputStream(paramFile1), new FileOutputStream(paramFile2));
  }
  
  public static void n(InputStream paramInputStream, OutputStream paramOutputStream) {
    n(paramInputStream, paramOutputStream, 8192);
  }
  
  public static void n(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) {
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    for (i = paramInputStream.read(arrayOfByte, 0, paramInt); i != -1; i = paramInputStream.read(arrayOfByte, 0, paramInt))
      paramOutputStream.write(arrayOfByte, 0, i); 
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream) {
    try {
      try {
        n(paramInputStream, paramOutputStream);
      } finally {
        paramInputStream.close();
      } 
    } finally {
      paramOutputStream.close();
    } 
  }
  
  public static String n(InputStream paramInputStream, String paramString) {
    StringWriter stringWriter = new StringWriter();
    try {
      InputStreamReader inputStreamReader = (paramString != null) ? new InputStreamReader(paramInputStream, paramString) : new InputStreamReader(paramInputStream);
      try {
        char[] arrayOfChar = new char[8192];
        int i;
        for (i = inputStreamReader.read(arrayOfChar, 0, 8192); i != -1; i = inputStreamReader.read(arrayOfChar, 0, 8192))
          stringWriter.write(arrayOfChar, 0, i); 
        String str = stringWriter.toString();
        if (inputStreamReader != null)
          inputStreamReader.close(); 
        stringWriter.close();
        return str;
      } catch (Throwable throwable) {
        if (inputStreamReader != null)
          try {
            inputStreamReader.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (Throwable throwable) {
      try {
        stringWriter.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      } 
      throw throwable;
    } 
  }
  
  public static int n(InputStream paramInputStream, byte[] paramArrayOfbyte) {
    int i = 0;
    int j = paramArrayOfbyte.length - i;
    int k;
    for (k = paramInputStream.read(paramArrayOfbyte, i, j); k != -1 && j > 0; k = paramInputStream.read(paramArrayOfbyte, i, j)) {
      i += k;
      j -= k;
    } 
    return i;
  }
  
  public static void n(InputStream paramInputStream, File paramFile) {
    ZipInputStream zipInputStream = new ZipInputStream(paramInputStream);
    for (ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
      File file = new File(paramFile, zipEntry.getName());
      if (zipEntry.isDirectory()) {
        file.mkdir();
      } else {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
          n(zipInputStream, fileOutputStream);
          fileOutputStream.close();
        } catch (Throwable throwable) {
          try {
            fileOutputStream.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          } 
          throw throwable;
        } 
      } 
    } 
  }
}


/* Location:              C:\Program Files\Charles\lib\charles.jar!\com\xk7\\util\w.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */