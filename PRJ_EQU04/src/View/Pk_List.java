package View;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public final class Pk_List extends JDialog {

	private static final long serialVersionUID = 1L;
	private static JTable jt;
	private static int No_ligne = 0;

	private Pk_List(AbstractTableModel m, String t)
	{

        jt = new JTable(m);
        add(new JScrollPane(jt));
        this.setBounds(150, 150, 450, 200);
        setModal(true);
		setTitle(t);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    No_ligne = 0;
		jt.addMouseListener(new MouseAdapter()
		{
	  			@Override
	  			public void mousePressed(MouseEvent e)
	  			{
				  	//No_ligne = jt.getSelectedRow();
	  				No_ligne = (int)jt.getValueAt(jt.getSelectedRow()-1, 0);
				  	dispose();
				   	e.setSource(null);
	  			}
  		});
		setVisible(true);
	}



	/** return the selectedRow from a table created with model and title
	 *
	 * @param m will construct the table
	 * @param t will name the window
	 * @return the row selected or 0 if clause without selection
	 */
	public final static int pickFromTable(AbstractTableModel m,String t){
		new Pk_List(m, t);
		return No_ligne;
	}
}
