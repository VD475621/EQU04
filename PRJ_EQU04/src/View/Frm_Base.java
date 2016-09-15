package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frm_Base extends JFrame {

	private JPanel contentPane;
	protected JButton btnNaviguerGauche;
	protected JButton btnAjouter;
	protected JButton btnSupprimer;
	protected JButton btnConsulter;
	protected JButton btnNaviguer;
	protected JButton btnFin;
	protected JButton btnNaviguer_1;
	protected JButton btnModifier;
	
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
		
		btnNaviguerGauche = new JButton("Debut");
		btnNaviguerGauche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNaviguerGauche.setBounds(36, 667, 117, 29);
		contentPane.add(btnNaviguerGauche);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(294, 667, 117, 29);
		contentPane.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(423, 667, 117, 29);
		contentPane.add(btnSupprimer);
		
		btnConsulter = new JButton("Consulter");
		btnConsulter.setBounds(682, 667, 117, 29);
		contentPane.add(btnConsulter);
		
		btnNaviguer = new JButton("Avant");
		btnNaviguer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNaviguer.setBounds(165, 667, 117, 29);
		contentPane.add(btnNaviguer);
		
		btnFin = new JButton("Fin");
		btnFin.setBounds(940, 667, 117, 29);
		contentPane.add(btnFin);
		
		btnNaviguer_1 = new JButton("Apres");
		btnNaviguer_1.setBounds(811, 667, 117, 29);
		contentPane.add(btnNaviguer_1);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(553, 667, 117, 29);
		contentPane.add(btnModifier);
	}
}
