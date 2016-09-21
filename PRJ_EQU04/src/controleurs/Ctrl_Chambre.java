package controleurs;

import modeles.Mod_Chambre;
import modeles.Mod_ChambreTable;

import java.util.ArrayList;

import View.Frm_Chambre;

public class Ctrl_Chambre {
	
	public Mod_Chambre modeleChambre = null;
	private ArrayList<Mod_Chambre> Ls_chambre = null;
	private int position = 0;
	public Mod_ChambreTable modeleChambreTable = null; 
	
	
	public Ctrl_Chambre(Frm_Chambre frm_cham)
	{
		modeleChambre = new Mod_Chambre(); 
		Ls_chambre = modeleChambre.Get_LsChambre();
		
	}
	
	
	public void Assign(Frm_Chambre frm_cham, int position)
	{
		modeleChambreTable = new Mod_ChambreTable((int) modeleChambre.Get_courant());
		
		//Faire un set de la table
		
		
		
	}

}
