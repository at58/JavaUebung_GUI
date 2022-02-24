package gui.projects;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class encryptedReader extends FilterReader {

  public encryptedReader(Reader in){  //Konstruktoraufruf der Basisklasse // erwartet einen Reader
    super(in);
  }
  public int read() throws IOException{
    return super.read() -1;
    /*
     verschiebt das gelesene Zeichen wieder um eine Position im Unicode zurück.
     */
  }

  public int read (char[] c, int offset, int length) throws IOException{
    //Schritt 1: Original-Daten einlesen
    int result = super.read(c, offset, length);
    /*
    Zeichen werden in das Char-Array c eingelesen
    und in result wird die Anzahl der gelesenen Zeichen gespeichert.
     */
    // Schritt 2: Dekodieren (die Verschlüsselung wird wieder entschlüsselt)
    for (var i = 0; i < result; i++){
      c[i + offset] = (char) ((c[i + offset]) -1); // (char) = Explizite Typumwandlung zu Char
      /*
      Der Code jedes Zeichens des char-Arrays wird um 1 reduziert
      und anschließend wieder in den Datentyp char umgewandelt.
       */
    }
    return result;  //Anzahl gelesener Zeichen zurückliefern
  }
}
