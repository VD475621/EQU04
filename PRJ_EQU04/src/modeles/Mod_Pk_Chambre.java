package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Pk_Chambre extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<?>> LesChambres = new  ArrayList<ArrayList<?>>();
	private final  String[] lesTitres = {"NoCham","Etage", "Prix", "CodTypCha", "CodLoc"};

	public Mod_Pk_Chambre(java.sql.Date DateDeb, java.sql.Date DateFin)
	{
		this.Lire_Enre(DateDeb, DateFin);
	}
	
	public void Lire_Enre(java.sql.Date DateDeb, java.sql.Date DateFin)
	{
		//System.out.println(DateDeb);
		//System.out.println(DateFin);
		try {
			PreparedStatement state = ModConnexion.getInstance()
									.getLaConnectionStatique()
									.prepareStatement("Select * from SELECT_CHAMBRE_FILTRE where NoCham not in (select c.NoCham from chambre c, de d, reservation r " + 
														" where c.nocham=d.FKNoCham AND d.FKIdReser=r.idreser AND " + 
														" (c.etat=0 OR not (TO_DATE('" + DateDeb + "', 'YY-MM-DD')>=r.dateFin OR TO_DATE('"+DateFin+"','YY-MM-DD')<=r.dateDebut))) order by NoCham");
			//state.setDate(1, DateDeb);
			//state.setDate(2, DateFin);
			//state.setDate(3, DateFin);
			//state.setDate(4, DateFin);
			
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				
				row.add(rs.getString("NoCham"));
				row.add(rs.getString("Etage"));
				row.add(rs.getDouble("Prix"));
				row.add(rs.getString("FKCodTypCha"));
				row.add(rs.getString("FKCodLoc"));

				LesChambres.add(row); 
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_PkList_Client.java Lire_Enre" + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	public static void AjouterChambreTemp(String c){
		try {
			PreparedStatement state = ModConnexion.getInstance()
									.getLaConnectionStatique()
									.prepareStatement("INSERT INTO TEMP_CHAMBRE VALUES ('" + c + "')");
			
			state.executeUpdate();
			state.execute("commit");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_PkList_Client.java AjouterChambreTemp " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	public static void RetirerChambreTemp(String c){
		try {
			PreparedStatement state = ModConnexion.getInstance()
									.getLaConnectionStatique()
									.prepareStatement("DELETE FROM TEMP_CHAMBRE WHERE NoCham=?");	
			state.setString(1, c);
			state.executeUpdate();
			state.execute("commit");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_PkList_Client.java RetirerChambreTemp " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	public static void ViderChambreTemp(){
		try {
			PreparedStatement state = ModConnexion.getInstance()
									.getLaConnectionStatique()
									.prepareStatement("DELETE FROM TEMP_CHAMBRE");
			state.executeUpdate();
			state.execute("commit");
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_PkList_Client.java ViderChambreTemp " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return LesChambres.size();
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
		return LesChambres.get(rowIndex).get(columnIndex);
	}

}
