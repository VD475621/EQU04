package controleurs;

import java.util.ArrayList;

import View.Frm_Chambre;
import View.Frm_Reservation;
import modeles.Mod_Reservation;
import modeles.Mod_Reservation_cham;

public class Ctrl_Reservation {
	public Mod_Reservation mod_reser = null;
	public Mod_Reservation_cham mod_reser_cham = null;
	private ArrayList<Mod_Reservation> Ls_reser = null;
	private int position = 0;
	
	
	public Ctrl_Reservation(Frm_Reservation frm_cham)
	{
		mod_reser = new Mod_Reservation(); 
		Ls_reser = mod_reser.getLes_resers();
		
	}
	
	
	public void Assign(Frm_Chambre frm_cham, int position)
	{
		mod_reser_cham = new Mod_Reservation_cham((int) mod_reser.Get_courant());
		
		//Faire un set de la table
		
		
		
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
