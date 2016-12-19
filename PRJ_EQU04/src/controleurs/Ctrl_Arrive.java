package controleurs;

import java.awt.Point;
import java.sql.Date;

import javax.swing.JOptionPane;

import View.Frm_Arrive;
import View.Frm_ArriveRapport;
import View.Frm_ChambreRapport;
import View.Pk_List;
import modeles.Mod_Arrive;
import modeles.Mod_Arrive_Cham;
import modeles.Mod_Pk_Arrive;
import modeles.Mod_Pk_Chambre;
import modeles.Mod_Pk_Client;
import modeles.Mod_Pk_Reservation;

public class Ctrl_Arrive {

	public enum State {
		Consult,
		Add,
		Edit,
		Delete
	}


	private Frm_Arrive form;

	//UI Model
	public Mod_Arrive mod_arrive = null;
	public Mod_Arrive_Cham mod_arrive_cham = null;

	//PickList Model
	public Mod_Pk_Client mod_pk_client = null;
	public Mod_Pk_Reservation mod_pk_reserv = null;
	public Mod_Pk_Arrive mod_pk_arrive = null;
	public Mod_Pk_Chambre mod_pk_chambre = null;

	private State state = State.Consult;
	private int position = 0;
	private int ReservPosition = 0;
	private int ClientPosition = 0;
	private int ArrivePosition = 0;


	public Ctrl_Arrive(Frm_Arrive frm_arriv)
	{
		form = frm_arriv;
		mod_arrive = new Mod_Arrive(); 
	}


	public void Assign(int position)
	{
		mod_arrive.setCourant(position);


		//affichage de la reservation et du client

		form.getTB_CliNo().setText(mod_arrive.getValueAt(position, 0).toString());
		form.getTB_Nom().setText(mod_arrive.getValueAt(position, 1).toString());
		form.getTB_Adr().setText(mod_arrive.getValueAt(position, 2).toString());
		form.getTB_Tel().setText(mod_arrive.getValueAt(position, 3).toString());
		form.getTB_Fax().setText(mod_arrive.getValueAt(position, 4).toString());
		form.getTB_NumCham().setText(mod_arrive.getValueAt(position, 5).toString());
		form.getTB_NoReserv().setText(mod_arrive.getValueAt(position, 6).toString());
		form.getTB_DateReserv().setText(mod_arrive.getValueAt(position, 7).toString());
		form.getTB_DateDebut().setText(mod_arrive.getValueAt(position, 8).toString());
		form.getTB_DateFin().setText(mod_arrive.getValueAt(position, 9).toString());
		form.getTB_NoCli().setText(mod_arrive.getValueAt(position, 0).toString());
		form.getTB_NomReserv().setText(mod_arrive.getValueAt(position, 1).toString());


		//affichage des chambres
		if(this.state == State.Consult)
		{
			mod_arrive_cham = new Mod_Arrive_Cham((int)mod_arrive.getValueAt(position, 6),this);
			form.getTBL_Reserv().setModel(mod_arrive_cham);
		}
	}


	public void Premier()
	{
		this.position = 0;
		Assign(position);
	}

	public void Suivant()
	{
		if(position > (mod_arrive.getLesEnreg().size() - 1) )
			position = 0;
		else
			position++;
		mod_arrive.setCourant(position);
		Assign(position);	
	}

	public void Consulter()
	{
		this.state = State.Consult;
		form.getTB_CliNo().setEditable(false);
		form.getTB_Nom().setEditable(false);
		form.getTB_Adr().setEditable(false);
		form.getTB_Tel().setEditable(false);
		form.getTB_Fax().setEditable(false);
		form.getTB_NumCham().setEditable(false);
		form.getTB_NoReserv().setEditable(false);
		form.getTB_DateReserv().setEditable(false);
		form.getTB_DateDebut().setEditable(false);
		form.getTB_DateFin().setEditable(false);
		form.getTB_NoCli().setEditable(false);
		form.getTB_NomReserv().setEditable(false);
		this.position = 0;
		Assign(position);
	}

	public void Ajouter()
	{
		this.state = State.Add;
		clearForm();
	}

	public void Modifier()
	{
		this.state = State.Edit;
		clearForm();
	}

	public void Supprimer()
	{
		this.state = State.Delete;
		clearForm();
	}

	public void Precedent()
	{
		if (position < 0)
			position = mod_arrive.getLesEnreg().size() - 1;
		else 
			position--;

		mod_arrive.setCourant(position);
		Assign(position);	
	}

