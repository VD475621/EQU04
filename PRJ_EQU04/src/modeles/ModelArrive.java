package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class ModelArrive {
	
	private String NoCli;
	private String NomCli;
	private String AdrCli;
	private String TelCli;
	private String FaxCli;
	private String NoChamCli;
	
	private String NoReserv;
	private String DateReserv;
	private String DateDebut;
	private String DateFin;
	
	private static Connection laConnexion = ModConnexion.getInstance().getLaConnectionStatique();
    private final ArrayList<ModelArrive> lesEnreg = new ArrayList<ModelArrive>();
 
    /*
     * Constructeur 1
     */
    public ModelArrive( String _NoCli,String _NomCli, String _AdrCli,String _TelCli, String _FaxCli,String _NoChamCli,String _NoReserv,String _DateReserv,String _DateDebut,String _DateFin) {
    	NoCli = _NoCli;
    	NomCli = _NomCli;
    	AdrCli = _AdrCli;
    	TelCli = _TelCli;
        FaxCli = _FaxCli;
    	NoChamCli = _NoChamCli;
    	
    	NoReserv = _NoReserv;
    	DateReserv = _DateReserv;
    	DateDebut = _DateDebut;
    	DateFin = _DateFin;
 
    }
    /*
     * Constructeur 2
     */
    public ModelArrive() {
        if(laConnexion == null)
            JOptionPane.showMessageDialog(null, "Connexion Null","ERREUR", JOptionPane.ERROR_MESSAGE);
        lireEnreg();
    }
 
    public void lireEnreg() {
        try {    
            lesEnreg.clear();
            Statement state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery("SELECT Client.IdCli,Client.Nom,Client.Adresse,Client.Telephone,Client.Fax,Arrive.FKNoCham,Reservation.IdReser,Reservation.dateReser,Reservation.dateDebut,Reservation.dateFin FROM Client,Arrive,Reservation WHERE Client.IdCli = Arrive.FKIdCli AND Client.IdCli = Reservation.FKIdCli");                                                                                                                                                                                                                                                                                                                                                                                                                                   
 
            while (rs.next())
            {
            	String _NoCli = rs.getString("IdCli");
            	String _NomCli = rs.getString("Nom");
            	String _AdrCli = rs.getString("Adresse");
            	String _TelCli = rs.getString("Telephone");
            	String _FaxCli = rs.getString("Fax");
            	String _NoChamCli = rs.getString("FKNoCham");
            	
            	String _NoReserv = rs.getString("IdReser");
            	String _DateReserv = rs.getString("dateReser");
            	String _DateDebut = rs.getString("dateDebut");
            	String _DateFin = rs.getString("dateFin");
            	
                lesEnreg.add(new ModelArrive(_NoCli,_NomCli,_AdrCli,_TelCli,_FaxCli,_NoChamCli,_NoReserv,_DateReserv,_DateDebut,_DateFin));  
            }           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "ALERTE", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    //Accesseurs
    /*this.setNoCli(_NoTrans);
    this.setNomCli(_DateTrans);
    this.setAdrCli(_TypeTrans);
    this.setTelCli(_Description);
    this.setFaxCli(_RefTrans);
    this.setNoChamCli(_MontTrans);
    
    this.setNoReserv();
    this.setDateReserv();
    this.setDateDebut();
    this.setDateFin();*/
 
    public String getNoCli() {
        return NoCli;
    }
 
    public String getNomCli()
    {
        return NomCli;
    }
 
    public String getAdrCli() {
        return AdrCli;
    }
 
    public String getTelCli() {
        return TelCli;
    }
 
    public String getFaxCli() {
        return FaxCli;
    }
 
    public String getNoChamCli() {
        return NoChamCli;
    }
 
    public String getNoReserv() {
        return NoReserv;
    }
     
    public String getDateReserv()
    {
        return DateReserv;
    }
    
    public String getDateDebut()
    {
        return DateDebut;
    }
    
    public String getDateFin()
    {
        return DateFin;
    }
    
    
 
 
    public ArrayList<ModelArrive> getLesEnreg() {
        return lesEnreg;
    }
 
 
    //setters
    /*public void setNoTrans(String _NoTrans) {
        noTrans = _NoTrans;
    }
 
    public void setDateTrans(String _DateTrans) {
        dateTrans = _DateTrans;
    }
 
    public void setTypeTrans(String _TypeTrans) {
        typeTxTrans = _TypeTrans;
    }
 
    public void setDescTrans(String _DescTrans) {
        descTrans = _DescTrans;
    }
 
    public void setRefTrans(String _RefTrans) {
        refTrans = _RefTrans;
    }
 
    public void setMontTrans(String _MontTrans) {
        montTrans = _MontTrans;
    }*/
 
}
