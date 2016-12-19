package modeles;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mod_Arrive {

	private int NoCli;
	private String NomCli;
	private String AdrCli;
	private String TelCli;
	private String FaxCli;
	private String NoChamCli;

	private int NoReserv;
	private Date DateReserv;
	private Date DateDebut;
	private Date DateFin;

	private int courant = 0;

	private static Connection laConnexion = ModConnexion.getInstance().getLaConnectionStatique();
	private final ArrayList<Mod_Arrive> lesEnreg = new ArrayList<Mod_Arrive>();

	/*
	 * Constructeur 1
	 */
	public Mod_Arrive( int _NoCli,String _NomCli, String _AdrCli,String _TelCli, String _FaxCli,String _NoChamCli,int _NoReserv,Date _DateReserv,Date _DateDebut,Date _DateFin) {
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
	public Mod_Arrive() {
		if(laConnexion == null)
			JOptionPane.showMessageDialog(null, "Connexion Null","ERREUR", JOptionPane.ERROR_MESSAGE);
		lireEnreg();
	}

	public void lireEnreg() {
		try {    
			lesEnreg.clear();
			Statement state = laConnexion.createStatement();
			ResultSet rs = state.executeQuery("SELECT c.IdCli,c.Nom,c.Adresse,c.Telephone,c.Fax,a.FKNoCham,r.IdReser,r.dateReser,r.dateDebut,r.dateFin FROM CLIENT c,RESERVATION r ,ARRIVE a WHERE r.FKIdCli = c.IdCli AND a.FKIdReser = r.IdReser order by r.IdReser");                                                                                                                                                                                                                                                                                                                                                                                                                                   

			while (rs.next())
			{
				int _NoCli = rs.getInt("IdCli");
				String _NomCli = rs.getString("Nom");
				String _AdrCli = rs.getString("Adresse");
				String _TelCli = rs.getString("Telephone");
				String _FaxCli = rs.getString("Fax");
				String _NoChamCli = rs.getString("FKNoCham");
				int _NoReserv = rs.getInt("IdReser");
				Date _DateReserv = rs.getDate("dateReser");
				Date _DateDebut = rs.getDate("dateDebut");
				Date _DateFin = rs.getDate("dateFin");

				//System.out.println(_NomCli);
				//System.out.println("No.Client :" + _NoCli);
				//System.out.println("No.Reserv :" + _NoReserv);
				//System.out.println("---------------------");


				/*String _DateDebut = new SimpleDateFormat("yyyy-MM-dd").format(date);

            	try {
                    date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(rs.getString("dateFin"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            	String _DateFin = new SimpleDateFormat("yyyy-MM-dd").format(date);*/

				lesEnreg.add(new Mod_Arrive(_NoCli,_NomCli,_AdrCli,_TelCli,_FaxCli,_NoChamCli,_NoReserv,_DateReserv,_DateDebut,_DateFin));  
				//System.out.println("Enregistrements count:" + lesEnreg.size());
			}           
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean Insert(int _IdReser, int _IdCli, String _NoCham, Date _dateArrive)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("INSERT INTO ARRIVE (NOARRIVE,FKIDRESER,FKIDCLI,FKNOCHAM,DATEARRIVE) VALUES(SEQ_ARRIVE.nextval,?,?,?,?)");
			state.setInt(1, _IdReser);
			state.setInt(2, _IdCli);
			state.setString(3, _NoCham);
			state.setDate(4, _dateArrive);

			int rows = state.executeUpdate();
			System.out.println("Insert Result: "+rows);
			if(rows > 0)
			{
				this.lireEnreg();
				return true;
			}
			else
				return false;
		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean Delete(int _NoArrive)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("DELETE FROM ARRIVE WHERE NOARRIVE = ?");
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

	public boolean canBeDeleted(int _IdReser,int _IdCli)
	{
		try
		{
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT COUNT(*) FROM TRX t, DEPART d WHERE t.FKIdReser = ? AND t.FKIdCli = ? AND d.FKIdReser = ? AND d.FKIdCli = ?",ResultSet.TYPE_SCROLL_INSENSITIVE);
			state.setInt(1, _IdReser);
			state.setInt(2, _IdCli);
			state.setInt(3, _IdReser);
			state.setInt(4, _IdCli);
			
			System.out.print(state.toString());
			
			ResultSet rs = state.executeQuery();
			rs.next();

			int rows = rs.getInt(1);
			
			if(rows > 0)
				return false;
			else 
				return true;
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"canBeDeleted" + e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean setArrive(int _IdReser, String _oldcham , String _newcham)
	{
		try {
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("UPDATE ARRIVE SET FkNoCham = ? WHERE FkNoCham = ? AND FkIdReser = ?");
			state.setString(1, _newcham);
			state.setString(2, _oldcham);
			state.setInt(3, _IdReser);

			int rows = state.executeUpdate();
			System.out.println("Insert Result: "+rows);
			if(rows > 0)
				return true;
			else
				return false;

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Delete" + e.getErrorCode() + " " + e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			return false;
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

	public String getNoChamCli() {
		return NoChamCli;
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
		Mod_Arrive reser = lesEnreg.get(rowIndex);
		if(columnIndex == 0) return reser.getNoCli();
		if(columnIndex == 1) return reser.getNomCli();
		if(columnIndex == 2) return reser.getAdrCli();
		if(columnIndex == 3) return reser.getTelCli();
		if(columnIndex == 4) return reser.getFaxCli();
		if(columnIndex == 5) return reser.getNoChamCli();
		if(columnIndex == 6) return reser.getNoReserv();
		if(columnIndex == 7) return reser.getDateReserv();
		if(columnIndex == 8) return reser.getDateDebut();
		if(columnIndex == 9) return reser.getDateFin();

		return null;
	}




	public ArrayList<Mod_Arrive> getLesEnreg() {
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
