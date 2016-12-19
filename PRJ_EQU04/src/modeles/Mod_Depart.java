package modeles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Mod_Depart {
	
	private int NoCli;
	private String NomCli;
	private String AdrCli;
	private String TelCli;
	private String FaxCli;
	private String TypeCarte;
	
	private int NoReserv;
	private Date DateReserv;
	private Date DateDebut;
	private Date DateFin;
	private Date DateDepart;
	private String ConfPar;
	private int NoDepart;
	
	private int courant = 0;
	
	private static Connection laConnexion = ModConnexion.getInstance().getLaConnectionStatique();
    private final ArrayList<Mod_Depart> lesEnreg = new ArrayList<Mod_Depart>();
 
    /*
     * Constructeur 1
     */
    public Mod_Depart( int _NoCli,String _NomCli, String _AdrCli,String _TelCli, String _FaxCli,String _TypeCarte,int _NoReserv,Date _DateReserv,Date _DateDebut,Date _DateFin, String _ConfPar,int _NoDepart,Date _DateDepart) {
    	NoCli = _NoCli;
    	NomCli = _NomCli;
    	AdrCli = _AdrCli;
    	TelCli = _TelCli;
        FaxCli = _FaxCli;
        TypeCarte = _TypeCarte;
    	
    	NoReserv = _NoReserv;
    	DateReserv = _DateReserv;
    	DateDebut = _DateDebut;
    	DateFin = _DateFin;
    	DateDepart = _DateDepart;
    	ConfPar = _ConfPar;
    	
    	NoDepart = _NoDepart;
 
    }
    /*
     * Constructeur 2
     */
    public Mod_Depart() {
        if(laConnexion == null)
            JOptionPane.showMessageDialog(null, "Connexion Null","ERREUR", JOptionPane.ERROR_MESSAGE);
        lireEnreg();
    }
 
    public void lireEnreg() {
        try {    
            lesEnreg.clear();
            Statement state = laConnexion.createStatement();
            ResultSet rs = state.executeQuery("SELECT c.IdCli,c.Nom,c.Adresse,c.Telephone,c.Fax,c.TypeCarte,r.IdReser,r.dateReser,r.dateDebut,r.dateFin,d.ConfirmePar,d.NODEPART,d.dateDepart FROM CLIENT c,DEPART d, Reservation r WHERE d.FKIdCli = c.IdCli AND d.FKIdReser = r.IdReser");                                                                                                                                                                                                                                                                                                                                                                                                                                   
 
            while (rs.next())
            {
            	int _NoCli = rs.getInt("IdCli");
            	//System.out.println(_NoCli);
            	String _NomCli = rs.getString("Nom");
            	String _AdrCli = rs.getString("Adresse");
            	String _TelCli = rs.getString("Telephone");
            	String _FaxCli = rs.getString("Fax");
            	String _TypeCarte = rs.getString("TypeCarte");
            	int _NoReserv = rs.getInt("IdReser");
            	
            	System.out.println(_NoCli);
            	System.out.println(_NomCli);
            	System.out.println(_NoReserv);
            	System.out.println("---------------------");
            
                
                Date _DateReserv = rs.getDate("dateReser");
            	
                Date _DateDebut = rs.getDate("dateDebut");
            	
                Date _DateFin = rs.getDate("dateFin");
                
                String confpar = rs.getString("confirmepar");
                
                int nodepart = rs.getInt("nodepart");
                
                Date datedepart = rs.getDate("datedepart");
            	
                lesEnreg.add(new Mod_Depart(_NoCli,_NomCli,_AdrCli,_TelCli,_FaxCli,_TypeCarte,_NoReserv,_DateReserv,_DateDebut,_DateFin,confpar,nodepart,datedepart));  
                //System.out.println("Enregistrements count:" + lesEnreg.size());
            }           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "ALERTE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean Delete(int _NoArrive)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("DELETE FROM DEPART WHERE NOARRIVE = ?");
			state.setInt(1, _NoArrive);
			
			int rows = state.executeUpdate();
			System.out.println("Insert Result: "+rows);
			if(rows > 0)
				return true;
			else
				return false;
			
			//this.lireEnreg();
			//this.fireTableDataChanged();
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Delete" + e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
    
    public Mod_Depart getDepartByIdReserv(int IdReserv)
	{
		for(int i = 0;i < (lesEnreg.size()-1) ; i++){
			if((int)this.getValueAt(i,6) == IdReserv)
				return lesEnreg.get(i);
		}
		return null;
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
 
    public int getNoCli() {
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
 
    public String getTypeCarte() {
        return TypeCarte;
    }
 
    public int getNoReserv() {
        return NoReserv;
    }
     
    public Date getDateReserv()
    {
        return DateReserv;
    }
    
    public Date getDateDebut()
    {
        return DateDebut;
    }
    
    public Date getDateFin()
    {
        return DateFin;
    }
    
    public Date getDateDepart()
    {
        return DateDepart;
    }
    
    public String getConfPar()
    {
        return ConfPar;
    }
    
    public int getNoDepart()
    {
        return NoDepart;
    }
    
    public int Get_courant() {
		// TODO Auto-generated method stub
		return courant;
	}

	public void setCourant(int valueAt) {
		// TODO Auto-generated method stub
		
		this.courant = valueAt;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Mod_Depart reser = lesEnreg.get(rowIndex);
		if(columnIndex == 0) return reser.getNoCli();
		if(columnIndex == 1) return reser.getNomCli();
		if(columnIndex == 2) return reser.getAdrCli();
		if(columnIndex == 3) return reser.getTelCli();
		if(columnIndex == 4) return reser.getFaxCli();
		if(columnIndex == 5) return reser.getTypeCarte();
		if(columnIndex == 6) return reser.getNoReserv();
		if(columnIndex == 7) return reser.getDateReserv();
		if(columnIndex == 8) return reser.getDateDebut();
		if(columnIndex == 9) return reser.getDateFin();
		if(columnIndex == 10) return reser.getConfPar();
		
		return null;
	}
    
    
 
 
    public ArrayList<Mod_Depart> getLesEnreg() {
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
