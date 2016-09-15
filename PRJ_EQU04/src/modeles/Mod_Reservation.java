package modeles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Reservation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variable client
	private int IdCli;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String typ_carte;
	private Date exp;
	private double solde_du;
	//variable reservation
	private int IdReser;
	private Date dateReser;
	private Date dateDebut;
	private Date dateFin;


	
	public Mod_Reservation()
	{
		Lire_Enre();
	}
	
	public Mod_Reservation(int IdCli, String nom, String adresse, String telephone, String fax, String typ_carte, Date exp, double solde_du, int IdReser, Date dateReser, Date dateDebut, Date dateFin)
	{
		SetIdCli(IdCli);
		SetNom(nom);
		SetAdresse(adresse);
		SetTelephone(telephone);
		SetFax(fax);
		SetTypeCarte(typ_carte);
		SetExp(exp);
		SetSolde(solde_du);
		SetIdReser(IdReser);
		SetDateReser(dateReser);
		SetDateDebut(dateDebut);
		SetDateFin(dateFin);
	}
	
	//incomplet
	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("");
			//state.setInt(1,vnumbon);
			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
			    int noBon = rs.getInt("");
				int num_prod = rs.getInt("");
			    String des_prod = rs.getString("");
				int quan_com = rs.getInt("");
				double prix_unitaire = rs.getDouble("");
				double prix_vente = rs.getDouble("");
				//setNumBon(noBon);
				//lesProduits.add(new ModContientProduit(num_prod,des_prod,quan_com,prix_unitaire,prix_vente));  
				}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Mod_Reservation.java",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void SetIdCli(int id)
	{
		this.IdCli = id;
	}
	public int GetIdCli()
	{
		return this.IdCli;
	}
	
	public void SetIdReser(int id)
	{
		this.IdReser = id;
	}
	
	public int GetIdReser()
	{
		return this.IdReser;
	}
	
	public void SetNom(String id)
	{
		this.nom = id;
	}
	public String GetNom()
	{
		return this.nom;
	}
	
	public void SetAdresse(String id)
	{
		this.adresse = id;
	}
	
	public String GetAdresse()
	{
		return this.adresse;
	}
	
	public void SetTelephone(String id)
	{
		this.telephone = id;
	}
	
	public String GetTelephone()
	{
		return this.telephone;
	}
	
	public void SetFax(String id)
	{
		this.fax = id;
	}
	
	public String GetFax()
	{
		return this.fax;
	}

	public void SetTypeCarte(String id)
	{
		this.typ_carte = id;
	}
	public String GetTypeCarte()
	{
		return this.typ_carte;
	}
	public void SetExp(Date id)
	{
		this.exp = id;
	}

	public Date GetExp()
	{
		return this.exp;
	}
	public void SetSolde(double id)
	{
		this.solde_du = id;
	}
	
	public double GetSolde()
	{
		return this.solde_du;
	}
	public void SetDateReser(Date id)
	{
		this.dateReser = id;
	}
	
	public Date GetDateReser()
	{
		return this.dateReser;
	}
	
	public void SetDateDebut(Date id)
	{
		this.dateDebut = id;
	}
	
	public Date GetDateDebut()
	{
		return this.dateDebut;
	}
	
	public void SetDateFin(Date id)
	{
		this.dateFin = id;
	}
	
	public Date GetDateFin()
	{
		return this.dateFin;
	}
}
