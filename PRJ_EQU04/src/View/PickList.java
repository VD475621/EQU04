package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import controleurs.Ctrl_Arrive;
import modeles.ModConnexion;

public class PickList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton Btn_Ok;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	
	private Ctrl_Arrive crt_arrive;
	private PickList instance;
	private ModelPickList modelPickList;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public PickList(Ctrl_Arrive crt) {
		crt_arrive = crt;
		modelPickList = new ModelPickList();
		instance = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Btn_Ok = new JButton("OK");
		Btn_Ok.setBounds(276, 227, 95, 23);
		Btn_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				System.out.println(index);
				String noreserv = modelPickList.getLes_Enregs().get(index).getNoReserv();
				System.out.println(noreserv);
				int reserIndex = crt_arrive.getIndexofReserv(noreserv);
				System.out.println(reserIndex);
				crt_arrive.Assign(reserIndex);
				instance.dispose();
			}
		});
		contentPane.add(Btn_Ok);
		
	    btnCancel = new JButton("Cancel");
		btnCancel.setBounds(57, 227, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.dispose();
			}
		});
		contentPane.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 429, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 429, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		table.setModel(modelPickList);	
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount() >= 2)
				{
					int index = table.getSelectedRow();
					System.out.println(index);
					String noreserv = modelPickList.getLes_Enregs().get(index).getNoReserv();
					System.out.println(noreserv);
					int reserIndex = crt_arrive.getIndexofReserv(noreserv);
					System.out.println(reserIndex);
					crt_arrive.Assign(reserIndex);
					instance.dispose();
				}
			}
		});
	}
}

class ModelPickList extends AbstractTableModel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NoReserv;
	private String NoCli;
	private String Nom;
	private String DateArrive;
	private String NoCham;
	
	private ArrayList<ModelPickList> les_Enregs = new  ArrayList<ModelPickList>();
	private final  String[] lesTitres = {"No.Reservation", "No. Client", "Nom", "DateArrive","No.Chambre"};
	
	public ModelPickList(String _NoReserv,String _NoCli,String _Nom,String _DateArrive,String _NoCham)
	{
		NoReserv = _NoReserv;
		NoCli =_NoCli;
		Nom = _Nom;
		DateArrive = _DateArrive;
		NoCham = _NoCham;
	}
	
	public ModelPickList()
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
				String nocli = rs.getString("FKIdCli");
				String nom = rs.getString("Nom");
				String datearrive = rs.getString("dateArrive");
				String nocham = rs.getString("FKNoCham");
				
				les_Enregs.add(new ModelPickList(noreserv, nocli, nom, datearrive,nocham));  
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
		ModelPickList c = (ModelPickList)les_Enregs.get(rowIndex);
		if(columnIndex == 0) {return c.getNoReserv();}
		if(columnIndex == 1) {return c.getNoCli();}
		if(columnIndex == 2) {return c.getNom();}
		if(columnIndex == 3) {return c.getDateArrive();}
		if(columnIndex == 4) {return c.getNoCham();}
		return null;
	}

	public ArrayList<ModelPickList> getLes_Enregs() {
		return les_Enregs;
	}


	public String getColumnName(int ColumnIndex) {
		return lesTitres[ColumnIndex];
	}
	public String getNoReserv() {
		return NoReserv;
	}
	public String getNoCli() {
		return NoCli;
	}
	public String getNom() {
		return Nom;
	}
	public String getDateArrive() {
		return DateArrive;
	}
	public String getNoCham() {
		return NoCham;
	}
	
}


