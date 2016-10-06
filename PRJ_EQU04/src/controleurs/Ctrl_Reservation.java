package controleurs;

import java.util.ArrayList;

import javax.swing.JTable;

import View.Frm_Chambre;
import View.Frm_Reservation;
import View.Pk_List;
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
		f.getTb_adresse().setText(" ");
		f.getTb_date_debut().setText(" ");
		f.getTb_date_fin().setText(" ");
		f.getTb_date_reser().setText(mod_reser.getDatDuJour().toString());
		f.getTb_IdCli().setText(" ");
		int value =(int)mod_reser.getValueAt(mod_reser.getRowCount()-1, 8) +1;
		f.getTb_IdReser().setText(Integer.toString(value));
		f.getTb_Nom().setText(" ");
		f.getTb_typ_carte().setText(" ");
		f.getTbf_exp().setText(" ");
		f.getTbf_fax().setText(" ");
		f.getTbf_solde_du().setText(" ");
		f.getTbf_telephone().setText(" ");
		f.getScrP_Reser().setViewportView(new JTable());
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
 