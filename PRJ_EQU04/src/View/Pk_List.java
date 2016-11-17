package View;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public final class Pk_List extends JDialog {

	private static final long serialVersionUID = 1L;
	private static JTable jt;
	private static Object No_ligne = null;

	private Pk_List(AbstractTableModel m, String t, int state)
	{
		No_ligne = null;
		if(m.getRowCount()>0){
			jt = new JTable(m);
	        add(new JScrollPane(jt));
	        this.setBounds(150, 150, 450, 200);
	        setModal(true);
			setTitle(t);
		    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			jt.addMouseListener(new MouseAdapter()
			{
		  			@Override
		  			public void mousePressed(MouseEvent e)
		  			{
		  				if(state == 0){
			  				No_ligne = jt.getValueAt(jt.getSelectedRow(), 0);
		  				}
		  				else if (state == 1){
		  					ArrayList<Object> row = new ArrayList<Object>();
		  					for(int i =0;i<jt.getColumnCount();i++){
		  						row.add(jt.getValueAt(jt.getSelectedRow(), i));
		  					}
		  					//System.out.println(row);
		  					No_ligne = row;
		  				}
					  	dispose();
					   	e.setSource(null);
		  			}
	  		});
			setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Il n'y a pas de valeur a selectionn� pour " + t);
		}
        
	}



	/** return the selectedRow from a table created with model and title
	 *
	 * @param m will construct the table
	 * @param t will name the window
	 * @return the row selected or 0 if clause without selection
	 */
	public final static Object pickFromTable(AbstractTableModel m,String t){
		new Pk_List(m, t, 0);
		return No_ligne;
	}
	public final static ArrayList<Object> pickFromTableRow(AbstractTableModel m,String t){
		new Pk_List(m, t, 1);
		return (ArrayList<Object>) No_ligne;
	}
}
