package modeles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModelTableChambre extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NoCham;
	private String CodeType;
	private double Prix;
	private boolean OQP;

	private static Connection laConnexion = ModConnexion.getInstance().getLaConnectionStatique();
	private ArrayList<ModelTableChambre> lesEnreg = new ArrayList<ModelTableChambre>();
	ModelTableChambre instanceArrive = null;
	private final  String[] headers = {"No. Reservation","No. Client","Nom du client", "Téléphone","Solde Dû"};

	/*
	 * Constructeur 1
	 */
	public ModelTableChambre(String _NoCham,String _CodeType,double _Prix,boolean oqp) {
		NoCham = _NoCham;
		CodeType = _CodeType;
		Prix = _Prix;
		OQP = oqp;

	}

	public ModelTableChambre()
	{

	}

	public ModelTableChambre(String _NoCli) {
		instanceArrive = new ModelTableChambre();
		lireEnreg();
	}

	public List<List<String>> getActiveReserv()
	{
		System.out.println("GetActiveReserv");
		List<List<String>> Rows = new ArrayList<List<String>>();

		try {    
			Statement state = laConnexion.createStatement();
			ResultSet rs = state.executeQuery("SELECT ARRIVE.NO_RESER,ARRIVE.NO_CLI FROM ARRIVE WHERE NO_RESER NOT IN (SELECT QUITTE.NO_RESER FROM QUITTE)");                                                                                                                                                                                                                                                                                                                                                                                                                                   

			while (rs.next())
			{
				Rows.get(0).add(rs.getString("NO_RESER"));
				Rows.get(1).add(rs.getString("NO_CLI"));
				System.out.println("NoReserv:" + rs.getString("NO_RESER"));
				System.out.println("NoCli:" + rs.getString("NO_CLI"));
			}
			return Rows;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public void lireEnreg() {
		try {   
			//List<List<String>> Rows = getActiveReserv();

			Statement state = laConnexion.createStatement();
			ResultSet rs = state.executeQuery("SELECT CHAMBRE.NoCham,CHAMBRE.FKCodTypCha,CHAMBRE.Prix,CHAMBRE.Etat FROM CHAMBRE") ;                                                                                                                                                                                                                                                                                                                                                                                                                                   

			while (rs.next())
			{
				lesEnreg.add(new ModelTableChambre(rs.getString("NoCham"),rs.getString("FKCodTypCha"),rs.getDouble("Prix"),rs.getBoolean("Etat")));  
			}   

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}


	@Override
	public int getRowCount() {
		return lesEnreg.size();
	}

	@Override
	public int getColumnCount() {   
		return headers.length;
	}

	public String getColumnName(int columnIndex)
	{
		return headers[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		ModelTableChambre unBon = (ModelTableChambre)lesEnreg.get(rowIndex);
		if(columnIndex == 0) return unBon.getNoCham();
		if(columnIndex == 1) return unBon.getCodeType();
		if(columnIndex == 2) return unBon.getPrix();
		if(columnIndex == 3) return unBon.getOQP();

		else return null;
	}
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex){

		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		default:
			return Object.class;
		}
	}

	public ArrayList<ModelTableChambre> getLesEnreg() {
		return lesEnreg;
	}

	public String getNoCham()
	{
		return NoCham;
	}

	public String getCodeType()
	{
		return CodeType;
	}

	public double getPrix()
	{
		return Prix;
	}

	public boolean getOQP()
	{
		return OQP;
	}
}
