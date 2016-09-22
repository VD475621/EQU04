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
		Ls_reser = mod_reser.Get_LsChambre();
		
	}
	
	
	public void Assign(Frm_Chambre frm_cham, int position)
	{
		mod_reser_cham = new Mod_Reservation_cham((int) mod_reser.Get_courant());
		
		//Faire un set de la table
		
		
		
	}


	/**
	 * @return the ls_reser
	 */
	private ArrayList<Mod_Reservation> getLs_reser() {
		return Ls_reser;
	}


	/**
	 * @param ls_reser the ls_reser to set
	 */
	private void setLs_reser(ArrayList<Mod_Reservation> ls_reser) {
		Ls_reser = ls_reser;
	}


	/**
	 * @return the position
	 */
	private int getPosition() {
		return position;
	}


	/**
	 * @param position the position to set
	 */
	private void setPosition(int position) {
		this.position = position;
	}
	
	
	
}
