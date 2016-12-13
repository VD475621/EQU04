package modeles;

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
	private String NoCli;
	private String NomCli;
	private String DateDepart;
	
	private ArrayList<Mod_Depart_Cham> les_reser_c = new  ArrayList<Mod_Depart_Cham>();
	private final  String[] lesTitres = {"No chambre", "No. Client", "Nom du client", "Date de départ"};
	
	public Mod_Depart_Cham(String _Nocham, String _NoCli, String _NomCli, String _DateDepart)
	{
		this.NoCham = _Nocham;
		this.NoCli = _NoCli;
		this.NomCli = _NomCli;
		this.DateDepart = _DateDepart;
	}
	
	public Mod_Depart_Cham(String _IdReserv)
	{
		super();
		Lire_Enre(_IdReserv);
	}
	
	public void Lire_Enre(String _IdReserv)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select d.FKNoCham,d.FKIdCli,c.Nom,d.dateDepart FROM Depart d,Client c WHERE d.FKIdReser = ?");
			state.setInt(1, Integer.parseInt(_IdReserv));
			
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String nocham = rs.getString("FKNoCham");
				String IdCli = rs.getString("FKIdCli");
				String Nom = rs.getString("Nom");
				String DateDepart = rs.getString("dateDepart");
				
				les_reser_c.add(new Mod_Depart_Cham(nocham, IdCli, Nom, DateDepart));  
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return les_reser_c.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stubßßßßßßß
		Mod_Depart_Cham c = les_reser_c.get(rowIndex);
		if(columnIndex == 0) {return c.getNoCham();}
		if(columnIndex == 1) {return c.getNoCli();}
		if(columnIndex == 2) {return c.getNomCli();}
		if(columnIndex == 3) {return c.getDateDepart();}
		return null;
	}

	public ArrayList<Mod_Depart_Cham> getLes_reser_c() {
		return les_reser_c;
	}

	public void setLes_reser_c(ArrayList<Mod_Depart_Cham> les_reser_c) {
		this.les_reser_c = les_reser_c;
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

	public String getNoCli() {
		return NoCli;
	}

	public String getNomCli() {
		return NomCli;
	}

	public String getDateDepart() {
		return DateDepart;
	}

	
	

}
