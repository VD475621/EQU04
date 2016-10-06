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
	
	
	public ArrayList<ArrayList<?>> Ls_codCom= new ArrayList<ArrayList<?>>();
	public ArrayList<String> titres = new ArrayList<String>();
	
	
	
	public Mod_ChambreTable()
	{
		super();
	}
	
	public Mod_ChambreTable(String NoCham)
	{
		titres.add("CodCom");
		titres.add("Desc");
		this.Lire(NoCham);
	}
	
	public Mod_ChambreTable(int codtyp, String desccom)
	{
		
	}
	
	
	public void Lire(String NoCham)
	{
		try {    
			
		
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("select COMMODITE.CodCom , COMMODITE.DescCom FROM COMMODITE , AYANT where COMMODITE.CodCom = AYANT.FKCodCom and AYANT.FKnoCham = "+ NoCham);
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				
				
				while (rs.next()) {
					ArrayList<Object> row = new ArrayList<Object>();
					row.add(rs.getString("CodCom"));
					row.add(rs.getString("DescCom"));
					
					System.out.println(row.get(0));
					Ls_codCom.add(row); 
				}	
			}
		} catch (SQLException e) {
			System.out.print(e);
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
	
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {return Ls_codCom.get(rowIndex).get(columnIndex);}
	public int getRowCount() {return Ls_codCom.size();}
	public int getColumnCount() {return titres.size();}
	

	

	
}
