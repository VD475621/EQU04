package View;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import modeles.ModConnexion;
import modeles.Mod_Arrive_Cham;

public class PickList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1264630510882715065L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickList frame = new PickList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PickList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Btn_Ok = new JButton("OK");
		Btn_Ok.setBounds(226, 227, 95, 23);
		contentPane.add(Btn_Ok);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(57, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 209, 352, -193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(172, 120, 1, 1);
		scrollPane.add(table);
	}
}

class ModelPicklist extends AbstractTableModel
{
	
	private String NoReserv;
	private String NoCli;
	private String Nom;
	private String DateArrive;
	private String NoCham;
	
	private ArrayList<ModelPicklist> les_Enregs = new  ArrayList<ModelPicklist>();
	private final  String[] lesTitres = {"No.Reservation", "No. Client", "Nom", "DateArrive","No.Chambre"};
	
	public ModelPicklist(String _NoReserv,String _NoCli,String _Nom,String _DateArrive,String _NoCham)
	{
		NoReserv = _NoReserv;
		NoCli =_NoCli;
		Nom = _Nom;
		DateArrive = _DateArrive;
		NoCham = _NoCham;
	}
	
	public ModelPicklist()
	{
		super();
		Lire_Enreg();
	}
	
	public void Lire_Enreg()
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT a.FKIdReser,a.FKIdCli,c.Nom,a.dateArrive,a.FKNoCham FROM Client c, Arrive a WHERE c.IdCli = a.FKIdCli");
			
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String noreserv = rs.getString("FKIdReser");
				String nocli = rs.getString("FKNoCli");
				String nom = rs.getString("Nom");
				String datearrive = rs.getString("dateArrive");
				String nocham = rs.getString("FKNoCham");
				
				les_Enregs.add(new ModelPicklist(noreserv, nocli, nom, datearrive,nocham));  
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
		return les_Enregs.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ModelPicklist c = (ModelPicklist)les_Enregs.get(rowIndex);
		if(columnIndex == 0) {return c.getNoCham();}
		if(columnIndex == 1) {return c.getType();}
		if(columnIndex == 2) {return c.getPrix();}
		if(columnIndex == 3) {return c.isOccupee();}
		return null;
	}

	public ArrayList<ModelPicklist> getLes_Enregs() {
		return les_Enregs;
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

	
}