	public void Dernier()
	{
		this.position = mod_arrive.getLesEnreg().size()-1;
		Assign(position);
	}

	public void clearForm()
	{
		form.getTB_CliNo().setText("");
		form.getTB_Nom().setText("");
		form.getTB_Adr().setText("");
		form.getTB_Tel().setText("");
		form.getTB_Fax().setText("");
		form.getTB_NumCham().setText("");
		form.getTB_NoReserv().setText("");
		form.getTB_DateReserv().setText("");
		form.getTB_DateDebut().setText("");
		form.getTB_DateFin().setText("");
		form.getTB_NoCli().setText("");
		form.getTB_NomReserv().setText("");
		mod_arrive_cham.clear();
	}

	public Mod_Arrive getArriveByIdReserv(int IdReserv)
	{
		for(int i = 0;i < (mod_arrive.getLesEnreg().size()-1) ; i++){
			if((int)mod_arrive.getValueAt(i,6) == IdReserv)
				return mod_arrive.getLesEnreg().get(i);
		}
		return null;
	}

	public void ChamDoubleClicked()
	{
		if(this.state == State.Edit)
		{
			Mod_Arrive MA = mod_arrive.getLesEnreg().get(ArrivePosition);
			this.ListeChambre(MA.getDateDebut(), MA.getDateFin());
		}
	}

	public void ReservDoubleClicked()
	{
		if(this.state == State.Add)
		{
			ListeReserv();
		}
		else if(this.state == State.Edit || this.state == State.Delete)
		{
			ListeArrive();
		}
	}

	public void ListeArrive()
	{
		int IdReserv = (int)Pk_List.pickFromTable((mod_pk_arrive = new Mod_Pk_Arrive()), "Listes des arrivees");

		for(int i=0; i < mod_arrive.getLesEnreg().size(); i++)
		{
			if(IdReserv == (int)mod_arrive.getValueAt(i, 6))
			{
				System.out.print("Assign");
				Assign(i);
				mod_arrive_cham.Lire_Enre(IdReserv);
				ArrivePosition = i;
			}
		}
	}

	public void ListeReserv()
	{
		int IdReserv = (int)Pk_List.pickFromTable((mod_pk_reserv = new Mod_Pk_Reservation()), "Listes des reservations");

		for(int i=0; i<mod_pk_reserv.getRowCount(); i++)
		{
			if(IdReserv == (int)mod_pk_reserv.getValueAt(i, 0))
			{
				System.out.print("Assign");
				form.getTB_NoReserv().setText(mod_pk_reserv.getValueAt(i, 0).toString());
				form.getTB_DateReserv().setText(mod_pk_reserv.getValueAt(i, 3).toString());
				form.getTB_DateDebut().setText(mod_pk_reserv.getValueAt(i, 4).toString());
				form.getTB_DateFin().setText(mod_pk_reserv.getValueAt(i, 5).toString());
				form.getTB_NoCli().setText(mod_pk_reserv.getValueAt(i, 1).toString());
				form.getTB_NomReserv().setText(mod_pk_reserv.getValueAt(i, 2).toString());
				mod_arrive_cham.Lire_Enre(IdReserv);

				this.ReservPosition = i;
			}
			//System.out.println(IdReserv + "===" + lookup);
		}
	} 

	public void ListeClient()
	{
		if(this.state == State.Add)
		{
			String IdClient = Integer.toString((int)Pk_List.pickFromTable((mod_pk_client = new Mod_Pk_Client()), "Listes des Clients"));

			for(int i=0; i<mod_pk_client.getRowCount(); i++)
			{
				if(IdClient.equals(Integer.toString((int)mod_pk_client.getValueAt(i, 0))))
				{
					System.out.print("Assign");
					form.getTB_CliNo().setText(mod_pk_client.getValueAt(i, 0).toString());
					form.getTB_Nom().setText(mod_pk_client.getValueAt(i, 1).toString());
					form.getTB_Adr().setText(mod_pk_client.getValueAt(i, 2).toString());
					form.getTB_Tel().setText(mod_pk_client.getValueAt(i, 3).toString());
					this.ClientPosition = i;
				}
			}
		}
	} 

	public void ListeChambre(Date _debut,Date _fin)
	{
		if(this.state == State.Edit)
		{
			int noreser = Integer.parseInt(this.form.getTB_NoReserv().getText());
			String oldcham =  this.form.getTB_NumCham().getText();
			String NoCham = (String)Pk_List.pickFromTable((mod_pk_chambre = new Mod_Pk_Chambre(_debut,_fin)), "Listes des chambres");
			if(mod_arrive_cham.canEditCham(noreser,oldcham))
			{
				if(mod_arrive_cham.setCham(noreser, oldcham, NoCham))
				{
					form.getTB_NumCham().setText(NoCham);

				}
			}

		}
	}

