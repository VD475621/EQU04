package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_Pk_Reservation extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdReser;
	private int IdCli;
	private String Nom;
	private java.sql.Date dateReser;
	private java.sql.Date dateDebut;
	private java.sql.Date dateFin;
	
	private ArrayList<ArrayList<?>> enregReser = new  ArrayList<ArrayList<?>>();
	private final  String[] lesTitres = {"NoReser","IdCli", "Nom", "DateReser", "DateDebut", "DateFin"};
	
	public Mod_Pk_Reservation()
	{
		this.Lire_Enre();
	}
	
	public void Lire_Enre()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select *  from SELECT_RESERVATION_RESER");	
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				
				row.add(rs.getInt("IdReser"));
				row.add(rs.getInt("IdCli"));
				row.add(rs.getString("Nom"));
				row.add(rs.getDate("dateReser"));
				row.add(rs.getDate("dateDebut"));
				row.add(rs.getDate("dateFin"));

				enregReser.add(row); 
			}
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Probleme rencontre dans Mod_Reservation.java " + e.toString(), "ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}


	public int getIdReser() {
		return IdReser;
	}


	public void setIdReser(int idReser) {
		IdReser = idReser;
	}


	public int getIdCli() {
		return IdCli;
	}


	public void setIdCli(int idCli) {
		IdCli = idCli;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public java.sql.Date getDateReser() {
		return dateReser;
	}


	public void setDateReser(java.sql.Date dateReser) {
		this.dateReser = dateReser;
	}


	public java.sql.Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(java.sql.Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public java.sql.Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(java.sql.Date dateFin) {
		this.dateFin = dateFin;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return enregReser.size();
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
		return enregReser.get(rowIndex).get(columnIndex);
	}
	
	
	
	
}
