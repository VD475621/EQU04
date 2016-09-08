package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frm_Base extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Base frame = new Frm_Base();
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
	public Frm_Base() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNaviguerGauche = new JButton("Debut");
		btnNaviguerGauche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNaviguerGauche.setBounds(36, 667, 117, 29);
		contentPane.add(btnNaviguerGauche);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(294, 667, 117, 29);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(423, 667, 117, 29);
		contentPane.add(btnSupprimer);
		
		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.setBounds(682, 667, 117, 29);
		contentPane.add(btnConsulter);
		
		JButton btnNaviguer = new JButton("Avant");
		btnNaviguer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNaviguer.setBounds(165, 667, 117, 29);
		contentPane.add(btnNaviguer);
		
		JButton btnFin = new JButton("Fin");
		btnFin.setBounds(940, 667, 117, 29);
		contentPane.add(btnFin);
		
		JButton btnNaviguer_1 = new JButton("Apres");
		btnNaviguer_1.setBounds(811, 667, 117, 29);
		contentPane.add(btnNaviguer_1);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(553, 667, 117, 29);
		contentPane.add(btnModifier);
	}
}
