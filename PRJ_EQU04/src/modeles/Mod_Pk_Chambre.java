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

			/*PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select c.NOCHAM, c.ETAGE,c.PRIX,c.FKCODTYPCHA,c.FKCODLOC " +
																											" from Chambre c, Reservation r, De d " + 
																											" where c.Nocham=d.FKNOCHAM and d.FKIDRESER=r.IDRESER AND c.etat = 1 " + 
																											" and not(?>r.DATEDEBUT and ?<r.DATEFIN) and not(?<r.DATEFIN and ?>r.DATEDEBUT)" +
																											" and d.Attribuee = 0");	
			state.setDate(1, DateDeb);
			state.setDate(2, DateDeb);
			state.setDate(3, DateFin);
			state.setDate(4, DateFin);*/

			PreparedStatement state = ModConnexion.getInstance()
									.getLaConnectionStatique()
									.prepareStatement("Select * from EQU04PRG01.SELECT_CHAMBRE_FILTRE where NoCham not in (select c.NoCham from EQU04PRG01.chambre c, EQU04PRG01.de d, EQU04PRG01.reservation r " + 
														" where c.nocham=d.FKNoCham AND d.FKIdReser=r.idreser AND " + 
														" (c.etat=0 OR not (TO_DATE('" + DateDeb + "', 'YY-MM-DD')>=r.dateFin OR TO_DATE('"+DateFin+"','YY-MM-DD')<=r.dateDebut))) order by NoCham");

			
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
									.prepareStatement("INSERT INTO EQU04PRG01.TEMP_CHAMBRE VALUES ('" + c + "')");
			
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
									.prepareStatement("DELETE FROM EQU04PRG01.TEMP_CHAMBRE WHERE NoCham=?");	
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
									.prepareStatement("DELETE FROM EQU04PRG01.TEMP_CHAMBRE");
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
