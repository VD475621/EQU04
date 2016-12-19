package controleurs;

import java.awt.Point;
import java.sql.Date;

import javax.swing.JOptionPane;

import View.Frm_Depart;
import View.Pk_List;
import modeles.Mod_Arrive;
import modeles.Mod_Depart;
import modeles.Mod_Depart_Cham;
import modeles.Mod_Pk_Arrive;
import modeles.Mod_Pk_Depart;

public class Ctrl_Depart {

	public enum State {
		Consult,
		Add,
		Edit,
		Delete
	}


	private Frm_Depart form;

	//UI Model
	public Mod_Depart mod_depart = null;
	public Mod_Depart_Cham mod_depart_cham = null;
	public Mod_Arrive mod_arrive = null;

	//PickList Model
	public Mod_Pk_Depart mod_pk_depart = null;
	public Mod_Pk_Arrive mod_pk_arrive = null;

	private State state = State.Consult;
	private int position = 0;
	private int ReservPosition = 0;
	private int ArrivePosition = 0;


	public Ctrl_Depart(Frm_Depart frm_depart)
	{
		form = frm_depart;
		mod_depart = new Mod_Depart(); 
	}


	public void Assign(int position)
	{
		mod_depart.setCourant(position);


		//affichage de la reservation et du client

		form.getTB_CliNo().setText(mod_depart.getValueAt(position, 0).toString());
		form.getTB_Nom().setText(mod_depart.getValueAt(position, 1).toString());
		form.getTB_Adr().setText(mod_depart.getValueAt(position, 2).toString());
		form.getTB_Tel().setText(mod_depart.getValueAt(position, 3).toString());
		form.getTB_Fax().setText(mod_depart.getValueAt(position, 4).toString());
		form.getTB_NumCham().setText(mod_depart.getValueAt(position, 5).toString());
		form.getTB_NoReserv().setText(mod_depart.getValueAt(position, 6).toString());
		form.getTB_DateReserv().setText(mod_depart.getValueAt(position, 7).toString());
		form.getTB_DateDebut().setText(mod_depart.getValueAt(position, 8).toString());
		form.getTB_DateFin().setText(mod_depart.getValueAt(position, 9).toString());
		form.getTB_ConfPar().setText(mod_depart.getValueAt(position, 10).toString());


		//affichage des chambres
		if(this.state == State.Consult)
		{
			mod_depart_cham = new Mod_Depart_Cham((int)mod_depart.getValueAt(position, 6));
			form.getTBL_Reserv().setModel(mod_depart_cham);
		}
	}

	public void AssignArrive(int position)
	{
		mod_depart.setCourant(position);


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
	}

	public void Premier()
	{
		this.position = 0;
		Assign(position);
	}

	public void Suivant()
	{
		if(position > (mod_depart.getLesEnreg().size() - 1) )
			position = 0;
		else
			position++;
		mod_depart.setCourant(position);
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
		form.getTB_ConfPar().setEditable(false);
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
		form.getTB_ConfPar().setEditable(true);
		clearForm();
	}

