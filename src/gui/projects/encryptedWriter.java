package gui.projects;

import java.io.FilterWriter;
import java.io.Writer;
import java.io.IOException;

public class encryptedWriter extends FilterWriter {

  public encryptedWriter(Writer out){ // Konstruktoraufruf der Basisklasse//erwartet ein Writer-Objekt
    super(out);
  }

  public void write(int c) throws IOException{
    super.write(c +1);
    /*
    Schreibt anstellen des Zeichens c das um eine Position im Unicode
    nach hinten verschobene Zeichen
     */
  }

  public void write(char[] c, int offset, int count) throws IOException {
    for (var i = 0; i<count; i++){
      write(c[offset + i]);
    }
  }

  public void write(char[] c) throws IOException{
    write(c,0,c.length);
  }

  public void write(String s, int offset, int count) throws IOException{
    for (var i=0; i<count; i++){
      write(s.charAt(offset + i));
    }
  }

  public void write(String s) throws IOException{
    write(s,0,s.length());
  }
}
