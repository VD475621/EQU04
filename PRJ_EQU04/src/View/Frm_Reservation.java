package View;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleurs.Ctrl_Reservation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JFormattedTextField Tbf_solde_du;
	private JFormattedTextField Tbf_exp;
	private JFormattedTextField Tbf_telephone;
	private JFormattedTextField Tbf_fax;
	
	private Ctrl_Reservation ct_reser;
	
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
		setTitle("Reservation");
		
		Initialise();
		
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
		
		JLabel Lb_telephone = new JLabel("Telephone");
		Lb_telephone.setBounds(6, 89, 74, 16);
		Pn_client.add(Lb_telephone);
		
		JLabel Lb_nom = new JLabel("Nom");
		Lb_nom.setBounds(212, 6, 61, 16);
		Pn_client.add(Lb_nom);
		
		JLabel lb_fax = new JLabel("Fax");
		lb_fax.setBounds(212, 89, 31, 16);
		Pn_client.add(lb_fax);
		
		Tb_IdCli = new JTextField();
		Tb_IdCli.setEditable(false);
		Tb_IdCli.setBounds(79, 1, 130, 26);
		Pn_client.add(Tb_IdCli);
		Tb_IdCli.setColumns(10);
		
		Tb_adresse = new JTextField();
		Tb_adresse.setEditable(false);
		Tb_adresse.setBounds(79, 39, 298, 26);
		Pn_client.add(Tb_adresse);
		Tb_adresse.setColumns(10);
		
		Tb_Nom = new JTextField();
		Tb_Nom.setEditable(false);
		Tb_Nom.setBounds(247, 1, 130, 26);
		Pn_client.add(Tb_Nom);
		Tb_Nom.setColumns(10);
		
		Tbf_telephone = new JFormattedTextField();
		Tbf_telephone.setEditable(false);
		Tbf_telephone.setText("(   )     -     ");
		Tbf_telephone.setBounds(79, 84, 130, 26);
		Pn_client.add(Tbf_telephone);
		
		Tbf_fax = new JFormattedTextField();
		Tbf_fax.setEditable(false);
		Tbf_fax.setText("(   )     -     ");
		Tbf_fax.setBounds(247, 84, 130, 26);
		Pn_client.add(Tbf_fax);
		
		JLabel Lb_typCarte = new JLabel("Type de Carte");
		Lb_typCarte.setBounds(6, 135, 93, 16);
		Pn_client.add(Lb_typCarte);
		
		JLabel Lb_exp = new JLabel("Expiration");
		Lb_exp.setBounds(6, 179, 74, 16);
		Pn_client.add(Lb_exp);
		
		JLabel Lb_solde_du = new JLabel("Solde du");
		Lb_solde_du.setBounds(212, 179, 61, 16);
		Pn_client.add(Lb_solde_du);
		
		Tbf_exp = new JFormattedTextField();
		Tbf_exp.setEditable(false);
		Tbf_exp.setText("jj/mm/aaaa");
		Tbf_exp.setBounds(79, 174, 121, 26);
		Pn_client.add(Tbf_exp);
		
		Tb_typ_carte = new JTextField();
		Tb_typ_carte.setEditable(false);
		Tb_typ_carte.setBounds(99, 130, 174, 26);
		Pn_client.add(Tb_typ_carte);
		Tb_typ_carte.setColumns(10);
		
		Tbf_solde_du = new JFormattedTextField();
		Tbf_solde_du.setEditable(false);
		Tbf_solde_du.setText("0,00 $");
		Tbf_solde_du.setBounds(273, 174, 104, 26);
		Pn_client.add(Tbf_solde_du);
		
		JPanel Pn_reservation = new JPanel();
		Pn_reservation.setBounds(603, 63, 424, 225);
		getContentPane().add(Pn_reservation);
		Pn_reservation.setLayout(null);
		
		JLabel Lb_Reservation = new JLabel("No. Reservation");
		Lb_Reservation.setBounds(6, 10, 107, 16);
		Pn_reservation.add(Lb_Reservation);
		
		JLabel Lb_date_reser = new JLabel("Reserve le ");
		Lb_date_reser.setBounds(6, 44, 107, 16);
		Pn_reservation.add(Lb_date_reser);
		
		JLabel Lb_date_debut = new JLabel("Date de debut");
		Lb_date_debut.setBounds(6, 84, 107, 16);
		Pn_reservation.add(Lb_date_debut);
		
		JLabel Lb_date_fin = new JLabel("Date de fin");
		Lb_date_fin.setBounds(6, 122, 107, 16);
		Pn_reservation.add(Lb_date_fin);
		
		Tb_IdReser = new JTextField();
		Tb_IdReser.setEditable(false);
		Tb_IdReser.setBounds(128, 5, 130, 26);
		Pn_reservation.add(Tb_IdReser);
		Tb_IdReser.setColumns(10);
		
		Tb_date_reser = new JTextField();
		Tb_date_reser.setEditable(false);
		Tb_date_reser.setText("jj/mm/aaaa");
		Tb_date_reser.setBounds(128, 39, 130, 26);
		Pn_reservation.add(Tb_date_reser);
		Tb_date_reser.setColumns(10);
		
		Tb_date_debut = new JTextField();
		Tb_date_debut.setEditable(false);
		Tb_date_debut.setText("jj/mm/aaaa");
		Tb_date_debut.setBounds(128, 79, 130, 26);
		Pn_reservation.add(Tb_date_debut);
		Tb_date_debut.setColumns(10);
		
		Tb_date_fin = new JTextField();
		Tb_date_fin.setEditable(false);
		Tb_date_fin.setText("jj/mm/aaaa");
		Tb_date_fin.setBounds(128, 117, 130, 26);
		Pn_reservation.add(Tb_date_fin);
		Tb_date_fin.setColumns(10);
		
		JLabel Lb_information_reser = new JLabel("Information sur la reservation");
		Lb_information_reser.setBounds(683, 35, 220, 16);
		getContentPane().add(Lb_information_reser);
		
		JLabel Lb_information_client = new JLabel("Information sur le client qui reserve");
		Lb_information_client.setBounds(187, 35, 234, 16);
		getContentPane().add(Lb_information_client);
		
		JScrollPane ScrP_Reser = new JScrollPane();
		ScrP_Reser.setBounds(63, 332, 964, 191);
		getContentPane().add(ScrP_Reser);
		
		Tbl_reservation = new JTable();
		
		ScrP_Reser.setColumnHeaderView(Tbl_reservation);
		
		Consulter();
	}
	
	private void Initialise()
	{
		Tbl_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		Tb_IdReser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		Tb_IdCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		btnFin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNaviguer_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnConsulter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNaviguer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNaviguerGauche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}
	
	private void Consulter()
	{
		Tb_IdReser.setEditable(false);
		Tb_IdCli.setEditable(false);
		Tb_adresse.setEditable(false);
		Tb_Nom.setEditable(false);
		Tb_IdReser.setEditable(false);
		Tb_date_reser.setEditable(false);
		Tb_date_debut.setEditable(false);
		Tb_date_fin.setEditable(false);
		Tb_typ_carte.setEditable(false);
	}
	
	private void Ajouter()
	{
		
	}
	
	private void Modifier()
	{
		
	}
	
	private void Supprimer()
	{
		
	}

	/**
	 * @return the tb_IdCli
	 */
	private JTextField getTb_IdCli() {
		return Tb_IdCli;
	}

	/**
	 * @param tb_IdCli the tb_IdCli to set
	 */
	private void setTb_IdCli(JTextField tb_IdCli) {
		Tb_IdCli = tb_IdCli;
	}

	/**
	 * @return the tb_adresse
	 */
	private JTextField getTb_adresse() {
		return Tb_adresse;
	}

	/**
	 * @param tb_adresse the tb_adresse to set
	 */
	private void setTb_adresse(JTextField tb_adresse) {
		Tb_adresse = tb_adresse;
	}

	/**
	 * @return the tb_Nom
	 */
	private JTextField getTb_Nom() {
		return Tb_Nom;
	}

	/**
	 * @param tb_Nom the tb_Nom to set
	 */
	private void setTb_Nom(JTextField tb_Nom) {
		Tb_Nom = tb_Nom;
	}

	/**
	 * @return the tb_IdReser
	 */
	private JTextField getTb_IdReser() {
		return Tb_IdReser;
	}

	/**
	 * @param tb_IdReser the tb_IdReser to set
	 */
	private void setTb_IdReser(JTextField tb_IdReser) {
		Tb_IdReser = tb_IdReser;
	}

	/**
	 * @return the tb_date_reser
	 */
	private JTextField getTb_date_reser() {
		return Tb_date_reser;
	}

	/**
	 * @param tb_date_reser the tb_date_reser to set
	 */
	private void setTb_date_reser(JTextField tb_date_reser) {
		Tb_date_reser = tb_date_reser;
	}

	/**
	 * @return the tb_date_debut
	 */
	private JTextField getTb_date_debut() {
		return Tb_date_debut;
	}

	/**
	 * @param tb_date_debut the tb_date_debut to set
	 */
	private void setTb_date_debut(JTextField tb_date_debut) {
		Tb_date_debut = tb_date_debut;
	}

	/**
	 * @return the tb_date_fin
	 */
	private JTextField getTb_date_fin() {
		return Tb_date_fin;
	}

	/**
	 * @param tb_date_fin the tb_date_fin to set
	 */
	private void setTb_date_fin(JTextField tb_date_fin) {
		Tb_date_fin = tb_date_fin;
	}

	/**
	 * @return the tb_typ_carte
	 */
	private JTextField getTb_typ_carte() {
		return Tb_typ_carte;
	}

	/**
	 * @param tb_typ_carte the tb_typ_carte to set
	 */
	private void setTb_typ_carte(JTextField tb_typ_carte) {
		Tb_typ_carte = tb_typ_carte;
	}

	/**
	 * @return the tbl_reservation
	 */
	private JTable getTbl_reservation() {
		return Tbl_reservation;
	}

	/**
	 * @param tbl_reservation the tbl_reservation to set
	 */
	private void setTbl_reservation(JTable tbl_reservation) {
		Tbl_reservation = tbl_reservation;
	}

	/**
	 * @return the tbf_solde_du
	 */
	private JFormattedTextField getTbf_solde_du() {
		return Tbf_solde_du;
	}

	/**
	 * @param tbf_solde_du the tbf_solde_du to set
	 */
	private void setTbf_solde_du(JFormattedTextField tbf_solde_du) {
		Tbf_solde_du = tbf_solde_du;
	}

	/**
	 * @return the tbf_exp
	 */
	private JFormattedTextField getTbf_exp() {
		return Tbf_exp;
	}

	/**
	 * @param tbf_exp the tbf_exp to set
	 */
	private void setTbf_exp(JFormattedTextField tbf_exp) {
		Tbf_exp = tbf_exp;
	}

	/**
	 * @return the tbf_telephone
	 */
	private JFormattedTextField getTbf_telephone() {
		return Tbf_telephone;
	}

	/**
	 * @param tbf_telephone the tbf_telephone to set
	 */
	private void setTbf_telephone(JFormattedTextField tbf_telephone) {
		Tbf_telephone = tbf_telephone;
	}

	/**
	 * @return the tbf_fax
	 */
	private JFormattedTextField getTbf_fax() {
		return Tbf_fax;
	}

	/**
	 * @param tbf_fax the tbf_fax to set
	 */
	private void setTbf_fax(JFormattedTextField tbf_fax) {
		Tbf_fax = tbf_fax;
	}
	
	
	
}