package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Reservation_cham extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Mod_Reservation_cham> les_reser_c = new  ArrayList<Mod_Reservation_cham>();
	private final  String[] lesTitres = {"No chambre", "Type", "Prix", "Occupée"};
	
	Mod_Reservation_cham()
	{
		
	}
	
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
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
