
/*View for RESER*/
CREATE OR REPLACE VIEW SELECT_CLIENT_RESER (IdCli, Nom, Adresse, Telephone, TypeCarte, DateExp, Fax, Solde_du)
as 
SELECT IdCli, Nom, Adresse, Telephone, TypeCarte, DateExp, Fax, Solde_du FROM Client;


CREATE OR REPLACE VIEW SELECT_RESERVATION_RESER (IdReser, dateReser, dateDebut, dateFin)
as 
SELECT IdReser, dateReser, dateDebut, dateFin FROM RESERVATION;


/*
CREATE OR REPLACE VIEW SELECT_DE_RESER ()
as 
SELECT  FROM DE d, RESERVATION r, CHAMBRE c;
*/


/*View for Chambre*/



/*View for */