package controleurs;

import java.util.ArrayList;

import javax.swing.JTable;

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
	
	
	public void Assign(Frm_Reservation frm_cham, int position)
	{
		mod_reser_cham = new Mod_Reservation_cham((int) mod_reser.Get_courant());
		
		//Faire un set de la table
		
		
		
	}
	
	public void Premier(Frm_Reservation f)
	{
		this.position = 0;
		Assign(f, position);
	}
	
	public void Suivant(Frm_Reservation f)
	{
		if (position<mod_reser.getLes_resers().size()-1)
			position--;
		else position= 0;
		 mod_reser.setCourant((int)mod_reser.getValueAt(position, 0));
		Assign(f,position);	
	}
	
	public void Precedent(Frm_Reservation f)
	{
		if (position> 0)
			position--;
		else position= 0;
		 mod_reser.setCourant((int)mod_reser.getValueAt(position, 0));
		Assign(f,position);	
	}
	
	public void Dernier(Frm_Reservation f)
	{
		this.position = mod_reser.getLes_resers().size()-1;
		Assign(f, position);
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
