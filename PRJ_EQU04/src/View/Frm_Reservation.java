package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controleurs.Ctrl_Reservation;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.beans.PropertyChangeEvent;
import javax.swing.JMenuItem;
import javax.swing.JFrame;

public class Frm_Reservation extends Frm_Base {

	/**
	 * 
	 */
	public enum State {Consulter, Ajouter, Modifier, Supprimer};
	private State etat = null;
	private Frm_Reservation instance;
	private static final long serialVersionUID = 1L;
	private JTextField Tb_IdCli;
	private JTextField Tb_adresse;
	private JTextField Tb_Nom;
	private JTextField Tb_IdReser;
	private JTextField Tb_date_reser;
	private JTextField Tb_date_debut;
	private JTextField Tb_date_fin;
	private JTextField Tb_typ_carte;
	private JFormattedTextField Tbf_solde_du;
	private JFormattedTextField Tbf_exp;
	private JFormattedTextField Tbf_telephone;
	private JFormattedTextField Tbf_fax;
	private JScrollPane ScrP_Reser;
	private JButton Btn_PkList;
	private JButton Btn_PkList_client;
	private JButton btn_addChambre;
	private JButton btn_removeChambre;
	
	private Ctrl_Reservation ct_reser;
	private JMenuItem mntmRapportReservation;
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.dispose();
			}
		});
		instance = this;
		
		
		this.setEtat(State.Consulter);
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consulter();
				ct_reser.ViderTableTemp(instance);
			}
		});
		btnSauvegarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//---------------------------------------
				ct_reser.SauvegarderReservation(instance);
				//---------------------------------------
			}
		});
		
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulter();
			}
		});
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modifier();
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supprimer();
				ct_reser.SupprimerReservation(instance);
			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter();
			}
		});
		
		//precedent
		btnNaviguer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_reser.Precedent(instance);
			}
		});
		//premier
		btnNaviguerGauche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_reser.Premier(instance);
			}
		});
		//dernier
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_reser.Dernier(instance);
			}
		});
		//suivant
		btnNaviguer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ct_reser.Suivant(instance);
			}
		});
		
		setTitle("Reservation");
		
		
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
		Lb_nom.setBounds(256, 6, 39, 16);
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
		Tb_Nom.setBounds(294, 1, 130, 26);
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
		
		Btn_PkList_client = new JButton("...");
		Btn_PkList_client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(etat ==State.Ajouter)
					ct_reser.ListeClient(instance);
				else if(etat == State.Modifier){
					ct_reser.ModifierClient(instance);
				}
			}
		});
		Btn_PkList_client.setBounds(212, 6, 31, 16);
		Pn_client.add(Btn_PkList_client);
		
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
		Tb_date_debut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(State.Modifier == etat){
					//System.out.println("mod");
					ct_reser.ModifDateIsArrive(instance);
				}
				else if(State.Ajouter == etat){
					ct_reser.GetDate(instance, Tb_date_debut, true);
					//System.out.println("add");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ct_reser.DateInModif(instance, Tb_date_debut, true);
			}
		});
		Tb_date_debut.setEditable(false);
		Tb_date_debut.setText("jj/mm/aaaa");
		Tb_date_debut.setBounds(128, 79, 130, 26);
		Pn_reservation.add(Tb_date_debut);
		Tb_date_debut.setColumns(10);
		
		
		Tb_date_fin = new JTextField();
		Tb_date_fin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(State.Modifier == etat){
					//System.out.println("mod");
					ct_reser.ModifDateIsDepart(instance);
				}
				else if(State.Ajouter == etat){
					ct_reser.GetDate(instance, Tb_date_fin, false);
					//System.out.println("add");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ct_reser.DateInModif(instance, Tb_date_fin, false);
			}
		});
		Tb_date_fin.setEditable(false);
		Tb_date_fin.setText("jj/mm/aaaa");
		Tb_date_fin.setBounds(128, 117, 130, 26);
		Pn_reservation.add(Tb_date_fin);
		Tb_date_fin.setColumns(10);
		
		Btn_PkList = new JButton("...");
		Btn_PkList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ct_reser.ListeReservation(instance);
			}
		});
		Btn_PkList.setBounds(268, 7, 28, 23);
		Pn_reservation.add(Btn_PkList);
		
		JLabel Lb_information_reser = new JLabel("Information sur la reservation");
		Lb_information_reser.setBounds(683, 35, 220, 16);
		getContentPane().add(Lb_information_reser);
		
		JLabel Lb_information_client = new JLabel("Information sur le client qui reserve");
		Lb_information_client.setBounds(187, 35, 234, 16);
		getContentPane().add(Lb_information_client);
		
		btn_addChambre = new JButton("+");
		btn_addChambre.setEnabled(false);
		btn_addChambre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(etat == State.Ajouter)
				{
					java.sql.Date datereser = null;
				    java.sql.Date datedeb = null;
				    java.sql.Date datefin = null;
					
				    datereser = java.sql.Date.valueOf(Tb_date_reser.getText());
					datedeb = java.sql.Date.valueOf(Tb_date_debut.getText());
					datefin = java.sql.Date.valueOf(Tb_date_fin.getText());
					
					if(datedeb.compareTo(datereser)>=0){

						if(datedeb.compareTo(datefin)<0)
						    ct_reser.ListeChambreFiltrer(instance, datedeb, datefin);
						else{
						    JOptionPane.showMessageDialog(null, "La date de debut doit etre superieur la date de fin");
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "La date de debut doit etre egal ou superieur la date de reservation");
					}
					
				}
				else if(etat == State.Modifier){
					if(ct_reser.DateInModif(instance, Tb_date_debut, true) 
							&& ct_reser.DateInModif(instance, Tb_date_fin, false)){
						
						java.sql.Date datadeb = null;
					    java.sql.Date datafin = null;
									
						datadeb = java.sql.Date.valueOf(Tb_date_debut.getText());
						datafin = java.sql.Date.valueOf(Tb_date_fin.getText());
						if(datadeb.compareTo(datafin)<0)
						    ct_reser.ListeChambreFiltrer(instance, datadeb, datafin);
						else{
						    JOptionPane.showMessageDialog(null, "La date de debut doit etre avant la date de fin");
						}
					}
				}
			}
		});
		btn_addChambre.setBounds(508, 585, 32, 29);
		getContentPane().add(btn_addChambre);
		
		btn_removeChambre = new JButton("-");
		btn_removeChambre.setEnabled(false);
		btn_removeChambre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ct_reser.RetirerChambre(instance);
			}
		});
		btn_removeChambre.setBounds(553, 585, 32, 29);
		getContentPane().add(btn_removeChambre);
		
		mntmRapportReservation = new JMenuItem("Rapport Reservation");
		mntmRapportReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRapReser frm = new FrmRapReser();
				frm.setVisible(true);
			}
		});
		mnRapport.add(mntmRapportReservation);
		
		ScrP_Reser = new JScrollPane();
		ScrP_Reser.setBounds(63, 332, 964, 191);
		
		ct_reser = new Ctrl_Reservation(instance);
		
		Consulter();
	}
	
	
	
	public State getEtat() {
		return etat;
	}

	public void setEtat(State etat) {
		this.etat = etat;
	}

	public void Consulter()
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
			
			
			btnAnnuler.setEnabled(false);
			btnSauvegarder.setEnabled(false);
			this.btn_addChambre.setEnabled(false);
			this.btn_removeChambre.setEnabled(false);
			this.btnConsulter.setEnabled(true);
			this.btnAjouter.setEnabled(true);
			this.Btn_PkList.setEnabled(true);
			this.btnFin.setEnabled(true);
			this.btnModifier.setEnabled(true);
			this.btnNaviguer.setEnabled(true);
			this.btnNaviguer_1.setEnabled(true);
			this.btnNaviguerGauche.setEnabled(true);
			this.btnSupprimer.setEnabled(true);
			this.Btn_PkList_client.setEnabled(false);
			this.etat = State.Consulter;
			this.ct_reser.Assign(instance, 0);
			ct_reser.setPosition(0);
		
	}
	
	private void Ajouter()
	{
		if(this.etat == State.Consulter)
		{
			Tb_IdReser.setEditable(false);
			Tb_IdCli.setEditable(false);
			Tb_adresse.setEditable(false);
			Tb_Nom.setEditable(false);
			Tb_date_reser.setEditable(false);
			Tb_date_debut.setEditable(true);
			Tb_date_fin.setEditable(true);
			Tb_typ_carte.setEditable(false);
			btnAnnuler.setEnabled(true);
			btnSauvegarder.setEnabled(true);


			this.btn_addChambre.setEnabled(true);
			this.btn_removeChambre.setEnabled(true);
			this.Btn_PkList_client.setEnabled(true);
			this.Btn_PkList.setEnabled(false);
			this.btnFin.setEnabled(false);
			this.btnModifier.setEnabled(false);
			this.btnNaviguer.setEnabled(false);
			this.btnNaviguer_1.setEnabled(false);
			this.btnNaviguerGauche.setEnabled(false);
			this.btnSupprimer.setEnabled(false);
			this.btnConsulter.setEnabled(false);
			
			
			this.ct_reser.ViderChamps(instance);
			
			this.etat = State.Ajouter;
		}
	}
	
	private void Modifier()
	{
		if(this.etat == State.Consulter)
		{
			Tb_IdReser.setEditable(false);
			Tb_IdCli.setEditable(false);
			Tb_adresse.setEditable(false);
			Tb_Nom.setEditable(false);
			Tb_date_reser.setEditable(false);
			Tb_date_debut.setEditable(true);
			Tb_date_fin.setEditable(true);
			Tb_typ_carte.setEditable(false);
			btnAnnuler.setEnabled(true);
			btnSauvegarder.setEnabled(true);


			this.btn_addChambre.setEnabled(true);
			this.btn_removeChambre.setEnabled(true);
			this.Btn_PkList_client.setEnabled(true);
			this.Btn_PkList.setEnabled(false);
			this.btnFin.setEnabled(false);
			this.btnModifier.setEnabled(false);
			this.btnNaviguer.setEnabled(false);
			this.btnNaviguer_1.setEnabled(false);
			this.btnNaviguerGauche.setEnabled(false);
			this.btnSupprimer.setEnabled(false);
			this.btnConsulter.setEnabled(false);
			this.btnAjouter.setEnabled(false);
			
			this.etat = State.Modifier;
			ct_reser.SetOldDateInModif(instance);
			//save chambre in tempChambre
			ct_reser.SaveChambreInTempChambre(instance);
		}
	}
	
	private void Supprimer()
	{
		if(etat == State.Consulter){
			this.etat = State.Supprimer;
			//this.Btn_PkList.setEnabled(true);
		}
	}
	
	public void setjScrollPane(JTable UneTable)
	{		
		ScrP_Reser.setViewportView(UneTable);
		getContentPane().add(ScrP_Reser);
	}

	public Frm_Reservation getInstance() {
		return instance;
	}

	public void setInstance(Frm_Reservation instance) {
		this.instance = instance;
	}

	public JScrollPane getScrP_Reser() {
		return ScrP_Reser;
	}

	public void setScrP_Reser(JScrollPane scrP_Reser) {
		ScrP_Reser = scrP_Reser;
	}

	public JTextField getTb_IdCli() {
		return Tb_IdCli;
	}

	public void setTb_IdCli(JTextField tb_IdCli) {
		Tb_IdCli = tb_IdCli;
	}

	public JTextField getTb_adresse() {
		return Tb_adresse;
	}

	public void setTb_adresse(JTextField tb_adresse) {
		Tb_adresse = tb_adresse;
	}

	public JTextField getTb_Nom() {
		return Tb_Nom;
	}

	public void setTb_Nom(JTextField tb_Nom) {
		Tb_Nom = tb_Nom;
	}

	public JTextField getTb_IdReser() {
		return Tb_IdReser;
	}

	public void setTb_IdReser(JTextField tb_IdReser) {
		Tb_IdReser = tb_IdReser;
	}

	public JTextField getTb_date_reser() {
		return Tb_date_reser;
	}

	public void setTb_date_reser(JTextField tb_date_reser) {
		Tb_date_reser = tb_date_reser;
	}

	public JTextField getTb_date_debut() {
		return Tb_date_debut;
	}

	public void setTb_date_debut(JTextField tb_date_debut) {
		Tb_date_debut = tb_date_debut;
	}

	public JTextField getTb_date_fin() {
		return Tb_date_fin;
	}

	public void setTb_date_fin(JTextField tb_date_fin) {
		Tb_date_fin = tb_date_fin;
	}

	public JTextField getTb_typ_carte() {
		return Tb_typ_carte;
	}

	public void setTb_typ_carte(JTextField tb_typ_carte) {
		Tb_typ_carte = tb_typ_carte;
	}

	public JFormattedTextField getTbf_solde_du() {
		return Tbf_solde_du;
	}

	public void setTbf_solde_du(JFormattedTextField tbf_solde_du) {
		Tbf_solde_du = tbf_solde_du;
	}

	public JFormattedTextField getTbf_exp() {
		return Tbf_exp;
	}

	public void setTbf_exp(JFormattedTextField tbf_exp) {
		Tbf_exp = tbf_exp;
	}

	public JFormattedTextField getTbf_telephone() {
		return Tbf_telephone;
	}

	public void setTbf_telephone(JFormattedTextField tbf_telephone) {
		Tbf_telephone = tbf_telephone;
	}

	public JFormattedTextField getTbf_fax() {
		return Tbf_fax;
	}

	public void setTbf_fax(JFormattedTextField tbf_fax) {
		Tbf_fax = tbf_fax;
	}

	public Ctrl_Reservation getCt_reser() {
		return ct_reser;
	}

	public void setCt_reser(Ctrl_Reservation ct_reser) {
		this.ct_reser = ct_reser;
	}
}