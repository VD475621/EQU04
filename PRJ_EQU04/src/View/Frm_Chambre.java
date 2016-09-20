package View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controleurs.Ctrl_Chambre;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Frm_Chambre extends Frm_Base{
	
	private JPanel contentPane;
	private JTextField Tb_NoCham;
	private JTextField Tb_Etage;
	private JTextField Tb_Etat;
	private JTextField Tb_CodType;
	private JTextField Tb_Localisation;
	private JTextField Tb_DescType;
	private JTextField Tb_DescLoc;
	private JTextField Tb_Prix;
	private JTable Tbl_Chambre;
	private JTable Tbl_Chambre_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Base frame = new Frm_Chambre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Frm_Chambre() {
		super();
		
		Initialiser_ObjetGraph();
		
		
	}
	
	
	private void Initialiser_Listener()
	{
		btnNaviguer.addActionListener(new ActionListener())
		{
			
		}
	}
	
	
	
	
	private void Initialiser_ObjetGraph()
	{
		JPanel Pn_Chambre = new JPanel();
		Pn_Chambre.setBounds(26, 68, 493, 533);
		getContentPane().add(Pn_Chambre);
		Pn_Chambre.setLayout(null);
		
		JLabel Lb_NoCham = new JLabel("No. Cham");
		Lb_NoCham.setBounds(6, 37, 62, 16);
		Pn_Chambre.add(Lb_NoCham);
		
		JLabel Lb_Etage = new JLabel("Etage");
		Lb_Etage.setBounds(6, 100, 61, 16);
		Pn_Chambre.add(Lb_Etage);
		
		
		
		
		
		JLabel lblEtat = new JLabel("Etat");
		lblEtat.setBounds(6, 160, 61, 16);
		Pn_Chambre.add(lblEtat);
		
		
		
		JLabel Lb_Codetype = new JLabel("Code_Type");
		Lb_Codetype.setBounds(6, 225, 76, 16);
		Pn_Chambre.add(Lb_Codetype);
		
		
		
		JLabel Lb_Localisation = new JLabel("Code_Localisation");
		Lb_Localisation.setBounds(222, 37, 115, 16);
		Pn_Chambre.add(Lb_Localisation);
		
		
		
		JLabel Lb_DescType = new JLabel("Description");
		Lb_DescType.setBounds(222, 100, 76, 16);
		Pn_Chambre.add(Lb_DescType);
		
		Tb_DescType = new JTextField();
		Tb_DescType.setBounds(349, 95, 130, 26);
		Pn_Chambre.add(Tb_DescType);
		Tb_DescType.setColumns(10);
		
		JLabel Lb_DescLoc = new JLabel("Description");
		Lb_DescLoc.setBounds(222, 160, 76, 16);
		Pn_Chambre.add(Lb_DescLoc);
		
		Tb_DescLoc = new JTextField();
		Tb_DescLoc.setBounds(349, 155, 130, 26);
		Pn_Chambre.add(Tb_DescLoc);
		Tb_DescLoc.setColumns(10);
		
		JLabel Lb_Prix = new JLabel("Prix");
		Lb_Prix.setBounds(222, 225, 61, 16);
		Pn_Chambre.add(Lb_Prix);
		
		
		
		JTextArea Ta_Memo = new JTextArea();
		Ta_Memo.setBounds(24, 359, 440, 109);
		Pn_Chambre.add(Ta_Memo);
		
		JLabel Lb_Memo = new JLabel("Memo");
		Lb_Memo.setBounds(21, 331, 61, 16);
		Pn_Chambre.add(Lb_Memo);
		
		JLabel Lb_Titre = new JLabel("Information sur les chambres");
		Lb_Titre.setBounds(186, 51, 186, 16);
		getContentPane().add(Lb_Titre);
		
		Tbl_Chambre = new JTable();
		Tbl_Chambre.setBounds(606, 321, 136, -82);
		getContentPane().add(Tbl_Chambre);
		
		JLabel lblCodcom = new JLabel("CODCOM");
		lblCodcom.setBounds(621, 162, 61, 16);
		getContentPane().add(lblCodcom);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(875, 162, 73, 16);
		getContentPane().add(lblDescription);
		
		JScrollPane Jpn_Chambre = new JScrollPane();
		Jpn_Chambre.setBounds(558, 203, 502, 319);
		getContentPane().add(Jpn_Chambre);
		
		Tbl_Chambre_1 = new JTable();
		Jpn_Chambre.setViewportView(Tbl_Chambre_1);
		
		Tb_NoCham = new JTextField();
		Tb_NoCham.setBounds(80, 32, 130, 26);
		Tb_NoCham.setEditable(false);
		Tb_NoCham.setEnabled(false);
		//Pn_Chambre.add(Tb_NoCham);
		Tb_NoCham.setColumns(10);
		
		Tb_Etage = new JTextField();
		Tb_Etage.setBounds(80, 95, 130, 26);
		Tb_Etage.setEditable(false);
		Tb_Etage.setEnabled(false);
		//Pn_Chambre.add(Tb_Etage);
		Tb_Etage.setColumns(10);
		
		Tb_Etat = new JTextField();
		Tb_Etat.setBounds(80, 155, 130, 26);
		Tb_Etat.setEditable(false);
		Tb_Etat.setEnabled(false);
		//Pn_Chambre.add(Tb_Etat);
		Tb_Etat.setColumns(10);
		
		
		Tb_CodType = new JTextField();
		Tb_CodType.setBounds(80, 220, 130, 26);
		Tb_CodType.setEditable(false);
		Tb_CodType.setEnabled(false);
		//Pn_Chambre.add(Tb_CodType);
		Tb_CodType.setColumns(10);
		
		
		Tb_Localisation = new JTextField();
		Tb_Localisation.setBounds(349, 32, 130, 26);
		Tb_Localisation.setEditable(false);
		Tb_Localisation.setEnabled(false);
		//Pn_Chambre.add(Tb_Localisation);
		Tb_Localisation.setColumns(10);
		
		Tb_Prix = new JTextField();
		Tb_Prix.setBounds(349, 220, 130, 26);
		Tb_Prix.setEditable(false);
		Tb_Prix.setEnabled(false);
		//Pn_Chambre.add(Tb_Prix);
		Tb_Prix.setColumns(10);
	}
	
	
	
	//-------------------------------------
	public JTextField getTb_NoCham() {
		return Tb_NoCham;
	}


	public void setTb_NoCham(JTextField tb_NoCham) {
		Tb_NoCham = tb_NoCham;
	}


	public JTextField getTb_Etage() {
		return Tb_Etage;
	}


	public void setTb_Etage(JTextField tb_Etage) {
		Tb_Etage = tb_Etage;
	}


	public JTextField getTb_Etat() {
		return Tb_Etat;
	}


	public void setTb_Etat(JTextField tb_Etat) {
		Tb_Etat = tb_Etat;
	}


	public JTextField getTb_CodType() {
		return Tb_CodType;
	}


	public void setTb_CodType(JTextField tb_CodType) {
		Tb_CodType = tb_CodType;
	}


	public JTextField getTb_Localisation() {
		return Tb_Localisation;
	}


	public void setTb_Localisation(JTextField tb_Localisation) {
		Tb_Localisation = tb_Localisation;
	}


	public JTextField getTb_DescType() {
		return Tb_DescType;
	}


	public void setTb_DescType(JTextField tb_DescType) {
		Tb_DescType = tb_DescType;
	}


	public JTextField getTb_DescLoc() {
		return Tb_DescLoc;
	}


	public void setTb_DescLoc(JTextField tb_DescLoc) {
		Tb_DescLoc = tb_DescLoc;
	}


	public JTextField getTb_Prix() {
		return Tb_Prix;
	}


	public void setTb_Prix(JTextField tb_Prix) {
		Tb_Prix = tb_Prix;
	}


	public JTable getTbl_Chambre() {
		return Tbl_Chambre;
	}


	public void setTbl_Chambre(JTable tbl_Chambre) {
		Tbl_Chambre = tbl_Chambre;
	}


	public JTable getTbl_Chambre_1() {
		return Tbl_Chambre_1;
	}


	public void setTbl_Chambre_1(JTable tbl_Chambre_1) {
		Tbl_Chambre_1 = tbl_Chambre_1;
	}
	
	
	
	
}
