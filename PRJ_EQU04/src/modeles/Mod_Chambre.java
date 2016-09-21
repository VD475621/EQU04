package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public final class Mod_Chambre{

	private static final long serialVersionUID = 1L;
	
	private int NoCham;
	private int Etage;
	private double Prix;
	private boolean Etat;
	private String Memo;
	private String CodTypCha;
	private String CodLoc;
	private String Desc_typ;
	private String Desc_Loc;
	private int courant = 0;
	
	
	public static ArrayList<ArrayList<?>> Ls_Chambre = new ArrayList<ArrayList<?>>();
	

	public static void setLs_Chambre(ArrayList<ArrayList<?>> ls_Chambre) {
		Ls_Chambre = ls_Chambre;
	}

	public static ArrayList<String> Titre_Tab = new ArrayList<String>();
	
	
	public Mod_Chambre()
	{
		super();
		Titre_Tab.add("noCham");
		Titre_Tab.add("etage");
		Titre_Tab.add("etat");
		Titre_Tab.add("codeType");
		Titre_Tab.add("codeLoc");
		Titre_Tab.add("descType");
		Titre_Tab.add("descLoc");
		Titre_Tab.add("prix");
		Titre_Tab.add("memo");
	}
	
	public Mod_Chambre(int No_Cham, int etage, double prix, boolean etat, String memo, String codtypcha,String codloc, String desctyp, String descloc)
	{
		super();
		
		this.Set_Nocham(No_Cham);
		this.Set_Etage(etage);
		this.Set_Prix(prix);
		this.Set_Etat(etat);
		this.Set_Memo(memo);
		this.Set_CodTypCham(codtypcha);
		this.Set_CodLoc(codloc);
		this.Set_DescTyp(desctyp);
		this.Set_DescLoc(descloc);
		
	}
	
	
	public static void Lire()
	{
		try {    
			
			
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT ");
			
			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				row.add(rs.getString("noCham"));
				row.add(rs.getString("etage"));
				row.add(rs.getBoolean("etat"));
				row.add(rs.getString("codTypCha"));
				row.add(rs.getString("codLoc"));
				row.add(rs.getString("descType"));
				row.add(rs.getString("descLoc"));
				row.add(rs.getDouble("prix"));
				row.add(rs.getString("memo"));
				System.out.println(row.get(0));
				Ls_Chambre.add(row);   
				}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Mod_Chambre.java",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	//Get et Set ------------------------------------------------------------------
	
	public static int getNbRow() {return Ls_Chambre.size();}
	
	public static Object getPosition(int rowIndex, int columnIndex) {return Ls_Chambre.get(rowIndex).get(columnIndex);}
	
	public static ArrayList<ArrayList<?>> getLs_Chambre() {
		return Ls_Chambre;
	}
	
	public int Get_Nocham()
	{
		return this.NoCham;
	}
	
	public void Set_Nocham(int set)
	{
		this.NoCham = set;
	}
	
	
	public int Get_Etage()
	{
		return this.Etage;
	}
	
	public void Set_Etage(int set)
	{
		this.Etage = set;
	}
	
	
	public double Get_Prix()
	{
		return this.Prix;
	}
	
	public void Set_Prix(double set)
	{
		this.Prix = set;
	}
	
	public boolean Get_Etat()
	{
		return this.Etat;
	}
	
	public void Set_Etat(boolean set)
	{
		this.Etat = set;
	}
	
	
	public String Get_Memo()
	{
		return this.Memo;
	}
	
	public void Set_Memo(String set)
	{
		this.Memo = set;
	}
	
	
	public String Get_CodTypCham()
	{
		return this.CodTypCha;
	}
	
	public void Set_CodTypCham(String set)
	{
		this.CodTypCha = set;
	}
	
	
	
	public String Get_CodLoc()
	{
		return this.CodLoc;
	}
	
	public void Set_CodLoc(String set)
	{
		this.CodLoc = set;
	}
	
	
	public String Get_DescTyp()
	{
		return this.Desc_typ;
	}
	
	public void Set_DescTyp(String set)
	{
		this.Desc_typ = set;
	}
	
	public String Get_DescLoc()
	{
		return this.Desc_Loc;
	}
	
	public void Set_DescLoc(String set)
	{
		this.Desc_Loc = set;
	}
	
	public int Get_courant()
	{
		return this.courant;
	}
	
	public void Set_courant(int set)
	{
		this.courant = set;
	}
//----------------------------------------------------------------------------------------	
	
	
	
	
	

}
