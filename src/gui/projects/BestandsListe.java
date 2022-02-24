package gui.projects;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import javax.swing.JList; //*
import javax.swing.DefaultListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane; //* 

import java.util.ArrayList;


public class BestandsListe extends JFrame {
	
	private JTextField tfArtikel;
	private JTextField tfAnzahl;
	
	private ArrayList<String> Artikel = new ArrayList<>();
	private ArrayList<Double> Preis = new ArrayList<>();

	
  /*
  Launch the Application
   */
  public static void main(String[] args){

    EventQueue.invokeLater(()-> {
      try{
        BestandsListe frame = new BestandsListe();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /*
  Create the frame
   */
  public BestandsListe(){
  	setForeground(Color.GRAY);
  	setFont(new Font("Arial", Font.ITALIC, 13));
  	setBackground(Color.MAGENTA);
    setTitle("Bestandserfassung | Bestellerfassung");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100, 100, 700, 400);
    
    Font arial = new Font("Arial", Font.ITALIC + Font.PLAIN, 11);
    DecimalFormat decimal = new DecimalFormat("###,##0.000");

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(10,10,10,10));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblArtikel = new JLabel("Artikel");
    lblArtikel.setFont(arial);
    lblArtikel.setBounds(10, 10, 42, 24);
    contentPane.add(lblArtikel);
    
    tfArtikel = new JTextField();
    tfArtikel.setBounds(10, 28, 104, 19);
    contentPane.add(tfArtikel);
    tfArtikel.setColumns(10);
    
    JLabel lblOptionen = new JLabel("Optionen");
    lblOptionen.setFont(arial);
    lblOptionen.setBounds(10, 55, 62, 13);
    contentPane.add(lblOptionen);
    
    JButton btnLoeschen = new JButton("Entfernen");
    btnLoeschen.setFont(arial);
    btnLoeschen.setBounds(10, 131, 85, 21);
    contentPane.add(btnLoeschen);
    
    JButton btnVersenden = new JButton("Versenden");
    btnVersenden.setFont(new Font("Arial", Font.ITALIC, 10));
    btnVersenden.setBounds(10, 100, 85, 21);
    contentPane.add(btnVersenden);
    
    JButton btnBestellen = new JButton("Bestellen");
    btnBestellen.setBounds(10, 69, 85, 21);
    contentPane.add(btnBestellen);
    
    JLabel lblAnzahl = new JLabel("Anzahl");
    lblAnzahl.setBounds(125, 16, 45, 13);
    contentPane.add(lblAnzahl);
    
    tfAnzahl = new JTextField();
    tfAnzahl.setBounds(124, 28, 96, 19);
    contentPane.add(tfAnzahl);
    tfAnzahl.setColumns(10);
    
    JLabel lblBestand = new JLabel("Lager-Bestand");
    lblBestand.setBounds(445, 16, 85, 13);
    contentPane.add(lblBestand);
    
    JScrollPane scrollBestand = new JScrollPane();
    scrollBestand.setBounds(445, 28, 231, 325);
    contentPane.add(scrollBestand);
    
    JList<String> listBestand = new JList<>();
    listBestand.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    listBestand.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listBestand.setBounds(445, 30, 231, 323);
    scrollBestand.setViewportView(listBestand); //JList wird in JScrollPane integriert
    
    DefaultListModel<String> bestandModel = new DefaultListModel<>();
    listBestand.setModel(bestandModel);
    
    
    
    
    

  }
  public double rabatt(int prozentsatz) {
	  double rabattSumme = this.rabatt(prozentsatz) * prozentsatz;
	  return rabattSumme;
  }
  
  public double steuerBetrag(double nettopreis) {
	  double steuersatz = 0.19;
	  double steuern = nettopreis * steuersatz;
	  return steuern;
  }
  
  public double bruttoPreis(double nettoPreis) {
	  double steuersatz = 0.19;
	  double bruttoPreis = nettoPreis * steuersatz;
	  return bruttoPreis;
  }
}
