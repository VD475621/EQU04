package modeles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Depart_Cham extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdReser;
	
	private String NoCham;
	private int NoCli;
	private String NomCli;
	private Date DateDepart;
	
	private ArrayList<Mod_Depart_Cham> lesEnreg = new  ArrayList<Mod_Depart_Cham>();
	private final  String[] lesTitres = {"No chambre", "No. Client", "Nom du client", "Date de départ"};
	
	public Mod_Depart_Cham(String _Nocham, int _NoCli, String _NomCli, Date _DateDepart)
	{
		this.NoCham = _Nocham;
		this.NoCli = _NoCli;
		this.NomCli = _NomCli;
		this.DateDepart = _DateDepart;
	}
	
	public Mod_Depart_Cham(int _IdReserv)
	{
		super();
		Lire_Enre(_IdReserv);
	}
	
	public void Lire_Enre(int _IdReserv)
	{
		try {
			this.clear();
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select d.FKNoCham,d.FKIdCli,c.Nom,d.dateDepart FROM Depart d,Client c WHERE d.FKIdReser = ? AND d.FKIDCLI = c.IdCli");
			state.setInt(1, _IdReserv);
			
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String nocham = rs.getString("FKNoCham");
				int IdCli = rs.getInt("FKIdCli");
				String Nom = rs.getString("Nom");
				Date DateDepart = rs.getDate("dateDepart");
				
				lesEnreg.add(new Mod_Depart_Cham(nocham, IdCli, Nom, DateDepart));  
			}
			this.fireTableDataChanged();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean Insert(int _IdReser, int _IdCli, String _NoCham, Date _dateDepart,String ConfPar)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("INSERT INTO DEPART (NODEPART,FKIDRESER,FKIDCLI,FKNOCHAM,DATEDEPART,CONFIRMEPAR) VALUES(SEQ_ARRIVE.nextval,?,?,?,?,?)");
			state.setInt(1, _IdReser);
			state.setInt(2, _IdCli);
			state.setString(3, _NoCham);
			state.setDate(4, _dateDepart);
			state.setString(5, ConfPar);

			int rows = state.executeUpdate();
			System.out.println("Insert Result: "+rows);
			if(rows > 0)
			{
				this.Lire_Enre(_IdReser);
				return true;
			}
			else
				return false;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean setAttribue(int _IdReser, String _NoCham, boolean value)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("UPDATE DE SET Attribuee = ? WHERE FkNoCham = ? AND FkIdReser = ?");
			state.setInt(1, ((value) ? 1 : 0));
			state.setString(2, _NoCham);
			state.setInt(3, _IdReser);

			System.out.println("Attribue: " + ((value) ? 1 : 0));
			System.out.println("NoCham: " + _NoCham);
			System.out.println("IdReser: " + _IdReser);


			int rows = state.executeUpdate();
			System.out.println("Insert Result: "+rows);
			if(rows > 0)
				return true;
			else
				return false;

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Delete" + e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void clear()
	{
		lesEnreg.clear();
		this.fireTableDataChanged();
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesEnreg.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stubßßßßßßß
		Mod_Depart_Cham c = lesEnreg.get(rowIndex);
		if(columnIndex == 0) {return c.getNoCham();}
		if(columnIndex == 1) {return c.getNoCli();}
		if(columnIndex == 2) {return c.getNomCli();}
		if(columnIndex == 3) {return c.getDateDepart();}
		return null;
	}

	public ArrayList<Mod_Depart_Cham> getLes_reser_c() {
		return lesEnreg;
	}

	public void setLes_reser_c(ArrayList<Mod_Depart_Cham> les_reser_c) {
		this.lesEnreg = les_reser_c;
	}

	public String getColumnName(int ColumnIndex) {
		return lesTitres[ColumnIndex];
	}

	public String getNoCham() {
		return NoCham;
	}

	public void setNoCham(String noCham) {
		NoCham = noCham;
	}

	public int getNoCli() {
		return NoCli;
	}

	public String getNomCli() {
		return NomCli;
	}

	public Date getDateDepart() {
		return DateDepart;
	}

	
	

}
