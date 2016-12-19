package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controleurs.Ctrl_ArriveRapport;

public class Frm_ArriveRapport extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField Tbox_date1;
	private JTextField Tbox_date2;
	private Frm_ArriveRapport instance;
	
	public Frm_ArriveRapport(){
		this.setSize(300, 150);
		setTitle("Rapport");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		instance = this;
		getContentPane().setLayout(null);
		
		JButton btnGenerer = new JButton("Generer");
		btnGenerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Tbox_date2.getText().isEmpty() && !Tbox_date1.getText().isEmpty()){
					Ctrl_ArriveRapport.apercu("RapArrive.jrxml", Tbox_date1.getText(), Tbox_date2.getText());
					instance.dispose();
				}
			}
		});
		btnGenerer.setBounds(49, 74, 97, 29);
		getContentPane().add(btnGenerer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.dispose();
			}
		});
		btnAnnuler.setBounds(158, 74, 97, 29);
		getContentPane().add(btnAnnuler);
		
		JLabel lblDate1 = new JLabel("Date 1");
		lblDate1.setBounds(49, 18, 49, 23);
		getContentPane().add(lblDate1);
		
		Tbox_date1 = new JTextField();
		Tbox_date1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateTimePicker.pickDate(instance, Tbox_date1);
			}
		});
		Tbox_date1.setBounds(110, 17, 145, 23);
		getContentPane().add(Tbox_date1);
		Tbox_date1.setColumns(10);
		
		JLabel lblDate2 = new JLabel("Date 2");
		lblDate2.setBounds(49, 45, 49, 23);
		getContentPane().add(lblDate2);
		
		Tbox_date2 = new JTextField();
		Tbox_date2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DateTimePicker.pickDate(instance, Tbox_date2);
			}
		});
		Tbox_date2.setColumns(10);
		Tbox_date2.setBounds(110, 45, 145, 23);
		getContentPane().add(Tbox_date2);
	}
}
