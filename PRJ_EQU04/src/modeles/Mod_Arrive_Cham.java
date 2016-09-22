package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Arrive_Cham extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdReser;
	private String NoCham;
	private String Type;
	private double Prix;
	private boolean Occupee;
	
	private ArrayList<Mod_Arrive_Cham> les_reser_c = new  ArrayList<Mod_Arrive_Cham>();
	private final  String[] lesTitres = {"No chambre", "Type", "Prix", "Occupee"};
	
	public Mod_Arrive_Cham(String nocham, String type, double prix, boolean occ)
	{
		this.setNoCham(nocham);
		this.setType(type);
		this.setPrix(prix);
		this.setOccupee(occ);
	}
	
	public Mod_Arrive_Cham(String _IdReserv)
	{
		super();
		Lire_Enre(_IdReserv);
	}
	
	public void Lire_Enre(String _IdReserv)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select c.NoCham, c.FKCodTypCha, c.Prix, c.Etat FROM De d, Chambre c WHERE c.NoCham = d.FKNoCham AND d.FKIdReser = ?");
			state.setInt(1, Integer.parseInt(_IdReserv));
			
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String nocham = rs.getString("NoCham");
				String type = rs.getString("FKCodTypCha");
				double prix = rs.getDouble("Prix");
				boolean occ = rs.getBoolean("Etat");
				
				les_reser_c.add(new Mod_Arrive_Cham(nocham, type, prix, occ));  
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
		// TODO Auto-generated method stub
		Mod_Arrive_Cham c = (Mod_Arrive_Cham)les_reser_c.get(rowIndex);
		if(columnIndex == 0) {return c.getNoCham();}
		if(columnIndex == 1) {return c.getType();}
		if(columnIndex == 2) {return c.getPrix();}
		if(columnIndex == 3) {return c.isOccupee();}
		return null;
	}

	public ArrayList<Mod_Arrive_Cham> getLes_reser_c() {
		return les_reser_c;
	}

	public void setLes_reser_c(ArrayList<Mod_Arrive_Cham> les_reser_c) {
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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public boolean isOccupee() {
		return Occupee;
	}

	public void setOccupee(boolean occupee) {
		this.Occupee = occupee;
	}

	public int getIdReser() {
		return IdReser;
	}

	public void setIdReser(int idReser) {
		IdReser = idReser;
	}

	
	

}
