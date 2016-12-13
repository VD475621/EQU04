package controleurs;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import View.Frm_Base;
import View.Frm_Chambre;
import View.Pk_List;
import modeles.Mod_Chambre;
import modeles.Mod_ChambreTable;
import modeles.Mod_AMod;
import modeles.Procs;
import utils.Mode;

public class Ctrl_Chambre {
	

	private int position;
	private Frm_Chambre Frm_Chambre;
	private Mode mode;
	private Mod_AMod newChambreCodCom;
	private Mod_AMod modChambre;
	private String errorMsg;
	public Ctrl_Chambre(Frm_Chambre Frm_Chambre){
		this.Frm_Chambre = Frm_Chambre;
		position = 0;
		modChambre = Procs.SELECT_CHAMBRE();
	}
	
	public void AffecteValeurs(){
	    Frm_Chambre.getTb_NoCham().setText(modChambre.getValueAt(position, 0).toString()); 
	    Frm_Chambre.getTb_Etage().setText(modChambre.getValueAt(position, 1).toString());   
	    Frm_Chambre.getTb_CodType().setText(modChambre.getValueAt(position, 3).toString());
	    Frm_Chambre.getTb_Localisation().setText(modChambre.getValueAt(position, 5).toString());
	    Frm_Chambre.getTb_DescType().setText(modChambre.getValueAt(position, 4).toString());
	    Frm_Chambre.getTb_DescLoc().setText(modChambre.getValueAt(position, 6).toString());
	    Frm_Chambre.getTb_Prix().setText(modChambre.getValueAt(position, 7).toString());
	    if(modChambre.getValueAt(position, 8) != null)
	    	Frm_Chambre.getTb_Memo().setText(modChambre.getValueAt(position, 8).toString());
	    else
	    	Frm_Chambre.getTb_Memo().setText("");
	    
	    Frm_Chambre.get_DataGrid().setViewportView(new JTable(Procs.SELECT_AYANT(modChambre.getValueAt(position, 0).toString())));
	    
	    if(modChambre.getValueAt(position, 2).toString().equals("1"))
	    	Frm_Chambre.getCb_Etat().setSelected(true);
	    else
	    	Frm_Chambre.getCb_Etat().setSelected(false);
	}

