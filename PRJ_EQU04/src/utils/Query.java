package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeles.ModConnexion;
import modeles.Mod_AMod;

public class Query {
	private String query;
    private int paramAmount;
	public Query(String statement){
		this.query = statement;
		paramAmount = 0;
		for(int i = 0 ; i < statement.length();i++)
			if(statement.charAt(i) == '@')
				paramAmount++;
	}

	private String formatQuery(Object sqlParameters){
		ArrayList<Object> sqlParametersList = new ArrayList<Object>();
		if(sqlParameters instanceof ArrayList)
			sqlParametersList = (ArrayList<Object>)sqlParameters;		
		else if(sqlParameters != null)
			sqlParametersList.add(sqlParameters);
		
		if(sqlParametersList.size() == paramAmount){
			String formatedQuery = "";
			char car;
			boolean paramFound = false;
			int paramIndex = 0;
			for(int i = 0 ; i < query.length(); i++){
				car = query.charAt(i);
				if(car == '@'){
					paramFound = true;
					formatedQuery += sqlParametersList.get(paramIndex).toString();
					paramIndex++;
				}
				else if(car == ' ' || car ==','){
					if(paramFound)
						paramFound = false;	
				
					formatedQuery += car;
				}
				else{
					if(!paramFound)
						formatedQuery += car;
				}
			}
			return formatedQuery;
		}
		else{
			System.out.println("Nombre de parametre incorrect dans la query "  + paramAmount + " attendu " + sqlParametersList.size() + " envoye" );
			return null;
		}
	}
	
	public Mod_AMod execute(Object sqlParameters){
		try {    
			Mod_AMod model = new Mod_AMod();
			PreparedStatement state = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement(this.formatQuery(sqlParameters));
			ResultSet rs = state.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for(int i = 0 ; i < columnCount;i++)
				model.columnTitle().add(rsmd.getColumnName(i+1));
	
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for(int i = 0 ; i < columnCount; i++)
					row.add(rs.getObject(i+1));
				model.data().add(row); 
			} 
			return model;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println("problem with this statement : " + query);
		}
		return null;
	}
}
