package modeles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Reservation extends AbstractTableModel{
	
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
	
	private int courant=0;
	
	private ArrayList<Mod_Reservation> les_resers = new  ArrayList<Mod_Reservation>();
	public final  String[] lesTitres = {"IdCli", "Nom","adresse","telephone","fax","typ_carte","exp","solde_du", "IdReser", "dateReser","dateDebut", "dateFin"};
	
	public Mod_Reservation()
	{
		Lire_Enre();
	}
	
	public Mod_Reservation(int IdCli, String nom, String adresse, String telephone, String fax, String typ_carte, java.sql.Date exp, double solde_du, int IdReser, java.sql.Date dateReser, java.sql.Date dateDebut, java.sql.Date dateFin)
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
	
	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT c.IdCli, c.Nom, c.Adresse, c.Telephone, c.fax, c.TypeCarte, c.DateExp, "+
																											"c.Solde_Du, r.IdReser, r.dateReser, r.dateDebut, r.dateFin " + 
																											"FROM CLIENT c, RESERVATION r WHERE r.FKIdCli=c.IdCli order by r.IdReser");	
			ResultSet rs = state.executeQuery();
			
			
			while (rs.next()) {
				int idcli = rs.getInt("IdCli");
				String nom = rs.getString("Nom");
				String adresse = rs.getString("Adresse");
				String tel = rs.getString("Telephone");
				String fax = rs.getString("fax");
				String carte = rs.getString("TypeCarte");
				java.sql.Date exp = rs.getDate("DateExp");
				double solde = rs.getDouble("Solde_Du");
				int idreser = rs.getInt("IdReser");
				java.sql.Date datreser = rs.getDate("dateReser");
				java.sql.Date datdebut = rs.getDate("dateDebut");
				java.sql.Date datfin = rs.getDate("dateFin");

				System.out.println(idcli + " " + nom + " " + adresse + " " + tel +" " + fax + " " + carte +  " " + exp + " " + solde + " " + idreser + " " + datreser + " " + datdebut + " " + datfin);
				
				les_resers.add(new Mod_Reservation(idcli, nom, adresse, tel, fax, carte, exp, solde, idreser, datreser, datdebut, datfin)); 
				//this.setCourant(idreser);
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
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

	public ArrayList<Mod_Reservation> getLes_resers() {
		return les_resers;
	}

	public void setLes_resers(ArrayList<Mod_Reservation> les_resers) {
		this.les_resers = les_resers;
	}

	public int Get_courant() {
		// TODO Auto-generated method stub
		return courant;
	}

	public void setCourant(int valueAt) {
		// TODO Auto-generated method stub
		this.courant = valueAt;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return les_resers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Mod_Reservation reser = (Mod_Reservation)les_resers.get(rowIndex);
		
		if(columnIndex == 0) return reser.GetIdCli();
		if(columnIndex == 1) return reser.GetNom();
		if(columnIndex == 2) return reser.GetAdresse();
		if(columnIndex == 3) return reser.GetTelephone();
		if(columnIndex == 4) return reser.GetFax();
		if(columnIndex == 5) return reser.GetTypeCarte();
		if(columnIndex == 6) return reser.GetExp();
		if(columnIndex == 7) return reser.GetSolde();
		if(columnIndex == 8) return reser.GetIdReser();
		if(columnIndex == 9) return reser.GetDateReser();
		if(columnIndex == 10) return reser.GetDateDebut();
		if(columnIndex == 11) return reser.GetDateFin();
		
		return null;
	}
	
	public java.sql.Date getDatDuJour() {
	    Calendar calendar = Calendar.getInstance();
	    java.util.Date laDate = calendar.getTime();
	    return new java.sql.Date(laDate.getTime());
	}
	public java.sql.Date getDatRequise()
	{
		 Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.DATE, 10);
		 java.util.Date laDate = calendar.getTime();
		 return new java.sql.Date(laDate.getTime());
	}
	
	
}
