package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Pk_Client extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<?>> LesClients = new  ArrayList<ArrayList<?>>();
	private final  String[] lesTitres = {"IdCli","Nom", "Adresse", "Telephone"};
	
	public Mod_Pk_Client()
	{
		this.Lire_Enre();
	}
	
	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select IdCli, Nom, Adresse, Telephone from Client");	
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				
				row.add(rs.getInt("IdCli"));
				row.add(rs.getString("Nom"));
				row.add(rs.getString("Adresse"));
				row.add(rs.getString("Telephone"));

				LesClients.add(row); 
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_PkList_Client.java " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return LesClients.size();
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
		return LesClients.get(rowIndex).get(columnIndex);
	}

}
