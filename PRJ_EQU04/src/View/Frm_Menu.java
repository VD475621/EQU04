package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frm_Menu extends JFrame {

	private JPanel contentPane;
	private Frm_Base win;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Menu frame = new Frm_Menu();
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
	public Frm_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Chambre");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				win= new Frm_Chambre();
				win.setVisible(true);
			}
		});
		btnNewButton.setBounds(83, 44, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reservation");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				win= new Frm_Reservation();
				win.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(83, 78, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnDepart = new JButton("Depart");
		btnDepart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En cours de developpement", "En developpement", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDepart.setBounds(83, 112, 105, 23);
		contentPane.add(btnDepart);
		
		JButton btnAdministration = new JButton("Administration");
		btnAdministration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En cours de developpement", "En developpement", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAdministration.setBounds(83, 146, 105, 23);
		contentPane.add(btnAdministration);
		
		JButton btnClient = new JButton("Client");
		btnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En cours de developpement", "En developpement", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnClient.setBounds(222, 44, 105, 23);
		contentPane.add(btnClient);
		
		JButton btnArrive = new JButton("Arrive");
		btnArrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				win= new Frm_Arrive();win.setVisible(true);
			}
		});
		btnArrive.setBounds(222, 78, 105, 23);
		contentPane.add(btnArrive);
		
		JButton btnTransaction = new JButton("Transaction");
		btnTransaction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En cours de developpement", "En developpement", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnTransaction.setBounds(222, 112, 105, 23);
		contentPane.add(btnTransaction);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(222, 146, 105, 23);
		contentPane.add(btnQuitter);
	}
}
