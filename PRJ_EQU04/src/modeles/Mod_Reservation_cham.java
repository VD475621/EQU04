package modeles;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Mod_Reservation_cham extends AbstractTableModel {
	
	private ArrayList<Mod_Reservation> lesProduits = new  ArrayList<Mod_Reservation>();
	private final  String[] lesTitres = {"No chambre", "Type", "Prix", "Occupée"};
	
	Mod_Reservation_cham()
	{
		
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
