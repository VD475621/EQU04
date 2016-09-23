package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controleurs.Ctrl_Arrive;

public class Frm_Arrive extends Frm_Base {

	private static final long serialVersionUID = 1L;
	
	private JTextField TB_CliNo;
	private JTextField TB_Nom;
	private JTextField TB_Adresse;
	private JTextField TB_Tel;
	private JTextField TB_Fax;
	private JTextField TB_NumCham;
	private JTextField TB_NoReserv;
	private JTextField TB_DateReserv;
	private JTextField TB_DateDebut;
	private JTextField TB_DateFin;
	private JTextField TB_NoCli;
	private JTextField TB_NomReserv;
	private JScrollPane SP_Table;
	private JTable TBL_Reserv;
	
	private Ctrl_Arrive crt_arrive;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Arrive frame = new Frm_Arrive();
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
	public Frm_Arrive() {
		super();
		crt_arrive = new Ctrl_Arrive(this);
		
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crt_arrive.Dernier();
			}
		});
		btnNaviguer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crt_arrive.Suivant();
			}
		});
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNaviguer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crt_arrive.Precedent();
			}
		});
		
		btnNaviguerGauche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crt_arrive.Premier();
			}
		});
		
		getContentPane().setLayout(null);
		
		JPanel PN_Arrive = new JPanel();
		PN_Arrive.setBorder(new LineBorder(new Color(0, 0, 0)));
		PN_Arrive.setBounds(79, 48, 921, 560);
		getContentPane().add(PN_Arrive);
		PN_Arrive.setLayout(null);
		
		JPanel PN_InfoCli = new JPanel();
		PN_InfoCli.setBorder(new LineBorder(new Color(0, 0, 0)));
		PN_InfoCli.setBounds(38, 37, 458, 235);
		PN_Arrive.add(PN_InfoCli);
		PN_InfoCli.setLayout(null);
		
		JLabel LB_Clientno = new JLabel("Client No. :");
		LB_Clientno.setBounds(23, 19, 71, 16);
		PN_InfoCli.add(LB_Clientno);
		
		JLabel LB_Nom = new JLabel("Nom : ");
		LB_Nom.setBounds(248, 19, 61, 16);
		PN_InfoCli.add(LB_Nom);
		
		TB_CliNo = new JTextField();
		TB_CliNo.setBounds(106, 14, 130, 26);
		PN_InfoCli.add(TB_CliNo);
		TB_CliNo.setColumns(10);
		
		TB_Nom = new JTextField();
		TB_Nom.setBounds(298, 14, 130, 26);
		PN_InfoCli.add(TB_Nom);
		TB_Nom.setColumns(10);
		
		JLabel LB_Adresse = new JLabel("Adresse :");
		LB_Adresse.setBounds(23, 79, 61, 16);
		PN_InfoCli.add(LB_Adresse);
		
		TB_Adresse = new JTextField();
		TB_Adresse.setBounds(90, 74, 338, 26);
		PN_InfoCli.add(TB_Adresse);
		TB_Adresse.setColumns(10);
		
		JLabel LB_Tel = new JLabel("Téléphone : ");
		LB_Tel.setBounds(23, 133, 83, 16);
		PN_InfoCli.add(LB_Tel);
		
		TB_Tel = new JTextField();
		TB_Tel.setBounds(106, 128, 130, 26);
		PN_InfoCli.add(TB_Tel);
		TB_Tel.setColumns(10);
		
		JLabel LB_Fax = new JLabel("Fax : ");
		LB_Fax.setBounds(248, 133, 34, 16);
		PN_InfoCli.add(LB_Fax);
		
		TB_Fax = new JTextField();
		TB_Fax.setBounds(282, 128, 146, 26);
		PN_InfoCli.add(TB_Fax);
		TB_Fax.setColumns(10);
		
		JLabel LB_NumCham = new JLabel("Numéro Chambre : ");
		LB_NumCham.setBounds(23, 183, 122, 16);
		PN_InfoCli.add(LB_NumCham);
		
		TB_NumCham = new JTextField();
		TB_NumCham.setBounds(157, 178, 101, 26);
		PN_InfoCli.add(TB_NumCham);
		TB_NumCham.setColumns(10);
		
		JPanel PN_InfoCliTitle = new JPanel();
		PN_InfoCliTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		PN_InfoCliTitle.setBounds(78, 15, 372, 23);
		PN_Arrive.add(PN_InfoCliTitle);
		
		JLabel LB_InfoCliTitle = new JLabel("Information du client");
		PN_InfoCliTitle.add(LB_InfoCliTitle);
		
		JPanel PN_InfoReserv = new JPanel();
		PN_InfoReserv.setBorder(new LineBorder(new Color(0, 0, 0)));
		PN_InfoReserv.setBounds(534, 37, 348, 235);
		PN_Arrive.add(PN_InfoReserv);
		PN_InfoReserv.setLayout(null);
		
		JLabel LB_NoReserv = new JLabel("No. Réservation :");
		LB_NoReserv.setBounds(16, 11, 117, 16);
		PN_InfoReserv.add(LB_NoReserv);
		
		TB_NoReserv = new JTextField();
		TB_NoReserv.setBounds(133, 6, 130, 26);
		PN_InfoReserv.add(TB_NoReserv);
		TB_NoReserv.setColumns(10);
		TB_NoReserv.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount() >= 2)
				{
					System.out.println("DoubleClicked");
					PickList PlForm = new PickList(crt_arrive);
					PlForm.setVisible(true);
				}
			}
		});
		
		JLabel LB_DateReserv = new JLabel("Réservé le :");
		LB_DateReserv.setBounds(16, 53, 80, 16);
		PN_InfoReserv.add(LB_DateReserv);
		
		TB_DateReserv = new JTextField();
		TB_DateReserv.setBounds(133, 48, 130, 26);
		PN_InfoReserv.add(TB_DateReserv);
		TB_DateReserv.setColumns(10);
		
		JLabel LB_DateDebut = new JLabel("Date de début :");
		LB_DateDebut.setBounds(16, 93, 96, 16);
		PN_InfoReserv.add(LB_DateDebut);
		
		TB_DateDebut = new JTextField();
		TB_DateDebut.setBounds(133, 88, 130, 26);
		PN_InfoReserv.add(TB_DateDebut);
		TB_DateDebut.setColumns(10);
		
		JLabel LB_DateFin = new JLabel("Date de fin :");
		LB_DateFin.setBounds(16, 133, 96, 16);
		PN_InfoReserv.add(LB_DateFin);
		
		TB_DateFin = new JTextField();
		TB_DateFin.setBounds(133, 128, 130, 26);
		PN_InfoReserv.add(TB_DateFin);
		TB_DateFin.setColumns(10);
		
		JLabel LB_NoCli = new JLabel("Client No. :");
		LB_NoCli.setBounds(16, 173, 80, 16);
		PN_InfoReserv.add(LB_NoCli);
		
		TB_NoCli = new JTextField();
		TB_NoCli.setBounds(101, 168, 72, 26);
		PN_InfoReserv.add(TB_NoCli);
		TB_NoCli.setColumns(10);
		
		JLabel LB_NomReserv = new JLabel("Nom :");
		LB_NomReserv.setBounds(16, 213, 61, 16);
		PN_InfoReserv.add(LB_NomReserv);
		
		TB_NomReserv = new JTextField();
		TB_NomReserv.setBounds(69, 208, 147, 26);
		PN_InfoReserv.add(TB_NomReserv);
		TB_NomReserv.setColumns(10);
		
		JPanel PN_InfoReservTitle = new JPanel();
		PN_InfoReservTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		PN_InfoReservTitle.setBounds(579, 15, 259, 23);
		PN_Arrive.add(PN_InfoReservTitle);
		
		JLabel LB_InfoReservTitle = new JLabel("Information sur la réservation");
		PN_InfoReservTitle.add(LB_InfoReservTitle);
		
		JSeparator SPRT_Middle = new JSeparator();
		SPRT_Middle.setBounds(49, 333, 833, 3);
		PN_Arrive.add(SPRT_Middle);
		
		SP_Table = new JScrollPane();
		SP_Table.setBounds(38, 315, 844, 202);
		PN_Arrive.add(SP_Table);
		
		TBL_Reserv = new JTable();
		SP_Table.setViewportView(TBL_Reserv);
		TBL_Reserv.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"No. Chambre", "Code Type", "Prix","Occupée"}
                ));
		
		Consulter();
		crt_arrive.Premier();
	}
	
	private void Consulter()
	{
		TB_CliNo.setEditable(false);
		TB_Nom.setEditable(false);
		TB_Adresse.setEditable(false);
		TB_Tel.setEditable(false);
		TB_Fax.setEditable(false);
		TB_NumCham.setEditable(false);
		TB_NoReserv.setEditable(false);
		TB_DateReserv.setEditable(false);
		TB_DateDebut.setEditable(false);
		TB_DateFin.setEditable(false);
		TB_NoCli.setEditable(false);
		TB_NomReserv.setEditable(false);
	}
	
	public JTextField getTB_CliNo() {return TB_CliNo;}
	public JTextField getTB_Nom() {return TB_Nom;}
	public JTextField getTB_Adr() {return TB_Adresse;}
	public JTextField getTB_Tel() {return TB_Tel;}
	public JTextField getTB_Fax() {return TB_Fax;}
	public JTextField getTB_NumCham() {return TB_NumCham;}
	public JTextField getTB_NoReserv() {return TB_NoReserv;}
	public JTextField getTB_DateReserv() {return TB_DateReserv;}
	public JTextField getTB_DateDebut() {return TB_DateDebut;}
	public JTextField getTB_DateFin() {return TB_DateFin;}
	public JTextField getTB_NoCli() {return TB_NoCli;}
	public JTextField getTB_NomReserv() {return TB_NomReserv;}
	public JTable getTBL_Reserv() {return TBL_Reserv;}
	public JScrollPane getScrollP() {return SP_Table;}
	
}
