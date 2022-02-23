import java.awt.EventQueue;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import javax.swing.ListSelectionModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;

public class KontaktlisteMitSpeichern extends JFrame {

  private final JTextField tfNachname;
  private final JTextField tfVorname;
  private final JTextField tfTelefon;
  private final JTextField tfEmail;
  private DefaultListModel<String> kontakteModel;
  private final ArrayList<String> pflichtangaben = new ArrayList<>();
  private final String dateiPfad = "." + File.separator + "meine Kontakte.txt";
  private final File datei = new File(dateiPfad);
  /*
  Die absolute Pfadangabe mit / als Trennzeichen kann durch die Konstante File.separator ersetzt werden.
  File.separator dient dazu, plattformunabhängig immer das korrekte Trennzeichen für Pfadangaben auszugeben.
   */

  /*
   * Launch the Application
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        KontaktlisteMitSpeichern frame = new KontaktlisteMitSpeichern();
        frame.setVisible(true);
      } catch(Exception e) {
        e.printStackTrace();
      }
    });
  }

  /*
   * Create the Frame
   */
  public KontaktlisteMitSpeichern() {

    setTitle("Kontaktliste");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 543, 340);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblNachname = new JLabel("Nachname *");
    lblNachname.setBounds(10, 11, 105, 14);
    contentPane.add(lblNachname);

    tfNachname = new JTextField();
    tfNachname.setBounds(10, 27, 131, 20);
    contentPane.add(tfNachname);
    tfNachname.setColumns(10);

    JLabel lblVorname = new JLabel("Vorname *");
    lblVorname.setBounds(154, 11, 87, 14);
    contentPane.add(lblVorname);

    tfVorname = new JTextField();
    tfVorname.setBounds(155, 27, 131, 20);
    contentPane.add(tfVorname);
    tfVorname.setColumns(10);

    JLabel lblTelefon = new JLabel("Telefon");
    lblTelefon.setBounds(300, 11, 116, 14);
    contentPane.add(lblTelefon);

    tfTelefon = new JTextField();
    tfTelefon.setBounds(296, 27, 218, 20);
    contentPane.add(tfTelefon);
    tfTelefon.setColumns(10);

    JLabel lblEmail = new JLabel("EMail *");
    lblEmail.setBounds(10, 58, 131, 14);
    contentPane.add(lblEmail);

    tfEmail = new JTextField();
    tfEmail.setBounds(10, 74, 276, 20);
    contentPane.add(tfEmail);
    tfEmail.setColumns(10);

    JLabel lblPflichtfelder = new JLabel("* Pflichtfelder!");
    lblPflichtfelder.setBounds(10, 258, 87, 23);
    contentPane.add(lblPflichtfelder);

    JButton btnUebernehmen = new JButton("Übernehmen >>");
    btnUebernehmen.addActionListener(e ->  {
        if (tfNachname.getText().isEmpty()) {
           pflichtangaben.add("Nachname");
        }
        if (tfVorname.getText().isEmpty()) {
          pflichtangaben.add("Vorname");
        }
        if (tfEmail.getText().isEmpty()) {
          pflichtangaben.add("E-Mail");
        }
        if (pflichtangaben.size()>0){
          JOptionPane.showMessageDialog(null, "Die Felder: "+ pflichtangaben + " sind Pflichtfelder!");
        }
        else {
          kontakteModel.addElement(tfNachname.getText() + "; "
                                       + tfVorname.getText() + "; " + tfTelefon.getText() + "; "
                                       + tfEmail.getText());
          tfNachname.setText(""); // Die Textfelder wieder leeren.
          tfVorname.setText("");
          tfTelefon.setText("");
          tfEmail.setText("");
          tfNachname.requestFocus();
          pflichtangaben.clear();
        }
    });
    btnUebernehmen.setBounds(300, 73, 214, 23);
    contentPane.add(btnUebernehmen);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 119, 504, 105);
    contentPane.add(scrollPane);

    JList<String> listKontakte = new JList<>();
    listKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Die Markierung von nur einem Eintrag erlauben
    scrollPane.setViewportView(listKontakte);

    JLabel lblKontaktliste = new JLabel("Kontaktliste");
    lblKontaktliste.setBounds(10, 105, 131, 14);
    contentPane.add(lblKontaktliste);

    JButton btnEnde = new JButton("Ende");
    btnEnde.addActionListener(e -> {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(datei))){
          for (int i = 0; i < kontakteModel.getSize(); i++){
            out.write(kontakteModel.get(i));
            out.newLine();
          }
        } catch(IOException ex) {
          ex.printStackTrace();
        }
        System.exit(0);

    });
    btnEnde.setBounds(425, 235, 89, 23);
    contentPane.add(btnEnde);

    JButton btnSpeichern = new JButton("Speichern");
    btnSpeichern.addActionListener(e ->  {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(datei))){
          for (int i = 0; i < kontakteModel.getSize(); i++){
            out.write(kontakteModel.get(i));
            out.newLine();
          }
        } catch (IOException ex2) {
          ex2.printStackTrace();
        }
    });
    btnSpeichern.setBounds(429, 272, 85, 21);
    contentPane.add(btnSpeichern);

    kontakteModel = new DefaultListModel<>();
    listKontakte.setModel(kontakteModel);

    JButton btnLoeschen = new JButton("markierten Eintrag l\u00F6schen");
    btnLoeschen.addActionListener(e -> {
      int index = listKontakte.getSelectedIndex();	// Liefert die Position des Markierten Eintrages zurück
      if (index >= 0) {
        kontakteModel.remove(index);
      } else {
        JOptionPane.showMessageDialog(null, "Kein Eintrag markiert!");
      }
    });
    btnLoeschen.setBounds(10, 235, 191, 23);
    contentPane.add(btnLoeschen);

    JButton btnBearbeiten = new JButton("bearbeiten");
    btnBearbeiten.addActionListener(e -> {
      int index = listKontakte.getSelectedIndex();	// liefert die Position des markierten Eintrag zurück
      if (index >= 0) {
        String zeile = kontakteModel.getElementAt(index);	// Die Rückgabe mit (String) in einen String casten
        tfNachname.setText(zeile.substring(0, zeile.indexOf(";")));	// substring() extrahiert Zeichen von Index 0 bis zum Index wo das erste Semikolon auftaucht
        zeile = zeile.substring(zeile.indexOf(";") + 1); // Verkürzt den gespeicherten String um den vorherigen Eintrag, also wird der String extrahiert ab Index, wo ; steht bis zur länge der restlichen Zeile
        tfVorname.setText(zeile.substring(0, zeile.indexOf(";")));		// Hier ist die Zeile bereits um den vorherigen Eintrag gekürzt
        zeile = zeile.substring(zeile.indexOf(";") + 1);	// Wiederholung der Prozedur
        tfTelefon.setText(zeile.substring(0, zeile.indexOf(";")));
        zeile = zeile.substring(zeile.indexOf(";") + 1);
        tfEmail.setText(zeile);		// Der gespeicherte String in zeile besteht nur noch aus dem Eintrag der Email-Adresse
        kontakteModel.remove(index);	// Zum Schluss wird der markierte Eintrag gelöscht, da er ja verändert neu gespeichert wurde.
      }
    });
    btnBearbeiten.setBounds(247, 235, 124, 23);
    contentPane.add(btnBearbeiten);
  }
}