	public void Supprimer()
	{
		this.state = State.Delete;

		Mod_Arrive MPA = mod_arrive.getLesEnreg().get(this.ArrivePosition);
		Mod_Depart MD = mod_depart.getDepartByIdReserv(MPA.getNoReserv());
		String nocham = MPA.getNoChamCli();
		int nodepart = MD.getNoDepart();
		Date debut = MPA.getDateDebut();
		Date fin = MPA.getDateFin();

				int dialogResult = JOptionPane.showConfirmDialog (null, "�tes-vous certain de vouloir supprimer cet enregistrement ? (Depart #"+nodepart+")","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

		if(dialogResult == JOptionPane.YES_OPTION){
			System.out.println("Deleting Arrive #"+nodepart+" ...");

			if(!mod_arrive.Delete(nodepart))
			{
				JOptionPane.showMessageDialog(null, "L'enregistrement n'a pas �t� supprimer.","Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(MD.getDateDepart().before(fin))
				{
					this.mod_depart_cham.setAttribue(MPA.getNoReserv(), nocham, true);
				}
				this.clearForm();
			}

		}

	}

	public void Precedent()
	{
		if (position < 0)
			position = mod_depart.getLesEnreg().size() - 1;
		else 
			position--;

		mod_depart.setCourant(position);
		Assign(position);	
	}

	public void Dernier()
	{
		this.position = mod_depart.getLesEnreg().size()-1;
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
		form.getTB_ConfPar().setText("");
		mod_depart_cham.clear();
	}

	public Mod_Depart getArriveByIdReserv(int IdReserv)
	{
		for(int i = 0;i < (mod_depart.getLesEnreg().size()-1) ; i++){
			if((int)mod_depart.getValueAt(i,6) == IdReserv)
				return mod_depart.getLesEnreg().get(i);
		}
		return null;
	}



	public void ListeArrive()
	{
		if(this.state == State.Add)
		{
			mod_arrive = new Mod_Arrive();
			int IdReserv = (int)Pk_List.pickFromTable((mod_pk_arrive = new Mod_Pk_Arrive()), "Listes des arrivees");
			for(int i=0; i < mod_arrive.getLesEnreg().size(); i++)
			{

				if(IdReserv == (int)mod_arrive.getValueAt(i, 6))
				{
					AssignArrive(i);
					mod_depart_cham.Lire_Enre(IdReserv);
					ArrivePosition = i;
				}
			}
		}
	}


	public void TableDoubleClicked(Point coord)
	{
		int row = form.getTBL_Reserv().rowAtPoint(coord);
		int col = form.getTBL_Reserv().columnAtPoint(coord);
		String newcham = mod_depart_cham.getValueAt(row, 0).toString();

	}

	public void Sauvegarder()
	{
		if(this.state == State.Add)
		{
			java.util.Date date = new java.util.Date();
			int IdReser = (int)mod_arrive.getValueAt(this.ArrivePosition, 6);
			Mod_Arrive MPA = mod_arrive.getLesEnreg().get(ArrivePosition);

			Date today = new Date(date.getTime());
			Date debut = MPA.getDateDebut();
			Date fin = MPA.getDateFin();
			System.out.println(today);
			System.out.println(debut);
			System.out.println(fin);
			int IdCli = MPA.getNoCli();
			String NoCham = MPA.getNoChamCli();
			String ConfPar = form.getTB_ConfPar().getText();

			if(IsBetweenDate(today,debut,fin))
			{
				if(this.mod_depart_cham.Insert(IdReser, IdCli, NoCham, today,ConfPar))
				{
					if(today.before(fin))
					{
						if(this.mod_depart_cham.setAttribue(IdReser, NoCham, false))
						{
							mod_depart.lireEnreg();
							mod_depart_cham.Lire_Enre(IdReser);
							mod_depart_cham.fireTableDataChanged();
						}
					}
				}
			}
		}
		else if(this.state == State.Edit)
		{

		}                                                                                                                                                                                                                                                                                                                                                                                                                                        
		else if(this.state == State.Delete)
		{
			/*Mod_Pk_Depart MPA = mod_pk_depart.getLesEnreg().get(this.ArrivePosition);
			int NoArrive = MPA.getNoArrive();
			int NoReserv = MPA.getNoReser();
			int NoCli = MPA.getIdCli();
			String NoCham = MPA.getNoCham();

			int dialogResult = JOptionPane.showConfirmDialog (null, "�tes-vous certain de vouloir supprimer cet enregistrement ? (Arrive #"+NoArrive+")","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			if(dialogResult == JOptionPane.YES_OPTION){
				System.out.println("Deleting Arrive #"+NoArrive+" ...");
				if(mod_depart.canBeDeleted(NoReserv, NoCli))
				{
					if(!mod_depart.Delete(NoArrive))
					{
						JOptionPane.showMessageDialog(null, "L'enregistrement n'a pas �t� supprimer.","Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						this.mod_depart_cham.setAttribue(NoReserv, NoCham, false);
						this.clearForm();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "L'enregistrement que vous essayer de supprimer comporte une transaction ou un d�part et ne peut �tre supprimer.","Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}*/
		}
	}

	public boolean IsBetweenDate(Date current,Date start,Date end)
	{
		if(start.before(current))
		{
			System.out.println("Allo?2");
			if(end.after(current))
			{
				System.out.println("Allo?3");
				return true;
			}
			return false;
		}
		return false;
	}

	public void Annuler()
	{

	}


	public Mod_Depart getmod_arrive() {
		return mod_depart;
	}


	public void setmod_arrive(Mod_Depart mod_arrive) {
		this.mod_depart = mod_depart;
	}


	public Mod_Depart getmod_arrive_cham() {
		return mod_depart;
	}


	public void setmod_arrive_cham(Mod_Depart mod_depart_cham) {
		this.mod_depart = mod_depart_cham;
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
