package controleurs;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import View.DateTimePicker;
import View.Frm_Reservation;
import View.Frm_Reservation.State;
import View.Pk_List;
import modeles.Mod_Pk_Chambre;
import modeles.Mod_Pk_Client;
import modeles.Mod_Pk_Reservation;
import modeles.Mod_Reservation;
import modeles.Mod_Reservation_cham;

public class Ctrl_Reservation {
	public Mod_Reservation mod_reser;
	public Mod_Reservation_cham mod_reser_cham;
	private ArrayList<Mod_Reservation> Ls_reser;
	private int position = 0;
	private JTable jt;
	
	private java.sql.Date datedebut_b = null;
	private java.sql.Date datefin_b = null;
	
	public Ctrl_Reservation(Frm_Reservation frm_cham)
	{
		mod_reser = new Mod_Reservation(); 
		Ls_reser = mod_reser.getLes_resers();
		Assign(frm_cham, position);
	}
	
	
	public void Assign(Frm_Reservation frm, int position)
	{
		mod_reser.setCourant((int) mod_reser.getValueAt(position, 8));
		
		//affichage de la reservation et du client
		frm.getTb_IdCli().setText(mod_reser.getValueAt(position, 0).toString());
		frm.getTb_Nom().setText(mod_reser.getValueAt(position, 1).toString());
		frm.getTb_adresse().setText(mod_reser.getValueAt(position, 2).toString());
		frm.getTbf_telephone().setText(mod_reser.getValueAt(position, 3).toString());
		frm.getTbf_fax().setText(mod_reser.getValueAt(position, 4).toString());
		frm.getTb_typ_carte().setText(mod_reser.getValueAt(position, 5).toString());
		frm.getTbf_exp().setText(mod_reser.getValueAt(position, 6).toString());
		frm.getTbf_solde_du().setText(mod_reser.getValueAt(position, 7).toString());
		frm.getTb_IdReser().setText(mod_reser.getValueAt(position, 8).toString());
		frm.getTb_date_reser().setText(mod_reser.getValueAt(position, 9).toString());
		frm.getTb_date_debut().setText(mod_reser.getValueAt(position, 10).toString());
		frm.getTb_date_fin().setText(mod_reser.getValueAt(position, 11).toString());
		
		
		//affichage des chambres
		
		mod_reser_cham = new Mod_Reservation_cham(mod_reser.Get_courant());
		jt = new JTable(mod_reser_cham);
		jt.removeColumn(jt.getColumnModel().getColumn(0));
		frm.setjScrollPane(jt);
	}
	
	public void ViderChamps(Frm_Reservation f)
	{
		f.getTb_adresse().setText("");
		f.getTb_date_debut().setText(mod_reser.getDatDuJour().toString());
		f.getTb_date_fin().setText(mod_reser.getDateRequise().toString());
		f.getTb_date_reser().setText(mod_reser.getDatDuJour().toString());
		f.getTb_IdCli().setText("");
		int value =(int)mod_reser.getValueAt(mod_reser.getRowCount()-1, 8) +1;
		f.getTb_IdReser().setText(Integer.toString(value));
		f.getTb_Nom().setText("");
		f.getTb_typ_carte().setText("");
		f.getTbf_exp().setText("");
		f.getTbf_fax().setText("");
		f.getTbf_solde_du().setText("");
		f.getTbf_telephone().setText("");
		
		mod_reser_cham = new Mod_Reservation_cham();
		jt = new JTable(new DefaultTableModel(new Object[]{"No chambre", "Type", "Prix", "Occupee"}, 0));
		f.getScrP_Reser().setViewportView(jt);
	}
	
	public void Premier(Frm_Reservation f)
	{
		this.position = 0;
		Assign(f, position);
	}
	
	public void Suivant(Frm_Reservation f)
	{
		if (position<mod_reser.getLes_resers().size()-1)
			position++;
		else 
			position= 0;
		mod_reser.setCourant((int)mod_reser.getValueAt(position, 8));
		Assign(f, position);	
	}
	
	public void Precedent(Frm_Reservation f)
	{
		if (position> 0)
			position--;
		else 
			position= mod_reser.getLes_resers().size()-1;
		mod_reser.setCourant((int)mod_reser.getValueAt(position, 8));
		Assign(f,position);	
	}
	
	public void Dernier(Frm_Reservation f)
	{
		this.position = mod_reser.getLes_resers().size()-1;
		Assign(f, position);
	}
	