	public void TableDoubleClicked(Point coord)
	{
		int row = form.getTBL_Reserv().rowAtPoint(coord);
		int col = form.getTBL_Reserv().columnAtPoint(coord);
		String newcham = mod_arrive_cham.getValueAt(row, 0).toString();

		if(this.state == State.Add)
		{
			form.getTB_NumCham().setText(newcham);
		}
		else if(this.state == State.Edit)
		{
			int noreser = Integer.parseInt(this.form.getTB_NoReserv().getText());
			String oldcham =  this.form.getTB_NumCham().getText();

			if(mod_arrive_cham.canEditCham(noreser,oldcham))
			{
				if(mod_arrive.setArrive(noreser, oldcham, newcham))
				{
					mod_arrive_cham.setAttribue(noreser, oldcham, false);
					if(mod_arrive.setArrive(noreser, newcham, oldcham))
					{
						mod_arrive_cham.setAttribue(noreser, newcham, true);
						form.getTB_NumCham().setText(newcham);
					}
				}
			}
		}
	}

	public void Sauvegarder()
	{
		if(this.state == State.Add)
		{
			java.util.Date date = new java.util.Date();
			Date today = new Date(date.getTime());
			Date debut = (Date)mod_pk_reserv.getValueAt(this.ReservPosition, 4);
			Date fin = (Date)mod_pk_reserv.getValueAt(this.ReservPosition, 5);
			int IdReser = (int)mod_pk_reserv.getValueAt(this.ReservPosition, 0);
			int IdCli = (int)mod_pk_reserv.getValueAt(this.ReservPosition, 1);
			String NoCham = form.getTB_NumCham().getText();

			if(IsBetweenDate(today,debut,fin))
			{
				if(this.mod_arrive.Insert(IdReser, IdCli, NoCham, today))
				{
					if(this.mod_arrive_cham.setAttribue(IdReser, NoCham, true))
					{
						mod_arrive_cham.Lire_Enre(IdReser);
						mod_arrive_cham.fireTableDataChanged();
					}
				}
			}
		}
		else if(this.state == State.Edit)
		{

		}                                                                                                                                                                                                                                                                                                                                                                                                                                        
		else if(this.state == State.Delete)
		{
			Mod_Pk_Arrive MPA = mod_pk_arrive.getLesEnreg().get(this.ArrivePosition);
			int NoArrive = MPA.getNoArrive();
			int NoReserv = MPA.getNoReser();
			int NoCli = MPA.getIdCli();
			String NoCham = MPA.getNoCham();

			int dialogResult = JOptionPane.showConfirmDialog (null, "Êtes-vous certain de vouloir supprimer cet enregistrement ? (Arrive #"+NoArrive+")","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			if(dialogResult == JOptionPane.YES_OPTION){
				System.out.println("Deleting Arrive #"+NoArrive+" ...");
				if(mod_arrive.canBeDeleted(NoReserv, NoCli))
				{
					if(!mod_arrive.Delete(NoArrive))
					{
						JOptionPane.showMessageDialog(null, "L'enregistrement n'a pas été supprimer.","Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						this.mod_arrive_cham.setAttribue(NoReserv, NoCham, false);
						this.clearForm();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "L'enregistrement que vous essayer de supprimer comporte une transaction ou un départ et ne peut être supprimer.","Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public boolean IsBetweenDate(Date current,Date start,Date end)
	{
		if(start.compareTo(current) <= 0)
		{
			System.out.println("Allo?2");
			if(end.compareTo(current) >= 0 )
			{
				System.out.println("Allo?3");
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void rapport(){
		Frm_ArriveRapport winRapport = new Frm_ArriveRapport();
		winRapport.setVisible(true);
        //fenetre.dispose();
	}

	public void Annuler()
	{

	}


	public Mod_Arrive getmod_arrive() {
		return mod_arrive;
	}


	public void setmod_arrive(Mod_Arrive mod_arrive) {
		this.mod_arrive = mod_arrive;
	}


	public Mod_Arrive getmod_arrive_cham() {
		return mod_arrive;
	}


	public void setmod_arrive_cham(Mod_Arrive mod_arrive_cham) {
		this.mod_arrive = mod_arrive_cham;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}

	public State getState()
	{
		return this.state;
	}




}
