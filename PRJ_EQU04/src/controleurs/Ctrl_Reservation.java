package controleurs;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.DateTimePicker;
import View.Frm_Chambre;
import View.Frm_Reservation;
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
		else position= 0;
		 	mod_reser.setCourant((int)mod_reser.getValueAt(position, 8));
		Assign(f, position);	
	}
	
	public void Precedent(Frm_Reservation f)
	{
		if (position> 0)
			position--;
		else position= 0;
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
		
		//this.mod_reser_cham.setNoCham(row.get(0).toString());
		//this.mod_reser_cham.setType(row.get(3).toString());
		//this.mod_reser_cham.setPrix(Double.parseDouble(row.get(2).toString()));
		//this.mod_reser_cham.setOccupee(false);
		
		
		DefaultTableModel model = (DefaultTableModel) jt.getModel();
		model.addRow(new Object[]{row.get(0).toString(), row.get(3).toString(), Double.parseDouble(row.get(2).toString()), false});
		
		//jt.removeColumn(jt.getColumnModel().getColumn(0));
		f.setjScrollPane(jt);
	}
	
	public void RetirerChambre(Frm_Reservation f){
		DefaultTableModel model = (DefaultTableModel) jt.getModel();
		model.removeRow(jt.getSelectedRow());
		f.setjScrollPane(jt);
	}
	
	public void SauvegarderReservation(Frm_Reservation f){
		if(Validation(f)){
			Mod_Reservation mod;
			ArrayList<String> c = new ArrayList<String>();
			
			int idreser = Integer.parseInt(f.getTb_IdReser().getText());
			int idcli = Integer.parseInt(f.getTb_IdCli().getText());
			java.sql.Date datereser = Date.valueOf(f.getTb_date_reser().getText());
			java.sql.Date datedebut = Date.valueOf(f.getTb_date_debut().getText());
			java.sql.Date datefin = Date.valueOf(f.getTb_date_fin().getText());
			
			mod = new Mod_Reservation(idreser, idcli, datereser, datedebut, datefin);
			//System.out.println(idreser + " " + idcli + " " + datereser + " " + datedebut + " " + datefin);
			int n = jt.getRowCount();
			for(int i=0;i<n;i++){
				c.add(jt.getValueAt(i, 0).toString());
			}
			//System.out.println(c);
			mod_reser.SauvegarderReservation(mod, c);
			
			
			mod_reser = new Mod_Reservation(); 
			Ls_reser = mod_reser.getLes_resers();
			Assign(f, position);
			f.Consulter();
		}
		
	}
	
	public boolean Validation(Frm_Reservation f){
		return true;
	}
	
	
	public void GetDate(Frm_Reservation f, JTextField TBox){
		DateTimePicker.pickDate(f, TBox);
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
