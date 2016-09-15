package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

public class Frm_Reservation extends Frm_Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Tb_IdCli;
	private JTextField Tb_adresse;
	private JTextField Tb_Nom;
	private JTextField Tb_IdReser;
	private JTextField Tb_date_reser;
	private JTextField Tb_date_debut;
	private JTextField Tb_date_fin;
	private JTextField Tb_typ_carte;
	private JTable Tbl_reservation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Reservation frame = new Frm_Reservation();
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
	public Frm_Reservation() {
		super();
		
		JPanel Pn_client = new JPanel();
		Pn_client.setBounds(63, 63, 450, 225);
		getContentPane().add(Pn_client);
		Pn_client.setLayout(null);
		
		JLabel Lb_client_no = new JLabel("Client no");
		Lb_client_no.setBounds(6, 6, 61, 16);
		Pn_client.add(Lb_client_no);
		
		JLabel Lb_adresse = new JLabel("Adresse");
		Lb_adresse.setBounds(6, 44, 61, 16);
		Pn_client.add(Lb_adresse);
		
		JLabel Lb_telephone = new JLabel("Téléphone");
		Lb_telephone.setBounds(6, 89, 74, 16);
		Pn_client.add(Lb_telephone);
		
		JLabel Lb_nom = new JLabel("Nom");
		Lb_nom.setBounds(212, 6, 61, 16);
		Pn_client.add(Lb_nom);
		
		JLabel lb_fax = new JLabel("Fax");
		lb_fax.setBounds(212, 89, 31, 16);
		Pn_client.add(lb_fax);
		
		Tb_IdCli = new JTextField();
		Tb_IdCli.setBounds(79, 1, 130, 26);
		Pn_client.add(Tb_IdCli);
		Tb_IdCli.setColumns(10);
		
		Tb_adresse = new JTextField();
		Tb_adresse.setBounds(79, 39, 298, 26);
		Pn_client.add(Tb_adresse);
		Tb_adresse.setColumns(10);
		
		Tb_Nom = new JTextField();
		Tb_Nom.setBounds(247, 1, 130, 26);
		Pn_client.add(Tb_Nom);
		Tb_Nom.setColumns(10);
		
		JFormattedTextField Tbf_telephone = new JFormattedTextField();
		Tbf_telephone.setText("(   )     -     ");
		Tbf_telephone.setBounds(79, 84, 130, 26);
		Pn_client.add(Tbf_telephone);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("(   )     -     ");
		formattedTextField.setBounds(247, 84, 130, 26);
		Pn_client.add(formattedTextField);
		
		JLabel Lb_typCarte = new JLabel("Type de Carte");
		Lb_typCarte.setBounds(6, 135, 93, 16);
		Pn_client.add(Lb_typCarte);
		
		JLabel Lb_exp = new JLabel("Expiration");
		Lb_exp.setBounds(6, 179, 74, 16);
		Pn_client.add(Lb_exp);
		
		JLabel Lb_solde_du = new JLabel("Solde dû");
		Lb_solde_du.setBounds(212, 179, 61, 16);
		Pn_client.add(Lb_solde_du);
		
		JFormattedTextField Tbf_exp = new JFormattedTextField();
		Tbf_exp.setText("jj/mm/aaaa");
		Tbf_exp.setBounds(79, 174, 121, 26);
		Pn_client.add(Tbf_exp);
		
		Tb_typ_carte = new JTextField();
		Tb_typ_carte.setBounds(99, 130, 174, 26);
		Pn_client.add(Tb_typ_carte);
		Tb_typ_carte.setColumns(10);
		
		JFormattedTextField Tbf_solde_du = new JFormattedTextField();
		Tbf_solde_du.setText("0,00 $");
		Tbf_solde_du.setBounds(273, 174, 104, 26);
		Pn_client.add(Tbf_solde_du);
		
		JPanel Pn_reservation = new JPanel();
		Pn_reservation.setBounds(603, 63, 424, 225);
		getContentPane().add(Pn_reservation);
		Pn_reservation.setLayout(null);
		
		JLabel Lb_Reservation = new JLabel("No. Réservation");
		Lb_Reservation.setBounds(6, 10, 107, 16);
		Pn_reservation.add(Lb_Reservation);
		
		JLabel Lb_date_reser = new JLabel("Réservé le ");
		Lb_date_reser.setBounds(6, 44, 107, 16);
		Pn_reservation.add(Lb_date_reser);
		
		JLabel Lb_date_debut = new JLabel("Date de début");
		Lb_date_debut.setBounds(6, 84, 107, 16);
		Pn_reservation.add(Lb_date_debut);
		
		JLabel Lb_date_fin = new JLabel("Date de fin");
		Lb_date_fin.setBounds(6, 122, 107, 16);
		Pn_reservation.add(Lb_date_fin);
		
		Tb_IdReser = new JTextField();
		Tb_IdReser.setBounds(128, 5, 130, 26);
		Pn_reservation.add(Tb_IdReser);
		Tb_IdReser.setColumns(10);
		
		Tb_date_reser = new JTextField();
		Tb_date_reser.setText("jj/mm/aaaa");
		Tb_date_reser.setBounds(128, 39, 130, 26);
		Pn_reservation.add(Tb_date_reser);
		Tb_date_reser.setColumns(10);
		
		Tb_date_debut = new JTextField();
		Tb_date_debut.setText("jj/mm/aaaa");
		Tb_date_debut.setBounds(128, 79, 130, 26);
		Pn_reservation.add(Tb_date_debut);
		Tb_date_debut.setColumns(10);
		
		Tb_date_fin = new JTextField();
		Tb_date_fin.setText("jj/mm/aaaa");
		Tb_date_fin.setBounds(128, 117, 130, 26);
		Pn_reservation.add(Tb_date_fin);
		Tb_date_fin.setColumns(10);
		
		JLabel Lb_information_reser = new JLabel("Information sur la réservation");
		Lb_information_reser.setBounds(683, 35, 220, 16);
		getContentPane().add(Lb_information_reser);
		
		JLabel Lb_information_client = new JLabel("Information sur le client qui réserve");
		Lb_information_client.setBounds(187, 35, 234, 16);
		getContentPane().add(Lb_information_client);
		
		JScrollPane ScrP_Reser = new JScrollPane();
		ScrP_Reser.setBounds(63, 336, 964, 191);
		getContentPane().add(ScrP_Reser);
		
		Tbl_reservation = new JTable();
		ScrP_Reser.setColumnHeaderView(Tbl_reservation);
	}
}
