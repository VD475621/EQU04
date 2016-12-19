package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import controleurs.Ctrl_Arrive;
import controleurs.Ctrl_Arrive.State;

public class Mod_Arrive_Cham extends AbstractTableModel {

	/**
	 * 
	 */
	private Ctrl_Arrive parent;
	private static final long serialVersionUID = 1L;
	private int IdReser;
	private String NoCham;
	private String Type;
	private double Prix;
	private boolean Occupee;

	private ArrayList<Mod_Arrive_Cham> lesEnreg = new  ArrayList<Mod_Arrive_Cham>();
	private final  String[] lesTitres = {"No chambre", "Type", "Prix", "Occupee"};

	public Mod_Arrive_Cham(String nocham, String type, double prix, boolean occ, int idreser)
	{
		this.setNoCham(nocham);
		this.setType(type);
		this.setPrix(prix);
		this.setOccupee(occ);
		this.setIdReser(idreser);
	}

	public Mod_Arrive_Cham(int _IdReserv,Ctrl_Arrive _parent)
	{
		super();

		this.parent = _parent;
		Lire_Enre(_IdReserv);
	}

	public void Lire_Enre(int _IdReserv)
	{
		lesEnreg.clear();
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select c.NoCham, c.FKCodTypCha, c.Prix, d.Attribuee, d.FKIDRESER FROM De d, Chambre c WHERE c.NoCham = d.FKNoCham AND d.FKIdReser = ?");
			state.setInt(1, _IdReserv);

			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String nocham = rs.getString("NoCham");
				String type = rs.getString("FKCodTypCha");
				double prix = rs.getDouble("Prix");
				boolean occ = rs.getBoolean("Attribuee");
				int idreser = rs.getInt("FkIdReser");

				lesEnreg.add(new Mod_Arrive_Cham(nocham, type, prix, occ,idreser));  
			}

			this.fireTableDataChanged();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
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

	public boolean setCham(int _IdReser, String _oldcham , String _newcham)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("UPDATE DE SET FkNoCham = ? WHERE FkNoCham = ? AND FkIdReser = ?");
			state.setString(1, _newcham);
			state.setString(2, _oldcham);
			state.setInt(3, _IdReser);

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

	public boolean canEditCham(int _IdReser,String _NoCham)
	{
		try
		{
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT COUNT(*) FROM DEPART d WHERE d.FKIdReser = ? AND d.FKNOCHAM = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			state.setInt(1, _IdReser);
			state.setString(2, _NoCham);


			ResultSet rs = state.executeQuery();
			rs.next();

			int rows = rs.getInt(1);

			if(rows > 0)
				return false;
			else 
				return true;

		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"canBeDeleted" + e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
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
		// TODO Auto-generated method stub
		Mod_Arrive_Cham c = (Mod_Arrive_Cham)lesEnreg.get(rowIndex);
		if(columnIndex == 0) {return c.getNoCham();}
		if(columnIndex == 1) {return c.getType();}
		if(columnIndex == 2) {return c.getPrix();}
		if(columnIndex == 3) 
		{
			return (c.isOccupee()) ? "Prise" : "Libre";
		}
		return null;
	}

	public void setValueAt(Object value, int row, int col) {
		System.out.println("yoyoyo");
		if(this.parent.getState() == State.Edit)
		{
			Mod_Arrive_Cham c = (Mod_Arrive_Cham)lesEnreg.get(row);
			if(col == 1){

			}

			if(col == 3){
				this.setAttribue( c.getIdReser(), c.getNoCham(), (Integer.parseInt((String)value)) == 1 ? true : false );
				this.clear();
				this.Lire_Enre(c.getIdReser());
			}
		}
	}

	public ArrayList<Mod_Arrive_Cham> getlesEnreg() {
		return lesEnreg;
	}

	public void setLes_reser_c(ArrayList<Mod_Arrive_Cham> les_reser_c) {
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

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(this.parent.getState() == State.Edit)
		{
			return  columnIndex == 3;
		}
		else
		{
			return false;
		}
	}


}
