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
	private int IdReser;
	private String NoCham;
	private String Type;
	private double Prix;
	private boolean occupee;
	
	private ArrayList<Mod_Reservation_cham> les_reser_c = new  ArrayList<Mod_Reservation_cham>();
	private final  String[] lesTitres = {"No chambre", "Type", "Prix", "Occupee"};
	
	public Mod_Reservation_cham(String nocham, String type, double prix, boolean occ)
	{
		this.setNoCham(nocham);
		this.setType(type);
		this.setPrix(prix);
		this.setOccupee(occ);
	}
	
	public Mod_Reservation_cham(int position)
	{
		super();
		Lire_Enre(position);
	}
	
	public void Lire_Enre(int p)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("");
			state.setInt(1, p);
			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				int idreser = rs.getInt("IdReser");
				String nocham = rs.getString("NoCham");
				String type = rs.getString("Type");
				double prix = rs.getDouble("Prix");
				boolean occ = rs.getBoolean("Occupee");
				
				setIdReser(idreser);
				les_reser_c.add(new Mod_Reservation_cham(nocham, type, prix, occ));  
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Mod_Reservation.java","ALERTE", JOptionPane.ERROR_MESSAGE);
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
		Mod_Reservation_cham c = (Mod_Reservation_cham)les_reser_c.get(rowIndex);
		if(columnIndex == 0) c.getNoCham();
		if(columnIndex == 1) c.getType();
		if(columnIndex == 2) c.getPrix();
		if(columnIndex == 3) c.isOccupee();
		return null;
	}

	public ArrayList<Mod_Reservation_cham> getLes_reser_c() {
		return les_reser_c;
	}

	public void setLes_reser_c(ArrayList<Mod_Reservation_cham> les_reser_c) {
		this.les_reser_c = les_reser_c;
	}

	public String[] getLesTitres() {
		return lesTitres;
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
		return occupee;
	}

	public void setOccupee(boolean occupee) {
		this.occupee = occupee;
	}

	public int getIdReser() {
		return IdReser;
	}

	public void setIdReser(int idReser) {
		IdReser = idReser;
	}

	
	

}
