package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import controleurs.CtrlConnexion;
import elementsGraphiques.BtnOption;
import elementsGraphiques.Police;

public class Frm_Connexion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrinc;
	protected JTextField txtUser;
	protected JPasswordField txtMdp;
	private Frm_Connexion instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Frm_Connexion tmp = new Frm_Connexion(); 
					 tmp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frm_Connexion() {
		instance=this;
		setTitle("AUTHENTIFICATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnPrinc = new JPanel();
		pnPrinc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrinc);
		pnPrinc.setLayout(null);
		
		JTextPane jTxtPnTitre = new JTextPane();
		
	
		//Titre avec la police standardisée
		jTxtPnTitre.setFont(Police.stdPolice);
		jTxtPnTitre.setBackground(Color.LIGHT_GRAY);
		jTxtPnTitre.setText("\t\tBienvenue dans le Système CLÉ.\n\tVeuillez entrer vos informations de connexion.");
		jTxtPnTitre.setAlignmentY(CENTER_ALIGNMENT);
		jTxtPnTitre.setBounds(6, 15, 444, 47);
		jTxtPnTitre.setEditable(false);
		pnPrinc.add(jTxtPnTitre);
		
				
		//btnOption est une classe personnalisée du projet dant
		//le packagae elementsGraphiques
		BtnOption btnAnnuler= new BtnOption("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			Frm_Connexion.this.setVisible(false);
				
				
			}
		});
		btnAnnuler.setLocation(42, 231);
		pnPrinc.add(btnAnnuler);
		
		BtnOption btnConnect =new BtnOption("Connexion");
		btnConnect.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
				char[] pass = txtMdp.getPassword();
				String passString = new String(pass);
				CtrlConnexion.connexion(instance,txtUser.getText() ,passString);
				}
			});
		btnConnect.setLocation(302, 231);
		pnPrinc.add(btnConnect);
		
		JPanel jPnCnx = new JPanel();
		jPnCnx.setBackground(Color.LIGHT_GRAY);
		jPnCnx.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jPnCnx.setBounds(42, 94, 377, 125);
		pnPrinc.add(jPnCnx);
		jPnCnx.setLayout(null);
		
		JLabel lblUser = new JLabel();
		lblUser.setBounds(60, 34, 16, 16);
		jPnCnx.add(lblUser);
		//lblUser.setIcon(new ImageIcon(Frm_Connexion.class.getResource("/elementsGraphiques/Images/connection/utilisateur.png")));
		
		JLabel lblMdP = new JLabel();
		lblMdP.setBounds(60, 75, 16, 16);
		jPnCnx.add(lblMdP);
		//lblMdP.setIcon(new ImageIcon(Frm_Connexion.class.getResource("/elementsGraphiques/Images/connection/key.png")));
		
		txtUser = new JTextField();
		txtUser.setBounds(88, 22, 223, 28);
		jPnCnx.add(txtUser);
		txtUser.setColumns(10);
		
		txtMdp = new JPasswordField();
		txtMdp.setBounds(88, 62, 223, 28);
		jPnCnx.add(txtMdp);
		this.txtUser.setText("EQU04PRG01");
		this.txtMdp.setText("j52754");
	}
}
