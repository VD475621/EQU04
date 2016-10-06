package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.swing.JOptionPane;


public final class ModConnexion {
	
	//Propriétés
	private static volatile ModConnexion instance = null;
	
	private  Connection laConnectionStatique;
	
	//Constructeur vide
	private ModConnexion()
	{
		super();
	};

	
	
	public boolean connexion(String nomUsager, String mdp)
	{ 	
		
			boolean ok = true;
			
			try{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				
				} 
			catch(SQLException e)
				{
					JOptionPane.showMessageDialog(null,"Classe non trouvee " + "pour le chargement " + "du pilote JDBC Oracle", "ALERTE", JOptionPane.ERROR_MESSAGE);
					ok = false;
				}
			
			if (ok == true)
				{
					try {
						setLaConnectionStatique((Connection) DriverManager.getConnection("jdbc:oracle:thin:@10.10.1.60:1522:orcl",nomUsager,mdp));
					}
					catch(SQLException en)
					{
						System.out.println("Cannot connect to local");
						try{
								//Création de la connection
							setLaConnectionStatique((Connection) DriverManager.getConnection("jdbc:oracle:thin:@205.236.2.160:1522:orcl",nomUsager,mdp));
							}
						catch(SQLException e)
							{
								JOptionPane.showMessageDialog(null,  e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
								ok = false;
							}
					}
				}
			return ok;
	}
	
	public boolean deconnexion()
	{
		try{
		laConnectionStatique.close();
		return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	};
	
	//Méthode qui renvoie une instance de la classe
	public final static  ModConnexion getInstance(){
		  if(ModConnexion.instance == null){
			synchronized (ModConnexion.class){  
		  	    ModConnexion.instance = new ModConnexion();
			}
		    System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
		  }
		  
		  return ModConnexion.instance  ;
		}
	
	//GETTERS et SETTERS des propriétés

	public  Connection getLaConnectionStatique() {
		return laConnectionStatique;
	}
	public  void setLaConnectionStatique(Connection cnx) {
		laConnectionStatique = cnx;
	}

}

	