	public void setConsultationMode(){
		mode = Mode.CONSULTATION;
		Frm_Chambre.getTb_NoCham().setEnabled(false);
		Frm_Chambre.getTb_Etage().setEnabled(false);
		Frm_Chambre.getTb_Etat().setEnabled(false);
		Frm_Chambre.getTb_CodType().setEnabled(false);
		Frm_Chambre.getTb_Localisation().setEnabled(false);
		Frm_Chambre.getTb_DescType().setEnabled(false);
		Frm_Chambre.getTb_DescLoc().setEnabled(false);
		Frm_Chambre.getTb_Prix().setEnabled(false);
		Frm_Chambre.getTb_Memo().setEnabled(false);
		
		Frm_Chambre.getBt_Ajout().setEnabled(true);
		Frm_Chambre.getBt_Annuler().setEnabled(false);
		Frm_Chambre.getBt_Debut().setEnabled(true);
		Frm_Chambre.getBt_Fin().setEnabled(true);
		Frm_Chambre.getBt_Modifier().setEnabled(true);
		Frm_Chambre.getBt_Precedent().setEnabled(true);
		Frm_Chambre.getBt_Sauvegarder().setEnabled(false);
		Frm_Chambre.getBt_Suivant().setEnabled(true);
		Frm_Chambre.getBt_Supprimer().setEnabled(true);
		
		Frm_Chambre.get_CBEtat().setEnabled(false);
		Frm_Chambre.get_AddCodCom().setEnabled(false);
		Frm_Chambre.get_SuppCodCom().setEnabled(false);
		
		position = 0;
		AffecteValeurs();
	}
	public void setAjoutMode(){
		mode = Mode.AJOUT;
		
		Frm_Chambre.getTb_NoCham().setEnabled(true);
		Frm_Chambre.getTb_Etage().setEnabled(true);
		Frm_Chambre.getTb_Prix().setEnabled(true);
		Frm_Chambre.getTb_Memo().setEnabled(true);
		Frm_Chambre.getTb_NoCham().setEditable(true);
		Frm_Chambre.getTb_Etage().setEditable(true);
		Frm_Chambre.getTb_Prix().setEditable(true);
		Frm_Chambre.getTb_Memo().setEditable(true);
		
		
		
		Frm_Chambre.getTb_NoCham().setText("");
		Frm_Chambre.getTb_Etage().setText("");
		Frm_Chambre.getTb_Etat().setText("");
		Frm_Chambre.getTb_CodType().setText("");
		Frm_Chambre.getTb_Localisation().setText("");
		Frm_Chambre.getTb_DescType().setText("");
		Frm_Chambre.getTb_DescLoc().setText("");
		Frm_Chambre.getTb_Prix().setText("");
		Frm_Chambre.getTb_Memo().setText("");
		
		Frm_Chambre.getBt_Ajout().setEnabled(false);
		Frm_Chambre.getBt_Annuler().setEnabled(true);
		Frm_Chambre.getBt_Debut().setEnabled(false);
		Frm_Chambre.getBt_Fin().setEnabled(false);
		Frm_Chambre.getBt_Modifier().setEnabled(false);
		Frm_Chambre.getBt_Precedent().setEnabled(false);
		Frm_Chambre.getBt_Sauvegarder().setEnabled(true);
		Frm_Chambre.getBt_Suivant().setEnabled(false);
		Frm_Chambre.getBt_Supprimer().setEnabled(false);
		
		Frm_Chambre.get_CBEtat().setEnabled(true);
		Frm_Chambre.get_AddCodCom().setEnabled(true);
		Frm_Chambre.get_SuppCodCom().setEnabled(true);
		
		
		newChambreCodCom = Procs.SELECT_CODCOM();
		newChambreCodCom.empty();
		Frm_Chambre.get_DataGrid().setViewportView(new JTable(newChambreCodCom));
	}
	public void setModificationMode(){
		mode = Mode.MODIFICATION;
		
		Frm_Chambre.getTb_NoCham().setEnabled(false);
		Frm_Chambre.getTb_Etage().setEnabled(true);
		Frm_Chambre.getTb_Prix().setEnabled(true);
		Frm_Chambre.getTb_Memo().setEnabled(true);
		Frm_Chambre.getTb_NoCham().setEditable(true);
		Frm_Chambre.getTb_Etage().setEditable(true);
		Frm_Chambre.getTb_Prix().setEditable(true);
		Frm_Chambre.getTb_Memo().setEditable(true);
		
		Frm_Chambre.getBt_Ajout().setEnabled(false);
		Frm_Chambre.getBt_Annuler().setEnabled(true);
		Frm_Chambre.getBt_Debut().setEnabled(false);
		Frm_Chambre.getBt_Fin().setEnabled(false);
		Frm_Chambre.getBt_Modifier().setEnabled(false);
		Frm_Chambre.getBt_Precedent().setEnabled(false);
		Frm_Chambre.getBt_Sauvegarder().setEnabled(true);
		Frm_Chambre.getBt_Suivant().setEnabled(false);
		Frm_Chambre.getBt_Supprimer().setEnabled(false);
		
		Frm_Chambre.get_CBEtat().setEnabled(true);
		Frm_Chambre.get_AddCodCom().setEnabled(true);
		Frm_Chambre.get_SuppCodCom().setEnabled(true);
		
		
		newChambreCodCom = Procs.SELECT_AYANT(Frm_Chambre.getTb_NoCham().getText());
		Frm_Chambre.get_DataGrid().setViewportView(new JTable(newChambreCodCom));
	}
//method Event
	public void modifier(){
		if(mode == Mode.CONSULTATION){
			if(!(Procs.SELECT_DE().contains(Frm_Chambre.getTb_NoCham().getText(),1))) 
				this.setModificationMode();
			else
				JOptionPane.showMessageDialog(Frm_Chambre,"Erreur: la chambre est reserver");
		}
	}
	public void supprimer(){
		if(mode == Mode.CONSULTATION){
			if(!(Procs.SELECT_DE().contains(Frm_Chambre.getTb_NoCham().getText(),1))){
				if(Procs.DELETE_AYANT(modChambre.getValueAt(position, 0).toString()) && Procs.DELETE_CHAMBRE(modChambre.getValueAt(position, 0).toString())){
					JOptionPane.showMessageDialog(Frm_Chambre,"Supression reussi ");
					modChambre = Procs.SELECT_CHAMBRE();
					position = 0;
					AffecteValeurs();
				}
				else
					JOptionPane.showMessageDialog(Frm_Chambre,"Supression echoue");
			}
			else
				JOptionPane.showMessageDialog(Frm_Chambre,"Erreur: la chambre est reserver");
		}
	}
	public void premier(){  
		position = 0;
		AffecteValeurs();
    }
	public void suivant(){  
		if (position < modChambre.getRowCount() - 1)
			position++;
		else 
			position = 0;
		AffecteValeurs();
	}
	public void precedent(){
		if (position > 0)
			position--;
		else 
			position = modChambre.getRowCount() - 1;
		AffecteValeurs();	
	}
	public void dernier(){  
		position = modChambre.getRowCount() - 1;
		AffecteValeurs();
    }
	public void quitter(){  
		Frm_Base winPrincipale = new Frm_Base();
		winPrincipale.setVisible(true);
		Frm_Chambre.dispose();
    }
	