	public void ListeReservation(Frm_Reservation f)
	{
		int value = (int)Pk_List.pickFromTable(new Mod_Pk_Reservation(), "Listes des Reservations");
		for(int i=0; i<mod_reser.getLes_resers().size(); i++)
			if(value==(int)mod_reser.getValueAt(i, 8)){
				position = i; break;
			}
		this.Assign(f, position);
	}
	
	public void ListeClient(Frm_Reservation f)
	{
		int value = (int)Pk_List.pickFromTable(new Mod_Pk_Client(), "Listes des Clients");
		for(int i=0; i<mod_reser.getLes_resers().size(); i++)
			if(value==(int)mod_reser.getValueAt(i, 0))
			{
				f.getTb_IdCli().setText(mod_reser.getValueAt(i, 0).toString());
				f.getTb_Nom().setText(mod_reser.getValueAt(i, 1).toString());
				f.getTb_adresse().setText(mod_reser.getValueAt(i, 2).toString());
				f.getTbf_telephone().setText(mod_reser.getValueAt(i, 3).toString());
				f.getTbf_fax().setText(mod_reser.getValueAt(i, 4).toString());
				f.getTb_typ_carte().setText(mod_reser.getValueAt(i, 5).toString());
				f.getTbf_exp().setText(mod_reser.getValueAt(i, 6).toString());
				f.getTbf_solde_du().setText(mod_reser.getValueAt(i, 7).toString());
				return;
			}
	}
	
	
	public void ListeChambreFiltrer(Frm_Reservation f, java.sql.Date DateDeb, java.sql.Date DateFin){
		ArrayList<Object> row = Pk_List.pickFromTableRow(new Mod_Pk_Chambre(DateDeb, DateFin), "Listes des Chambres");
		if(row != null){
			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.addRow(new Object[]{row.get(0).toString(), row.get(3).toString(), Double.parseDouble(row.get(2).toString()), false});
			Mod_Pk_Chambre.AjouterChambreTemp((String) row.get(0));
			f.setjScrollPane(jt);
		}
	}
	
	public void RetirerChambre(Frm_Reservation f){
		if(f.getEtat() != State.Consulter && jt.getSelectedRow() != -1){
			Mod_Pk_Chambre.RetirerChambreTemp((String) jt.getValueAt(jt.getSelectedRow(), 0));
			DefaultTableModel model = (DefaultTableModel) jt.getModel();
			model.removeRow(jt.getSelectedRow());
			f.setjScrollPane(jt);
		}
	}
	
	public void SauvegarderReservation(Frm_Reservation f){
		if(Validation(f)){
			Mod_Reservation mod;
			ArrayList<String> c = new ArrayList<String>();
			
			int idreser = Integer.parseInt(f.getTb_IdReser().getText());
			int idcli = Integer.parseInt(f.getTb_IdCli().getText());
			java.sql.Date datereser = java.sql.Date.valueOf(f.getTb_date_reser().getText());
			java.sql.Date datedebut = java.sql.Date.valueOf(f.getTb_date_debut().getText());
			java.sql.Date datefin = java.sql.Date.valueOf(f.getTb_date_fin().getText());
			
			mod = new Mod_Reservation(idreser, idcli, datereser, datedebut, datefin);
			//System.out.println(idreser + " " + idcli + " " + datereser + " " + datedebut + " " + datefin);
			for(int i=0;i<jt.getRowCount();i++){
				c.add(jt.getValueAt(i, 0).toString());
			}
			//System.out.println(c);
			mod_reser.SauvegarderReservation(mod, c);
			
			mod_reser = new Mod_Reservation(); 
			Ls_reser = mod_reser.getLes_resers();
			Assign(f, position);
			f.Consulter();
			Mod_Pk_Chambre.ViderChambreTemp();
		}
		
	}
	
