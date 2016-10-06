package controleurs;

import javax.swing.JTable;

import View.Frm_Base;
import View.Frm_Chambre;
import modeles.Mod_Chambre;
import modeles.Mod_ChambreTable;

public class Ctrl_Chambre {
	

	private int position;
	
	private Frm_Chambre frm_Cham = null;
	
	
	public Ctrl_Chambre(Frm_Chambre frm_cham)
	{
	
		this.frm_Cham = frm_cham;
		
		Mod_Chambre.Lire();
		
		position= 0;
	}
	
	
	public void Assign()
	{	//Faire un set de la table
		frm_Cham.getTb_NoCham().setText(Mod_Chambre.getPosition(position, 0).toString());
		frm_Cham.getTb_Etage().setText(Mod_Chambre.getPosition(position, 1).toString());
		frm_Cham.getTb_Etat().setText(Mod_Chambre.getPosition(position, 2).toString());
		frm_Cham.getTb_CodType().setText(Mod_Chambre.getPosition(position, 3).toString());
		frm_Cham.getTb_Localisation().setText(Mod_Chambre.getPosition(position, 4).toString());
		frm_Cham.getTb_DescType().setText(Mod_Chambre.getPosition(position, 5).toString());
		frm_Cham.getTb_DescLoc().setText(Mod_Chambre.getPosition(position, 6).toString());
		frm_Cham.getTb_Prix().setText(Mod_Chambre.getPosition(position, 7).toString());
		frm_Cham.getTb_Memo().setText(Mod_Chambre.getPosition(position, 8).toString());
		
		frm_Cham.get_DataGrid().setViewportView(new JTable(new Mod_ChambreTable(Mod_Chambre.getPosition(position, 0).toString())));
		//table
		
	}
	
	
	
	public void first(){  
		position = 0;
		Assign();
    }
	public void next(){  
		if (position < Mod_Chambre.getNbRow() - 1)
			position++;
		else 
			position = 0;
		Assign();
	}
	public void next1(){
		if (position > 0)
			position--;
		else 
			position = Mod_Chambre.getNbRow() - 1;
		Assign();	
	}
	public void last(){  
		position = Mod_Chambre.getNbRow() - 1;
		Assign();
    }
	public void quit(){  
		Frm_Base frm_Base = new Frm_Base();
		frm_Base.setVisible(true);
		frm_Cham.dispose();
		
    }
	
	public void ListeChambres (){   
		
		    //position = Pk_Base2.pickFromTable(new ModPLChambreChambre(),"listes des chambres");
			Assign();	
		
	}

}
