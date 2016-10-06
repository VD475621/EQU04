package controleurs;

import java.util.ArrayList;

import View.Frm_Arrive;
import modeles.Mod_Arrive_Cham;
import modeles.ModelArrive;

public class Ctrl_Arrive {
	public ModelArrive mod_arrive = null;
	private Frm_Arrive form;
	public Mod_Arrive_Cham mod_arrive_cham = null;
	private ArrayList<ModelArrive> Ls_reser = null;
	private int position = 0;
	
	
	public Ctrl_Arrive(Frm_Arrive frm_arriv)
	{
		form = frm_arriv;
		mod_arrive = new ModelArrive(); 
		Ls_reser = mod_arrive.getLesEnreg();
		
	}
	
	
	public void Assign(int position)
	{
		mod_arrive.setCourant(position);
		
		
		//affichage de la reservation et du client
		
		form.getTB_CliNo().setText(mod_arrive.getValueAt(position, 0).toString());
		form.getTB_Nom().setText(mod_arrive.getValueAt(position, 1).toString());
		form.getTB_Adr().setText(mod_arrive.getValueAt(position, 2).toString());
		form.getTB_Tel().setText(mod_arrive.getValueAt(position, 3).toString());
		form.getTB_Fax().setText(mod_arrive.getValueAt(position, 4).toString());
		form.getTB_NumCham().setText(mod_arrive.getValueAt(position, 5).toString());
		form.getTB_NoReserv().setText(mod_arrive.getValueAt(position, 6).toString());
		form.getTB_DateReserv().setText(mod_arrive.getValueAt(position, 7).toString());
		form.getTB_DateDebut().setText(mod_arrive.getValueAt(position, 8).toString());
		form.getTB_DateFin().setText(mod_arrive.getValueAt(position, 9).toString());
		form.getTB_NoCli().setText(mod_arrive.getValueAt(position, 0).toString());
		form.getTB_NomReserv().setText(mod_arrive.getValueAt(position, 1).toString());
		
		
		//affichage des chambres
		mod_arrive_cham = new Mod_Arrive_Cham(mod_arrive.getValueAt(position, 6).toString());
		form.getTBL_Reserv().setModel(mod_arrive_cham);
		
		
	}
	
	public void Premier()
	{
		this.position = 0;
		Assign(position);
	}
	
	public void Suivant()
	{
		if(position > (mod_arrive.getLesEnreg().size() - 1) )
			position = 0;
		else
			position++;
		 mod_arrive.setCourant(position);
		Assign(position);	
	}
	
	public void Precedent()
	{
		if (position < 0)
			position = mod_arrive.getLesEnreg().size() - 1;
		else 
			position--;
		
		 mod_arrive.setCourant(position);
		Assign(position);	
	}
	
	public void Dernier()
	{
		this.position = mod_arrive.getLesEnreg().size()-1;
		Assign(position);
	}
	
	public int getIndexofReserv(String IdReserv)
	{
		for(int i = 0;i < (mod_arrive.getLesEnreg().size()-1) ; i++){
			if(mod_arrive.getValueAt(i,6).toString().equals(IdReserv))
				return i;
		}
		return -1;
	}
	
	
/*
	//GESTION DES LISTES DE SÉLECTION (PICKLISTS)
		//Liste des bons à partir du modèle ModBonAcheteur (vue principale)
		//voir CtrlListBons et WinListBons
		public void ListeBons (WinBon winBon)
		{   WinListBons pkListBon = new WinListBons();
		    pkListBon.setVisible(true);
			AffecteValeurs(winBon,pkListBon.getNoLigneSel());	
		}
		
		//Liste des acheteurs voir WinListAcheteurs, ModListAcheteur et CtrlListAcheteurs
		public void ListeAch (WinBon winBon)
		{   WinListAcheteurs pkListAch = new WinListAcheteurs();
		    pkListAch.setLocationRelativeTo(winBon.getbtnPkAch());
		    pkListAch.setVisible(true);
		    pkListAch.setEnabled(true);
			AfficheAcheteur(winBon,pkListAch);	
		}
		
		//Liste des produits voir WinListProduits, ModListProduits et CtrlListProduits
		public void ListeProduits (WinBon winBon)
		{   WinListProduits pkListProd = new WinListProduits();
		    ModContientProduit unProduit;
		    pkListProd.setLocationRelativeTo(winBon.getBtnAjtProduit());
		    pkListProd.setVisible(true);
		    pkListProd.setEnabled(true);
		    
		    //récupération des informations de la liste de sélection via son controleur
		    int noProd = pkListProd.getCtrl().getNoProduit();
			String descProd = pkListProd.getCtrl().getDesProd();
			Double prixProd = pkListProd.getCtrl().getPrixProd();
			int Qte = 0;
			Double prixVente = 0.0;
			
			// Création d'un produit selon le modèle contient produit
			unProduit = new ModContientProduit(noProd,descProd,Qte,prixProd,prixVente);
			modeleProduit.AjouteProduit(unProduit);
			winBon.setjScrollPane(new JTable(modeleProduit)); 
		}
		*/
	

	public ModelArrive getmod_arrive() {
		return mod_arrive;
	}


	public void setmod_arrive(ModelArrive mod_arrive) {
		this.mod_arrive = mod_arrive;
	}


	public ModelArrive getmod_arrive_cham() {
		return mod_arrive;
	}


	public void setmod_arrive_cham(ModelArrive mod_arrive_cham) {
		this.mod_arrive = mod_arrive_cham;
	}


	public ArrayList<ModelArrive> getLs_reser() {
		return Ls_reser;
	}


	public void setLs_reser(ArrayList<ModelArrive> ls_reser) {
		Ls_reser = ls_reser;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	
	
	
	
}
