package modeles;

import java.util.ArrayList;
import Utils.Query;

public class Procs {
	private static Query SELECT_RESERVATION = new Query("SELECT * FROM vueReservation");
	private static Query SELECT_CHAMBRE = new Query("SELECT CHAMBRE.noCham, CHAMBRE.etage, CHAMBRE.etat,CHAMBRE.FKCodTypCha, TYPECHAM.descType, CHAMBRE.FKCodLoc,LOCALISATION.descLoc, CHAMBRE.prix ,CHAMBRE.memo FROM CHAMBRE ,TYPECHAM  ,LOCALISATION where CHAMBRE.FKCodTypCha = TYPECHAM.CodTypCha and CHAMBRE.FKCodLoc = LOCALISATION.CodLoc ORDER BY CHAMBRE.noCham ASC");
	private static Query SELECT_AYANT = new Query("select COMMODITE.CodCom , COMMODITE.DescCom FROM COMMODITE , AYANT where COMMODITE.CodCom = AYANT.FKCodCom and AYANT.FKnoCham = ?");
	private static Query SELECT_CODCOM = new Query("select COMMODITE.CodCom,  COMMODITE.DescCom from COMMODITE");
	private static Query SELECT_CODLOC = new Query("select LOCALISATION.CodLoc,  LOCALISATION.DescLoc from LOCALISATION");
	private static Query SELECT_CODTYP = new Query("select TYPECHAM.CodTypCha,  TYPECHAM.DescType, TYPECHAM.nbdispo from TYPECHAM");
	private static Query SELECT_DE = new Query("select * from DE");
	private static Procedure INSERT_CHAMBRE = new Procedure("INSERT into EQU04PRG01.CHAMBRE VALUES( ? , ? , ? , ? , ? , ? , ? )");
	private static Procedure INSERT_AYANT = new Procedure("INSERT into EQU04PRG01.AYANT VALUES ( ? , ? )");
	private static Procedure UPDATE_CHAMBRE = new Procedure("UPDATE EQU04PRG01.CHAMBRE SET CHAMBRE.etage = ?, CHAMBRE.prix = ?,CHAMBRE.etat = ?, CHAMBRE.FKCodTypCha = ?, CHAMBRE.FKCodLoc = ?, CHAMBRE.memo = ? WHERE CHAMBRE.noCham = ?");
	private static Procedure DELETE_AYANT = new Procedure("DELETE from EQU04PRG01.AYANT WHERE AYANT.FKnoCham = ?");
	private static Procedure DELETE_CHAMBRE = new Procedure("DELETE from EQU04PRG01.CHAMBRE WHERE CHAMBRE.noCham = ?");
	
	
	/**
	 * @return le Mod_AMode reservation formater comme suit:
	 * idCli,nom,adresse,telephone,fax,typeCarte,dateExp,soldeDu,IdReser,dateReser,dateDebut,dateFin
	 */
	public static  Mod_AMod SELECT_RESERVATION(){
		return SELECT_RESERVATION.execute(null);
	}
	/**
	 * @return le Mod_AMode chambre formater comme suit:
	 * nocham,etage,etat,codtyp,destyp,codloc,descloc,prix,memo
	 */
	public static  Mod_AMod SELECT_CHAMBRE(){
		return SELECT_CHAMBRE.execute();
	}
	/**
	 * @return le Mod_AMode de formater comme suit:
	 * idReser,Nocham,Attribuee
	 */
	public static  Mod_AMod SELECT_DE(){
		return SELECT_DE.execute();
	}
	/**
	 * @return le Mod_AMode codtyp formater comme suit:
	 * codtyp, desctype , NbDispo
	 */
	public static  Mod_AMod SELECT_CODTYP(){
		return SELECT_CODTYP.execute();
	}
	
	/**
	 * @return le Mod_AMode codloc formater comme suit:
	 * codloc,descloc
	 */
	public static Mod_AMod SELECT_CODLOC(){
		return SELECT_CODLOC.execute();
	}
	
	/**
	 * @return le Mod_AMode codcom
	 * codcom,descCom
	 */
	public static Mod_AMod SELECT_CODCOM(){
		return SELECT_CODCOM.execute();
	}
	
	/**
	 * @param le numero de la chambre 
	 * @return la liste des commodite pour une chambre formater comme suit:
	 * codCom,descCom
	 */
	public static  Mod_AMod SELECT_AYANT(String noCham){
		return SELECT_AYANT.execute(noCham);
	}
	
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_CHAMBRE(ArrayList<String> sqlParameters){
		return INSERT_CHAMBRE.execute(sqlParameters);
	}
	
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,codcom
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_AYANT(ArrayList<String> sqlParameters){
		return INSERT_AYANT.execute( sqlParameters);
	}
	
	/**
	 * @param sqlParameters list de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed 
	 */
	public static boolean UPDATE_CHAMBRE(ArrayList<String> sqlParameters){
		return UPDATE_CHAMBRE.execute(sqlParameters);
	}
	
	/**
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	public static boolean DELETE_AYANT(String nocham){
		return DELETE_AYANT.execute(nocham);
	}
	
	/** 
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	public static boolean DELETE_CHAMBRE(String nocham){
		return DELETE_CHAMBRE.execute(nocham);
	}
}