	public boolean Validation(Frm_Reservation f){
		boolean flag = true;
		String erreur = "";
		JViewport viewport = f.getScrP_Reser().getViewport(); 
		JTable jt = (JTable)viewport.getView();
		if(f.getTb_IdCli().getText().isEmpty()){
			flag = false;
			erreur += "Un client doit etre selectionne!\n";
		}
		if(jt.getRowCount()==0){
			flag = false;
			erreur += "Au moins une chambre doit etre selectionnee!\n";
		}
		
		java.sql.Date reser = java.sql.Date.valueOf(f.getTb_date_reser().getText());
		java.sql.Date debut = java.sql.Date.valueOf(f.getTb_date_debut().getText());
		java.sql.Date fin = java.sql.Date.valueOf(f.getTb_date_fin().getText());
		if(reser.compareTo(debut)>0){
			flag = false;
			erreur += "La date de debut doit etre egale ou superieur a la date de reservaton!\n";
		}
		if(debut.compareTo(fin)>0){
			flag = false;
			erreur += "La date de fin doit etre superieur a la date de debut!";
		}
		
		if(!flag){
			JOptionPane.showMessageDialog(f, erreur);
		}
		
		return flag;
	}
	
	public void SupprimerReservation(Frm_Reservation f){
		int idreser = Integer.parseInt(f.getTb_IdReser().getText());
		ArrayList<String> c = new ArrayList<String>();
		for(int i=0;i<jt.getRowCount();i++){
			c.add(jt.getValueAt(i, 0).toString());
		}
		
	}
	
	public void Modification(Frm_Reservation f){
		
	}
	
	public void SauvegarderModificationReservation(Frm_Reservation f){
		if(Validation(f)){
			
		}
	}
	
	public void ViderTableTemp(){
		Mod_Pk_Chambre.ViderChambreTemp();
	}
	
	public void GetDate(Frm_Reservation f, JTextField TBox, boolean d){
		DateTimePicker.pickDate(f, TBox);
	}
	
	public boolean DateInModif(Frm_Reservation f, JTextField TBox, boolean d){
		if(f.getEtat() == State.Modifier && datedebut_b != null && datefin_b != null){
			java.sql.Date date2 = java.sql.Date.valueOf(TBox.getText());
			if(d){
				if(datedebut_b.compareTo(date2)>0){
					TBox.setText(datedebut_b.toString());
					JOptionPane.showMessageDialog(null, "Erreur, date de debut ne peut etre changer pour une date anterieur",
							"ERREUR", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			else{
				if(datefin_b.compareTo(date2)<0){
					TBox.setText(datefin_b.toString());
					JOptionPane.showMessageDialog(null, "Erreur, date de fin ne peut etre changer pour une date ulterieur",
							"ERREUR", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		return true;
	}
	
	public void ModifDateIsArrive(Frm_Reservation f){
		if(mod_reser.IsArrive(Integer.parseInt(f.getTb_IdReser().getText()))){
			JOptionPane.showMessageDialog(null, "Erreur, date de debut ne peut etre changer, car le client est arrive",
					"ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		else
			this.GetDate(f, f.getTb_date_debut(), true);
	}
	
	public void ModifDateIsDepart(Frm_Reservation f){
		if(mod_reser.IsDepart(Integer.parseInt(f.getTb_IdReser().getText()))){
			JOptionPane.showMessageDialog(null, "Erreur, date de fin ne peut etre changer, car le client est partit",
					"ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		else
			this.GetDate(f, f.getTb_date_debut(), true);
	}
	
	public void ModifierClient(Frm_Reservation f){
		if(mod_reser.IsClient(Integer.parseInt(f.getTb_IdReser().getText()),Integer.parseInt(f.getTb_IdCli().getText()))){
			JOptionPane.showMessageDialog(null, "Ce client possede des transactions on ne peut le modifier", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		else{
			this.ListeClient(f);
		}
	}
	
	public void SetOldDateInModif(Frm_Reservation f){
		datedebut_b = java.sql.Date.valueOf(f.getTb_date_debut().getText());
		datefin_b = java.sql.Date.valueOf(f.getTb_date_fin().getText());
		
		//System.out.println(datedebut_b + " " + datefin_b);
	}
		

	public Mod_Reservation getMod_reser() {
		return mod_reser;
	}


	public void setMod_reser(Mod_Reservation mod_reser) {
		this.mod_reser = mod_reser;
	}


	public Mod_Reservation_cham getMod_reser_cham() {
		return mod_reser_cham;
	}


	public void setMod_reser_cham(Mod_Reservation_cham mod_reser_cham) {
		this.mod_reser_cham = mod_reser_cham;
	}


	public ArrayList<Mod_Reservation> getLs_reser() {
		return Ls_reser;
	}


	public void setLs_reser(ArrayList<Mod_Reservation> ls_reser) {
		Ls_reser = ls_reser;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}
	
}
