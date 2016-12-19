package modeles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Pk_Arrive extends AbstractTableModel{

	private int NoArrive;
	private int NoReser;
	private int IdCli;
	private String Nom;
	private Date DateArrive;
	private String NoCham;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Mod_Pk_Arrive> LesArrives = new  ArrayList<Mod_Pk_Arrive>();
	private final  String[] lesTitres = {"No.Reserv", "No.Client","Nom", "Date Arrive","No. Chambre"};

	public Mod_Pk_Arrive()
	{
		this.Lire_Enre();
	}

	public Mod_Pk_Arrive(int _NoArrive,int _NoReser, int _IdCli, String _Nom, Date _DateArrive, String _NoCham)
	{
		this.NoArrive = _NoArrive;
		this.NoReser = _NoReser;
		this.IdCli = _IdCli;
		this.Nom = _Nom;
		this.DateArrive = _DateArrive;
		this.NoCham = _NoCham;
	}

	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT a.NoArrive, a.FKIdReser, a.FKIdCli, c.Nom, a.dateArrive, a.FKNoCham FROM Client c, Arrive a WHERE a.FKIdCli = c.IdCli");	
			ResultSet rs = state.executeQuery();

			while (rs.next()) {

				LesArrives.add(new Mod_Pk_Arrive(
						rs.getInt("NoArrive"),
						rs.getInt("FKIdReser"),
						rs.getInt("FKIdCli"),
						rs.getString("Nom"),
						rs.getDate("dateArrive"),
						rs.getString("FKNoCham")
						)); 
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Pk_Arrive.java " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}

	public ArrayList<Mod_Pk_Arrive> getLesEnreg() {
		return LesArrives;
	}

	public Mod_Pk_Arrive getArriveByIdReserv(int IdReserv)
	{
		for(int i = 0;i < (this.getLesEnreg().size()-1) ; i++){
			if((int)getLesEnreg().get(i).getNoReser() == IdReserv)
				return getLesEnreg().get(i);
		}
		return null;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return LesArrives.size();
	}
	@Override
	public String getColumnName(int columnIndex)
	{
		return lesTitres[columnIndex];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Mod_Pk_Arrive arrive = LesArrives.get(rowIndex);
		if(columnIndex == 0) return arrive.getNoReser();
		if(columnIndex == 1) return arrive.getIdCli();
		if(columnIndex == 2) return arrive.getNom();
		if(columnIndex == 3) return arrive.getDateArriv();
		if(columnIndex == 4) return arrive.getNoCham();

		return null;
	}

	public int getNoArrive()
	{
		return this.NoArrive;
	}

	public int getNoReser()
	{
		return this.NoReser;
	}

	public int getIdCli()
	{
		return this.IdCli;
	}

	public String getNom()
	{
		return this.Nom;
	}

	public Date getDateArriv()
	{
		return this.DateArrive;
	}

	public String getNoCham()
	{
		return this.NoCham;
	}
}
