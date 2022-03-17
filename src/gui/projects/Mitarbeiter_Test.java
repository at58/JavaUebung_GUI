package gui.projects;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;

public class Mitarbeiter_Test extends JFrame {

	private JPanel contentPane;
	private JTextField tfVorname;
	private JTextField tfNachname;
	private JTextField tfAlter;
	private JTextField tfStrasseNr;
	private JTextField tfPlz;
	private JTextField tfOrt;
	private JTextField tfPersoNr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mitarbeiter_Test frame = new Mitarbeiter_Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mitarbeiter_Test() {
		
		setTitle("Mitarbeiter Liste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(12, 20, 65, 22);
		contentPane.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(118, 20, 65, 22);
		contentPane.add(lblNachname);
		
		JLabel lblAlter = new JLabel("Alter");
		lblAlter.setBounds(220, 20, 31, 22);
		contentPane.add(lblAlter);
		
		JLabel lblStrasseNr = new JLabel("Stra\u00DFe & Haus-Nr.");
		lblStrasseNr.setBounds(272, 20, 117, 22);
		contentPane.add(lblStrasseNr);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setBounds(429, 20, 42, 22);
		contentPane.add(lblPlz);
		
		JLabel lblOrt = new JLabel("Wohnort");
		lblOrt.setBounds(489, 20, 65, 22);
		contentPane.add(lblOrt);
		
		JLabel lblAbteilung = new JLabel("Abteilung");
		lblAbteilung.setBounds(590, 20, 65, 22);
		contentPane.add(lblAbteilung);
		
		JLabel lblPersoNr = new JLabel("Personal-Nr.");
		lblPersoNr.setBounds(670, 20, 82, 22);
		contentPane.add(lblPersoNr);
		
		tfVorname = new JTextField();
		tfVorname.setBounds(10, 40, 100, 25);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);
		
		tfNachname = new JTextField();
		tfNachname.setColumns(10);
		tfNachname.setBounds(116, 40, 96, 25);
		contentPane.add(tfNachname);
		
		tfAlter = new JTextField();
		tfAlter.setColumns(10);
		tfAlter.setBounds(218, 40, 42, 25);
		contentPane.add(tfAlter);
		
		tfStrasseNr = new JTextField();
		tfStrasseNr.setColumns(10);
		tfStrasseNr.setBounds(270, 40, 145, 25);
		contentPane.add(tfStrasseNr);
		
		tfPlz = new JTextField();
		tfPlz.setColumns(10);
		tfPlz.setBounds(427, 40, 50, 25);
		contentPane.add(tfPlz);
		
		tfOrt = new JTextField();
		tfOrt.setColumns(10);
		tfOrt.setBounds(487, 40, 91, 25);
		contentPane.add(tfOrt);
		
		tfPersoNr = new JTextField();
		tfPersoNr.setColumns(10);
		tfPersoNr.setBounds(668, 40, 73, 25);
		contentPane.add(tfPersoNr);
		
		final String[] auswahl = {"IT-Systeme", "Datenschutz", "Produktion", "Vertrieb", "Produktion", "Logistik", "Marketing"};
		final JComboBox<String> cbAbteilung = new JComboBox<>();
		cbAbteilung.setBounds(590, 39, 65, 25);
		contentPane.add(cbAbteilung);
		cbAbteilung.setVisible(true);
		
		JTextPane tpList = new JTextPane();
		tpList.setBounds(126, 75, 616, 272);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 75, 566, 272);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tpList);
		
		JButton btnExit = new JButton("Schlie\u00DFen");
		btnExit.addActionListener(e ->{
			System.exit(0);
		});
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(618, 357, 117, 25);
		contentPane.add(btnExit);
		
		JButton btnEdit = new JButton("Bearbeiten");
		btnEdit.setBounds(12, 85, 98, 25);
		contentPane.add(btnEdit);
		
		JButton btnAbbruch = new JButton("Abbrechen");
		btnAbbruch.setBounds(12, 125, 98, 25);
		contentPane.add(btnAbbruch);
		
		JButton btnSave = new JButton("Speichern");
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(12, 165, 98, 25);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("L\u00F6schen");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(12, 205, 98, 25);
		contentPane.add(btnDelete);
	}
}
