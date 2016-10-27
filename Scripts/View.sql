
/*View for RESERVATION*/

CREATE OR REPLACE VIEW SELECT_RESERVATION_RESER (IdReser, IdCli, Nom, dateReser, dateDebut, dateFin)
as 
SELECT r.IdReser, c.IdCli, nom, dateReser, dateDebut, DateFin from RESERVATION r, CLIENT c where r.FKIdCli=c.IdCli order by r.IdReser;

CREATE OR REPLACE VIEW SELECT_RESERVATION (IdCli, Nom, Adresse, Telephone, fax, TypeCarte, DateExp, Solde_Du, IdReser, dateReser, dateDebut, dateFin)
as
SELECT c.IdCli, c.Nom, c.Adresse, c.Telephone, c.fax, c.TypeCarte, c.DateExp, c.Solde_Du, r.IdReser, r.dateReser, r.dateDebut, r.dateFin
FROM CLIENT c, RESERVATION r WHERE r.FKIdCli=c.IdCli order by r.IdReser;

CREATE OR REPLACE VIEW SELECT_RESERVATION_CHAMBRE (FKIdReser, NoCham, CodTypCha, Prix, Attribuee)
as
select d.FKIdReser, c.NoCham, tc.CodTypCha, c.Prix, d.Attribuee 
from De d, Chambre c, TypeCham tc 
where tc.CodTypCha=c.FKCodTypCha and c.NoCham=d.FKNoCham;

CREATE OR REPLACE VIEW SELECT_CHAMBRE_FILTRE (NOCHAM, ETAGE, PRIX, FKCODTYPCHA, FKCODLOC)
as
select c.NOCHAM, c.ETAGE, c.PRIX, c.FKCODTYPCHA, c.FKCODLOC from Chambre c where c.etat=1 and c.NoCham not in (select * from TEMP_CHAMBRE) order by c.NoCham;

/*
CREATE OR REPLACE VIEW SELECT_DE_RESER ()
as 
SELECT  FROM DE d, RESERVATION r, CHAMBRE c;
*/


/*View for Chambre*/



/*View for */