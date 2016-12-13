package modeles;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class Mod_AMod extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> columnTitle;
	
	public Mod_AMod(){
		data = new ArrayList<ArrayList<Object>>();
		columnTitle = new ArrayList<String>();
	}
	public void empty(){
		data.clear();
	}
	public void addRow(ArrayList<Object> row){
		data.add(row); 
	}
	public void removeLastRow(){
		if(data.size() > 0)
			data.remove(data.size() -1);
	}
	public void removeColumn(int columnIndex){
		for(int i = 0 ; i < data.size(); i++)
			data.get(i).remove(columnIndex);
		columnTitle.remove(columnIndex);
		
	}
	public void substractModele(Mod_AMod modele){
		for(int i = 0 ; i < modele.data.size();i++){
			for(int j = data.size() - 1 ; j >= 0 ; j--){
				if(modele.getValueAt(i, 0).equals(this.getValueAt(j,0)) ){
					data.remove(j);
				}
			}
		}	
	}
	public boolean contains(String value, int columnIndex){
		for(ArrayList<Object> row : data){
			if(row.get(columnIndex).equals(value)){
				return true;
			}
		}
		return false;
	}
	//getters
	
	public int getRowCount() {return data.size();}
	public int getColumnCount() {return columnTitle.size();}
	public String getColumnName(int columnIndex){return columnTitle.get(columnIndex);}
	public Object getValueAt(int rowIndex, int columnIndex) {return data.get(rowIndex).get(columnIndex);}
	public ArrayList<String> columnTitle(){return columnTitle;}
	public ArrayList<ArrayList<Object>> data(){return data;}
}
