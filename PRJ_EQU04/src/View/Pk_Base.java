package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pk_Base extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable Tbl_list;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pk_Base dialog = new Pk_Base();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pk_Base() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		Tbl_list = new JTable();
		scrollPane.setColumnHeaderView(Tbl_list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * @return the tbl_list
	 */
	private JTable getTbl_list() {
		return Tbl_list;
	}

	/**
	 * @param tbl_list the tbl_list to set
	 */
	private void setTbl_list(JTable tbl_list) {
		Tbl_list = tbl_list;
	}
	
	
}
