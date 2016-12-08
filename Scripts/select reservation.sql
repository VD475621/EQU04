select * from trx;

select * from de;

select * from reservation;

select * from arrive;

select * from depart;

select r.Idreser, r.DATERESER, r.DATEDEBUT, r.DATEFIN, nc.FKNOCHAM, ch.FKCODTYPCHA, nc.FKIDCLI, nc.nom
from reservation r, chambre ch, (select d.FKIDRESER, d.FKNOCHAM, nb.nom, nb.FKIDCLI 
                                from  de d
                                full outer join ( select a.FKNOCHAM, a.FKIDCLI, a.FKIDRESER, c.nom  from ARRIVE a, client c
                                                  where a.FKIDCLI=c.IDCLI order by a.FKIDRESER
                                                ) nb
                                on d.FKIDRESER=nb.FKIDRESER and d.FKNOCHAM=nb.FKNOCHAM) nc
where r.IDRESER=nc.FKIDRESER and ch.NOCHAM=nc.FKNOCHAM order by r.idreser;