package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Mod_ChambreTable extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private int CodCom;
	private String DescCom;
	
	private ArrayList<Mod_ChambreTable> Ls_ChambreTable = new ArrayList<Mod_ChambreTable>();
	
	
	
	public Mod_ChambreTable()
	{
		super();
	}
	
	public Mod_ChambreTable(int position)
	{
		super();
	}
	
	public Mod_ChambreTable(int codtyp, String desccom)
	{
		
	}
	
	
	public void Lire(int position)
	{
		try {    
			
		
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT ");
				state.setInt(1,position);
			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
			   int codtype = rs.getInt("CodCom");
			   String desccom = rs.getString("DescCom");
				
				Ls_ChambreTable.add(new Mod_ChambreTable(codtype, desccom));  
				}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Mod_ChambreTable.java",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	public int Get_CodCom()
	{
		return this.CodCom;
	}
	
	public void Set_CodCom(int set)
	{
		this.CodCom = set;
	}
	
	public String Get_DescCom()
	{
		return this.DescCom;
	}
	
	public void Set_DescCom(String set)
	{
		this.DescCom = set;
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
