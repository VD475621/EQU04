package View;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public final class Pk_List extends JDialog {

	private static final long serialVersionUID = 1L;
    private static JTable DgTable;
	private static int NoLigneSel = 0;
	
	private Pk_List(AbstractTableModel model,String Title) 
	{
		
        DgTable = new JTable(model);
        add(new JScrollPane(DgTable));
        this.setBounds(150, 150, 450, 200);
        setModal(true);
		setTitle(Title);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    NoLigneSel = 0;
		DgTable.addMouseListener(new MouseAdapter() 
		{
	  		@Override
	  		public void mousePressed(MouseEvent e) 
	  		{
	  			NoLigneSel = DgTable.getSelectedRow();
	  			dispose();
	   			e.setSource(null);
  			}
  		});
		setVisible(true);
	}
	
	
	
	/** return the selectedRow from a table created with model and title
	 * 
	 * @param model will construct the table
	 * @param Title will name the window
	 * @return the row selected or 0 if clause without selection
	 */
	public final static int pickFromTable(AbstractTableModel model,String Title){
		new Pk_List(model,Title);
		return NoLigneSel;
	}
}

