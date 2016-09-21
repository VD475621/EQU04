package controleurs;

import java.util.ArrayList;

import View.Frm_Chambre;
import View.Frm_Reservation;
import modeles.Mod_Chambre;
import modeles.Mod_ChambreTable;
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
		mod_reser_cham = new mod_reser_cham((int) mod_reser.Get_courant());
		
		//Faire un set de la table
		
		
		
	}
	
}