	public void sauvegarder(){
		if(mode == Mode.AJOUT){
			if(valideAjout()){
			//preparation des donnees d'insertion
				ArrayList<String> values = new ArrayList<String>();
				values.add( Frm_Chambre.getTb_NoCham().getText() );
				values.add( Frm_Chambre.getTb_Etage().getText() );
				values.add(Frm_Chambre.getTb_Prix().getText());
				if(Frm_Chambre.getCb_Etat().isSelected())
					values.add("1");
				else
					values.add("0");
				values.add( Frm_Chambre.getTb_CodType().getText());
				values.add( Frm_Chambre.getTb_Localisation().getText());
				values.add( Frm_Chambre.getTb_Memo().getText());
			//test de l insertion
				boolean succesEnregistrement = true;
				if(!Procs.INSERT_CHAMBRE(values))
					succesEnregistrement = false;
				for(int i = 0; i < newChambreCodCom.getRowCount() ; i++)
					if(!Procs.INSERT_AYANT(new ArrayList<String>(Arrays.asList(Frm_Chambre.getTb_NoCham().getText(),newChambreCodCom.getValueAt(i,0).toString()))))
						succesEnregistrement = false;
			//resultat
				if(succesEnregistrement){
					JOptionPane.showMessageDialog(Frm_Chambre,"Ajout reussie");
					this.setConsultationMode();
				}
				else{
					JOptionPane.showMessageDialog(Frm_Chambre,"Erreur Ajout");
				}
			}else
				JOptionPane.showMessageDialog(Frm_Chambre,errorMsg);	
		}
		else if(mode == Mode.MODIFICATION){
			if(valideModification()){
				//preparation des donnees d'insertion
					ArrayList<String> values = new ArrayList<String>();
					
					values.add( Frm_Chambre.getTb_Etage().getText() );
					values.add(Frm_Chambre.getTb_Prix().getText());
					if(Frm_Chambre.getCb_Etat().isSelected())
						values.add("1");
					else
						values.add("0");
					values.add( Frm_Chambre.getTb_CodType().getText());
					values.add( Frm_Chambre.getTb_Localisation().getText());
					values.add( Frm_Chambre.getTb_Memo().getText());
					values.add( Frm_Chambre.getTb_NoCham().getText() );
				//test de l insertion
					boolean succesEnregistrement = true;
					if(!Procs.UPDATE_CHAMBRE(values))
						succesEnregistrement = false;
					Procs.DELETE_AYANT(Frm_Chambre.getTb_NoCham().getText());
					for(int i = 0; i < newChambreCodCom.getRowCount() ; i++)
						if(!Procs.INSERT_AYANT(new ArrayList<String>(Arrays.asList(Frm_Chambre.getTb_NoCham().getText(),newChambreCodCom.getValueAt(i,0).toString()))))
							succesEnregistrement = false;	
				//resultat
					if(succesEnregistrement){
						JOptionPane.showMessageDialog(Frm_Chambre,"Modification reussie");
						this.setConsultationMode();
					}
					else{
						JOptionPane.showMessageDialog(Frm_Chambre,"Erreur modification");
					}
				}else
					JOptionPane.showMessageDialog(Frm_Chambre,errorMsg);
		}
		//on refresh le model de chambre
		modChambre = Procs.SELECT_CHAMBRE();
	}
	public void annuler(){
		this.setConsultationMode();
	}
//boutons AJOUT/MODIFICATION codcom
	public void addCodCom(){
		Mod_AMod modele = Procs.SELECT_CODCOM();
		modele.substractModele(newChambreCodCom);
		int index = Pk_List.pickFromTable(modele,"listes des commodite");
		newChambreCodCom.addRow(new ArrayList<Object>(Arrays.asList((String)modele.getValueAt(index, 0) , (String)modele.getValueAt(index, 1))));
		Frm_Chambre.get_DataGrid().setViewportView(new JTable(newChambreCodCom));
	}
	public void removeCodCom(){
		newChambreCodCom.removeLastRow();
		Frm_Chambre.get_DataGrid().setViewportView(new JTable(newChambreCodCom));
	}
//pick list
	public void ListeChambres (){   
		if(mode != Mode.AJOUT){
			Mod_AMod chambres = Procs.SELECT_CHAMBRE();
			chambres.removeColumn(6);
			chambres.removeColumn(4);
		    position = Pk_List.pickFromTable(chambres,"listes des chambres");
			AffecteValeurs();	
		}
	}
	public void listeCodTyp(){
		if(mode == Mode.AJOUT || mode == Mode.MODIFICATION ){
			Mod_AMod modele = Procs.SELECT_CODTYP();
			int index = Pk_List.pickFromTable(modele,"listes des type de chambre");
			Frm_Chambre.getTb_CodType().setText(modele.getValueAt(index, 0).toString());
			Frm_Chambre.getTb_DescType().setText(modele.getValueAt(index, 1).toString());
		}
	}
	public void listeCodLoc(){
		if(mode == Mode.AJOUT || mode == Mode.MODIFICATION ){
			Mod_AMod modele = Procs.SELECT_CODLOC();
			int index = Pk_List.pickFromTable(modele,"listes des Localisation");
			Frm_Chambre.getTb_Localisation().setText(modele.getValueAt(index, 0).toString());
			Frm_Chambre.getTb_DescLoc().setText(modele.getValueAt(index, 1).toString());
		}
	}
//fonction de validation
	public boolean valideAjout(){
		errorMsg = "";
		boolean isValid = true;

		if(modChambre.contains(Frm_Chambre.getTb_NoCham().getText(), 0)){
			errorMsg += "la chambre existe deja\n";
			isValid = false;
		}
		if(!Frm_Chambre.getTb_NoCham().getText().matches("\\d{3}")){
			errorMsg += "le format d'entree du numero de chambre est incorrect\n";
			isValid = false;
		}
		if(!Frm_Chambre.getTb_Etage().getText().matches("\\d{2}")){
			errorMsg += "le format d'entree de l'etage est incorrect\n";
			isValid = false;
		}
		if(!Frm_Chambre.getTb_Prix().getText().matches("\\d{1,9}(.\\d{2})?")){
			errorMsg += "le format d'entree du prix est incorrect\n";
			isValid = false;
		}
		if(Frm_Chambre.getTb_Localisation().getText().equals("")){
			errorMsg += "Veuillez choisir un code de localisation\n";
			isValid = false;
		}
		if(Frm_Chambre.getTb_CodType().getText().equals("")){
			errorMsg += "Veuillez choisir un code de type de chambre\n";
			isValid = false;
		}
		if(newChambreCodCom.getRowCount() == 0){
			errorMsg += "la chambre doit avoir au moins une commodite\n";
			isValid = false;
		}
		return isValid;
	}
	public boolean valideModification(){
		errorMsg = "";
		boolean isValid = true;

		if(!Frm_Chambre.getTb_NoCham().getText().matches("\\d{3}")){
			errorMsg += "le format d'entree du numero de chambre est incorrect\n";
			isValid = false;
		}
		if(!Frm_Chambre.getTb_Etage().getText().matches("\\d{2}")){
			errorMsg += "le format d'entree de l'etage est incorrect\n";
			isValid = false;
		}
		if(!Frm_Chambre.getTb_Prix().getText().matches("\\d{1,9}(.\\d{2})?")){
			errorMsg += "le format d'entree du prix est incorrect\n";
			isValid = false;
		}
		if(Frm_Chambre.getTb_Localisation().getText().equals("")){
			errorMsg += "Veuillez choisir un code de localisation\n";
			isValid = false;
		}
		if(Frm_Chambre.getTb_CodType().getText().equals("")){
			errorMsg += "Veuillez choisir un code de type de chambre\n";
			isValid = false;
		}
		if(newChambreCodCom.getRowCount() == 0){
			errorMsg += "la chambre doit avoir au moins une commodite\n";
			isValid = false;
		}
		return isValid;
	}

}
